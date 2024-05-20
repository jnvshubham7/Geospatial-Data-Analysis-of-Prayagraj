package com.shubham.groundtruthcollection;

public class CsvData {

    private String latitude;
    private String longitude;
    private String className;

    public CsvData(String latitude, String longitude, String className) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.className = className;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


}
