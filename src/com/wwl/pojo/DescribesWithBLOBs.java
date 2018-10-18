package com.wwl.pojo;

public class DescribesWithBLOBs extends Describes {
    private String lifegoodsdescribe;

    private String shoppingonlinedescribe;

    private String otherdescribe;

    public String getLifegoodsdescribe() {
        return lifegoodsdescribe;
    }

    public void setLifegoodsdescribe(String lifegoodsdescribe) {
        this.lifegoodsdescribe = lifegoodsdescribe == null ? null : lifegoodsdescribe.trim();
    }

    public String getShoppingonlinedescribe() {
        return shoppingonlinedescribe;
    }

    public void setShoppingonlinedescribe(String shoppingonlinedescribe) {
        this.shoppingonlinedescribe = shoppingonlinedescribe == null ? null : shoppingonlinedescribe.trim();
    }

    public String getOtherdescribe() {
        return otherdescribe;
    }

    public void setOtherdescribe(String otherdescribe) {
        this.otherdescribe = otherdescribe == null ? null : otherdescribe.trim();
    }
}