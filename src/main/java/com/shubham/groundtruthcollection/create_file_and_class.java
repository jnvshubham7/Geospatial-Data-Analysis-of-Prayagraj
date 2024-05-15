package com.shubham.groundtruthcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class create_file_and_class extends AppCompatActivity {


    Button doneButton;

    String fileName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_file_and_class);

        doneButton = findViewById(R.id.doneButton);



        Button createFileButton = findViewById(R.id.createFileButton);
        createFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreateFileDialog();
            }
        });


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for "Done" button
                // Add your logic here

                Intent intent = new Intent(create_file_and_class.this, MainActivity.class);
                intent.putExtra("file_name", fileName);
                startActivity(intent);



            }
        });










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

//                    Intent intent = new Intent(this, MainActivity.class);
//                    intent.putExtra("file_name", fileName);
//                    startActivity(intent);

//                    Intent intent = new Intent();
//                    intent.putExtra("file_name", fileName);
//                    setResult(RESULT_OK, intent);
                    dialog.dismiss();
                } else {
                    Toast.makeText(create_file_and_class.this, "Please enter a file name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }








}