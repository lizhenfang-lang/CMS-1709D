package com.lizhenfang.cms.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lizhenfang.cms.common.JsonResult;
import com.lizhenfang.cms.pojo.Car;
import com.lizhenfang.cms.pojo.Link;
import com.lizhenfang.cms.pojo.Tousu;
import com.lizhenfang.cms.service.CarService;
import com.lizhenfang.cms.service.TousuService;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月20日 下午9:04:59
**/
@Controller
@RequestMapping("/admin/Sc/")
public class ScController {
  @Autowired
  public TousuService tousuService;
  @RequestMapping("list")
  public String list(Model model,Tousu tousu,
		 @RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
		 @RequestParam(value="pageSize",defaultValue="3") Integer pageSize) {
			PageInfo<Tousu> pageInfo=tousuService.getlist(tousu,pageNum,pageSize);
	        model.addAttribute("pageInfo",pageInfo);
		    return "Sc/list";
	  
  }
  @RequestMapping("deleteAll")
  @ResponseBody
  public JsonResult deleteAll(Model model,String ids) {
	  tousuService.deleteAll(ids);
	  return JsonResult.sucess();
  }
  @RequestMapping("edit")
  public String update(Integer id,Model model) {
	  if (id!=null) {
		Tousu tousu=tousuService.getById(id);
		model.addAttribute("tousu",tousu);
	}
	  return "Sc/edit";
  }
  
    @RequestMapping("save")
	@ResponseBody
	public JsonResult save(Tousu tousu,Model model) {
    	tousuService.save(tousu);
		return JsonResult.sucess();
	}
}
