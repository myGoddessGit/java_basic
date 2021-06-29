package com.http;

import com.sun.deploy.util.StringUtils;
import okhttp3.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author by chenYl on 2021/6/15 15:55
 * @Description :
 * @VERSION :
 * @TITLE :
 */
public class OkHttpUtils {
    public static final MediaType jsonMediaType = MediaType.parse("application/json;charset=utf-8");

    private OkHttpUtils() {}

    public static OkHttpClient getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE;
        private OkHttpClient singleton;
        Singleton() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(6L, TimeUnit.SECONDS);
            builder.readTimeout(6L, TimeUnit.SECONDS);
            builder.writeTimeout(6L, TimeUnit.SECONDS);
            ConnectionPool connectionPool = new ConnectionPool(50, 60, TimeUnit.SECONDS);
            builder.connectionPool(connectionPool);
            singleton = builder.build();
        }
        public OkHttpClient getInstance() {
            return singleton;
        }
    }

    //Get
    public static String get(String url) {
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = OkHttpUtil.getInstance().newCall(request).execute();
            if (response.isSuccessful()) {
                String content = response.body().string();
                return content;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * post-form
     */
    public static String postForm(String url, Map<String, String> params) {
        try {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> m : params.entrySet()) {
                builder.add(m.getKey(), m.getValue());
            }
            RequestBody body = builder.build();
            Request request = new Request.Builder().post(body).url(url).build();
            Response response = OkHttpUtil.getInstance().newCall(request).execute();
            if (response.isSuccessful()) {
                String content = response.body().string();
                return content;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //post-JSON
    public static String postJson(String url, String jsonBody) {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(jsonMediaType, jsonBody))
                    .build();

            Response response = OkHttpUtil.getInstance().newCall(request).execute();
            if (response.isSuccessful()) {
                String content = response.body().string();
                return content;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

