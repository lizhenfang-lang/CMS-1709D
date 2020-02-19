package com.lizhenfang.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lizhenfang.cms.pojo.Car;
import com.lizhenfang.cms.pojo.Tousu;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2020年2月18日 上午10:49:21
**/
public interface TousuDao1 {
     //列表
	List<Tousu> select(@Param("tousu")Tousu tousu);
    //删除
	boolean deleteAll(@Param("ids") String ids);
	
	int count(@Param("tousu") Tousu tousu);
	
	Tousu getById(@Param("id")Integer id);
	
	int add(@Param("tousu") Tousu tousu);
	
	int update(@Param("tousu") Tousu tousu);

}
