package com.wwl.util;

import java.util.List;

/**
 * service层结果返回controller
 */
public class CustomResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;
    
    //响应中的List数据
    private List<?> listData;
    
    public List<?> getListData() {
		return listData;
	}

	public void setListData(List<?> listData) {
		this.listData = listData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	//返回状态码
   public boolean  ok() {
	   if(status==200) {
		   return true;
	   }
	   
	   return false;
   }

}
