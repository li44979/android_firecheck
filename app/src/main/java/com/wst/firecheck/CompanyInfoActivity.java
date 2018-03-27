package com.wst.firecheck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.wst.firecheck.Adapter.SingleItemAdapter;
import com.wst.firecheck.Domin.InfoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/2/26.
 */

public class CompanyInfoActivity extends AppCompatActivity {
    private List<InfoItem> itemList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context self=this;
        setContentView(R.layout.activity_base_company_info);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        String companyId=intent.getStringExtra("id");
        MyOkHttp http=new MyOkHttp();
        http.get()
                .url("http://192.168.0.105:8080/api/company")
                .addParam("id",companyId)
                .tag(this)
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                      //  initItems();
                        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rlv_company_info);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(self);
                        recyclerView.setLayoutManager(layoutManager);
                        SingleItemAdapter singleItemAdapter = new SingleItemAdapter(itemList);
                        recyclerView.setAdapter(singleItemAdapter);
                    }
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });
    }

    private void initItems() {
        InfoItem id = new InfoItem("ID","0001");
        itemList.add(id);
        InfoItem companyName = new InfoItem("企业名称","01001-泽台光学工业");
        itemList.add(companyName);
        InfoItem status = new InfoItem("状态","待查");
        itemList.add(status);
        itemList.add(id);
        itemList.add(companyName);
        itemList.add(status);
        itemList.add(id);
        itemList.add(companyName);
        itemList.add(status);
        itemList.add(id);
        itemList.add(companyName);
        itemList.add(status);
        itemList.add(id);
        itemList.add(companyName);
        itemList.add(status);
    }
}
