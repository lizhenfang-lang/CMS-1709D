package com.lizhenfang.cms.common;

import com.lizf.common.utils.Md5Util;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月14日 下午11:30:08
**/
public class CmsMd5Util {
	/**
	 * @Title: stringToMd5   
	 * @Description: TODO(描述这个方法的作用)   
	 * @param: @param str
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String string2MD5(String str) {
		return Md5Util.string2MD5(str+"_cmsAdmin");
	}
}