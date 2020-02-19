package com.lizhenfang.cms.test;
/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2020年2月12日 下午2:51:37
**/


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.lizhenfang.cms.dao.ArticleDao;
import com.lizhenfang.cms.dao.ArticleRepository;
import com.lizhenfang.cms.pojo.Article;
import com.lizhenfang.cms.service.ArticleService;
//导入数据
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class TestPortMysql2Es {
	@Resource
	ArticleDao articleDao;
	
	/*@Resource
	ArticleDao articleDao;*/
	
	@Resource
	ArticleRepository articleRepository;
   /* @Test
    public void testPortMysql2Es(){
        //1.从MySQL中查询所有的文章列表
    	Article article = new Article();
    	article.setStatus(1);
    	PageInfo<Article> select = articleService.getPageInfo(article, 1,20);
    	
    	//2.把查询出的文章进行保存(保存到es的索引库)
    	articleRepository.saveAll(select.getList());
    	System.out.println("保存完毕");
    }*/
	
	@Test
	public void test() {
		
		//查询所有文章
		List<Article> list = articleDao.select(new Article());
		articleRepository.saveAll(list);
		System.out.println("文章全部导入完毕！");
		
		
	}
}
