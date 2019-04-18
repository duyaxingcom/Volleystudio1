package com.bawei.day08.presenter;

import android.content.Context;

import com.bawei.day08.iview.Iview;

public interface Ipresenter {
    void attchdataView(Iview iview);
    void datechView();
    void getData(Context context);
}
