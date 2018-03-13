package com.wst.firecheck.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wst.firecheck.R;

/**
 * Created by admin on 2018/2/24.
 */

public class SetTextviewInfoOneView extends LinearLayout {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.wst.firecheck";
    private TextView tvTitle;
    private TextView tvCont;
    private String mTitle;
    private String mCont;

    public SetTextviewInfoOneView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        initView();
    }

    public SetTextviewInfoOneView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTitle = attrs.getAttributeValue(NAMESPACE, "title");// 根据属性名称,获取属性的值
        mCont = attrs.getAttributeValue(NAMESPACE, "cont");

        initView();

//         int attributeCount = attrs.getAttributeCount();
//
//         for (int i = 0; i < attributeCount; i++) {
//         String attributeName = attrs.getAttributeName(i);
//         String attributeValue = attrs.getAttributeValue(i);
//         System.out.println(attributeName + "=" + attributeValue);
//         }
    }

    public SetTextviewInfoOneView(Context context) {
        super(context);
        initView();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        // 将自定义好的布局文件设置给当前的SettingItemView
        View view = View.inflate(getContext(), R.layout.info_textview_one,this);
        addView(view);

        tvTitle = (TextView) findViewById(R.id.tv_info_title);
        tvCont = (TextView) findViewById(R.id.tv_intfo_content);

        setTitle(mTitle);// 设置标题
        setmCont(mCont);//设置内容

    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setmCont(String cont) {
        tvCont.setText(cont);
    }
}

