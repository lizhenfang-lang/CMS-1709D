package com.lizhenfang.cms.listener;

import javax.annotation.Resource;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.lizhenfang.cms.dao.ArticleDao;
import com.lizhenfang.cms.pojo.Article;
import com.lizhenfang.cms.service.ArticleService;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2020年1月11日 下午7:23:23
**/
@Component
public class KafkaConsumerListener implements MessageListener<String,String> {
	@Resource
	private ArticleService articleService;
	@Resource
	private ArticleDao articleDao;
	
	@Override
	public void onMessage(ConsumerRecord<String, String> record) {
      String key = record.key();
		
		//判断key值内容
		if(key != null && key.equals("article_add")) {
			//添加数据
			
			//获取value
			String json = record.value();
			
			//将json转换成实体类对象
			Article article = JSON.parseObject(json, Article.class);
			
			//将数据存入到数据库
			 int kafkaSave = articleService.kafkaSave(article);
			
			System.out.println(kafkaSave + "=====" + article);
			
		}else if("addCount".equals(key)) {
			
			String value = record.value();
			Article article = JSON.parseObject(value, Article.class);
			articleDao.addHits(article.getId());
			System.err.println("点击量加一");
		}
		
	}
		
	

}
