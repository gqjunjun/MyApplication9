package Util;

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
    static OkhttpUtil okhttpUtill;
    OkHttpClient okHttpClient;
    private OkhttpUtil(){
        okHttpClient  = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request =chain.request();
                Response response =chain.proceed(request);

                return response;
            }
        }).build();
    }
    public static synchronized OkhttpUtil getindfac(){
        if(okhttpUtill==null){
            okhttpUtill = new OkhttpUtil();
        }
        return okhttpUtill;
    }

    public void doGet(String url , Map<String,String> map , Callback callback){
        if(map!=null&&map.size()>0){
            StringBuilder builder = new StringBuilder();
            for (String key:map.keySet()){
                    String value = map.get(key);
                    builder.append(key).append("=").append(value).append("&");
            }
            String str =builder.toString();
            int index = str.lastIndexOf("&");
            str= str.substring(0,index);
            url+="?"+str;
        }
        Request request = new Request.Builder().get().url(url).build();
        Call call =okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
