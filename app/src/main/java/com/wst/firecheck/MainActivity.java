package com.wst.firecheck;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button me;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tvapi);
        me=findViewById(R.id.me);
        me.setOnClickListener((v)-> {
            Toast.makeText(MainActivity.this, "你点击了我", Toast.LENGTH_LONG).show();
        } );
        String url="http://192.168.0.103:8080/api/values/5";
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtil.sendOkHttpRequest(url, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseData=response.body().string();
                        showResponse(responseData);
                    }
                });
            }
        }).start();
    }
          private void showResponse(final String response)
          {
              runOnUiThread(()-> {
                    Log.d(TAG, "~"+response+"~");
                      List<User> userList= JSON.parseArray(response,User.class);//反序列化
                     for(User u:userList){
                         Log.d(TAG, Integer.toString(u.getId()));
                         Log.d(TAG, u.getName());
                     }
              });
          }
}
