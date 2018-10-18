package com.wwl.pojo;

/**
 * 分页查询中的条件
 * @author Administrator
 *
 */
public class LimitCondition {
	private String startBirthdate;
	private String endBirthdate;
	private String lifegoodsdescribe;
	private String otherdescribe;
	private String shoppingonlinedescribe;
	private Integer pageSize=10; 
	private Integer pageNo=1;
	

	public String getStartBirthdate() {
		return startBirthdate;
	}
	public void setStartBirthdate(String startBirthdate) {
		this.startBirthdate = startBirthdate;
	}
	public String getEndBirthdate() {
		return endBirthdate;
	}
	public void setEndBirthdate(String endBirthdate) {
		this.endBirthdate = endBirthdate;
	}
	public String getLifegoodsdescribe() {
		return lifegoodsdescribe;
	}
	public void setLifegoodsdescribe(String lifegoodsdescribe) {
//		this.lifegoodsdescribe = "%"+lifegoodsdescribe+"%";
		this.lifegoodsdescribe = lifegoodsdescribe;
	}
	public String getOtherdescribe() {
		return otherdescribe;
	}
	public void setOtherdescribe(String otherdescribe) {
//		this.otherdescribe = "%"+otherdescribe+"%";
		this.otherdescribe = otherdescribe;
	}
	
	public String getShoppingonlinedescribe() {
		return shoppingonlinedescribe;
	}
	public void setShoppingonlinedescribe(String shoppingonlinedescribe) {
//		this.shoppingonlinedescribe ="%"+shoppingonlinedescribe+"%" ;
		this.shoppingonlinedescribe =shoppingonlinedescribe;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
}
