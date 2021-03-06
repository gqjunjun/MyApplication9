package util;

import android.view.View;

import java.io.IOException;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class OkhttpUtil {
    static OkhttpUtil okhttpUtil;
    OkHttpClient okHttpClient = null;
    private OkhttpUtil(){
       OkHttpClient.Builder builder = new OkHttpClient.Builder();
       builder.addInterceptor(new Interceptor() {
           @Override
           public Response intercept(Chain chain) throws IOException {
               Request request = chain.request();
               Response response = chain.proceed(request);
               return response;
           }
       });
       okHttpClient = builder.build();
    }
    public static OkhttpUtil getisface(){
        if(okhttpUtil==null){
            okhttpUtil =new OkhttpUtil();

        }
        return okhttpUtil;
    }
    public void doGet(String url, Map<String,String> map ,Callback callback){
        if(map!=null&&map.size()>0){
            StringBuilder builder = new StringBuilder();
            for (String key:map.keySet()) {
                String value =map.get(key);
                builder.append(key).append("=").append(value).append("&");
            }
            String path =builder.toString();
            int index = path.lastIndexOf("&");
             path= path.substring(0,index);
             url+="?"+path;

        }
        Request request = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }


    public void  doPost(String url, String phone,String pwd ,Callback callback){
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("phone",phone);
        builder.add("pwd",pwd);
        RequestBody body = builder.build();
        Request request =new Request.Builder().post(body).url(url).build();
        Call call =okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
