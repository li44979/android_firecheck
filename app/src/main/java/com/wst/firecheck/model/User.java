package com.wst.firecheck.model;

/**
 * Created by li449 on 2018/1/25.
 */

public class User{
    private int id;
    private String loginName;
    private  String name;
    private String mobilePhone;
    private String email;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public String getLoginName()
    {
        return loginName;
    }
    public void setLoginName(String loginName)
    {
        this.loginName=loginName;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getMobilePhone()
    {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone=mobilePhone;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }

}
