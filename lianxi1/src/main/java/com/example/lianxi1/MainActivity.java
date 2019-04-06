package com.example.lianxi1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.WaiAdapter;
import bean.MyBean;
import jiekou.contraInterface;
import presenter.MyPresenter;

public class MainActivity extends AppCompatActivity implements contraInterface.viewFace {
    RecyclerView recyclerView;
    CheckBox checkBox;
    TextView textView;
    WaiAdapter adapter;
    List<MyBean.DataBean> list = new ArrayList<>();
    contraInterface.presenterFace presenterFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.recyclerview_1);
        textView =findViewById(R.id.text_sum);
        checkBox =findViewById(R.id.checkbox_1);
        init();

    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter =new WaiAdapter(list,this);
        recyclerView.setAdapter(adapter);
        presenterFace = new MyPresenter<>(this);
        presenterFace.getData();

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    ischebox(true);
                }else{
                    ischebox(false);
                }
            }
        });


    }
    public void ischebox(boolean b){
        for (int i = 0; i <list.size() ; i++) {
                list.get(i).isSelect=b;
            for (int j = 0; j <list.get(i).getList().size() ; j++) {
                list.get(i).getList().get(j).cheSelect=b;
            }
        }
        adapter.notifyDataSetChanged();
        shouSum();
    }

    @Override
    public void showData(Object o) {
        MyBean myBean = (MyBean) o;
        list.addAll(myBean.getData());
        adapter.notifyDataSetChanged();
    }
    public void shouSum(){
        double sum=0;
        for (int i = 0; i <list.size() ; i++) {

            for (int j = 0; j <list.get(i).getList().size() ; j++) {
                if(list.get(i).getList().get(j).cheSelect){
                    double price = list.get(i).getList().get(j).getPrice();

                    sum+=price;
                }
            }
        }
        textView.setText(sum+"");
    }


}
