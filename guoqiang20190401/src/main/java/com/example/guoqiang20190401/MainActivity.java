package com.example.guoqiang20190401;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.adapter.GridAdapter;
import com.example.presenter.MyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import Util.OkhttpUtil;
import bean.MyBean;
import bean.MyBeans;
import bean.PickBean;
import jiekou.contraface;

public class MainActivity extends AppCompatActivity implements contraface.viewInface {
    contraface.presenInface presenInface;
    Banner banner;
    GridAdapter adapter;
    XRecyclerView xRecyclerView;
    List<String> pick = new ArrayList<>();
    List<MyBeans.Result> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);
        xRecyclerView = findViewById(R.id.xrecyclerview);
        boolean no = OkhttpUtil.isNo(this);
        if(no){
            //有网
            isinBaner();
            isinxRecyclerView();
        }else{
            //没网

        }

    }

    private void isinxRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        xRecyclerView.setLayoutManager(layoutManager);

        adapter = new GridAdapter(list, this);
        xRecyclerView.setAdapter(adapter);

        presenInface = new MyPresenter<>(this);
        presenInface.RrqeustData();
    }

    private void isinBaner() {
        pick.add("http://172.17.8.100/images/small/banner/cj.png");
        pick.add("http://172.17.8.100/images/small/banner/hzp.png");
        pick.add("http://172.17.8.100/images/small/banner/lyq.png");
        pick.add("http://172.17.8.100/images/small/banner/px.png");
        pick.add("ttp://172.17.8.100/images/small/banner/wy.png");

        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.setImages(pick);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();

    }

    @Override
    public void shouData(Object obj) {
        MyBeans myBeans  = (MyBeans) obj;

        adapter.notifyDataSetChanged();
    }

}
