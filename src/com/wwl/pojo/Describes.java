package com.wwl.pojo;

public class Describes {
    private Integer id;
    private String lifegoodsdescribe;
    private String shoppingonlinedescribe;
    private String otherdescribe;
    private Integer billsId;
    
    public String getLifegoodsdescribe() {
		return lifegoodsdescribe;
	}

	public void setLifegoodsdescribe(String lifegoodsdescribe) {
		this.lifegoodsdescribe = lifegoodsdescribe;
	}

	public String getShoppingonlinedescribe() {
		return shoppingonlinedescribe;
	}

	public void setShoppingonlinedescribe(String shoppingonlinedescribe) {
		this.shoppingonlinedescribe = shoppingonlinedescribe;
	}

	public String getOtherdescribe() {
		return otherdescribe;
	}

	public void setOtherdescribe(String otherdescribe) {
		this.otherdescribe = otherdescribe;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillsId() {
        return billsId;
    }

    public void setBillsId(Integer billsId) {
        this.billsId = billsId;
    }
}