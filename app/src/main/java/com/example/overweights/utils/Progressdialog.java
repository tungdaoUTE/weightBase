package com.example.overweights.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class Progressdialog {

     ProgressDialog progressDialog;

    public void showDialog(String message, Context context) {

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
        }

       // progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void dismissDialog() {
        progressDialog.dismiss();
    }
}