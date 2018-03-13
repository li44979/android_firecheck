package com.wst.firecheck.Domin;

/**
 * Created by admin on 2018/2/28.
 */

public class InfoItem {
    private String title;
    private String content;

    public InfoItem(String title,String cont){
        this.title = title;
        this.content = cont;
    }

    public String GetTitle(){
        return title;
    }

    public String GetContent() {
        return content;
    }
}
