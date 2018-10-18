package com.wwl.MyHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wwl.util.Constant;

public class CustomHandlerInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//第二 进入Handler方法之后，返回modelAndView之前执行：（菜单导航）将公用的模型数据传入视图
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		
	}

	//第一 进入handler(Controller)的方法之前执行:用于身份认证、身份授权
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		if(request.getSession().getAttribute(Constant.SESSIONUSER)==null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			
			return false;
		};
		return true;  //false：表示拦截，不向下执行
	}
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
}
