package com.example.lianxi2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import adapter.FragmentAdapter;
import fragment.MyFragment;
import fragment.ShowFragment;

public class MainActivity extends AppCompatActivity {
    ViewPager view_pager;
    RadioGroup radio_group;
    List<Fragment> list = new ArrayList<>();
    FragmentAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_pager =findViewById(R.id.view_pager);
        radio_group=findViewById(R.id.radiogroup);
        list.add(new ShowFragment());
        list.add(new MyFragment());
        adapter = new FragmentAdapter(getSupportFragmentManager(), list, this);
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
