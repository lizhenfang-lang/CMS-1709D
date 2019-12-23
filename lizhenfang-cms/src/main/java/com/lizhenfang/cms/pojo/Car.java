package com.lizhenfang.cms.pojo;

import java.io.Serializable;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月20日 下午8:58:07
**/
public class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id    ;
	private String name  ;
	private String price ;
	private Integer state ;
	private String color ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", state=" + state + ", color=" + color + "]";
	}
	public Car(Integer id, String name, String price, Integer state, String color) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.state = state;
		this.color = color;
	}
	public Car() {
		super();
	}
	
        
	
	
	
}
