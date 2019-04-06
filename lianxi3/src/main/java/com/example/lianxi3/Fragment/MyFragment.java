package com.example.lianxi3.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.lianxi3.R;


/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class MyFragment extends Fragment {
    TextView text_login;
    ImageView image_view_1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.my_fragment,container,false);
        text_login=view.findViewById(R.id.text_login);
        image_view_1=view.findViewById(R.id.image_view_1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        text_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),"登录",Toast.LENGTH_SHORT).show();
            }
        });
        String url="http://172.17.8.100//images//small//commodity//xbsd//sjb//5//1.jpg";
        Glide.with(getContext()).load(url).into(image_view_1);


    }
}
