package com.lizhenfang.cms.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.stat.TableStat.Mode;
import com.github.pagehelper.PageInfo;
import com.lizhenfang.cms.pojo.User;
import com.lizhenfang.cms.service.UserService;

/**
 * @program:lizhenfang-cms
 * @author: 李振芳
 *
 * @version:2019年12月10日 下午6:43:17
 **/
@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	private UserService userService;
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
	 * 用户管理
	 * 
	 * @return
	 */
	@RequestMapping("/user")
	public String user(User user,Model model,
      @RequestParam(value="pageNum",defaultValue="1") int pageNum,
	  @RequestParam(value="pageSize",defaultValue="3") int pageSize) {
		PageInfo<User> pageInfo=userService.getPageInfo(user,pageNum,pageSize);
		model.addAttribute("pageInfo",pageInfo);
		return "admin/user";
	}
	/**
	 * 禁用
	 * @param userId
	 * @return
	 */
    @ResponseBody
    @RequestMapping("/user/locked")
    public boolean locked(Integer userId) {
		boolean locked=userService.locked(userId);
    	return locked;
    	
    }
    /**
	 * 启用
	 * @param userId
	 * @return
	 */
    @ResponseBody
    @RequestMapping("/user/unlocked")
    public boolean unlocked(Integer userId) {
		boolean locked=userService.unlocked(userId);
    	return locked;
    	
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
