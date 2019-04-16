package com.bawei.volleystudio1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.volleystudio1.R;
import com.bawei.volleystudio1.bean.JosnBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    List<JosnBean.ResultBean> list;
    Context context;

    public MyAdapter(List<JosnBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
       if (convertView==null){
           convertView=View.inflate(context, R.layout.item,null);
           holder=new ViewHolder();
           holder.imageView=convertView.findViewById(R.id.login_iv);
           holder.textView=convertView.findViewById(R.id.login_tv);
           holder.textView1=convertView.findViewById(R.id.login_tv1);
           convertView.setTag(holder);
       }else {
           holder= (ViewHolder) convertView.getTag();
       }
        JosnBean.ResultBean bean = list.get(position);
       holder.textView.setText(bean.getCommodityName());
       holder.textView1.setText(bean.getPrice()+"");
        Glide.with(context).load(bean.getMasterPic()).into(holder.imageView);
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView textView1;
    }
}
