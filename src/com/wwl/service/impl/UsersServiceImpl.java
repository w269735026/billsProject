package com.wwl.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwl.common.Judge;
import com.wwl.mapper.UsersMapper;
import com.wwl.pojo.Users;
import com.wwl.pojo.UsersExample;
import com.wwl.pojo.UsersExample.Criteria;
import com.wwl.service.UsersService;
import com.wwl.util.Constant;
import com.wwl.util.CustomResult;
@Transactional
@Service
public class UsersServiceImpl implements UsersService{
	@Resource
	public UsersMapper usersMapper;
	
	@Transactional(propagation =Propagation.NOT_SUPPORTED) //不需要事务
	@Override
	public CustomResult selectConditionUsers(String str,String password) {
		CustomResult customResult = new CustomResult();
		//判断用户名
		if(Judge.isNullAndEmpty(str)) {
			customResult.setStatus(402);
			customResult.setMessage("账号不能为空!");
			return customResult;
		}
		//判断密码
		if(Judge.isNullAndEmpty(password)) {
			customResult.setStatus(401);
			customResult.setMessage("密码不能为空!");
			return customResult;
		}
		
		//查询数据库:逆向工程条件查询
		UsersExample ue= new UsersExample();
		Criteria criteria = ue.createCriteria();
		
		criteria.andPhoneEqualTo(str); //添加手机号码条件
		
		//md5加密   注意此spring工具类4.2以上的版本才有
		String md5Passowrd = DigestUtils.md5DigestAsHex(password.getBytes());
		criteria.andPasswordEqualTo(md5Passowrd);//添加密码条件
		
		//执行查询操作：
		List<Users> list = usersMapper.selectByExample(ue);
		if(Judge.isNullAndEmpty(list)) {
			customResult.setStatus(403);
			customResult.setMessage("账号或密码错误!");
		}else {
			Users users = list.get(0);
			customResult.setStatus(200);
			customResult.setData(users);
		}
		return customResult;
	}
	
	@Override
	public CustomResult updateByPassword(String oldPassword, String newPassword,String reNewPassword,HttpSession session) {
		CustomResult customResult = new CustomResult();
		//判断两次密码输入是否一致
		if(Judge.isNullAndEmpty(oldPassword)) {
			customResult.setStatus(404);
			customResult.setMessage("旧密码不能为空！");
			return customResult;
		}
		if(Judge.isNullAndEmpty(newPassword)) {
			customResult.setStatus(404);
			customResult.setMessage("新密码不能为空！");
			return customResult;
		}
		if(!newPassword.equals(reNewPassword)) {
			customResult.setStatus(404);
			customResult.setMessage("两次输入的密码不一致！");
			return customResult;
		}
		
		//从session中获取账号：手机号码
		Users users = (Users) session.getAttribute(Constant.SESSIONUSER);
		//验证旧密码是否一致:先查询数据库后得到
		if(users !=null) {
			//执行id查询
			Users user = usersMapper.selectByPrimaryKey(users.getUserid());
			//转换为md5密码
			String md5DPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
			//判断
			if(md5DPassword.equals(user.getPassword())) {
				//执行插入 操作
				user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
				if(usersMapper.updateByPrimaryKey(user)>0) {
					customResult.setStatus(200);
					customResult.setMessage("修改密码成功！");
					return customResult;
				}
			}
		}
		customResult.setStatus(404);
		customResult.setMessage("修改密码失败，请确认旧密码是否输入正确！");
		return customResult;
	}
	
	@Transactional(propagation =Propagation.NOT_SUPPORTED) //不需要事务
	public CustomResult selectLikeUsers(String username,String pageNo,String pageSize) {
		CustomResult customResult = new CustomResult();
		//分页插件的使用:共两步，第一步
		PageHelper.startPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize));
		UsersExample example=new UsersExample();
		Criteria criteria = example.createCriteria();
		//设置模糊查询username
		if(username !=null) {
			try {
				byte[] bytes = username.getBytes("iso8859-1");
				String str= new String(bytes,"utf-8");
				username="%"+str+"%";
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}else {
			username="%%";
		}
		criteria.andUsernameLike(username);
		List<Users> list = usersMapper.selectByExample(example);
		if(!Judge.isNullAndEmpty(list)) {
			//分页插件的使用:共两步，第二步,把查询的结果当参数放进去
			PageInfo<Users> pageInfo = new PageInfo<>(list);
			List<Users> rlist = pageInfo.getList();
			customResult.setListData(rlist);
			customResult.setStatus(200);
		}else {
			customResult.setStatus(404);
		}
		return customResult;
	}
	public CustomResult selectUsersById(String id) {
		CustomResult customResult = new CustomResult();
		if(!Judge.isNullAndEmpty(id)) {
			Users users = usersMapper.selectByPrimaryKey(Integer.parseInt(id));
			if(users !=null) {
				customResult.setData(users);
				customResult.setStatus(200);
			}else {
				customResult.setStatus(404);
			}
		}
		return customResult;
	}

	@Override
	public CustomResult deleteUsersById(String userid) {
		CustomResult customResult = new CustomResult();
		if(!Judge.isNullAndEmpty(userid)) {
			if(usersMapper.deleteByPrimaryKey(Integer.parseInt(userid))>0) {
				customResult.setMessage("删除成功！");
				customResult.setStatus(200);
				return customResult;
			}
		}
		customResult.setMessage("删除失败，请稍后再操作！");
		customResult.setStatus(400);
		return customResult;
	}

	@Override
	public CustomResult insertUsers(Users users,String passwordRemi) {
		CustomResult customResult = new CustomResult();
		//校验判断操作
		if(users !=null) {
			if(Judge.isNullAndEmpty(users.getPhone())) {
				customResult.setMessage("手机号码不能为空!");
				customResult.setStatus(404);
				return customResult;
			}
			if(isPhoneAandUserCode(users,"true")) {	
				customResult.setStatus(null);
				customResult.setStatus(404);
				customResult.setMessage("已注册过的手机号码，请更换!");
				return customResult;
			}
			if(Judge.isNullAndEmpty(users.getUsercode())) {
				customResult.setMessage("账号昵称不能为空!");
				customResult.setStatus(404);
				return customResult;
			}
			if(isPhoneAandUserCode(users,null)) {
				customResult.setStatus(null);
				customResult.setStatus(404);
				customResult.setMessage("已注册过的账户，请更换!");
				return customResult;
			}
			if(Judge.isNullAndEmpty(users.getUsername())) {
				customResult.setMessage("用户名不能为空!");
				customResult.setStatus(404);
				return customResult;
			}
			if(users.getUserbirthdate()==null) {
				customResult.setMessage("出生日期不能为空!");
				customResult.setStatus(404);
				return customResult;
			}
			if(Judge.isNullAndEmpty(users.getPassword())) {
				customResult.setMessage("密码不能为空!");
				customResult.setStatus(404);
				return customResult;
			}
			if(!users.getPassword().equals(passwordRemi)) {
				customResult.setMessage("两次输入的密码不一致!");
				customResult.setStatus(404);
				return customResult;
			}
		}
		//密码转换为MD5
		String password = DigestUtils.md5DigestAsHex(passwordRemi.getBytes());
		users.setPassword(password);
		
		//补全users属性age
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String birthdate = sdf.format(users.getUserbirthdate());
		String curredate = sdf.format(new Date());
		int age=Integer.parseInt(curredate)-Integer.parseInt(birthdate);
		users.setAge(age);
		
		//执行插入数据库操作
		if(usersMapper.insert(users)>0) {
			customResult.setMessage("插入成功!");
			customResult.setStatus(200);
			return customResult;
		}
		customResult.setMessage("插入失败!");
		customResult.setStatus(400);
		return customResult;
	}

	@Override
	public CustomResult updateUsers(Users users) {
		CustomResult customResult = new CustomResult();
		//校验判断操作
		if(users !=null) {
			if(Judge.isNullAndEmpty(users.getPhone())) {
				customResult.setMessage("手机号码不能为空!");
				customResult.setStatus(404);
				return customResult;
			}
			if(isPhoneAandUserCode(users,"true")) {
				customResult.setStatus(null);
				customResult.setStatus(404);
				customResult.setMessage("已注册过的手机号码，请更换!");
				return customResult;
			}
		
			if(Judge.isNullAndEmpty(users.getUsername())) {
				customResult.setMessage("用户名不能为空!");
				customResult.setStatus(404);
				return customResult;
			}
			if(users.getUserbirthdate()==null) {
				customResult.setMessage("出生日期不能为空!");
				customResult.setStatus(404);
				return customResult;
			}
			
		}
		if(usersMapper.updateByPrimaryKeySelective(users)>0) {
			customResult.setMessage("修改成功！");
			customResult.setStatus(200);
			return customResult;
		};
		customResult.setMessage("修改失败！服务器较忙请稍后重试");
		customResult.setStatus(404);
		return customResult;
	}
	
	public boolean isPhoneAandUserCode(Users users,String str) {
		//执行phone查询数据库是否有数据
		UsersExample example= new UsersExample();
		Criteria criteria = example.createCriteria();
		//如果phone或者usercode值使用它，没有从users获取
	/*	if(Judge.isNullAndEmpty(phone) || Judge.isNullAndEmpty(usercode)) {
			if(Judge.isNullAndEmpty(phone)) {
				phone=users.getPhone();
			}
			if(Judge.isNullAndEmpty(usercode)){
				usercode=users.getUsercode();
			}
		}*/
		if(str==null) {
			criteria.andUsercodeEqualTo(users.getUsercode());//查询账户
		}else {
			criteria.andPhoneEqualTo(users.getPhone());//查询手机号码
		}
		
		List<Users> list = usersMapper.selectByExample(example);
		if(!Judge.isNullAndEmpty(list)){
			//判断是不是相同的id
			if(users.getUserid()!=list.get(0).getUserid()) {
				return true;
			}
		}
		return false;
	}
}
