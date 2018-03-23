package com.wst.firecheck.View;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wst.firecheck.R;

/**
 * Created by admin on 2018/2/24.
 */

public class SetListItemOneView extends LinearLayout {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.wst.firecheck";
    private ImageView ivIcon;
    private TextView tvTitle;
    private TextView tvRight;

    private String mTitle;
    private Boolean bBottomline;
    private Drawable mLeftIcon;
    private String mRight;

    public SetListItemOneView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        initView();
    }

    public SetListItemOneView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTitle = attrs.getAttributeValue(NAMESPACE, "show_title");// 根据属性名称,获取属性的值
        bBottomline = Boolean.valueOf(attrs.getAttributeValue(NAMESPACE, "show_bottomline"));
        mLeftIcon = Drawable.createFromPath(attrs.getAttributeValue(NAMESPACE, "show_leftimg"));
        mRight= attrs.getAttributeValue(NAMESPACE,"show_leftChar");
        initView();

//         int attributeCount = attrs.getAttributeCount();
//
//         for (int i = 0; i < attributeCount; i++) {
//         String attributeName = attrs.getAttributeName(i);
//         String attributeValue = attrs.getAttributeValue(i);
//         System.out.println(attributeName + "=" + attributeValue);
//         }
    }

    public SetListItemOneView(Context context) {
        super(context);
        initView();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        // 将自定义好的布局文件设置给当前的SettingItemView
        View view = View.inflate(getContext(), R.layout.item_view_one,this);
        addView(view);

        ivIcon = findViewById(R.id.iv_leftImage);
        tvTitle = findViewById(R.id.tv_centerName);
        tvRight = findViewById(R.id.tv_rightChar);

        setTitle(mTitle);// 设置标题
        setRigth(mRight);//设置右侧符号
        setIvIcon(mLeftIcon);//设置左侧图标
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setmCont(String cont) {
        tvRight.setText(cont);
    }

    public void setIvIcon(Drawable icon){ivIcon.setImageDrawable(icon);}

    public void setRigth(String right){tvRight.setText((right));}
}


