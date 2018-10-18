package com.wwl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwl.common.Judge;
import com.wwl.pojo.Users;
import com.wwl.service.UsersService;
import com.wwl.util.Constant;
import com.wwl.util.CustomResult;

/**
 * 用户类
 * @author Administrator
 *
 */
@Controller
public class UsersController {
	 
	@Resource
	private UsersService usersService;
	/**
	 * 登录操作
	 * @param str
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String longin(String phone,String password,Model model,HttpSession session) {
		//调用service层 获取自定义对象
		CustomResult customResult = usersService.selectConditionUsers(phone,password);
		//判断操作：status=200,证明登录成功
		if(customResult.ok()) {
			Users user=	(Users) customResult.getData();
			user.setPassword(null); //不把密码放入session
			//放入session中
			session.setAttribute(Constant.SESSIONUSER, user);
			return "redirect:/welcome.jsp";
		}else {
			//把错误代码返回登录页面
			model.addAttribute("error", customResult);
			return "forward:/login.jsp";
		}
	}
	/**
	 * 密码修改
	 * @param oldPassword
	 * @param newPassword
	 * @param reNewPassword
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/wwl/updatePasswordController")
	public String updatePasswordController(String oldPassword,String newPassword,String reNewPassword,HttpSession session,Model model) {
		//调用 service层 获取自定义对象消息状态
		CustomResult result = usersService.updateByPassword(oldPassword, newPassword,reNewPassword, session);
		model.addAttribute("result", result);
		return "password";
	}
	
	//public static 
	/**
	 * 模糊分页查询
	 * @param model
	 * @param username
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/wwl/limitUserList")
	public String limitUserList(Model model,String username,@RequestParam(value="pageNo",
	defaultValue="1")String pageNo,@RequestParam(value="pageNo",defaultValue="10")String pageSize) {
		CustomResult customResult = usersService.selectLikeUsers(username, pageNo, pageSize);
		if(customResult.ok()) {
			List<Users> list = (List<Users>) customResult.getListData();
			model.addAttribute("listUser", list);
		}
		return "userList";
	}
	
	/**
	 * 退出系统
	 * @param session
	 * @return
	 */
	@RequestMapping("/wwl/removeSession")
	public String removeSession(HttpSession session) {
		if(session !=null)
		session.invalidate();
		return "redirect:/login.jsp";
	}
	/**
	 * 根据id查询用户
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping("/wwl/userById")
	public String userById(String userid, String status,Model model) {
		CustomResult cr= usersService.selectUsersById(userid);
		if(cr.ok()) {
			Users data = (Users) cr.getData();
			model.addAttribute("user", data);
		}
		//跳转修改页面
		if("update".equals(status)) {
			return "userUpdate";
		}
		
		return "userView";
	}
	/**
	 * 根据id删除用户
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping("wwl/delectUserByIdController")
	public String delectUserByIdController(String userid,Model model) {
		CustomResult cr= usersService.deleteUsersById(userid);
		model.addAttribute("messmage", cr);
		return "redirect:limitUserList";
	}
	/**
	 * 插入用户
	 * @param users
	 * @param model
	 * @return
	 */
	@RequestMapping("wwl/userAddController")
	public String userAddController(Users users,String passwordRemi,Model model) {
		CustomResult cr= usersService.insertUsers(users,passwordRemi);
		model.addAttribute("message", cr);
		return "userAdd";
	}
	/**
	 * 修改用户信息
	 * @param users
	 * @param model
	 * @return
	 */
	@RequestMapping("wwl/updateUserController")
	public String updateUserController(Users users,Model model) {
		CustomResult cr= usersService.updateUsers(users);
		model.addAttribute("message",cr);
		model.addAttribute("user",users);
		return "userUpdate";
	}
} 
