package com.wwl.pojo;

import java.util.Date;

public class Bills {
    private Integer billsid;

    private Date date;

    private Float lifegoods;

    private Float waterbill;

    private Float electricitybill;

    private Float coalbill;

    private Float shoppingonline;

    private Float other;

    private String modified;

    private Date modifiedtime;

    private String creator;

    private Date cteatortime;

    public Integer getBillsid() {
        return billsid;
    }

    public void setBillsid(Integer billsid) {
        this.billsid = billsid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getLifegoods() {
        return lifegoods;
    }

    public void setLifegoods(Float lifegoods) {
        this.lifegoods = lifegoods;
    }

    public Float getWaterbill() {
        return waterbill;
    }

    public void setWaterbill(Float waterbill) {
        this.waterbill = waterbill;
    }

    public Float getElectricitybill() {
        return electricitybill;
    }

    public void setElectricitybill(Float electricitybill) {
        this.electricitybill = electricitybill;
    }

    public Float getCoalbill() {
        return coalbill;
    }

    public void setCoalbill(Float coalbill) {
        this.coalbill = coalbill;
    }

    public Float getShoppingonline() {
        return shoppingonline;
    }

    public void setShoppingonline(Float shoppingonline) {
        this.shoppingonline = shoppingonline;
    }

    public Float getOther() {
        return other;
    }

    public void setOther(Float other) {
        this.other = other;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified == null ? null : modified.trim();
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCteatortime() {
        return cteatortime;
    }

    public void setCteatortime(Date cteatortime) {
        this.cteatortime = cteatortime;
    }
}