package com.example.lianxi3.presenter;

import com.example.lianxi3.jiekou.ContarInterfac;
import com.example.lianxi3.modle.MyModel;


/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class MyPersenter<T> implements ContarInterfac.PresenterFara {
    MyModel myModel;
    T tt;

    public MyPersenter(T tt) {
        this.tt = tt;
        myModel = new MyModel();
    }

    @Override
    public void getDate() {
        String url = "http://172.17.8.100/ks/product/getCarts?uid=51";
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void seccuea(Object o) {
                ContarInterfac.shouFragmentFace shouFragmentFace = (ContarInterfac.shouFragmentFace) tt;
                shouFragmentFace.showDate(o);
            }
        });
        myModel.RequestGet(url,null);
    }
}
