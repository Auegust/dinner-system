package com.yummy.pojo;
/**
 * Function: ʵ��bean,����ת�ز�ѯʳ����. <br/> 
 * date: 2012-9-21 ����9:41:33 <br/> 
 * 
 * @author Jiahui.wen
 */
public class SearchFoodsDTO {
	
	private Integer dishId;
	private String name;
	private Float price;
	private String shopname;
	
	public Integer getDishId() {
		return dishId;
	}
	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	
}
