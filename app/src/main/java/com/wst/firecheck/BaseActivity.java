package com.wst.firecheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 2018/1/31.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private GridView gvBase;

    private String[] mItems = new String[] { "企业信息", "用户信息","系统设置"};

    private int[] mPics = new int[] { R.drawable.company,
            R.drawable.user, R.drawable.setup};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gvBase = (GridView) findViewById(R.id.gv_base);
        gvBase.setAdapter(new BaseActivity.BaseInfoAdapter());


        // 设置监听
        gvBase.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        // 企业管理
                        startActivity(new Intent(BaseActivity.this,BaseCompanyListActivity.class));
                        break;
                    case 1:
                        // 用户信息
                        startActivity(new Intent(BaseActivity.this,
                                SetOptionActivity.class));
                        break;
                    case 2:
                        // 基础设置
                        startActivity(new Intent(BaseActivity.this,
                                SetOptionActivity.class));
                        break;

                    default:
                        break;
                }
            }
        });
    }

    class BaseInfoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mItems.length;
        }

        @Override
        public Object getItem(int position) {
            return mItems[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(BaseActivity.this,
                    R.layout.main_list_item, null);
            ImageView ivItem = (ImageView) view.findViewById(R.id.iv_item);
            TextView tvItem = (TextView) view.findViewById(R.id.tv_item);

            tvItem.setText(mItems[position]);
            ivItem.setImageResource(mPics[position]);
            return view;
        }
    }
}
