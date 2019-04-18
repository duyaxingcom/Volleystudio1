package com.bawei.day08.volley;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class HttpVolley {
    private  static  HttpVolley httpVolley;

    //网络请求
    public  boolean isNet(Context context){
        if (context!=null){
            ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }
    //濑汉式
    public static synchronized HttpVolley getInstance(){
        if (httpVolley==null){
             httpVolley = new HttpVolley();
        }
        return httpVolley;
    }
    //Get请求
    public static void  HttpVolleyGet(String strUrl, final VolleyCallback volleyCallback){
         StringRequest stringRequest= new StringRequest(Request.Method.GET, strUrl, new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {
                   volleyCallback.onSuccess(response);
              }
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {
                   volleyCallback.onFail(error);
              }
          });
           stringRequest.setTag("post");
           Mymap.httpQueuePost().add(stringRequest);
    }
    public static void  HttpVolleyPost(String strUrl, final Map<String,String>map, final VolleyCallback volleyCallback){
        new StringRequest(Request.Method.POST, strUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            volleyCallback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                  volleyCallback.onFail(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
    }
    //接口
    public  interface VolleyCallback {
        void onSuccess(String response);

        void onFail(VolleyError error);
    }
}
