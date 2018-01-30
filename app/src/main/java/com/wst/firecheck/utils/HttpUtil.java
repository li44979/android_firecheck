package com.wst.firecheck.utils;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by li449 on 2018/1/25.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(final String url,final Callback callback)
    {
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
