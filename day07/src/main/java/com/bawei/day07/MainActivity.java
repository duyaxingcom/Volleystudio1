package com.bawei.day07;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.bawei.day07.adapter.MyAdapter;
import com.bawei.day07.bean.JsonBean;
import com.bawei.day07.iview.Iview;
import com.bawei.day07.presenter.Presenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {

    private RecyclerView recyclerView;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.login_rv);
        presenter = new Presenter();
        presenter.attchView(this);
        presenter.getData(this);

    }

    @Override
    public void getData(String data) {
        Gson gson=new Gson();
        JsonBean bean = gson.fromJson(data, JsonBean.class);
        List<JsonBean.ResultBean> list = bean.getResult();
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
          recyclerView.setLayoutManager(layoutManager);


        MyAdapter myAdapter = new MyAdapter(list, MainActivity.this);
        //点击事件
        myAdapter.onClink1(new MyAdapter.onClink() {
            @Override
            public void onClick(int pass) {
                Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_LONG).show();
            }

            @Override
            public void longonClink(int magg) {

            }
        });
        recyclerView.setAdapter(myAdapter);

        //分割线
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(MainActivity.this,R.drawable.shape));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
