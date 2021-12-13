package com.siamsoft.sqlite_cms;


public class Custom {


    String strID, strName, strMobile;

    public Custom(String strID, String strName, String strMobile) {
        this.strID = strID;
        this.strName = strName;
        this.strMobile = strMobile;
    }
    public Custom() {

    }

    public String getStrID() {
        return strID;
    }

    public void setStrID(String strID) {
        this.strID = strID;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrMobile() {
        return strMobile;
    }

    public void setStrMobile(String strMobile) {
        this.strMobile = strMobile;
    }
}

