package com.bawei.day07.volley;

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
    private static HttpVolley httpVolley;
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
    public static  synchronized HttpVolley getInstance(){
         if (httpVolley==null){
             httpVolley=new HttpVolley();
         }
         return httpVolley;
    }
    //get请求
      public  void VolleyHttpGet(String strUrl,final VolleybackString volleybackString){
          StringRequest stringRequest = new StringRequest(Request.Method.GET, strUrl, new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {
                 volleybackString.onSuccess(response);
              }
          }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {
                  volleybackString.onFail(error);
              }
          });
            stringRequest.setTag("tostpost");
            MyMap.httpQueuePost().add(stringRequest);
      }
    public  void VolleyHttpPost(String strUrl,final Map<String,String>map,final VolleybackString volleybackString){
       new StringRequest(Request.Method.POST, strUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
             volleybackString.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              volleybackString.onFail(error);
            }
        }){
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               return map;
           }
       };
    }
      public interface VolleybackString{
        void onSuccess(String response );
        void  onFail(VolleyError error);
      }
}
