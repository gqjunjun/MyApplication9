package com.example.rikao20;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class MyLayout extends LinearLayout {
    MyCallBack myCallBack;
    TextView text_fan,text_ti;
    MainActivity activity;
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        activity = (MainActivity) context;
        View view =LayoutInflater.from(context).inflate(R.layout.linear_layout,this);
        text_fan =view.findViewById(R.id.text_fan);
        text_ti =view.findViewById(R.id.text_ti);
        text_fan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack.fan();
            }
        });
        text_ti.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack.ti();
            }
        });

    }

    public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setMyCallBack(MyCallBack myCallBack){
        this.myCallBack=myCallBack;
    }


    public interface MyCallBack{
        public void fan();
        public void ti();
    }
}
