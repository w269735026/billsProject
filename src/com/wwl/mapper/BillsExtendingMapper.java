package com.wwl.mapper;

import java.util.List;

import com.wwl.pojo.BillsExtending;
import com.wwl.pojo.LimitCondition;

public interface BillsExtendingMapper {
	/**
	 * 通过多条件分页查询，返回集合
	 * @param limitCondition
	 * @return
	 */
	public List<BillsExtending> selectBillsJoindescribes(LimitCondition limitCondition);
	
	/**
	 * 根据billsid关联查询两表数据
	 * @param billsid
	 * @return
	 */
	public BillsExtending selectBillsAndDescribeById(String billsid);
	
	/**
	 * 求总和
	 * @return
	 */
	public float getTotal();
	
	/**
	 * 根据条件查询总和
	 * @return
	 */
	public float conditionSelectTotal(LimitCondition condition);
}
