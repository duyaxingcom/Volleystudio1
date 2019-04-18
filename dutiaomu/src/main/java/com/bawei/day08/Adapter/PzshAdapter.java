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

public class PzshAdapter extends RecyclerView.Adapter<PzshAdapter.PzshViewHolder> {
    JsonBean.ResultBean list;
    Context context;

    public PzshAdapter(JsonBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PzshViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.pzsh_item,viewGroup,false);
        return new PzshViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PzshViewHolder pzshViewHolder, int i) {
           pzshViewHolder.textView.setText(list.getPzsh().getCommodityList().get(i).getCommodityName());
        Glide.with(context).load(list.getPzsh().getCommodityList().get(i).getMasterPic()).into(pzshViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.getPzsh().getCommodityList().size();
    }

    public class PzshViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public PzshViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pzsh_iv);
            textView = itemView.findViewById(R.id.pzsh_tv);
        }
    }
}
