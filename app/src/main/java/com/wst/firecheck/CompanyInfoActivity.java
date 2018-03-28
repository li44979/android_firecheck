package com.wst.firecheck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.wst.firecheck.Adapter.SingleItemAdapter;
import com.wst.firecheck.Domin.InfoItem;
import com.wst.firecheck.model.Company;

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
                        List<Company> companys= JSON.parseArray(response,Company.class);
                        if(companys.size()>0) {
                            initItems(companys.get(0));
                        }
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

    //企业清单初始化
    private void initItems(Company company) {
        InfoItem id = new InfoItem("ID",String.valueOf(company.getCompanyId()));
        itemList.add(id);
        InfoItem customNumCode = new InfoItem("单位编号",company.getCustomNumCode());
        itemList.add(customNumCode);
        InfoItem companyName = new InfoItem("企业名称",company.getCustomNumCode()+"-"+company.getCompanyName());
        itemList.add(companyName);
        InfoItem status = new InfoItem("状态",company.getStatus());
        itemList.add(status);
        InfoItem leader =new InfoItem("负责人",company.getLeader());
        itemList.add(leader);
        InfoItem mobile =new InfoItem("联系方式",company.getMobile());
        itemList.add(mobile);
        InfoItem checkType =new InfoItem("检查类型",company.getCheckType());
        itemList.add(checkType);
        InfoItem community =new InfoItem("社区",company.getCommunity());
        itemList.add(community);
        InfoItem industrial =new InfoItem("工业园",company.getIndustrial());
        itemList.add(industrial);
        InfoItem policeStation =new InfoItem("派出所",company.getPoliceStation());
        itemList.add(policeStation);
        InfoItem address =new InfoItem("地址",company.getAddress());
        itemList.add(address);
    }
}
