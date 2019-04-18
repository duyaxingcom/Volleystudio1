package com.bawei.day08.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.day08.R;
import com.bawei.day08.bean.JsonBean;
import com.bumptech.glide.Glide;

public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.MlassViewHolder> {
    JsonBean.ResultBean list;
    Context context;

    public MlssAdapter(JsonBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MlssAdapter.MlassViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.mlss_item,viewGroup,false);
        return new MlassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MlssAdapter.MlassViewHolder mlassViewHolder, int i) {
          mlassViewHolder.textView.setText(list.getMlss().getCommodityList().get(i).getCommodityName());
        Glide.with(context).load(list.getMlss().getCommodityList().get(i).getMasterPic()).into(mlassViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.getMlss().getCommodityList().size();
    }

    public class MlassViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;

        public MlassViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.mlss_tv);
            imageView = itemView.findViewById(R.id.mlss_iv);
        }
    }
}
