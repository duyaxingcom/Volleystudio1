package com.bawei.day08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.bawei.day08.Adapter.BaAdapter;
import com.bawei.day08.bean.JsonBean;
import com.bawei.day08.iview.Iview;
import com.bawei.day08.presenter.Presenter;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements Iview {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.login_rv);
        Presenter presenter = new Presenter();
        presenter.attchdataView(this);
        presenter.getData(this);
    }

    @Override
    public void getData(String data) {
        Gson gson=new Gson();
        JsonBean bean = gson.fromJson(data, JsonBean.class);
        JsonBean.ResultBean list = bean.getResult();
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //适配器
        BaAdapter baAdapter=new BaAdapter(list, MainActivity.this);
          recyclerView.setAdapter(baAdapter);
    }
}
