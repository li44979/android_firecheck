package com.wst.firecheck;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.wst.firecheck.Adapter.SingleItemAdapter;
import com.wst.firecheck.Domin.InfoItem;
import com.wst.firecheck.View.SingleTitleView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Created by admin on 2018/2/27.
 */

public class CheckCompanyInfoActivity extends AppCompatActivity {
    private List<InfoItem> itemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_company_info);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initItems();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rlv_company_info);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SingleItemAdapter singleItemAdapter = new SingleItemAdapter(itemList);
        recyclerView.setAdapter(singleItemAdapter);

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
