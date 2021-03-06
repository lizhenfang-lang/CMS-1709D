package com.lizhenfang.cms.controller.admin;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lizf.common.utils.StringUtil;
import com.lizhenfang.cms.common.CmsConstant;
import com.lizhenfang.cms.common.CmsMd5Util;
import com.lizhenfang.cms.common.JsonResult;
import com.lizhenfang.cms.pojo.User;
import com.lizhenfang.cms.service.UserService;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月14日 下午11:42:12
**/
@Controller
@RequestMapping("/admin/user/")
public class AdminUserController {
	@Autowired
	private UserService userService;
	/**
	 * @Title: login   
	 * @Description: 后台登录接口   
	 * @param: @param user
	 * @param: @return      
	 * @return: Object      
	 * @throws
	 */
	@RequestMapping("login")
	@ResponseBody
	public Object login(User user,HttpSession session) {
		//判断用户名和密码
		if(StringUtil.isBlank(user.getUsername()) || StringUtil.isBlank(user.getPassword())) {
			return JsonResult.fail(1000, "用户名和密码不能为空");
		}
		//查询用户
		User userInfo = userService.getByUsername(user.getUsername());
		System.out.println(userInfo);
		//用户为空
		if(userInfo==null) {
			return JsonResult.fail(1000, "用户名或密码错误");
		}
		//是否管理员
		if(!userInfo.isAdmin()) {
			return JsonResult.fail(1000, "权限不够");
		}
		//判断密码
		String string2md5 = CmsMd5Util.string2MD5(user.getPassword());
		System.out.println(string2md5);
		if(string2md5.equals(userInfo.getPassword())) {
			session.setAttribute(CmsConstant.UserAdminSessionKey, userInfo);
			return JsonResult.sucess();
		}
		return JsonResult.fail(500, "未知错误");
	}
	
	@RequestMapping("logout")
	public Object logout(HttpServletResponse response,HttpSession session) {
		session.removeAttribute(CmsConstant.UserAdminSessionKey);
		return "redirect:/admin/";
	}
}
