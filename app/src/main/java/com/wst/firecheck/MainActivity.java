package com.wst.firecheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationBar.OnTabSelectedListener;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.util.Log;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnTabSelectedListener{

    private static final String TAG = "MainActivity";

    private GridView gvHome;
    private BottomNavigationBar bottomNavigationBar;

    private String[] mItems = new String[]{"基础信息", "检查标准", "消防检查", "检查报告"};

    private int[] mPics = new int[]{R.drawable.baseinfo,
            R.drawable.data, R.drawable.firecheck,
            R.drawable.checkresult};
    private int lastSelectedPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**底部菜单*/
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.index, R.string.btn_home).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.message, R.string.btn_message).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.workdesk, R.string.btn_workTable).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.me, R.string.btn_me).setActiveColorResource(R.color.orange))
                .setFirstSelectedPosition(0)
                .setBarBackgroundColor(R.color.colorPrimary)
                .initialise();

//        fragments = getFragments();
//        setDefaultFragment();
        /**设置底部菜单的监听*/
        bottomNavigationBar.setTabSelectedListener(this);

        TextBadgeItem mTextBadgeItem = new TextBadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.colorAccent)
                .setAnimationDuration(200)
                .setText("3")
                .setHideOnSelect(false);

        ShapeBadgeItem mShapeBadgeItem = new ShapeBadgeItem()
                .setShapeColorResource(R.color.colorPrimary)
                .setGravity(Gravity.TOP | Gravity.END)
                .setHideOnSelect(false);

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
                        startActivity(new Intent(MainActivity.this, BaseActivity.class));
                        break;
                    case 1:
                        //检查标准
                        break;
                    case 2:
                        //检查主页
                        startActivity(new Intent(MainActivity.this, CheckIndexActivity.class));
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
    /**主页菜单的适配器*/
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

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {

    }

    /**
     * 底部菜单选中
     */
    @Override
    public void onTabSelected(int position) {
        lastSelectedPosition = position;
        switch (position) {
            case 0:
                //当前页面是主页的情况下，不作动作。
                Log.i("INFOR", "点击了主页底部主页按钮");
                break;
            case 1:
                //todo 跳转到消息页面
                Log.i("INFOR", "goto message");
                break;
            case 2:
                //todo 跳转到工作台页面
                Log.i("INFOR", "goto work");
                break;
            case 3:
                //todo 跳转到 我 页面
                Log.i("INFOR", "goto me");
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

}
