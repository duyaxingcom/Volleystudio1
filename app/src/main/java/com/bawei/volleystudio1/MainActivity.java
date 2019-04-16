package com.bawei.volleystudio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bawei.volleystudio1.adapter.MyAdapter;
import com.bawei.volleystudio1.bean.JosnBean;
import com.bawei.volleystudio1.iview.Iview;
import com.bawei.volleystudio1.presenter.Presenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        Presenter presenter = new Presenter();
        presenter.attchView(this);
        presenter.getData(this);
    }

    @Override
    public void getData(String data) {
        Gson gson=new Gson();
        JosnBean bean = gson.fromJson(data, JosnBean.class);
        List<JosnBean.ResultBean> list = bean.getResult();
        MyAdapter myAdapter=new MyAdapter(list, MainActivity.this);
        listView.setAdapter(myAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
