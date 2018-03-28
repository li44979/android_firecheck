package com.wst.firecheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.util.LogUtils;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.wst.firecheck.Adapter.CompanyListAdapter;
import com.wst.firecheck.Adapter.UserListAdapter;
import com.wst.firecheck.model.Company;
import com.wst.firecheck.model.Config;
import com.wst.firecheck.model.User;

import java.util.ArrayList;
import java.util.List;

public class User_List_Activity extends AppCompatActivity {
    private List<User> users=new ArrayList<>();
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__list_);
        mListView=findViewById(R.id.list_user);
        MyOkHttp http=new MyOkHttp();
        http.get()
                .url(Config.ApiUrl+"/api/User/GetUserList")
                .addParam("pageIndex","1")
                .addParam("pageSize","20")
                .tag(this)
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        users= JSON.parseArray(response,User.class);
                        UserListAdapter adapter=new UserListAdapter(User_List_Activity.this,R.layout.listview_user,users);
                        mListView.setAdapter(adapter);
                    }
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        LogUtils.e(error_msg);
                    }
                });
    }
}
