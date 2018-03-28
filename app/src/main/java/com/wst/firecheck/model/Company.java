package com.wst.firecheck.model;
/**
 * Created by li449 on 2018/3/27.
 */

public class Company {
    private int companyId;
    private String customNumCode;
    private String companyName;
    private String status;
    private String leader;
    private String mobile;
    private String checkType;
    private String community;
    private String industrial;
    private String policeStation;
    private String address;
    private String picName;
    //单位id
    public int getCompanyId()
    {
        return companyId;
    }
    public void setCompanyId(int companyId)
    {
        this.companyId=companyId;
    }
    //单位名称
    public String getCompanyName()
    {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName=companyName;
    }
    //编号
    public String getCustomNumCode(){return customNumCode;}
    public void setCustomNumCode(String customNumCode) {
        this.customNumCode = customNumCode;}
    //状态
    public String getStatus(){return this.status;}
    public void setStatus(String status){this.status = status;}
    //负责人
    public String getLeader(){return this.leader;}
    public void setLeader(String leader){this.leader = leader;}
    //联系方式
    public String getMobile(){return this.mobile;}
    public void setMobile(String mobile){this.mobile = mobile;}
    //检查类型
    public String getCheckType(){return this.checkType;}
    public void setCheckType(String checkType){this.checkType = checkType;}
    //社区
    public String getCommunity(){return this.community;}
    public void setCommunity(String community){this.community = community;}
    //工业园
    public String getIndustrial(){return this.community;}
    public void setIndustrial(String industrial){this.industrial = industrial;}
    //派出所
    public String getPoliceStation(){return this.policeStation;}
    public void setPoliceStation(String policeStation){this.policeStation = policeStation;}
    //单位地址
    public String getAddress(){return this.address;}
    public void setAddress(String address){this.address = address;}
    //单位地址
    public String getPicName(){return this.picName;}
    public void setPicName(String picName){this.picName = picName;}
}
