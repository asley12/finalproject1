package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;


public class select_printerActivity extends AppCompatActivity {

    ListView select_printer_list;
    Button back_button;

    String[] printer_type ={
            "Printer A","Printer B", "Printer C", "Printer D","Printer E","Printer F",
    };

    String[] printer_subtype ={
            "Printer A","Printer B", "Printer C", "Printer D","Printer E","Printer F",
    };

    Integer[] print_view ={
            R.drawable.printer_a, R.drawable.printer_b, R.drawable.printer_c, R.drawable.printer_d, R.drawable.printer_e, R.drawable.printer_f,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_printer);



        printer_list_adapter adapter=new printer_list_adapter(this, printer_type, printer_subtype,print_view);
        select_printer_list=(ListView)findViewById(R.id.printer_list);
        select_printer_list.setAdapter(adapter);

        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_to_main = new Intent (select_printerActivity.this, MainActivity.class);
                startActivity(back_to_main);
            }
        });

        select_printer_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    String stringToPassBack = "A";
                    Intent intent = new Intent();
                    intent.putExtra("keyName_print", stringToPassBack);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else if (position == 1){
                    String stringToPassBack = "B";
                    Intent intent = new Intent();
                    intent.putExtra("keyName_print", stringToPassBack);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else if (position == 2){
                    String stringToPassBack = "C";
                    Intent intent = new Intent();
                    intent.putExtra("keyName_print", stringToPassBack);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else if (position == 3){
                    String stringToPassBack = "D";
                    Intent intent = new Intent();
                    intent.putExtra("keyName_print", stringToPassBack);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else if (position == 4){
                    String stringToPassBack = "E";
                    Intent intent = new Intent();
                    intent.putExtra("keyName_print", stringToPassBack);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else if (position == 5){
                    String stringToPassBack = "F";
                    Intent intent = new Intent();
                    intent.putExtra("keyName_print", stringToPassBack);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
