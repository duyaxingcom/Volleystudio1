package com.bawei.volleystudio1;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Mymap extends Application {
    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());

    }
    public static RequestQueue httpQueuepost(){
        return requestQueue;
    }
}
