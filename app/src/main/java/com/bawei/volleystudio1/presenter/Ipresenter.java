package com.bawei.volleystudio1.presenter;

import android.content.Context;

import com.bawei.volleystudio1.iview.Iview;

public interface Ipresenter {
    void attchView(Iview iview);
    void datechView();
    void getData(Context context);
}
