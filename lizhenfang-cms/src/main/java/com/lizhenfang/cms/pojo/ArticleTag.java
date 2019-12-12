package com.lizhenfang.cms.pojo;

import java.io.Serializable;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月12日 上午10:47:28
**/
public class ArticleTag implements Serializable{

	/**
	 *序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private Integer aid;

    private Integer tid;
    
    @Override
	public String toString() {
		return "ArticleTag [aid=" + aid + ", tid=" + tid + "]";
	}

	public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}
