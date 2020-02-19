package com.lizhenfang.cms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月14日 下午11:29:44
**/
public class AuthInterceptor implements HandlerInterceptor{
   
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object userInfo = request.getSession().getAttribute(CmsConstant.UserAdminSessionKey);
		if(userInfo!=null) {
			return true;
	}
	    response.sendRedirect("/admin/");
		return false;
	}

}
