package Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者： 郭强
 * 邮箱： 69666501@qq.com
 * 版本：V1.1
 */
public class OkhttpUtil {
    public static boolean isNo(Context context){
        if(context!=null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo of = manager.getActiveNetworkInfo();
            if(of!=null){
                return of.isConnected();
            }

        }
        return false;
    }

   static   OkhttpUtil okhttpUtil;
   OkHttpClient okHttpClient;
    private  OkhttpUtil(){

        okHttpClient  = new OkHttpClient.Builder().addInterceptor(new MyInterceptor()).build();
    }

    public static synchronized OkhttpUtil getisfradc(){
        if(okhttpUtil==null) {
            okhttpUtil = new OkhttpUtil();
        }
        return okhttpUtil;
    }
    public void doGet(String url, Map<String,String> map , Callback callback){
          if(map!=null&&map.size()>0){
              StringBuilder builder = new StringBuilder();
              for (String key:map.keySet()){
                  String value =map.get(key);
                  builder.append(key)
                          .append("=")
                          .append(value)
                          .append("&");

              }
              String s = builder.toString();
              int index = s.lastIndexOf("&");
             s = s.substring(0,index);
             url+="?"+s;
          }

          Request request = new Request.Builder()
                  .url(url)
                  .get()
                  .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public class  MyInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            return response;
        }
    }
}
