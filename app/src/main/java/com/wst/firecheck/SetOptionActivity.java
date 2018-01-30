package com.wst.firecheck;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wst.firecheck.View.SetOptionItemView;

/**
 * Created by admin on 2018/1/29.
 */

public class SetOptionActivity extends AppCompatActivity {
    private SetOptionItemView sivUpdate;// 设置升级
    private SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setoption);

        mPref = getSharedPreferences("config", MODE_PRIVATE);

        sivUpdate = (SetOptionItemView) findViewById(R.id.siv_update);
        //sivUpdate.setTitle("自动更新设置");

        boolean autoUpdate = mPref.getBoolean("auto_update", true);

        if (autoUpdate) {
            //sivUpdate.setDesc("自动更新已开启");
            sivUpdate.setChecked(true);
        } else {
            //sivUpdate.setDesc("自动更新已关闭");
            sivUpdate.setChecked(false);
        }

        sivUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 判断当前的勾选状态
                if (sivUpdate.isChecked()) {
                    // 设置不勾选
                    sivUpdate.setChecked(false);
                    //sivUpdate.setDesc("自动更新已关闭");
                    // 更新sp
                    mPref.edit().putBoolean("auto_update", false).commit();
                } else {
                    sivUpdate.setChecked(true);
                    //sivUpdate.setDesc("自动更新已开启");
                    // 更新sp
                    mPref.edit().putBoolean("auto_update", true).commit();
                }
            }
        });
    }
}
