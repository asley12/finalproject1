package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public final class logIn_cloud_dialog extends DialogFragment {
    public logIn_cloud_dialog() {

    }

    public static logIn_cloud_dialog newInstance(String title, int flag) {
        logIn_cloud_dialog frag = new logIn_cloud_dialog();
        Bundle args = new Bundle();
        Bundle selection = new Bundle();
        Bundle layoutView = new Bundle();
        args.putString("title", title);
        selection.putInt("flag", flag);
        // layoutView.putInt("layout", layout);
        frag.setArguments(args);
        frag.setArguments(selection);
        //     frag.setArguments(layoutView);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int flag = getArguments().getInt("flag");
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (flag == 1) {
            return inflater.inflate(R.layout.login_fragment, container);
        }
        else if (flag == 2){
            return inflater.inflate(R.layout.login_fragment_dropbox, container);
        }
        else if (flag == 3){
            return inflater.inflate(R.layout.login_fragment_evernote, container);
        }
        else if (flag == 4){
            return inflater.inflate(R.layout.login_fragment_googledrive, container);
        }
        else{
            return inflater.inflate(R.layout.login_fragment_onedrive, container);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button signIn = view.findViewById(R.id.login_button);
        final EditText email_Address = (EditText) view.findViewById(R.id.email_address_field);
        final EditText password = (EditText) view.findViewById(R.id.password_field);
        Button cancel = view.findViewById(R.id.cancellogin_button);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = email_Address.getText().toString();
                String pswd = password.getText().toString();
                int flag = getArguments().getInt("flag");
                if(email.equals("admin")&& pswd.equals("admin11")) {
                    if (flag == 1) {
                        Toast.makeText(getContext(), "box_cloud", Toast.LENGTH_SHORT).show();
                        dismiss();
                        Intent storage_box = new Intent(getContext(),file_storageActivity.class);
                        getContext().startActivity(storage_box);

                    } else if (flag == 2) {
                        Toast.makeText(getContext(), "dropbox_cloud", Toast.LENGTH_SHORT).show();
                        dismiss();
                        Intent storage_dropbox = new Intent(getContext(),file_storageActivity.class);
                        getContext().startActivity(storage_dropbox);
                    } else if (flag == 3) {
                        Toast.makeText(getContext(), "evernote_cloud", Toast.LENGTH_SHORT).show();
                        dismiss();
                        Intent storage_evernote = new Intent(getContext(),file_storageActivity.class);
                        getContext().startActivity(storage_evernote);
                    } else if (flag == 4) {
                        Toast.makeText(getContext(), "google_drive_cloud", Toast.LENGTH_SHORT).show();
                        Intent storage_gdrive = new Intent(getContext(),file_storageActivity.class);
                        getContext().startActivity(storage_gdrive);
                    } else {
                        Toast.makeText(getContext(), "onedrive_cloud", Toast.LENGTH_SHORT).show();
                        dismiss();
                        Intent storage_onedrive = new Intent(getContext(),file_storageActivity.class);
                        getContext().startActivity(storage_onedrive);
                    }
                }
                else if (email.isEmpty() && pswd.isEmpty()){
                    Toast.makeText(getContext(),"Please Input your email address & password", Toast.LENGTH_SHORT).show();
                }
                else if(email.isEmpty()|| pswd.isEmpty()) {
                    if (email.isEmpty()) {
                        Toast.makeText(getContext(), "Please Input your email address", Toast.LENGTH_SHORT).show();
                    }
                    else if (pswd.isEmpty()) {
                        Toast.makeText(getContext(), "Please Input your password", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getContext(),"your email address and password didn't match", Toast.LENGTH_SHORT).show();

                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
    }
}

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        String title = getArguments().getString("title");
//        int layout = getArguments().getInt("layout");
//        AlertDialog.Builder log_in_dialog = new AlertDialog.Builder(getActivity());
//        View layoutView = getLayoutInflater().inflate(layout,null);
//        log_in_dialog.setView(layoutView);
//        Button signIn = layoutView.findViewById(R.id.login_button);
//        Button cancel = layoutView.findViewById(R.id.cancellogin_button);
//        signIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int flag = getArguments().getInt("flag");
//                if (flag == 1) {
//                    Toast.makeText(getContext(), "box_cloud", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        return log_in_dialog.create();
//    }
//}
