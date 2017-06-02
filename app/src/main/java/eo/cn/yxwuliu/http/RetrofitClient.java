package eo.cn.yxwuliu.http;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eo.cn.yxwuliu.api.Api;
import eo.cn.yxwuliu.server.IHttpInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 这个类是自己封装好的请求client，通过okhttpclient
 * Created by Administrator on 2017/3/28 0028.
 * 单例模式
 */

public class RetrofitClient {

    private static IHttpInterface singleton;

    public static IHttpInterface getRetrofit(OkHttpClient client) {
        if (singleton == null) {
            synchronized (RetrofitClient.class) {
                singleton = createRetrofit(client).create(IHttpInterface.class);
            }
        }
        return singleton;
    }

    public static IHttpInterface getRetrofit() {
        if (singleton == null) {
            synchronized (RetrofitClient.class) {
                singleton = createRetrofit().create(IHttpInterface.class);
            }
        }
        return singleton;
    }


    private static Retrofit createRetrofit(OkHttpClient client) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    private static Retrofit createRetrofit() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Api.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }


}
