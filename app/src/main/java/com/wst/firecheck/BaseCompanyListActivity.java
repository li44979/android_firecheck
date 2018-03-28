package com.wst.firecheck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.alibaba.fastjson.JSON;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.wst.firecheck.Adapter.CompanyListAdapter;
import com.wst.firecheck.model.Company;
import com.wst.firecheck.model.Config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by admin on 2018/1/31.
 */

public class BaseCompanyListActivity extends AppCompatActivity {
   private List<Company> companys=new ArrayList<>();
    private SearchView mSearchView;
    private ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context self=this;
        setContentView(R.layout.activity_base_company_list);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSearchView = findViewById(R.id.sv_company);
        mListView = findViewById(R.id.lv_company);
        mListView.setTextFilterEnabled(true);
        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    mListView.setFilterText(newText);
                }else{
                    mListView.clearTextFilter();
                }
                return false;
            }
        });
        //设置ListView的点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Company company=companys.get(position);
                //进入企业信息页面
                Intent intent=new  Intent(BaseCompanyListActivity.this,CompanyInfoActivity.class);
                intent.putExtra("id",String.valueOf(company.getCompanyId()));
                startActivity(intent);
            }
        });
        MyOkHttp http=new MyOkHttp();
        http.get()
                .url(Config.ApiUrl+"/api/Company/GetCompanyList")
                .addParam("pageIndex","1")
                .addParam("pageSize","20")
                .tag(this)
                .enqueue(new RawResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, String response) {
                        companys= JSON.parseArray(response,Company.class);
                        CompanyListAdapter adapter=new CompanyListAdapter(BaseCompanyListActivity.this,R.layout.listview_company,companys);
                        mListView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                    }
                });

    }
}
