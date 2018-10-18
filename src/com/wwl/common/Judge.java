package com.wwl.common;

import java.util.List;

/**
 * 判断工具类
 * @author Administrator
 *
 */
public class Judge {
	/**
	 * 判断是否为null或空  
	 * @param str
	 * @return 返回null或空字符串为true,否则false
	 */
	public static boolean isNullAndEmpty(String str) {
		boolean flag=false;
		if(str == null) {
			flag=true;
		}else {
			if("".equals(str.trim())) {
				flag=true;
			}
		}
		return flag;
	}
	
	/**
	 * 判断是否为null或小于等于0 
	 * @param str
	 * @return 返回null或值小于0为true,否则false
	 */
	public static boolean isNullAndEmpty(Integer i) {
		boolean flag=false;
		if(i == null) {
			flag=true;
		}else {
			if(i<=0) {
				flag=true;
			}
		}
		return flag;
	}
	
	/**
	 * 判断list是否为null，或者空
	 * @param list
	 * @return 返回null或集合小于等于0的长度为true，否则false
	 */
	public static boolean isNullAndEmpty(List<?> list) {
		if(list !=null ){
			if(list.size()<=0){
				return true;
			}
		}else {
			return true;
		}
		return false;
	}
}
