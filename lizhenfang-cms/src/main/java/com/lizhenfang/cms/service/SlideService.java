package com.lizhenfang.cms.service;



/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月18日 下午7:21:28
**/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lizhenfang.cms.dao.SlideDao;
import com.lizhenfang.cms.pojo.Slide;



@Service
public class SlideService {
	@Autowired
	private SlideDao slideDao;
	/**
	 * @Title: getAll   
	 * @Description: 查询所有轮播图   
	 * @param: @return      
	 * @return: List<Slide>      
	 * @throws
	 */
	public List<Slide> getAll(){
		List<Slide> slideList = slideDao.select(null);
		return slideList;
	}
}