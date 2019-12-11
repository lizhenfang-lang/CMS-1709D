package com.lizhenfang.cms.pojo;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

/**
 * @program:lizhenfang-cms
 * @author: 李振芳
 *
 * @version:2019年12月11日 上午9:24:17
 **/
public class Article {
	private Integer id;
	private String title;
	private String content;
	private Integer picture;
	private Integer channel_id;
	private Integer category_id;
	private Integer user_id;
	private Integer hits;
	private Integer hot;
	private Integer status;
	private Integer deleted;
	private DateTime created;
	private DateTime updated;
	private String commentCnt;
	
	

}
