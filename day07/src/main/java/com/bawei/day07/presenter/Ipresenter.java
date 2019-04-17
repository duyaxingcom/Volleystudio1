package com.bawei.day07.presenter;

import android.content.Context;

import com.bawei.day07.iview.Iview;

public interface Ipresenter {
    void attchView(Iview iview);
    void datechView();
    void getData(Context context);
}
