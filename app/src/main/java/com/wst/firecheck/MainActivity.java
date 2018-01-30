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
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;
import com.alibaba.fastjson.JSON;
import com.wst.firecheck.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button me;
    private static final String TAG = "MainActivity";

    private GridView gvHome;

    private String[] mItems = new String[] { "基础信息", "检查标准", "消防检查","检查报告"};

    private int[] mPics = new int[] { R.drawable.base,
            R.drawable.check, R.drawable.xf,
            R.drawable.shu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvHome = (GridView) findViewById(R.id.gv_home);
        gvHome.setAdapter(new HomeAdapter());
        // 设置监听
        gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        // 手机防盗
                        //showPasswordDialog();
                        break;
                    case 3:
                        // 设置中心
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
