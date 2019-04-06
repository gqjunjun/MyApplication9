package com.example.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.guoqiang20190401.R;

import java.util.List;

import bean.MyBean;
import bean.MyBeans;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class GridAdapter extends RecyclerView.Adapter {
    List<MyBeans.Result> list;
    Context context;
    int teyp;
    public GridAdapter(List<MyBeans.Result> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if(teyp==1){
            view = LayoutInflater.from(context).inflate(R.layout.grid_layout_1,null);
            return new Holder_1(view);
        }else if(teyp==2){
            view = LayoutInflater.from(context).inflate(R.layout.grid_layout_2,null);
            return new Holder_2(view);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.grid_layout_3,null);
            return new Holder_3(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            if(teyp==1){
                String name = list.get(i).rxxp.commodityList.get(i).commodityName;
                String pick = list.get(i).rxxp.commodityList.get(i).masterPic;
                ((Holder_1)viewHolder).commodityName_1.setText(name);
                Glide.with(context).load(pick).into(((Holder_1)viewHolder).masterPic_1);

            }else if(teyp==2){
                String name = list.get(i).pzsh.commodityList.get(i).commodityName;
                String pick = list.get(i).pzsh.commodityList.get(i).masterPic;
                ((Holder_2)viewHolder).commodityName_2.setText(name);
                Glide.with(context).load(pick).into(((Holder_2)viewHolder).masterPic_2);
            }else{
                String name = list.get(i).mlss.commodityList.get(i).commodityName;
                String pick = list.get(i).mlss.commodityList.get(i).masterPic;
                ((Holder_3)viewHolder).commodityName_3.setText(name);
                Glide.with(context).load(pick).into(((Holder_3)viewHolder).masterPic_3);
            }
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).mlss!=null){
           return teyp=1;
        }else if(list.get(position).pzsh!=null){
            return teyp=2;
        }else{
            return  teyp=3;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class Holder_1 extends RecyclerView.ViewHolder{
        TextView commodityName_1;
        ImageView masterPic_1;
        public Holder_1(@NonNull View itemView) {

            super(itemView);
            commodityName_1=itemView.findViewById(R.id.commodityName_1);
            masterPic_1=itemView.findViewById(R.id.masterPic_1);

        }
    }
    public class Holder_2 extends RecyclerView.ViewHolder{
        TextView commodityName_2;
        ImageView masterPic_2;
        public Holder_2(@NonNull View itemView) {
            super(itemView);
            commodityName_2=itemView.findViewById(R.id.commodityName_2);
            masterPic_2=itemView.findViewById(R.id.masterPic_2);
        }
    }
    public class Holder_3 extends RecyclerView.ViewHolder{
        TextView commodityName_3;
        ImageView masterPic_3;
        public Holder_3(@NonNull View itemView) {
            super(itemView);
            commodityName_3=itemView.findViewById(R.id.commodityName_3);
            masterPic_3=itemView.findViewById(R.id.masterPic_3);
        }
    }
}
