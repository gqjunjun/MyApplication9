package com.example.lianxi3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lianxi3.Fragment.ShouFragment;
import com.example.lianxi3.R;
import com.example.lianxi3.bean.MyBean;

import java.util.List;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class LiAdaoter extends RecyclerView.Adapter<LiAdaoter.Holder_2> {
    List<MyBean.DataBean.ListBean> list;
    Context context;
    ShouFragment shouFragment;
    private MyCallBack myCallBack;


    public LiAdaoter(List<MyBean.DataBean.ListBean> list, Context context, ShouFragment shouFragment) {
        this.list = list;
        this.context = context;
        this.shouFragment = shouFragment;
    }

    @NonNull
    @Override
    public Holder_2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.li_layout,null);
        return new Holder_2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder_2 holder_2, final int i) {
        double price = list.get(i).getPrice();
        String title = list.get(i).getTitle();
        String url = list.get(i).getImages();
        final int num = list.get(i).getNum();
        holder_2.text_shu.setText(num+"");
        holder_2.text_title.setText(title);
        holder_2.text_price.setText(price+"");
        Glide.with(context).load(url).into(holder_2.image_view);
        holder_2.checkbox_3.setChecked(list.get(i).lichecde);

        holder_2.checkbox_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = holder_2.checkbox_3.isChecked();
                list.get(i).lichecde=b;
                myCallBack.setlist(list);
            }
        });
            holder_2.text_jia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int li = list.get(i).getNum();
                    li++;
                    list.get(i).setNum(li);
                    holder_2.text_shu.setText(li+"");
                    myCallBack.setlist(list);
                }
            });
        holder_2.text_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int li = list.get(i).getNum();
                if(li==1){
                    return;
                }
                li--;
                list.get(i).setNum(li);
                holder_2.text_shu.setText(li+"");
                myCallBack.setlist(list);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder_2 extends RecyclerView.ViewHolder{
        ImageView image_view;
        TextView text_jia,text_jian,text_shu,text_title,text_price;

        CheckBox checkbox_3;
        public Holder_2(@NonNull View itemView) {
            super(itemView);
            image_view  =itemView.findViewById(R.id.image_view);
            text_jia  =itemView.findViewById(R.id.text_jia);
            text_jian  =itemView.findViewById(R.id.text_jian);
            text_shu  =itemView.findViewById(R.id.text_shu);
            text_title  =itemView.findViewById(R.id.text_title);
            text_price  =itemView.findViewById(R.id.text_price);
            checkbox_3  =itemView.findViewById(R.id.checkbox_3);


        }
    }
    public void setMyCallBack(MyCallBack myCallBack){
        this.myCallBack=myCallBack;
    }
    public interface MyCallBack{
        public void setlist(List<MyBean.DataBean.ListBean> list);
    }

}
