package com.example.rikao18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.LinearAdapter;
import bean.MyBean;
import jiekou.contraInterface;
import presenter.MyPtersenter;

public class MainActivity extends AppCompatActivity implements contraInterface.ViewFace {
    contraInterface.PresenterFace presenterFace;
    RecyclerView recyclerView;
    LinearAdapter adapter;
    CheckBox checkBox;
    TextView text_sum;
    List<MyBean.DataBean>  list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        checkBox = findViewById(R.id.checkbox_3);
        text_sum =findViewById(R.id.text_sum);
        init();


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    itlinearlayout(true);
                }else{
                    itlinearlayout(false);
                }
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void itlinearlayout(boolean b) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).isSelect =b;
            for (int j = 0; j < list.get(i).getList().size(); j++) {
                list.get(i).getList().get(j).cheSelect=b;
            }
        }
        getSum();
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new LinearAdapter(list,this);
        recyclerView.setAdapter(adapter);
        presenterFace = new MyPtersenter<>(this);
        presenterFace.getData();

    }

    @Override
    public void showData(Object obj) {
        MyBean myBean = (MyBean) obj;
        list.addAll(myBean.getData());
        adapter.notifyDataSetChanged();
    }

    public void  getSum(){
        double sum=0;
        for (int i = 0; i <list.size() ; i++) {
            for (int j = 0; j <list.get(i).getList().size() ; j++) {
                if(list.get(i).getList().get(j).cheSelect){
                    double price = list.get(i).getList().get(j).getPrice();
                    sum+=price;
                }
            }
        }
        text_sum.setText(sum+"");
    }
}
