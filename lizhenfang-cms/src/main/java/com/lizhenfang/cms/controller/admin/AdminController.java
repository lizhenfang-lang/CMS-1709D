package com.lizhenfang.cms.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program:lizhenfang-cms
 * @author: 李振芳
 *
 * @version:2019年12月10日 下午6:43:17
 **/
@Controller
@RequestMapping("/admin/")
public class AdminController {
	/**
	 * 后台登录
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String login() {
		return "admin/login";

	}

	/**
	 * 后台首页
	 * 
	 * @return
	 */
	@RequestMapping("/home")
	public String home() {
		return "admin/home";

	}

	/**
	 * 用户管理
	 * 
	 * @return
	 */
	@RequestMapping("/user")
	public String user() {
		return "admin/user";

	}

	/**
	 * 后台欢迎页面
	 * 
	 * @return
	 */
	@RequestMapping("/welcome")
	public String welcome() {
		return "admin/welcome";

	}

	/**
	 * 文章管理
	 * 
	 * @return
	 */
	@RequestMapping("/article")
	public String article() {
		return "admin/article";

	}

	/**
	 * 系统设置
	 * 
	 * @return
	 */
	@RequestMapping("/settings")
	public String settings() {
		return "admin/settings";

	}
}
