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

    //企业清单初始化
    private void initItems() {
        InfoItem id = new InfoItem("ID","0001");
        itemList.add(id);
        InfoItem customNumCode = new InfoItem("单位编号","0001");
        itemList.add(customNumCode);
        InfoItem companyName = new InfoItem("企业名称","01001-泽台光学工业");
        itemList.add(companyName);
        InfoItem status = new InfoItem("状态","待查");
        itemList.add(status);
        InfoItem leader =new InfoItem("负责人","某某");
        itemList.add(leader);
        InfoItem mobile =new InfoItem("联系方式","13565006543");
        itemList.add(mobile);
        InfoItem checkType =new InfoItem("检查类型","三小场所");
        itemList.add(checkType);
        InfoItem community =new InfoItem("社区","大王山");
        itemList.add(community);
        InfoItem industrial =new InfoItem("工业园","万得山");
        itemList.add(industrial);
        InfoItem policeStation =new InfoItem("派出所","南园");
        itemList.add(policeStation);
        InfoItem address =new InfoItem("地址","深圳市南山区");
        itemList.add(address);
    }
}
