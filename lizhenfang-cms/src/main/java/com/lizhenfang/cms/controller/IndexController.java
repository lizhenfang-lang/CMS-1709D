package com.lizhenfang.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.lizhenfang.cms.common.HLUtils;
import com.lizhenfang.cms.dao.ArticleRepository;
import com.lizhenfang.cms.pojo.Article;
import com.lizhenfang.cms.pojo.Category;
import com.lizhenfang.cms.pojo.Channel;
import com.lizhenfang.cms.pojo.Link;
import com.lizhenfang.cms.pojo.Slide;
import com.lizhenfang.cms.pojo.User;
import com.lizhenfang.cms.service.ArticleService;
import com.lizhenfang.cms.service.LinkService;
import com.lizhenfang.cms.service.SlideService;
import com.lizhenfang.cms.service.UserService;


/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月10日 下午7:04:44
**/
@Controller

public class IndexController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private SlideService slideService;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	@Autowired
	private LinkService linkService;
	@Autowired
	private ArticleRepository articleRepository;
	
	@RequestMapping(value="/")
	public String index(Model model) {
		return index(1, model,null);
	}
	
	/*@RequestMapping(value="/hot/{pageNum}.html")
	public String index(@PathVariable Integer pageNum, Model model) {
		*//** 频道 *//*
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		*//** 轮播图 *//*
		List<Slide> slideList = slideService.getAll();
		model.addAttribute("slideList", slideList);
		*//** 最新文章 **//*
		List<Article> newArticleList = articleService.getNewList(6);
		model.addAttribute("newArticleList", newArticleList);
		*//** 热点文章 **//*
		if(pageNum==null) {
			pageNum=1;
		}
		PageInfo<Article> pageInfo =  articleService.getHotList(pageNum);
		model.addAttribute("pageInfo", pageInfo);
		return "index";
	}
	*/
	
	
	@RequestMapping(value="/hot/{pageNum}.html")
	public String index(@PathVariable Integer pageNum, Model model,String title) {
		/** 频道 */
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		/** 轮播图 */
		List<Slide> slideList = slideService.getAll();
		model.addAttribute("slideList", slideList);
		/** 最新文章 **/
		List<Article> newArticleList = articleService.getNewList(6);
		model.addAttribute("newArticleList", newArticleList);
		/** 热点文章 **/
		if(pageNum==null) {
			pageNum=1;
		}
		//高亮查询前的时间
		long i = System.currentTimeMillis();
		PageInfo<Article> pageInfo = (PageInfo<Article>) HLUtils.findByHighLight(elasticsearchTemplate, Article.class, pageNum,
				4, new String[]{"title"}, "id", title);
		//PageInfo<Article> pageInfo =  articleService.getHotList(pageNum);
		//高亮查询后的时间
 		long j = System.currentTimeMillis();
 		pageInfo.setPageNum(pageNum);
		pageInfo.setSize(4);
		model.addAttribute("queryTime", j-i);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("title", title);
		
		// 获取收藏链接
				List<Link> linksList = linkService.select();
				model.addAttribute("linksList", linksList);
		return "index";
	}
	
	@RequestMapping("/{channelId}/{cateId}/{pageNo}.html")
	public String channel(@PathVariable Integer channelId, Model model,
			@PathVariable Integer cateId,@PathVariable Integer pageNo) {
		/** 频道 */
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		/** 最新文章 **/
		List<Article> newArticleList = articleService.getNewList(6);
		model.addAttribute("newArticleList", newArticleList);
		/** 分类 */
		List<Category> cateList = articleService.getCateListByChannelId(channelId);
		model.addAttribute("cateList", cateList);
		PageInfo<Article> pageInfo =  articleService.getListByChannelIdAndCateId(channelId,cateId,pageNo);
		model.addAttribute("pageInfo", pageInfo);
		return "index";
	}
	
	/*@RequestMapping("article/{id}.html")
	public String articleDetail(@PathVariable Integer id,Model model) {
		*//** 查询文章 **//*
		Article article = articleService.getById(id);
		model.addAttribute("article", article);
		*//** 查询用户 **//*
		User user = userService.getById(article.getUserId());
		model.addAttribute("user", user);
		*//** 查询相关文章 **//*
		List<Article> articleList = articleService.getListByChannelId(article.getChannelId(),id,10);
		model.addAttribute("articleList", articleList);
		return "article/detail";
	}
	*/
	// 文章详情页查询
		@RequestMapping("article/{id}.html")
		public String articleDetail(@PathVariable Integer id, Model model,HttpServletRequest request) {
			//获取用户的ip地址
			String remoteAddr = request.getRemoteAddr();
			// 查询文章
			Article article = articleService.getById(id,remoteAddr);
			model.addAttribute("article", article);
			// 查询用户
			User user = userService.getById(article.getUserId());

			model.addAttribute("user", user);
			// 查询相关文章
			List<Article> articleList = articleService.getListByChannelId(article.getChannelId(), id, 10);
			model.addAttribute("articleList", articleList);
			return "article/detail";
		}
	
	
	
}