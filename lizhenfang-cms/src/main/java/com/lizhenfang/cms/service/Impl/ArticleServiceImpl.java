package com.lizhenfang.cms.service.Impl;
import java.util.Date;
/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月15日 上午12:05:25
**/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lizhenfang.cms.dao.ArticleDao;
import com.lizhenfang.cms.dao.CategoryDao;
import com.lizhenfang.cms.dao.ChannelDao;
import com.lizhenfang.cms.pojo.Article;
import com.lizhenfang.cms.pojo.Category;
import com.lizhenfang.cms.pojo.Channel;
import com.lizhenfang.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ChannelDao channelDao;
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public PageInfo<Article> getPageInfo(Article article, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Article> articleList = articleDao.select(article);
		return new PageInfo<>(articleList);
	}

	@Override
	public boolean updateStatus(Integer id, int status) {
		return articleDao.updateStatus(id, status)>0;
	}

	@Override
	public boolean addHot(Integer id) {
		return articleDao.addHot(id)>0;
	}

	@Override
	public List<Channel> getChannelList() {
		return channelDao.select(null);
	}

	@Override
	public Article getById(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.selectById(id);
	}

	@Override
	public boolean save(Article article) {
		if(article.getId()==null) {
			article.setDeleted(0);
			article.setCreated(new Date());
			article.setUpdated(new Date());
			article.setCommentcnt(0);
			article.setHits(0);
			article.setHot(0);
			articleDao.insert(article);
		}else {
			article.setUpdated(new Date());
			articleDao.update(article);
		}
		return true;
	}

	@Override
	public List<Category> getCateListByChannelId(Integer channelId) {
		return categoryDao.selectListByChannelId(channelId);
	}
	@Override
	public boolean delByIds(String ids) {
		return articleDao.updateDeletedByIds(ids)>0;
	}
	@Override
	public boolean isAllCheck(String ids) {
		List<Article> articleList = articleDao.selectByIds(ids);
		for (Article article:articleList) {
			if(article.getStatus()==1) {
				return false;
			}
		}
		return true;
	}
	@Override
	public List<Article> getListByChannelId(Integer channelId, Integer aritcleId, int num) {
		return articleDao.selectListByChannelId(channelId,aritcleId,num);
	}

	@Override
	public PageInfo<Article> getHotList(int pageNum) {
		PageHelper.startPage(pageNum, 1);
		List<Article> articleList = articleDao.selectByHot();
		
		return new PageInfo<>(articleList);
	}

	@Override
	public PageInfo<Article> getListByChannelIdAndCateId(Integer channelId, Integer cateId, Integer pageNum) {
		PageHelper.startPage(pageNum, 1);
		List<Article> articleList = articleDao.selectListByChannelIdAndCateId(channelId,cateId);
		 return new PageInfo<>(articleList);
	}
	@Override
	public List<Article> getNewList(int num) {
		System.out.println(articleDao.selectNewList(num));
		return articleDao.selectNewList(num);
	}
}