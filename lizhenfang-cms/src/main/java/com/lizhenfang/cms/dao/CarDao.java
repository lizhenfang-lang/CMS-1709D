package com.lizhenfang.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lizhenfang.cms.pojo.Car;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月20日 下午10:39:52
**/
public interface CarDao {
    //列表
	List<Car> select(@Param("car") Car car);
    //批量删除
	boolean deleteAll(@Param("ids") String ids);
	//根据id 修改 添加
	Car getById(@Param("id") Integer id);
	//查询数据条数
	int count(@Param("car") Car car);
	//修改
	int update(@Param("car") Car car);
	//添加
    int add(@Param("car") Car car);
    //删除
  	boolean deleteid(@Param("id") String id);
}
