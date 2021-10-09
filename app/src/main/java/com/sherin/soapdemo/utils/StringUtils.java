package com.sherin.soapdemo.utils;

import android.text.TextUtils;

import java.util.Date;

/**
 * Created by Sherin P Saleem
 */

public class StringUtils {

    public static boolean hasValue(String data) {
        if (data == null || data.length() == 0) {
            return false;
        }
        else {
            if (data.equalsIgnoreCase("null") || data.equalsIgnoreCase("nil")) {
                return false;
            }
        }
        return true;
    }


}
