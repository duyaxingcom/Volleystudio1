package com.bawei.day08.model;


import android.content.Context;

public interface Imodel {
    void  Requesdata(Context context, Callback callback);
    interface Callback{
        void  onSuccess(String data);
        void onFail(Exception e);
    }
}
