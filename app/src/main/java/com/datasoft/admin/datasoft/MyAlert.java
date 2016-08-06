package com.datasoft.admin.datasoft;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Admin on 06/08/2559.
 */
public class MyAlert {

    public void myDialog(Context context,
                         int intAvata,
                         String strTitle,
                         String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(findAvata(intAvata));
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public int findAvata(int intAvata) {

        int[] resultInts = new int[]{R.drawable.bird48, R.drawable.doremon48,
                R.drawable.kon48, R.drawable.nobita48, R.drawable.rat48};

        return resultInts[intAvata];
    }

}   //Main Class
