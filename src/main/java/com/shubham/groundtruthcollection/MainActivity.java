package com.shubham.groundtruthcollection;

import android.Manifest;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.shubham.groundtruthcollection.R;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner classSpinner;
    private Button saveLocationButton;
    private LocationManager locationManager;
    String fileName = null;

    ArrayList<String> list_received ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        classSpinner = findViewById(R.id.classSpinner);
        saveLocationButton = findViewById(R.id.saveLocationButton);

        list_received = getIntent().getStringArrayListExtra("class_names");
        fileName = getIntent().getStringExtra("file_name");
        Toast.makeText(this, "File Name: " + fileName, Toast.LENGTH_SHORT).show();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list_received);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(adapter);


//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.class_names, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        classSpinner.setAdapter(adapter);

        saveLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveLocation();
            }
        });






        // Initialize location manager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // Request location updates
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }

    private final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            // Handle location updates here if needed

           // Toast.makeText(MainActivity.this, "Location changed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    };

    private void saveLocation() {




        Toast.makeText(this, "Saving location...", Toast.LENGTH_SHORT).show();

        String selectedClass = classSpinner.getSelectedItem().toString();




        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
//            Toast.makeText(this, "Please grant permission to save location", Toast.LENGTH_SHORT).show();
//            return;
        }






        File documentsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

        File file = new File(documentsDirectory, fileName + ".csv");

// Check if Documents directory exists
        if (documentsDirectory.exists() || documentsDirectory.mkdirs()) {
            Toast.makeText(this, "Documents directory exists", Toast.LENGTH_SHORT).show();

            // Create the file inside the Documents directory
             file = new File(documentsDirectory, fileName + ".csv");
            try {
                if (file.createNewFile()) {
                    // File created successfully
                    Log.i("CreateFile", "example.txt created successfully");
                } else {
                    // File already exists
                    Log.i("CreateFile", "example.txt already exists");
                }
            } catch (IOException e) {
                // Error creating file
                e.printStackTrace();
                Log.e("CreateFile", "Error creating example.txt: " + e.getMessage());
            }
        } else {
            // Failed to create Documents directory
            Log.e("CreateFolder", "Failed to create Documents directory");
        }









//File directory = new File(getFilesDir() + "/groundtruth7");
//        Toast.makeText(this, "Path: " + directory, Toast.LENGTH_SHORT).show();

//        File directory = new File(Environment.getExternalStorageDirectory() + "/groundtruth7");`

//        File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "groundtruth");
//

        //print the path in logcat
//        Toast.makeText(this, "Path: " + directory, Toast.LENGTH_SHORT).show();
//        if (!directory.exists()) {
//            directory.mkdir();
//            Toast.makeText(this, "Directory created", Toast.LENGTH_SHORT).show();
//        }
//
//        File file = new File(directory, "groundtruth.csv");

        try {
            FileWriter writer = new FileWriter(file, true);
            // Get current location
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (lastKnownLocation != null) {
                    double latitude = lastKnownLocation.getLatitude();
                    double longitude = lastKnownLocation.getLongitude();

                    Toast.makeText(this, "Latitude: " + latitude + " Longitude: " + longitude, Toast.LENGTH_SHORT).show();


                    // Write to CSV file
                    writer.write(String.format(Locale.getDefault(), "%f,%f,%s\n", latitude, longitude, selectedClass));
                    writer.flush();
                    writer.close();
                    String message = "Location saved with class: " + selectedClass;
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Location not available", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving location", Toast.LENGTH_SHORT).show();
        }
    }





        @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove location updates when activity is destroyed
        if (locationManager != null) {
            locationManager.removeUpdates(locationListener);
        }
    }
}
