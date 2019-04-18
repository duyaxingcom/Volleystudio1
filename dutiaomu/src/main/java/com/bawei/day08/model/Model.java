package com.bawei.day08.model;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bawei.day08.Api;
import com.bawei.day08.volley.HttpVolley;



public class Model implements Imodel {

    private static final String TAG = "Model";
    private Handler handler=new Handler();
    private boolean wifi;

    @Override
    public void Requesdata(final Context context, final Callback callback) {
        wifi = HttpVolley.getInstance().isNet(context);
        if (wifi){
            HttpVolley.getInstance().HttpVolleyGet(Api.url, new HttpVolley.VolleyCallback() {
                @Override
                public void onSuccess(String response) {
                    callback.onSuccess(response);
                }

                @Override
                public void onFail(VolleyError error) {

                }
            });
        }else{
            //子线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context,"网络失败",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }).start();
            Log.d(TAG,"RequestdataView"+"网络连接失败");
        }

    }
}
