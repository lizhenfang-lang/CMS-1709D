package com.lizhenfang.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizf.common.utils.DateUtil;
import com.lizhenfang.cms.dao.TousuDao;
import com.lizhenfang.cms.dao.TousuDao1;
import com.lizhenfang.cms.pojo.Car;
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
	private TousuDao1 tousuDao1;
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
	
	public PageInfo<Tousu> getlist(Tousu tousu, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Tousu> Sclist=tousuDao1.select(tousu);
		return new PageInfo<>(Sclist);
	}

	public boolean deleteAll(String ids) {
	// TODO Auto-generated method stub
	return tousuDao1.deleteAll(ids);
   }

	public Tousu getById(Integer id) {
		// TODO Auto-generated method stub
		return tousuDao1.getById(id);
	}

	 //保存
	  public boolean save(Tousu tousu) {
		if (tousu.getId()==null) {
		    return tousuDao1.add(tousu)>0;	
		}
		return tousuDao1.update(tousu)>0;
	}

	
	
	
}
