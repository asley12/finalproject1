package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public final class printer_list_adapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] printer_type;
    private final String[] printer_subtype;
    private final Integer[] print_view;

    public printer_list_adapter(Activity context, String[] printer_type, String[] printer_subtype, Integer[] print_view) {
        super(context, R.layout.select_printer_list,printer_type);

        this.context = context;
        this.printer_type = printer_type;
        this.printer_subtype = printer_subtype;
        this.print_view = print_view;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.select_printer_list,null,true);

        TextView printer_name = (TextView)listview.findViewById(R.id.printerType);
        ImageView printer_viewImage = (ImageView) listview.findViewById(R.id.printer_type_icon);
        TextView printer_subname = (TextView) listview.findViewById(R.id.printer_subtype);

            printer_name.setText(printer_type[position]);
            printer_viewImage.setImageResource(print_view[position]);
            printer_subname.setText(printer_subtype[position]);

        return listview;
    }
}
