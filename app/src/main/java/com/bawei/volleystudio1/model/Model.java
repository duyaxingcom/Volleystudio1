package com.bawei.volleystudio1.model;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bawei.volleystudio1.Httpvolley;

import java.util.HashMap;

public class Model implements Imodel {
    private static final String TAG ="Model" ;
    private final String ListUrl="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=%E7%94%B7%E9%9E%8B";
    private Handler handler = new Handler();
    private boolean wifi;

    @Override
    public void Requestdata(final Context context, final Callback callback) {
       ;
        wifi = Httpvolley.getInstance().isNet(context);
        if (wifi){
            Httpvolley.getInstance().VolleyHttpGet(ListUrl, new Httpvolley.VolleyCallback() {
                @Override
                public void onSuccess(String response) {
                    callback.onSuccess(response);
                }

                @Override
                public void onFail(VolleyError error) {

                }
            });
        }else {
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
            Log.d(TAG,"getRequester"+"网络连接失败");
        }
    }
}
