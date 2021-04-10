package com.unicocoder.usergithub.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import java.util.Objects;

public class NetworkConnected {

    public static boolean getInstance(Context context){
        ConnectivityManager   connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return Objects.requireNonNull(connectivityManager).getActiveNetworkInfo() != null;
    }
}
