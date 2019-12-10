package com.lizhenfang.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月10日 下午7:04:44
**/
@Controller
@RequestMapping("/")
public class indexController {
   @RequestMapping("")
   public String index() {
	return "index";
	   
   }
}
