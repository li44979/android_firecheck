package com.wst.firecheck;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> names= Arrays.asList("peter","anna","mike");
        Collections.sort(names,(String a,String b)->{
            int i=b.compareTo(a);
            Log.e(TAG, "ll---l"+i );
            return i;
        });
        new Thread(){
            @Override
            public void run()
            {
                String result= Run("http://10.0.2.2:54331/test/get");
                Log.d(TAG, "返回结果"+result);
                handler.sendEmptyMessage(0);
            }
            private Handler handler=new Handler(){
                @Override
                public void handleMessage(Message msg)
                {
                    super.handleMessage(msg);
                }
            };

        }.start();
    }
    String Run(String url){
        OkHttpClient client=new OkHttpClient();
        try{
             Request request=new Request.Builder()
                                .url(url)
                                .build();
             Call call=client.newCall(request);
             Response response=call.execute();
             return  response.body().string();
        }catch (IOException ieo){
            ieo.printStackTrace();
        }
        return "";
    }
}
