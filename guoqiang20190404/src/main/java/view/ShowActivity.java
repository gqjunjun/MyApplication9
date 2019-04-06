package view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.guoqiang20190404.R;

import java.util.ArrayList;
import java.util.List;

import adapter.WaiAdapter;
import bean.MyBean;
import jiekou.contraInterface;
import ptesenter.MyPresenter;

public class ShowActivity extends AppCompatActivity implements contraInterface.ShowIntterface {
    contraInterface.Presenterface presenterface;
    List<MyBean.DataBean> list = new ArrayList<>();
    RecyclerView recyclerView_1;
    CheckBox checkBox_1;
    WaiAdapter adapter;
    TextView text_zong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        recyclerView_1 = findViewById(R.id.recyvlerview_1);
        checkBox_1 = findViewById(R.id.checkbox_1);
        text_zong = findViewById(R.id.text_zong);
        init();
        checkBox_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkBox_1.isChecked()){
                    ischecked(true);
                }else{
                    ischecked(false);
                }
                adapter.notifyDataSetChanged();
            }

        });
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_1.setLayoutManager(layoutManager);
        adapter = new WaiAdapter(list,this);
        recyclerView_1.setAdapter(adapter);
        presenterface = new MyPresenter<>(this);
        presenterface.requsetData();
    }


    @Override
    public void showData(Object obj) {
        MyBean myBean = (MyBean) obj;
        list.addAll(myBean.getData());
        adapter.notifyDataSetChanged();
    }

    public void ischecked(boolean b){
        for (int i = 0; i <list.size() ; i++) {
            list.get(i).chebox_1 =b;
            for (int j = 0; j <list.get(i).getList().size() ; j++) {
                list.get(i).getList().get(j).chebox_2=b;
            }
        }
        getSum();
    }
    public void  getSum(){
        int sum =0;
        for (int i = 0; i <list.size() ; i++) {

            for (int j = 0; j <list.get(i).getList().size() ; j++) {

                if(list.get(i).getList().get(j).chebox_2){
                    double price = list.get(i).getList().get(j).getPrice();
                    sum +=price;
                }


            }
        }
        text_zong.setText(sum+"");
    }


}
