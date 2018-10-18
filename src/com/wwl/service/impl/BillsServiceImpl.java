package com.wwl.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwl.common.Judge;
import com.wwl.mapper.BillsExtendingMapper;
import com.wwl.mapper.BillsMapper;
import com.wwl.mapper.DescribesMapper;
import com.wwl.pojo.Bills;
import com.wwl.pojo.BillsExtending;
import com.wwl.pojo.Describes;
import com.wwl.pojo.LimitCondition;
import com.wwl.pojo.PageParameter;
import com.wwl.pojo.Users;
import com.wwl.service.BillsService;
import com.wwl.util.Constant;
import com.wwl.util.CustomResult;

@Transactional
@Service
public class BillsServiceImpl implements BillsService{
	@Resource
	private BillsExtendingMapper billsEM;
	@Resource
	private BillsMapper billsMapper;
	@Resource
	private DescribesMapper describesMapper;
	
	@Transactional(propagation =Propagation.NOT_SUPPORTED) //不需要事务
	@Override
	public PageParameter conditionSelectService(LimitCondition condition) {
		//分页插件第一步
		PageHelper.startPage(condition.getPageNo(),condition.getPageSize());
		//设置模糊查询%%
		String lifegoodsdescribe=	condition.getLifegoodsdescribe();
		String otherdescribe = condition.getOtherdescribe();
		String shoppingonlinedescribe = condition.getShoppingonlinedescribe();
		if(!Judge.isNullAndEmpty(lifegoodsdescribe))
		condition.setLifegoodsdescribe("%"+lifegoodsdescribe+"%");
		if(!Judge.isNullAndEmpty(otherdescribe))
		condition.setOtherdescribe("%"+otherdescribe+"%");
		if(!Judge.isNullAndEmpty(shoppingonlinedescribe))
		condition.setShoppingonlinedescribe("%"+shoppingonlinedescribe+"%");
		List<BillsExtending> list = billsEM.selectBillsJoindescribes(condition);
		if(!Judge.isNullAndEmpty(list)) {
			//分页插件第二步
			//分页插件的使用:共两步，第二步,把查询的结果当参数放进去
			PageInfo<BillsExtending> pageInfo = new PageInfo<>(list);
			PageParameter  page= new PageParameter();
			//获取查询到的数据
			page.setList(pageInfo.getList());
			
			//总页数
			page.setTotalPage(pageInfo.getPages());;
			//获取总条数
			page.setTotalCount((int)pageInfo.getTotal());
			//首页
			page.setFirstPage(pageInfo.getFirstPage());
			//获取当前页面
			page.setCurrentPage(pageInfo.getPageNum());
			//获取上一页
			if(pageInfo.isIsFirstPage()) {
				page.setPrePage(1);
			}else {
				page.setPrePage(pageInfo.getPrePage());
			}
			//获取下一页
			if(pageInfo.isIsLastPage()) {
				page.setNextPage(pageInfo.getLastPage());
			}else {
				page.setNextPage(pageInfo.getNextPage());
			}
			//获取最后一页
			page.setLastPage(pageInfo.getLastPage());
			return page;
		}
		return null;
	}
	@Override
	public BillsExtending selectBillsAnddescribesByBillsIdService(String billsid) {
		//查询bills表
		BillsExtending billsExtending = billsEM.selectBillsAndDescribeById(billsid);
		
		return billsExtending;
	}
	@Override
	public CustomResult insertBillsService(BillsExtending billsExtending,HttpSession session) {
		//校验操作
		CustomResult customResult = new CustomResult();
		if(billsExtending !=null) {
			if(billsExtending.getDate() ==null) {
				customResult.setStatus(404);
				customResult.setMessage("日期不能为空!");
				return customResult;
			}
			
			//获取Describes数据
			Describes describes= billsExtending.getDescribes();
			
			Bills bills = billsExtending;
			//补全Bills属性
			Users user=(Users) session.getAttribute(Constant.SESSIONUSER);
			bills.setCreator(user.getUsername());
			bills.setCteatortime(new Date());
			bills.setModified(user.getUsername());
			bills.setModifiedtime(new Date());
			
			//执行数据插入bills表 中
			if(billsMapper.insert(bills)>0) {
				Integer billsid = bills.getBillsid();
				//获取自增长id插入describes的bills_id表中
				describes.setBillsId(billsid);
				//执行数据插入bills表 中
				if(describesMapper.insert(describes)>0) {
					customResult.setStatus(200);
					customResult.setMessage("插入成功");
					return customResult;
				}
			}
		}
		customResult.setStatus(404);
		customResult.setMessage("插入失败");
		return customResult;
	}
	
	@Override
	public CustomResult deleteBillsAndDescribeService(Integer billsid) {
		CustomResult customResult = new CustomResult();
		//先删除Describes表
		if(describesMapper.deleteByPrimaryKey(billsid)>0) {
			if(billsMapper.deleteByPrimaryKey(billsid)>0) {
				customResult.setStatus(200);
				customResult.setMessage("删除成功");
				return customResult;
			}
		}
		customResult.setStatus(404);
		customResult.setMessage("删除失败，请稍后操作");
		return customResult;
	}
	@Override
	public CustomResult updateDataByIdService(BillsExtending billsExtending, HttpSession session) {
		//校验操作
		CustomResult customResult = new CustomResult();
		if(billsExtending !=null) {
			if(billsExtending.getDate() ==null) {
				customResult.setStatus(404);
				customResult.setMessage("日期不能为空!");
				return customResult;
			}
			
			//获取Describes数据
			Describes describes= billsExtending.getDescribes();
			
			Bills bills = billsExtending;
			//补全Bills属性
			Users user=(Users) session.getAttribute(Constant.SESSIONUSER);
			bills.setModified(user.getUsername());
			bills.setModifiedtime(new Date());
			if(billsMapper.updateByPrimaryKeySelective(bills)>0) {
				if(describesMapper.updateByPrimaryKeySelective(describes)>0) {
					customResult.setStatus(200);
					customResult.setMessage("修改成功");
					return customResult;
				}
			}
		}
		customResult.setStatus(404);
		customResult.setMessage("修改失败，请稍后再试");
		return customResult;
		
	}
	@Override
	public float getTotalService() {
		return billsEM.getTotal();
	}
	
	@Override
	public float conditionSelectTotalService(LimitCondition condition) {
		
		return billsEM.conditionSelectTotal(condition);
	}

}
