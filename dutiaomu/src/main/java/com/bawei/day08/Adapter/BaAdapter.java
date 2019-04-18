package com.bawei.day08.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.day08.R;
import com.bawei.day08.bean.JsonBean;

public class BaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    JsonBean.ResultBean list;
    Context context;
    private int TYPE0=0;
    private int TYPE1=1;
    private int TYPE2=2;
    public BaAdapter(JsonBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE0;
        }else if(position==1){
            return TYPE1;
        }else{
            return TYPE2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int type=getItemViewType(i);
        if (type==TYPE0){
            View view= LayoutInflater.from(context).inflate(R.layout.item1,viewGroup,false);
            return new RxxpViewHolder(view);
        }else if (type==TYPE1){
            View view= LayoutInflater.from(context).inflate(R.layout.item1,viewGroup,false);
            return new PzshViewHolder(view);
        }else{
            View view= LayoutInflater.from(context).inflate(R.layout.item1,viewGroup,false);
            return new MlssViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
          int type=getItemViewType(i);
          if (type==TYPE0){
              RxxpViewHolder rxxpViewHolder = (RxxpViewHolder) viewHolder;
                rxxpViewHolder.textView.setText(list.getRxxp().getName());
                rxxpViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,true));
                  //设置适配器
               RxxpAdapter rxxpAdapter=new RxxpAdapter(list,context);
               rxxpViewHolder.recyclerView.setAdapter(rxxpAdapter);

          }else  if (type==TYPE1){
              PzshViewHolder pzshViewHolder= (PzshViewHolder) viewHolder;
              pzshViewHolder.textView.setText(list.getPzsh().getName());
              pzshViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,2));
              PzshAdapter pzshAdapter=new PzshAdapter(list,context);
              pzshViewHolder.recyclerView.setAdapter(pzshAdapter);

          }else {
              MlssViewHolder mlssViewHolder= (MlssViewHolder) viewHolder;
              mlssViewHolder.textView.setText(list.getMlss().getName());

              //设置适配器
              MlssAdapter adapter = new MlssAdapter(list, context);
              mlssViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,2));
              mlssViewHolder.recyclerView.setAdapter(adapter);
          }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
    public class MlssViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final RecyclerView recyclerView;

        public MlssViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.show_tv);
            recyclerView = itemView.findViewById(R.id.show_rv);
        }
    }
    public class PzshViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final RecyclerView recyclerView;

        public PzshViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.show_tv);
            recyclerView = itemView.findViewById(R.id.show_rv);
        }
    }
    public class RxxpViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final RecyclerView recyclerView;

        public RxxpViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.show_tv);
            recyclerView = itemView.findViewById(R.id.show_rv);
        }
    }
}

