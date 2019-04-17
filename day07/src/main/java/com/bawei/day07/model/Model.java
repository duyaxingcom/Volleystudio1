package com.bawei.day07.model;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bawei.day07.volley.HttpVolley;



public class Model implements Imodel {
    private static final String TAG ="Model" ;
    private final String url="http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=20";
    private boolean wifi;
    private Handler handler=new Handler();

    @Override
    public void RequestdataView(final Context context, final Callback callback) {
        wifi = HttpVolley.getInstance().isNet(context);
        if (wifi){
            HttpVolley.getInstance().VolleyHttpGet(url, new HttpVolley.VolleybackString() {
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
            Log.d(TAG,"RequestdataView"+"网络连接失败");
        }
    }
}
