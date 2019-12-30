package com.bw.miaoheng20191230.utils;

import android.os.Handler;

import com.bw.miaoheng20191230.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 时间 :2019/12/30  8:46
 * 作者 :苗恒
 * 功能 :
 */
public class OkHttpUtils {
    Handler handler=new Handler();
    private static OkHttpUtils okHttpUtils;

    private OkHttpUtils() {
    }

    public static OkHttpUtils getInstance() {
        if(okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if(okHttpUtils==null){
                    okHttpUtils=new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
    public void doGet(String url, final OkCallBack okCallBack){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .connectTimeout(3, TimeUnit.SECONDS)
                .build();
        Request request=new Request.Builder()
                .url(url)
                .get()
                .build();
         okHttpClient.newCall(request).enqueue(new Callback() {
             @Override
             public void onFailure(@NotNull Call call, @NotNull final IOException e) {
                  handler.post(new Runnable() {
                      @Override
                      public void run() {
                           okCallBack.failur(e);
                      }
                  });
             }

             @Override
             public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                 handler.post(new Runnable() {
                     @Override
                     public void run() {
                         try {
                             okCallBack.seccess(response.body().string());
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     }
                 });
             }
         });
    }
    public interface OkCallBack{
        void seccess(String response);
        void failur(Throwable throwable);
    }
}
