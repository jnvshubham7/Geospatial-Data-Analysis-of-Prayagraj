package com.shubham.groundtruthcollection;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.shubham.groundtruthcollection.R;
 import com.shubham.groundtruthcollection.CsvDataAdapter;

public class CsvViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csv_viewer);

        // Get file path from Intent extra
        Intent intent = getIntent();
        String filePath = intent.getStringExtra("filePath");

        // Read CSV file and extract data
        List<String> dataList = readCsvFile(filePath);

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Set adapter with extracted data
        CsvDataAdapter adapter = new CsvDataAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    private List<String> readCsvFile(String filePath) {
        List<String> dataList = new ArrayList<>();

        try {
            if (filePath != null) {
                File file = new File(filePath);
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;

                // Read each line from the CSV file
                while ((line = reader.readLine()) != null) {
                    // Add line to the data list
                    dataList.add(line);
                    Toast.makeText(this, "Data: " + line, Toast.LENGTH_SHORT).show();
                }

                // Close the reader
                reader.close();
            } else {
                // Log an error or show a message indicating that the file path is null
                Log.e("CsvViewerActivity", "File path is null");
                Toast.makeText(this, "File path is null", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error reading CSV file", Toast.LENGTH_SHORT).show();
        }

        return dataList;
    }

}
