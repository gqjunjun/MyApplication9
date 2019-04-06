package model;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import Util.OkhttpUtil;
import bean.MyBean;
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
    Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
           int arg = msg.arg1;
           if(arg ==1){
               String json = (String) msg.obj;
               Gson gson = new Gson();
               MyBean myBean = gson.fromJson(json, MyBean.class);
               myCallBack.sruusrr(myBean);
           }
        }
    };

    public void ReqeustData(String url, Map<String,String> map){
        OkhttpUtil okhttpUtil =OkhttpUtil.getindfac();
        okhttpUtil.doGet(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //成功
                String json = response.body().string();
                Message message= new Message();
                message.obj=json;
                message.arg1=1;
                handler.sendMessage(message);
            }
        });
    }


    public void setMyCallBack(MyCallBack myCallBack){
        this.myCallBack=myCallBack;
    }

    public interface MyCallBack{
        public void sruusrr(Object obj);
    }
}
