package com.lizhenfang.cms.pojo;

import java.io.Serializable;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月12日 上午10:52:44
**/
public class Tag implements Serializable{

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;

    private String tagname;
    
    @Override
	public String toString() {
		return "Tag [id=" + id + ", tagname=" + tagname + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }
}
