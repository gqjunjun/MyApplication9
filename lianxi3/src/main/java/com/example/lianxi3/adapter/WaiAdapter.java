package com.example.lianxi3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lianxi3.Fragment.ShouFragment;
import com.example.lianxi3.R;
import com.example.lianxi3.bean.MyBean;

import java.util.List;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class WaiAdapter extends RecyclerView.Adapter<WaiAdapter.Holder_1>{
    List<MyBean.DataBean> list;
    Context context;

    ShouFragment shouFragment;
    private MyCallBack myCallBack;

    public WaiAdapter(List<MyBean.DataBean> list, Context context,ShouFragment shouFragment) {
        this.list = list;
        this.context = context;
        this.shouFragment=shouFragment;
    }

    @NonNull
    @Override
    public Holder_1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.wai_layout,null);
        return new Holder_1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder_1 holder_1, final int i) {
        String neme = list.get(i).getSellerName();
        holder_1.text_name.setText(neme);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        holder_1.recyclerview_2.setLayoutManager(layoutManager);
        LiAdaoter adapter = new LiAdaoter(list.get(i).getList(), context,shouFragment );
        holder_1.recyclerview_2.setAdapter(adapter);
        holder_1.checkbox_2.setChecked(list.get(i).waichecde);

        holder_1.checkbox_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = holder_1.checkbox_2.isChecked();
                list.get(i).waichecde=b;
                for (int j = 0; j < list.get(i).getList().size(); j++) {
                list.get(i).getList().get(j).lichecde=b;
                }
                myCallBack.setlist(list);
            }
        });

        adapter.setMyCallBack(new LiAdaoter.MyCallBack() {
            @Override
            public void setlist(List<MyBean.DataBean.ListBean> llist) {
                int ss=0;
                for (int j = 0; j <llist.size() ; j++) {
                    if(llist.get(j).lichecde){
                        ss++;
                    }
                }
                if(ss==llist.size()){
                    holder_1.checkbox_2.setChecked(true);
                    list.get(i).waichecde=true;
                }else{
                    holder_1.checkbox_2.setChecked(false);
                    list.get(i).waichecde=false;
                }
                myCallBack.setlist(list);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_1 extends RecyclerView.ViewHolder{
        CheckBox checkbox_2;
        TextView text_name;
        RecyclerView recyclerview_2;

        public Holder_1(@NonNull View itemView) {

            super(itemView);
            checkbox_2=itemView.findViewById(R.id.checkbox_2);
            text_name=itemView.findViewById(R.id.text_name);
            recyclerview_2=itemView.findViewById(R.id.recyclerview_2);
        }
    }

    public void setMyCallBack(MyCallBack myCallBack){
        this.myCallBack=myCallBack;
    }
    public interface MyCallBack{
        public void setlist(List<MyBean.DataBean> list);
    }
}
