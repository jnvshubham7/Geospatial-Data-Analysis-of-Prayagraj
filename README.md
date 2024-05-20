
---

# Geospatial Data Analysis of Prayagraj

## Overview

This repository contains resources and documentation related to a geospatial data analysis project conducted in Prayagraj, India. The study focused on utilizing Sentinel-2 satellite imagery and SNAP (Sentinel Application Platform) tools for land classification. Through the application of SNAP tools and techniques, including spectral analysis and classification algorithms, the research successfully delineated land cover types into four distinct categories: urban areas, agricultural land, water bodies, and vegetation cover.

## Methodology

The methodology employed in this analysis involved several key steps:

1. **Data Acquisition:** Sentinel-2 satellite imagery covering the Prayagraj region was obtained for the analysis.
2. **Preprocessing:** The imagery underwent preprocessing steps, including atmospheric correction and radiometric calibration, to enhance its suitability for analysis.
3. **Image Processing:** SNAP tools were utilized for image processing tasks such as image subset selection, band composition, and spectral analysis.
4. **Classification:** Supervised classification algorithms, including Support Vector Machine (SVM) and Random Forest, were implemented for land cover classification.
5. **Validation:** The accuracy of the classification results was assessed through validation techniques, including ground truth data comparison and accuracy metrics computation.



## Classification Accuracy

- **Accuracy**: 0.9021
- **Misclassification Rate**: 0.0979
- **Weighted-F1**: 0.9015

## Images

### Trend in Previous Year Data

![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/4df5cea3-390c-494d-aac5-3e2ec7b526ca)


### Results and Analysis Screenshots of Different Years

#### 2020
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/a30200a1-7553-4cfd-974a-8ce224afe343)
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/6cdead1f-f161-477a-8d5b-cd52b55b7879)



#### 2021
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/5ac7efd3-3d2a-48fd-9e73-f28acea09102)
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/99c79ea4-14b8-4939-af8d-571cf1cdb9c4)






#### 2022
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/3642235b-a8b8-4ed9-ad63-922774230bf9)
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/e6a9ab9d-510b-4709-8224-3d0c05e5c4b0)



#### 2023
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/c211dcb3-e020-42aa-803d-2b623ec79b06)
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/48e50983-7584-427a-a107-8f036ed50f03)



#### 2024
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/214738bd-bbc6-4515-9aa4-8831fb05cda9)
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/401dd759-5e9c-4741-b47f-2e021317c4fe)














## Repository Structure

```
|- data/                    # Placeholder for raw and processed data
|- documentation/           # Documentation related to the project methodology and results
   |- methodology.pdf       # Detailed methodology document
   |- results_summary.pdf   # Summary of the classification results
|- scripts/                 # Scripts used for image processing and classification
|- LICENSE                  # License information for the repository
|- README.md                # Overview and usage instructions (this file)
```

## Usage

### Requirements

- [SNAP (Sentinel Application Platform)](https://step.esa.int/main/download/snap-download/): Required for image processing and classification tasks.
- Python 3.x: Required for running any Python scripts used in the analysis.

### Instructions

1. **Data Acquisition:** Download Sentinel-2 imagery covering the Prayagraj region from the ESA (European Space Agency) website or another data provider.
2. **Preprocessing:** Perform any necessary preprocessing steps using SNAP tools, such as atmospheric correction and radiometric calibration.
3. **Image Processing:** Utilize the provided scripts or adapt them as needed for image processing tasks.
4. **Classification:** Implement classification algorithms using SNAP tools or any other preferred software.
5. **Validation:** Validate the classification results using ground truth data and compute accuracy metrics.

Refer to the documentation for detailed instructions and additional information.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgements

We acknowledge the support of [ESA (European Space Agency)](https://www.esa.int/) for providing access to Sentinel-2 satellite imagery used in this analysis.

---
