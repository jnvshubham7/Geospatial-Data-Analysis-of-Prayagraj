
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

![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/baf399a9-faaa-4f5d-a30c-3586882522af)



### Results and Analysis Screenshots of Different Years

#### 2020
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/62856f7c-a127-4d22-80e2-7ae5f8384c0a)

![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/0ec65a80-ae57-44aa-8b2e-73f51abeaa26)




#### 2021
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/2d75b68c-aac1-45cb-a71a-468285d0636d)

![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/d8b47013-f661-466b-b3bf-bf28881d5495)







#### 2022
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/faa0e701-4e30-4be9-ad92-a0def2e68c18)

![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/900ec12a-ef4c-4037-ab6f-3522e0fa81e7)




#### 2023
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/128cd0fd-a977-4fc8-9bd4-be8538d4706d)

![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/205df454-09c1-463f-b9d2-89544a40d1b6)




#### 2024
![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/a65d6343-1904-4b5d-aa94-244cff9705a0)

![image](https://github.com/jnvshubham7/Geospatial-Data-Analysis-of-Prayagraj/assets/69629803/f608740d-de2c-4abd-afe8-73139e118488)















## Repository Structure

```
Android-App-Code-Repository/
│
├── Android-App-Code/
│   ├── app/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/              # Java code for the Android application
│   │   │   │   │   └── com/
│   │   │   │   │       └── shubham/
│   │   │   │   │           └── groundtruthcollection/
│   │   │   │   │               └── ...
│   │   │   │   ├── res/               # Android app resources (layouts, strings, etc.)
│   │   │   │   └── AndroidManifest.xml # Android app manifest file
│   │   │   └── test/                  # Test code for the Android app
│   │   └── build.gradle               # Gradle build configuration for the Android app
│   │
│   └── README.md
│
├── ppt/
│   ├── PPT.pdf                   # PDF version of the PowerPoint presentation
│   └── PPT.pptx                  # Original PowerPoint presentation file
│
├── report/
│   ├── Report.docx               # Original document file of the report
│   └── Report.pdf                # PDF version of the report
│
└── README.md

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
