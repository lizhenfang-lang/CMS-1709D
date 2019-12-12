package com.lizhenfang.cms.pojo;

import java.io.Serializable;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月12日 上午10:53:29
**/
public class VoteContent{
	 private Integer id;

	    private String title;

	    private String content;

	    @Override
		public String toString() {
			return "VoteContent [id=" + id + ", title=" + title + ", content=" + content + "]";
		}

		public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title == null ? null : title.trim();
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content == null ? null : content.trim();
	    }
	
}
