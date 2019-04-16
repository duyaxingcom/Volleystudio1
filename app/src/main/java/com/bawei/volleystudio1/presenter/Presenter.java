package com.bawei.volleystudio1.presenter;

import android.content.Context;

import com.bawei.volleystudio1.iview.Iview;
import com.bawei.volleystudio1.model.Imodel;
import com.bawei.volleystudio1.model.Model;

public class Presenter implements Ipresenter {

    private Model model;
    private Iview iview;

    @Override
    public void attchView(Iview iview) {
        model = new Model();
        this.iview = iview;
    }

    @Override
    public void datechView() {
        if (iview != null) {
            iview = null;
        }
        if (model != null) {
            model = null;
        }
        System.gc();
    }

    @Override
    public void getData(Context context) {
        model.Requestdata(context, new Imodel.Callback() {
            @Override
            public void onSuccess(String data) {
                iview.getData(data);
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }


}

