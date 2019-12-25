package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;


public final class internetConnection_alertDialog extends DialogFragment {
    public internetConnection_alertDialog() {
        // Constructor kosong untuk DialogFragment
    }

    public static internetConnection_alertDialog newInstance(String title, String message) {
        internetConnection_alertDialog frag = new internetConnection_alertDialog();
        Bundle args = new Bundle();
        Bundle notification = new Bundle();
        notification.putString("message", message);
        args.putString("title",title);
        frag.setArguments(args);
        frag.setArguments(notification);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        String message = getArguments().getString("message");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        return alertDialogBuilder.create();
    }

}
