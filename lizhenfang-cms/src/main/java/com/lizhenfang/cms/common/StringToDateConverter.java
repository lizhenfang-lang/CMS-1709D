package com.lizhenfang.cms.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月17日 下午2:19:49
**/
public class StringToDateConverter implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date= simpleDateFormat.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	
}
