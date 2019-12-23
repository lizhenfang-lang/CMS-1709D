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
import com.lizhenfang.cms.service.CarService;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月20日 下午9:04:59
**/
@Controller
@RequestMapping("/admin/car/")
public class CarController {
  @Autowired
  public CarService carService;
  
  @RequestMapping("list")
  public String list(Model model,Car  car,
		 @RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
		 @RequestParam(value="pageSize",defaultValue="3") Integer pageSize) {
			PageInfo<Car> pageInfo=carService.getlist(car,pageNum,pageSize);
	        model.addAttribute("pageInfo",pageInfo);
		    return "car/list";
	  
  }
  @RequestMapping("deleteAll")
  @ResponseBody
  public JsonResult deleteAll(Model model,String ids) {
	  carService.deleteAll(ids);
	  return JsonResult.sucess();
  }
  @RequestMapping("edit")
  public String update(Integer id,Model model) {
	  if (id!=null) {
		Car car=carService.getById(id);
		model.addAttribute("car",car);
	}
	  return "car/edit";
  }
  
    @RequestMapping("save")
	@ResponseBody
	public JsonResult save(Car car,Model model) {
		carService.save(car);
		return JsonResult.sucess();
	}
}
