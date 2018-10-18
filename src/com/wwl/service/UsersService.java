package com.wwl.service;

import javax.servlet.http.HttpSession;

import com.wwl.pojo.Users;
import com.wwl.util.CustomResult;

public interface UsersService {
	/**
	 * 登录操作
	 * @param str
	 * @param password
	 * @return
	 */
	public CustomResult selectConditionUsers(String str,String password);
	
	/**
	 * 密码修改
	 * @param oldPssword
	 * @param newPassword
	 * @return
	 */
	public CustomResult updateByPassword(String oldPassword,String newPassword,String reNewPassword,HttpSession session);
	/**
	 * 分页模糊查询
	 * @param username
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public CustomResult selectLikeUsers(String username,String pageNo,String pageSize);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public CustomResult selectUsersById(String id);
	
	/**
	 * 根据id删除用户
	 * @param userid
	 * @return
	 */
	public CustomResult deleteUsersById(String userid);
	/**
	 * 插入用户
	 * @param users
	 * @return
	 */
	public CustomResult insertUsers(Users users,String passwordRemi);
	
	/**
	 * 修改用户信息
	 * @param users
	 * @return
	 */
	public CustomResult updateUsers(Users users);
	
	/**
	 * 判断user对象中的属性Phone和usersCode，在数据库中是否有值 true 
	 * @param users  users必须是有的属性值userid和被判断的属性值
	 * @param str  属性值：null判断usersCode,否则判断phone
	 * @return
	 */
	public boolean isPhoneAandUserCode(Users users,String str);
}
