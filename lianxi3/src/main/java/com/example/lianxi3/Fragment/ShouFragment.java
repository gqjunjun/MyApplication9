package com.example.lianxi3.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lianxi3.R;
import com.example.lianxi3.adapter.WaiAdapter;
import com.example.lianxi3.bean.MyBean;
import com.example.lianxi3.jiekou.ContarInterfac;
import com.example.lianxi3.presenter.MyPersenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class ShouFragment extends Fragment implements ContarInterfac.shouFragmentFace {
    ContarInterfac.PresenterFara presenterFara;
    TextView text_zong;
    RecyclerView recyclerview_1;
    public CheckBox checkBox_1;
    WaiAdapter adapter;
    public List<MyBean.DataBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shou_fragment, container, false);
        text_zong = view.findViewById(R.id.text_zong);
        recyclerview_1 = view.findViewById(R.id.recyclerview_1);
        checkBox_1 = view.findViewById(R.id.checkbox_1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_1.setLayoutManager(layoutManager);
        adapter = new WaiAdapter(list, getContext(), this);
        recyclerview_1.setAdapter(adapter);
        presenterFara = new MyPersenter<>(this);
        presenterFara.getDate();

        checkBox_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum =0;
                boolean b = checkBox_1.isChecked();
                if(b){
                    for (int i = 0; i <list.size() ; i++) {
                        list.get(i).waichecde =b;
                        for (int j = 0; j <list.get(i).getList().size() ; j++) {
                            list.get(i).getList().get(j).lichecde=b;
                            double price = list.get(i).getList().get(j).getPrice();
                            int num = list.get(i).getList().get(j).getNum();
                            sum+=price*num;
                        }
                    }
                }else{
                    for (int i = 0; i <list.size() ; i++) {
                        list.get(i).waichecde =b;
                        for (int j = 0; j <list.get(i).getList().size() ; j++) {
                            list.get(i).getList().get(j).lichecde=b;

                        }
                        sum=0;
                    }

                }
                text_zong.setText(sum+"");
                adapter.notifyDataSetChanged();
            }
        });

        adapter.setMyCallBack(new WaiAdapter.MyCallBack() {
            @Override
            public void setlist(List<MyBean.DataBean> wlist) {
                int ss =0;
                int sum=0;
                for (int i = 0; i <wlist.size() ; i++) {
                    if(list.get(i).waichecde){
                        ss++;
                        for (int j = 0; j <wlist.get(i).getList().size() ; j++) {
                            double price = list.get(i).getList().get(j).getPrice();
                            int num = list.get(i).getList().get(j).getNum();
                            sum+=price*num;
                        }
                    }else{
                        for (int j = 0; j <wlist.get(i).getList().size() ; j++) {
                            if(list.get(i).getList().get(j).lichecde){
                                double price = list.get(i).getList().get(j).getPrice();
                                int num = list.get(i).getList().get(j).getNum();
                                sum+=price*num;
                            }

                        }
                    }
                }
                if(ss ==wlist.size()){
                    checkBox_1.setChecked(true);
                }else{
                    checkBox_1.setChecked(false);
                }
                text_zong.setText(sum+"");
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void showDate(Object obj) {

        MyBean myBean = (MyBean) obj;

        list.addAll(myBean.getData());
        list.remove(0);
        adapter.notifyDataSetChanged();

    }
}

