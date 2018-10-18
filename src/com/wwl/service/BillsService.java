package com.wwl.service;

import javax.servlet.http.HttpSession;

import com.wwl.pojo.BillsExtending;
import com.wwl.pojo.LimitCondition;
import com.wwl.pojo.PageParameter;
import com.wwl.util.CustomResult;
/**
 * 账单service层
 * @author Administrator
 *
 */
public interface BillsService {
	
	/**
	 * 模糊查询并条件查询
	 * @param condition
	 * @return
	 */
	public PageParameter conditionSelectService(LimitCondition condition);
	
	/**
	 * 根据id查询两表数据
	 * @param userid
	 * @return
	 */
	public BillsExtending selectBillsAnddescribesByBillsIdService(String billsid);
	
	/**
	 * 插入账单数据
	 * @param billsExtending
	 * @return
	 */
	public CustomResult insertBillsService(BillsExtending billsExtending,HttpSession session);
	
	/**
	 * 根据id删除两表数据
	 * @param billsid
	 * @return
	 */
	public CustomResult deleteBillsAndDescribeService(Integer billsid);
	/**
	 * 根据id修改两表数据
	 * @param bills
	 * @param session
	 * @return
	 */
	public CustomResult updateDataByIdService(BillsExtending billsExtending, HttpSession session);
	
	/**
	 * 求总和
	 * @return
	 */
	public float getTotalService();
	
	/**
	 * 条件查询总和
	 * @param condition
	 * @return
	 */
	public float conditionSelectTotalService(LimitCondition condition);

}
