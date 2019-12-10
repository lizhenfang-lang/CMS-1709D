package com.lizhenfang.cms.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月10日 下午6:43:17
**/
@Controller
@RequestMapping("/admin/")
public class AdminController {
   @RequestMapping("/")
   public String login() {
	return "admin/login";
	   
   }
	
	
	

}
