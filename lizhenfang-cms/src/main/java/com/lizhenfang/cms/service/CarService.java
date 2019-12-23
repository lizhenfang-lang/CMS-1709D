package com.lizhenfang.cms.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhenfang.cms.dao.CarDao;
import com.lizhenfang.cms.pojo.Car;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月20日 下午9:12:29
**/
@Service
public class CarService {
  @Autowired
  private CarDao carDao;
  //列表
  public  PageInfo<Car> getlist(Car car, Integer pageNum, Integer pageSize) {
	PageHelper.startPage(pageNum, pageSize);
	List<Car> carlist=carDao.select(car);
	return new PageInfo<>(carlist);
}
public boolean deleteAll(String ids) {
	// TODO Auto-generated method stub
	return carDao.deleteAll(ids);
}
  public Car getById(Integer id) {
	// TODO Auto-generated method stub
	return carDao.getById(id);
}
  //保存
  public boolean save(Car car) {
	if (car.getId()==null) {
	    return carDao.add(car)>0;	
	}
	return carDao.update(car)>0;
}
  

  
  
  
}
