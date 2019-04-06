package model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import bean.MyBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import util.OkHttpUtil;

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

            int ss= msg.arg1;
            Log.e("aaa","123");
            if(ss==1){
                String json = (String) msg.obj;
                try {
                    JSONObject oject = new JSONObject(json);
                    String m = oject.getString("message");
                    myCallBack.suruucee(m);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else{
                String json = (String) msg.obj;
                Gson gson = new Gson();
                MyBean myBean = gson.fromJson(json, MyBean.class);
                myCallBack.suruucee(myBean);
            }
        }
    };
    public void reqeustGet(String url, final Map<String,String> map){
        OkHttpUtil okHttpUtil =OkHttpUtil.getisfac();
        okHttpUtil.doGet(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message= new Message();
                message.obj=json;
                Log.e("aaa","456");
                handler.sendMessage(message);

            }
        });

    }
    public void reqeustPost(String url,String phone,String pwd){
        OkHttpUtil okHttpUtil= OkHttpUtil.getisfac();
        okHttpUtil.doPost(url, phone, pwd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message= new Message();
                message.obj=json;
                message.arg1=1;
                handler.sendMessage(message);
        }
        });
    }


    public void setMyCallBack(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }


    public interface MyCallBack{
        public void suruucee(Object obj);
    }
}
