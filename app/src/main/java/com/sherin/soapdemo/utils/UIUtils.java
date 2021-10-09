package com.sherin.soapdemo.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

/**
 * Created by Sherin P Saleem
 */

public class UIUtils {

    public static void showSnackBar(Activity context, String message) {
        Snackbar snack = Snackbar.make(context.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View view = snack.getView();
        TextView tv = (TextView) view.findViewById(com.google.android.material.R.id.snackbar_text);
        if(tv!=null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        snack.show();
    }

}
