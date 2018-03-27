package com.wst.firecheck;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.util.Log;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;
import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.util.LogUtils;
import com.wst.firecheck.model.User;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private GridView gvHome;

    private String[] mItems = new String[] { "基础信息", "检查标准", "消防检查","检查报告"};

    private int[] mPics = new int[] { R.drawable.baseinfo,
            R.drawable.data, R.drawable.firecheck,
            R.drawable.checkresult};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        User user=JSON.parseObject(intent.getStringExtra("user"),User.class);
        LogUtils.d(user.getName());//
        gvHome = (GridView) findViewById(R.id.gv_home);
        gvHome.setAdapter(new HomeAdapter());
        // 设置监听
        gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        // 基础信息
                        startActivity(new Intent(MainActivity.this,BaseActivity.class));
                        break;
                    case 1:
                        //检查标准
                        break;
                    case 2:
                        //检查主页
                        startActivity(new Intent(MainActivity.this,CheckIndexActivity.class));
                        break;
                    case 3:
                        //检查报告
                        startActivity(new Intent(MainActivity.this,
                                SetOptionActivity.class));
                        break;

                    default:
                        break;
                }
            }
        });
    }
    class HomeAdapter extends BaseAdapter {

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
            View view = View.inflate(MainActivity.this,
                    R.layout.main_list_item, null);
            ImageView ivItem = (ImageView) view.findViewById(R.id.iv_item);
            TextView tvItem = (TextView) view.findViewById(R.id.tv_item);
            tvItem.setText(mItems[position]);
            ivItem.setImageResource(mPics[position]);
            return view;
        }

    }
}
