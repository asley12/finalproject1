package com.example.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.media.Image;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int SELECT_PRINTER_REQUEST_CODE = 1;
    Button connect_printer;
    Button tri_d_print, print_from_cloud;
    ImageView printer_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect_printer = (Button) findViewById(R.id.connect_printer_btn);
        print_from_cloud = (Button)findViewById(R.id.print_from_cloud);
        tri_d_print = (Button) findViewById(R.id.tri_d_print);
        printer_view =(ImageView) findViewById(R.id.printerView);

        print_from_cloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkConnection();
            }
        });

        connect_printer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent selectPrinter = new Intent(MainActivity.this, select_printerActivity.class);
                startActivityForResult(selectPrinter, SELECT_PRINTER_REQUEST_CODE);
            }
        });
    }

    protected boolean isOnline() {
        ConnectivityManager connect = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo net_info = connect.getActiveNetworkInfo();
        if(net_info != null && net_info.isConnected()){
            return true;
        }
        else{
            return false;
        }
    }

    public void checkConnection() {
        if (isOnline()) {
            if(connect_printer.getText().toString().equals("Printer is not connected")){
                show_error_ifPrinterNotSelected();
            }
            else if (connect_printer.getText().toString().equals("Printer A is Connected")||connect_printer.getText().toString().equals("Printer B is Connected")||connect_printer.getText().toString().equals("Printer C is Connected")
            ||connect_printer.getText().toString().equals("Printer D is Connected")||connect_printer.getText().toString().equals("Printer E is Connected")||connect_printer.getText().toString().equals("Printer F is Connected")){
                Intent print_from_cloudActivity = new Intent(MainActivity.this, printCloudActivity.class);
                startActivity(print_from_cloudActivity);
                ///Toast.makeText(MainActivity.this, "You are connected to Internet", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            show_internet_connection_alert_dialog();
            //Toast.makeText(MainActivity.this, "You are not connected to Internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void show_internet_connection_alert_dialog(){
        FragmentManager dialogFrag = getSupportFragmentManager();
        internetConnection_alertDialog alertDialog = internetConnection_alertDialog.newInstance("Internet Connection","Please check your internet connection");
        alertDialog.show(dialogFrag,"internet_alert");

    }

    private void show_error_ifPrinterNotSelected(){
        FragmentManager dialogFrag = getSupportFragmentManager();
        internetConnection_alertDialog alertDialog = internetConnection_alertDialog.newInstance("There is no selected printer","Please select your printer first");
        alertDialog.show(dialogFrag,"no_printer_alert");

    }

        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PRINTER_REQUEST_CODE) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK
                // get String data from Intent
                String data_received = data.getStringExtra("keyName_print");
                if(data_received.equals("A")){
                    connect_printer.setText("Printer A is Connected");
                    printer_view.setImageResource(R.drawable.printer_a);
                }
                else if(data_received.equals("B")){
                    connect_printer.setText("Printer B is Connected");
                    printer_view.setImageResource(R.drawable.printer_b);
                }
                else if(data_received.equals("C")){
                    connect_printer.setText("Printer C is Connected");
                    printer_view.setImageResource(R.drawable.printer_c);
                }
                else if(data_received.equals("D")){
                    connect_printer.setText("Printer D is Connected");
                    printer_view.setImageResource(R.drawable.printer_d);
                }
                else if(data_received.equals("E")){
                    connect_printer.setText("Printer E is Connected");
                    printer_view.setImageResource(R.drawable.printer_e);
                }
                else if(data_received.equals("F")) {
                    connect_printer.setText("Printer F is Connected");
                    printer_view.setImageResource(R.drawable.printer_f);
                }

            }
        }
    }
}
