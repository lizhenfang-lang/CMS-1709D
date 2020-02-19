package com.lizhenfang.cms.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.stat.TableStat.Mode;
import com.github.pagehelper.PageInfo;
import com.lizf.common.utils.Md5Util;
import com.lizhenfang.cms.common.CmsConstant;
import com.lizhenfang.cms.common.HLUtils;
import com.lizhenfang.cms.common.JsonResult;
import com.lizhenfang.cms.dao.ArticleDao;
import com.lizhenfang.cms.pojo.Article;
import com.lizhenfang.cms.pojo.Category;
import com.lizhenfang.cms.pojo.Channel;
import com.lizhenfang.cms.pojo.User;
import com.lizhenfang.cms.service.ArticleService;


@Controller
@RequestMapping("/article/")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	 @Resource
	   private ElasticsearchTemplate elasticsearchTemplate;
	/**
	 * @Title: add   
	 * @Description: 发布文章   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Integer id,Model model) {
		logger.info("articleId:{}",id);
		if (id!=null) {
			Article article=articleService.getById(id);
			logger.info(article.toString());
			model.addAttribute("article",article);
			List<Category> cateList = articleService.getCateListByChannelId(article.getChannelId());
			model.addAttribute("cateList",cateList);
		}
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList",channelList);
		return "article/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult add(Article article,Model model,HttpSession session) {
		System.out.println(article);
		User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
		if(userInfo==null) {
			return JsonResult.fail(CmsConstant.unLoginErrorCode, "未登录");
		}
		article.setUserId(userInfo.getId());
		boolean result = articleService.save(article);
		return JsonResult.sucess(result);
	}
	
	/**
	 * @Title: getCateList   
	 * @Description: 根据频道Id查询分类列表   
	 * @param: @param channelId
	 * @param: @param model
	 * @param: @param session
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping(value="getCateList",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult getCateList(Integer channelId,Model model,HttpSession session) {
		return JsonResult.sucess(articleService.getCateListByChannelId(channelId));
	}
	/**
	 * @Title: delByIds   
	 * @Description: 批量删除   
	 * @param: @param ids
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping("delByIds")
	public @ResponseBody JsonResult delByIds(String ids) {
		if(ids==null) {
			return JsonResult.fail(10001, "请选择删除的文章");
		}
		//已审核判断
		boolean isCheck = articleService.isAllCheck(ids);
		if(!isCheck) {
			return JsonResult.fail(10001, "请选择未审核的文章删除");
		}
		//删除
		boolean result = articleService.delByIds(ids);
		if(result) {
			return JsonResult.sucess();
		}
		return JsonResult.fail(500, "未知错误");
	}
	
	/*@RequestMapping("search")
	public String search(String key,Model model,@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="5") Integer pageSize) {
		//定义一个开始时间
		long start=System.currentTimeMillis();
		
		PageInfo<Article> pageInfo = (PageInfo<Article>) HLUtils.findByHighLight(elasticsearchTemplate,Article.class, page, pageSize,new String[] {"title"},"id",key);
		//定义一个结束时间
		long  end=System.currentTimeMillis();
	    System.out.println("es查询一共花费了"+(end-start)+"毫秒");
		 
	    model.addAttribute("key",key);
		model.addAttribute("pageInfo",pageInfo);
		return "index";
	}*/
	
	
}












