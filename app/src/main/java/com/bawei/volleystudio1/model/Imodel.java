package com.bawei.volleystudio1.model;

import android.content.Context;

import javax.security.auth.callback.Callback;

public interface Imodel {
    void Requestdata(Context context,Callback callback);
    interface  Callback{
        void onSuccess(String data);
        void onFail(Exception e);
    }
}
