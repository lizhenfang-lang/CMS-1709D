package com.lizhenfang.cms.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lizhenfang.cms.pojo.Article;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2020年2月12日 下午2:36:52
**/
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer>{
     List<Article> findByTitle(String key);
}
