package com.lizhenfang.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月12日 上午10:33:25
**/
@Controller
@RequestMapping("/article/")
public class ArticleController {
	/**
	 * 发布文章
	 * @return
	 */
   @RequestMapping("add")
   public String add() {
	return "article/add";
	   
   }
   
   /**
	 * 修改文章
	 * @return
	 */
   @RequestMapping("update")
   public String update() {
	return "update";
	   
   }
}
