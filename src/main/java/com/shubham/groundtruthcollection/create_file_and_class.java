package com.shubham.groundtruthcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class create_file_and_class extends AppCompatActivity {

    Button doneButton;
    String fileName = null;
    ArrayList<String> listToSend;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_file_and_class);

        doneButton = findViewById(R.id.doneButton);

        listToSend = new ArrayList<>();

        Button createFileButton = findViewById(R.id.createFileButton);
        createFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreateFileDialog();
            }
        });

        Button createClassButton = findViewById(R.id.createClassButton);
        createClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreateClassDialog();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for "Done" button
                // Add your logic here
                Intent intent = new Intent(create_file_and_class.this, MainActivity.class);
                intent.putExtra("file_name", fileName);
                intent.putStringArrayListExtra("class_names", listToSend);





                startActivity(intent);
            }
        });
    }

    private void showCreateClassDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_create_class, null);
        builder.setView(dialogView);

        final EditText editTextClassName = dialogView.findViewById(R.id.editTextClassName);
        Button buttonCancel = dialogView.findViewById(R.id.buttonCancel1);
        Button buttonSave = dialogView.findViewById(R.id.buttonSave1);

        final AlertDialog dialog = builder.create();

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String className = editTextClassName.getText().toString().trim();
                if (!className.isEmpty()) {
                    // Add the entered class name to the list of classes
                    // Update the spinner in the main activity
//                    // For simplicity, I'll assume you have a method in MainActivity to update the spinner
//                    Intent intent = new Intent();
//                    intent.putExtra("class_name", className);
//                    setResult(RESULT_OK, intent);

                    //add class name to list
                    listToSend.add(className);
                    Toast.makeText(create_file_and_class.this, "Class Name: " + className, Toast.LENGTH_SHORT).show();




                    dialog.dismiss();
                } else {
                    Toast.makeText(create_file_and_class.this, "Please enter a class name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }

    private void showCreateFileDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_create_file, null);
        builder.setView(dialogView);

        final EditText editTextFileName = dialogView.findViewById(R.id.editTextFileName);
        Button buttonCancel = dialogView.findViewById(R.id.buttonCancel);
        Button buttonSave = dialogView.findViewById(R.id.buttonSave);

        final AlertDialog dialog = builder.create();

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileName = editTextFileName.getText().toString().trim();
                if (!fileName.isEmpty()) {
                    // Pass the entered text back to MainActivity using Intent extra
                    Intent intent = new Intent();
                    intent.putExtra("file_name", fileName);
                    setResult(RESULT_OK, intent);
                    dialog.dismiss();
                } else {
                    Toast.makeText(create_file_and_class.this, "Please enter a file name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }
}
