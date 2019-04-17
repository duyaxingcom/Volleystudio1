package com.bawei.day07.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.day07.R;
import com.bawei.day07.bean.JsonBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<JsonBean.ResultBean> list;
    Context context;
    private onClink onclink;

    public MyAdapter(List<JsonBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(context).inflate(R.layout.show_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
      viewHolder.textView.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getImageUrl()).into(viewHolder.imageView);
        // 回调
         viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
             onclink.onClick(viewHolder.getAdapterPosition());
             }
         });
        //下面写长按点击事件
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.show_iv);
            textView = itemView.findViewById(R.id.show_tv);
        }
    }
    //定义接口进行点击
    public interface onClink{
        //点击事件
       void onClick(int pass);
       //长按点击
       void longonClink(int magg);
    }
    public void onClink1(onClink onclink){
        this.onclink=onclink;
    }
}
