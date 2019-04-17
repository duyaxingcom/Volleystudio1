package com.bawei.day07.model;

import android.content.Context;

import javax.security.auth.callback.Callback;

public interface Imodel {
    void RequestdataView(Context context,Callback callback);
    interface Callback{
        void onSuccess(String data);
        void onFail(Exception e);
    }
}
