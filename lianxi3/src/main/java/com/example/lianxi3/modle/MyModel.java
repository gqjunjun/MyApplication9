package com.example.lianxi3.modle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Adapter;

import com.example.lianxi3.bean.MyBean;
import com.example.lianxi3.util.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class MyModel {
    MyCallBack myCallBack;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int ar = msg.arg1;
            if(ar==1){
                String json = (String) msg.obj;
                Gson gson = new Gson();
                MyBean myBean = gson.fromJson(json, MyBean.class);
                myCallBack.seccuea(myBean);
            }
        }
    };
    public void RequestGet(String url, Map<String,String> map){
        OkHttpUtil okHttpUtil = OkHttpUtil.getinfaets();
        okHttpUtil.doGet(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //成功
                String json = response.body().string();
                Message message = new Message();
                message.obj=json;
                message.arg1=1;
                handler.sendMessage(message);
            }
        });

    }
    public void RequestPost(){

    }

    public void setMyCallBack (MyCallBack myCallBack){
        this.myCallBack=myCallBack;
    }

    public interface MyCallBack{
        public void seccuea(Object o);
    }
}
