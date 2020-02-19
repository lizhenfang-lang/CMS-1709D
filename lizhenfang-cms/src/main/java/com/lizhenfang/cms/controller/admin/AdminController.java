package com.lizhenfang.cms.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lizhenfang.cms.dao.ArticleRepository;
import com.lizhenfang.cms.pojo.Article;
import com.lizhenfang.cms.pojo.Channel;
import com.lizhenfang.cms.pojo.User;
import com.lizhenfang.cms.service.ArticleService;
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
	
	@Autowired
	private ArticleService articleService;
	
	@Resource
	ArticleRepository articleRepository;
	/**
	 * 后台登录
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
	 * 文章管理
	 * 
	 * @return
	 */
	@RequestMapping("/article")
	public String article(Article article,Model model,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,@RequestParam(value="pageSize",defaultValue="3") int pageSize) {
		//设置文章状态
		article.setStatusIds("0,-1,1,3");
		PageInfo<Article> pageInfo = articleService.getPageInfo(article,pageNum,pageSize);
		model.addAttribute("pageInfo", pageInfo);
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		return "admin/article";
	}

	
	
	/**
	 * @Title: updateArticleStatus   
	 * @Description: 修改文章状态   
	 * @param: @param article
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	@RequestMapping("/article/update/status")
	@ResponseBody
	public boolean updateArticleStatus(Article article) {
		articleRepository.save(article);
		return articleService.updateStatus(article.getId(), article.getStatus());
	}
	/**
	 * @Title: addHot  
	 * @Description: 文章加热
	 * @param: @param article
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	@RequestMapping("/article/addHot")
	@ResponseBody
	public boolean addHot(Article article) {
		return articleService.addHot(article.getId());
	}
	
	
}
