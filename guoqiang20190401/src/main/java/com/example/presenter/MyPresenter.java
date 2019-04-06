package com.example.presenter;

import java.util.HashMap;
import java.util.Map;

import jiekou.contraface;
import model.MyModel;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class MyPresenter<T> implements contraface.presenInface{
  MyModel myModel;

  T tt;
    public MyPresenter(T tt) {
        this.tt = tt;
        myModel = new MyModel();
    }

    @Override
    public void RrqeustData() {
        String url ="http://172.17.8.100/small/commodity/v1/commodityList?status=%E7%8A%B6%E6%80%81";
        Map<String,String> map = new HashMap<>();

        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void sruuscc(Object obj) {
                contraface.viewInface viewInface = (contraface.viewInface) tt;
                viewInface.shouData(obj);
            }
        });
        myModel.getData(url,null);
    }


}
