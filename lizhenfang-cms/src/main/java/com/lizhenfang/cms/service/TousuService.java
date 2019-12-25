package com.lizhenfang.cms.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lizf.common.utils.DateUtil;
import com.lizhenfang.cms.dao.TousuDao;
import com.lizhenfang.cms.pojo.Tousu;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月23日 下午1:48:01
**/
@Service
public class TousuService {
	@Autowired
	private TousuDao tousuDao;
	@Autowired
	private ArticleService articleService;
	/**
	 * @Title: add   
	 * @Description: 添加评论   
	 * @param: @param comment
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	
	public boolean add(Tousu tousu) {
		String createdStr = DateUtil.dateTimeFormat.format(new Date());
		tousu.setCreated(createdStr);
		tousuDao.insert(tousu);
		articleService.addTousu(tousu.getArticleId());
		return true;
	}
	
	
}
