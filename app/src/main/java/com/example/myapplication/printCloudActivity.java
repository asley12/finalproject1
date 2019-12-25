package com.example.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class printCloudActivity extends AppCompatActivity {

    Button dropBox_button, box_button, evernote_button, googleDrive_button, oneDrive_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_cloud);

        dropBox_button = (Button) findViewById(R.id.dropBox_btn);
        box_button = (Button) findViewById(R.id.box_btn);
        evernote_button = (Button) findViewById(R.id.evernote_btn);
        googleDrive_button = (Button) findViewById(R.id.googleDrive_btn);
        oneDrive_button = (Button) findViewById(R.id.oneDrive_btn);

        box_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_login_cloud(1);

            }
        });

        dropBox_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_login_cloud(2);
            }
        });
        evernote_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_login_cloud(3);
            }
        });
        googleDrive_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_login_cloud(4);
            }
        });
        oneDrive_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_login_cloud(5);
            }
        });
    }

    private void show_login_cloud(int flag){
            FragmentManager loginDialog = getSupportFragmentManager();
            logIn_cloud_dialog logIn_cloud = logIn_cloud_dialog.newInstance("box", flag );
            logIn_cloud.show(loginDialog,"login_fragment");
    }
}
