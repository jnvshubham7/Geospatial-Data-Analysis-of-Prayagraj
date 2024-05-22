from rasterio.crs import CRS
from rasterio import warp
from rasterio import transform
import rasterio
import warnings
import pandas as pd
import numpy as np

from rasterio.warp import transform_geom
from sklearn.preprocessing import LabelEncoder
from matplotlib.colors import LinearSegmentedColormap

from rf import *

# Open the Sentinel-2 TIFF file
warnings.filterwarnings("ignore", category=UserWarning)
src = rasterio.open('../zero_cloud_dataset/collocate.tif')



def transformCoordinates(latitude, longitude):
    # Define the source CRS (lat/long)
    src_crs = 'EPSG:4326'  # WGS 84
    # Define the target CRS (UTM zone 44N)
    dst_crs = 'EPSG:32644'

    # Create a point geometry from the lat/long coordinates
    point_geom = {'type': 'Point', 'coordinates': (longitude, latitude)}

    transformed_geom = transform_geom(src_crs, dst_crs, point_geom)
    return transformed_geom['coordinates']
    
    # print("UTM coordinates (EPSG:32644) at ({}, {}): {}".format(latitude, longitude, transformed_geom['coordinates']))

def get_metadata():
    return src.meta

def get_crs():
    return src.crs

def get_val_at_geocoord(lat, lon):
    lat,lon = transformCoordinates(lat, lon)
    # print(src.descriptions)
    x, y = src.index(lat, lon)
    # print(x,y)
    value = src.read(window=((y, y+1), (x, x+1)))
    return x,y,value

def getData(df , inp_column_name, out_column_name):
    trunc_df = df[inp_column_name]
    out_column = []
    for index, row in trunc_df.iterrows():
        # print(index, row)
        x,y,value = get_val_at_geocoord(row['lat'], row['lon'])
        # print(type(value), value.shape)
        # print(value.shape[1])
        if (value.shape[1]) != 0:
            # print(value)
            out_column.append(value)
            # trunc_df.at[index, 'pixel_value'] = value
        else:
            out_column.append([])
    trunc_df[out_column_name] = out_column
    # trunc_df.drop(trunc_df['pixel_values'] == [])
    trunc_df = trunc_df[trunc_df[out_column_name].apply(lambda x: len(x) != 0)]
    trunc_df.reset_index(drop=True, inplace=True)
    return trunc_df


import matplotlib.pyplot as plt
def showImage():
    pass
    
def showImage(rgb_image):
    # raster_data = src.read()
    # plt.imshow(raster_data)
    # rgb_image = np.stack((raster_data[2], raster_data[0], raster_data[1]), axis=-1)
    print(rgb_image.shape)
    rgb_image = rgb_image / np.max(rgb_image)

    colors = [(0, 'blue'),   # Start with red at position 0
          (0.5, 'red'), # Change to green at position 0.5
          (1, 'green')]
    custom_cmap = LinearSegmentedColormap.from_list('custom_cmap', colors)
    plt.imshow(rgb_image, cmap=custom_cmap)
    plt.colorbar()
    plt.title("output")
    plt.show()
    # plt.show()

def predict(rf):
    # src = rasterio.open('../zero_cloud_dataset/collocate.tif')

    height = src.shape[0]
    width = src.shape[1]
    print(height, width)
    dtype = 'uint8'  # Example data type (change according to your data)
    count = 1  # Number of bands

    # Define the metadata for the output raster
    metadata = {
        'driver': 'GTiff',
        'height': height,
        'width': width,
        'count': count,
        'dtype': dtype,
        'crs': 'EPSG:4326',  # Example CRS (change according to your data)
        # 'transform': from_origin(0, 0, 1, 1)  # Example spatial transformation (change as needed)
    }

    data = []
    for x in range(0, height):
        for y in range(0, width):
            pixel_values = src.read(window=((x, x+1), (y, y+1)))
            
            pixel_values = np.array(pixel_values).flatten()
            if len(pixel_values) != 0:
                data.append(pixel_values)
            else:
                ValueError("value is unknown!!")
                
    rdata = np.array(data)
    rdata = rdata.reshape(height, width,7)
    arr = []
    for i in range(rdata.shape[0]):
        for j in range(rdata.shape[1]):
            arr.append(rdata[i,j,:])
    
    pred_inp = np.array(arr)
    pred_out = rf.predict(pred_inp)
    pred_out = pred_out.reshape(height, width)
    # print(pred_out.shape)
    
    showImage(pred_out)
    return


def main():
    df = pd.read_csv("./data.csv")
    df = getData(df, ['S No.', 'lat', 'lon','class'], 'values')
    
    df = df[df['values'].apply(lambda x: len(x) != 0)]
    df.reset_index(drop=True, inplace=True)
    
    x = df['values']
    x_flatten = []
    # y = df['class']
    x_temp = np.array(df['values'])
    for sublist in x_temp:
        # flattened_sublist = [val for sublist_2d in sublist for val in sublist_2d]
        t = sublist.flatten()
        x_flatten.append(t)  # Flatten each sublist into a 1D array
        
    # print(x_flatten[0])
    x = pd.DataFrame({'values':x_flatten})
    
    X = np.array(x_flatten)
    # print(X)
    class_encoder = LabelEncoder()
    encoded_class = class_encoder.fit_transform(df['class'].str.replace(' ', ''))
    y_encoded = pd.DataFrame(encoded_class)
    y = y_encoded.values.flatten()
    rf = randomForest(X, y)
    predict(rf)


if __name__ == "__main__":
    main()