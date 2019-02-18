package liushaojie.bawei.com.liushaojie.model.http;

import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.logging.Handler;

import liushaojie.bawei.com.liushaojie.model.bean.NewsBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 刘少杰
 * @Date: 2019/2/18 08:57:50
 * @Description:
 */
public class Http<T> {
    //单例
    private static Http http;
    private Http(){}
    public static Http getInstance(){
        if (http==null){
            return new Http();
        }else{
            return http;
        }
    }
    //接口回调
    private CallBackData callBackData;

    public void setCallBackData(CallBackData callBackData) {
        this.callBackData = callBackData;
    }
    //拦截器
    private static Interceptor interceptor(){
        Interceptor interceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request=chain.request();
                Log.e("myMessage","------------"+"拦截前");
                Response response=chain.proceed(request);
                Log.e("myMessage","------------"+"拦截后");
                return response;
            }
        };
        return interceptor;
    }
    //OKHttp POST请求
    public void postData(String path,String title,String link,final Class<T> tClass){
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("title", title)
                .add("link", link)
                .build();
        Request request = new Request.Builder().url(path).post(formBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败
                callBackData.onErr(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //成功
                String s = response.body().toString();
                //Gson解析
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(s, NewsBean.class);
                T t= (T) newsBean.getData().getData();
                Message message=new Message();
                message.obj=t;
                handler.sendMessage(message);
            }
        });

    }
    //OKHttp GET请求
    public void getData(String path,final Class<T> tClass){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        Request request = new Request.Builder().url(path).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败
                callBackData.onErr(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //成功
                String s = response.body().toString();
                //Gson解析
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(s, NewsBean.class);
                T t= (T) newsBean.getData().getData();
                Message message=new Message();
                message.obj=t;
                handler.sendMessage(message);
            }
        });
    }
    public interface CallBackData<D>{
        void onSuccess(D d);
        void onErr(IOException e);
    }
    //Handler
    android.os.Handler handler=new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            T t= (T) msg.obj;
            callBackData.onSuccess(t);
        }
    };
}
