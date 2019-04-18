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

public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.RxxpViewHolder> {
    JsonBean.ResultBean list;
    Context context;

    public RxxpAdapter(JsonBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RxxpViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.rxxp_item,viewGroup,false);
        return new RxxpViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpViewHolder rxxpViewHolder, int i) {
          rxxpViewHolder.textView.setText(list.getRxxp().getCommodityList().get(i).getCommodityName());
          rxxpViewHolder.textView1.setText(list.getRxxp().getCommodityList().get(i).getPrice()+"");
        Glide.with(context).load(list.getRxxp().getCommodityList().get(i).getMasterPic()).into(rxxpViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.getRxxp().getCommodityList().size();
    }

    public class RxxpViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final TextView textView1;
        private final ImageView imageView;

        public RxxpViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rxxp_tv);
            textView1 = itemView.findViewById(R.id.rxxp_tv1);
            imageView = itemView.findViewById(R.id.rxxp_iv);
        }
    }
}
