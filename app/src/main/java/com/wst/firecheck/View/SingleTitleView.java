package com.wst.firecheck.View;

import android.widget.LinearLayout;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.wst.firecheck.R;

/**
 * Created by admin on 2018/2/27.
 */

public class SingleTitleView extends LinearLayout {
    private TextView title_tv;
    private TextView content_tv;

    public SingleTitleView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.single_title_view, this);
        title_tv = ((TextView) findViewById(R.id.tv_item_title));
        content_tv = ((TextView) findViewById(R.id.tv_item_content));
    }
    /**1
     * 设置标题
     * @param title  标题内容
     */
    public void setitem_title(String title) {
        if (isNotNull(title, title_tv)) {
            title_tv.setText(title);
        }
    }
    /**
     * 设置内容
     * @param content  内容
     */
    public void setitem_content(String content) {
        if (isNotNull(content, content_tv)) {
            content_tv.setText(content);
        }
    }
//    /**
//     * 设置单位
//     * @param danwei 单位内容
//     */
//    public void setDanwei(String danwei){
//        if (isNotNull(danwei,danwei_tv)){
//            danwei_tv.setVisibility(View.VISIBLE);
//            danwei_tv.setText(danwei);
//            if (">".equals(danwei)) {
//                danwei_tv.setTextColor(Color.parseColor("#057dff"));
//            }
//        }
//    }

    public void setContentColor(int s){
        content_tv.setTextColor(s);
    }

    /**
     * 判断控件和内容是否为空
     * @param s  内容
     * @param t   控件
     * @return    false==》空；true==》不为空
     */
    private boolean isNotNull(String s, TextView t) {
        return (s!=null&&!"".equals(s)&&!"null".equals(s)&&t!=null);
    }
}
