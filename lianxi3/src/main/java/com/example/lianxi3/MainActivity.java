package com.example.lianxi3;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.lianxi3.Fragment.MyFragment;
import com.example.lianxi3.Fragment.ShouFragment;
import com.example.lianxi3.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RadioGroup radio_group;
    ViewPager view_pager;
    List<Fragment> list;
    FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio_group=findViewById(R.id.radio_group);
        view_pager=findViewById(R.id.view_pager);

        init();

    }

    private void init() {
        list = new ArrayList<>();
        list.add(new ShouFragment());
        list.add(new MyFragment());
        adapter = new FragmentAdapter(getSupportFragmentManager(),list, this);
        view_pager.setAdapter(adapter);
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rd1:
                        view_pager.setCurrentItem(0,false);
                        break;
                    case R.id.rd2:
                        view_pager.setCurrentItem(1,false);
                        break;
                }
            }
        });
    }
}
