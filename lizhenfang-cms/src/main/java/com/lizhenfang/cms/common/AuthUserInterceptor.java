package com.lizhenfang.cms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月17日 下午2:18:14
**/
public class AuthUserInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object userInfo = request.getSession().getAttribute(CmsConstant.UserSessionKey);
		if(userInfo!=null) {
			return true;
		}
	    response.sendRedirect("/user/login");
		return false;
	}
}
