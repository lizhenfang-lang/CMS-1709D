package com.lizhenfang.cms.pojo;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月11日 上午9:39:12
**/
public class Comment {
	private Integer id        ;
	private Integer articleld ;
	private Integer userld    ;
	private String  content   ;
	private DateTime created   ;
    
}  
