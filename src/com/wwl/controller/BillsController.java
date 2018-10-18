package com.wwl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwl.common.Judge;
import com.wwl.pojo.BillsExtending;
import com.wwl.pojo.LimitCondition;
import com.wwl.pojo.PageParameter;
import com.wwl.service.BillsService;
import com.wwl.util.CustomResult;

/**
 * 账单Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/wwl/")
public class BillsController {
	@Resource
	private BillsService billsService;
	
	/**
	 * 条件模糊分页查询
	 * @param condition
	 * @param model
	 * @return
	 */
	@RequestMapping("conditionSelectController")
	public String conditionSelectController(LimitCondition condition,Model model) {
		PageParameter pageParameter=billsService.conditionSelectService(condition);
		
		if(pageParameter != null) {
			model.addAttribute("page",pageParameter);
			//消费价格总和数据
			model.addAttribute("total", billsService.getTotalService());
		}
		//回显页面
		//model.addAttribute("condition", condition);
		return "billList";
	}
	/**
	 * 根据billsid查询数据并根据str数据跳转相关页面
	 * @param model
	 * @param str
	 * @param billsid
	 * @return
	 */
	@RequestMapping("selectBillsAnddescribesByBillsIdController")
	public String selectBillsAnddescribesByBillsIdController(Model model,String str,String billsid) {
		BillsExtending billsEx= billsService.selectBillsAnddescribesByBillsIdService(billsid);
		model.addAttribute("bills",billsEx);
		if(Judge.isNullAndEmpty(str)) {
			return "billView";
		}else {
			return "billUpdate";
		}
	}
	/**
	 * 插入账单操作
	 * @param model
	 * @param billsExtending
	 * @return
	 */
	@RequestMapping("insertDateController")
	public String insertDateController(Model model,BillsExtending bills,HttpSession session) {
		CustomResult customResult=billsService.insertBillsService(bills,session);
		model.addAttribute("message", customResult);
		return "billAdd";
	}
	/**
	 * 根据id删除
	 * @param model
	 * @param billsid
	 * @return
	 */
	@RequestMapping("deleteBillsAndDescribeController")
	public String deleteBillsAndDescribeController(Model model,Integer billsid) {
		CustomResult customResult=billsService.deleteBillsAndDescribeService(billsid);
		model.addAttribute("message", customResult);
		return "billList";
	}
	/**
	 * 修改账单数据
	 * @param model
	 * @param bills
	 * @param session
	 * @return
	 */
	@RequestMapping("updateDataByIdController")
	public String updateDataByIdController(Model model,BillsExtending bills,HttpSession session) {
		CustomResult customResult=billsService.updateDataByIdService(bills,session);
		model.addAttribute("message", customResult);
		model.addAttribute("bills", bills);
		return "billUpdate";
	}
	/**
	 * 条件模糊查询总和
	 * @param condition
	 * @param model
	 * @return
	 */
	@RequestMapping("conditionSelectTotalController")
	@ResponseBody
	public float conditionSelectTotalController(LimitCondition condition,Model model) {
		float i=billsService.conditionSelectTotalService(condition);
		
		return i;
	}
	
}
