package com.lizhenfang.cms.test.kafka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.lizf.common.utils.DateUtil;
import com.lizf.common.utils.FileUtil;
import com.lizf.common.utils.RandomUtil;
import com.lizhenfang.cms.pojo.Article;
import com.lizhenfang.cms.pojo.Category;
import com.lizhenfang.cms.pojo.Channel;
import com.lizhenfang.cms.service.ArticleService;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2020年1月11日 下午7:10:06
**/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ProducerTest {
   @Resource
   private KafkaTemplate<String,String> kafkaTemplate;
   @Resource
   private ArticleService articleService;
   @Test
	public void sendMsg() throws FileNotFoundException {
		//读取文档数据
		//创建目录对象
		File dir = new File("D:\\1709DJsoup");
		
		//循环遍历其中的文件
		File[] files = dir.listFiles();
		
		for (File file : files) {
			
			Article article = new Article();
			
//			(3)文本内容作为Article对象的content属性值。（2分）
			//获取文件内容
			String content = FileUtil.readTextFileByLine(file.getPath());
			article.setContent(content);
			
//			(2)将文件名作为Article对象的title属性值。（2分）
			//获取文章标题
			String title = file.getName().replace(".txt", "");
			article.setTitle(title);
			
//			(4)在文本内容中截取前140个字作为摘要。（2分）
			String abs = content;
			
			if(abs.length() > 140) {
				abs = content.substring(0, 140);
			}
			
			
//			(5)“点击量”和“是否热门”、“频道”字段要使用随机值。（2分）
			//点击量
			int hits = RandomUtil.random(0, 1000);
			article.setHits(hits);
			
			//是否热门
			int hot = RandomUtil.random(0, 100);
			article.setHot(hot);
			
			//频道
			List<Channel> channelList = articleService.getChannelList();
			
			//获取随机下标，然后根据下标获取其中的对象id
			int ch_random = RandomUtil.random(0, channelList.size() - 1);
			
			Channel channel = channelList.get(ch_random);
			article.setChannelId(channel.getId());
			
			//栏目
			List<Category> categoryList = articleService.getCateListByChannelId(channel.getId());
			
			//获取随机下标，根据下标获取其中的对象id
			int ca_random = RandomUtil.random(0, categoryList.size() - 1);
			
			Category category = categoryList.get(ca_random);
			article.setCategoryId(category.getId());
			
//			(6)文章发布日期从2019年1月1日模拟到今天。（2分）   -2
			Date createDate = DateUtil.randomDate("2019-01-01", "2020-02-17");
			
			article.setCreated(createDate);
			
			//修改日期
			article.setUpdated(createDate);
			
//			(7)其它的字段随便模拟。
			//文章状态
			article.setStatus(0);
			
			//删除状态
			article.setDeleted(0);
			
			//评论数据
			article.setCommentcnt(0);
			
			//用户
			//获取所有用户，需要添加对应的方法，目前先不实现
//			userService.getList();
			
			//封装成对象
			System.out.println(article);
			
			//发送数据
			//将对象转换成json对象
			
			String jsonString = JSON.toJSONString(article);			
			
			kafkaTemplate.sendDefault("article_add", jsonString);
			
			//System.out.println("通过kafka发送完毕！");
			System.out.println(article.getTitle()+"已导入完毕");
		}
		
	}
}
