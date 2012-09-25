package com.yummy.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yummy.pojo.ItemDTO;
import com.yummy.service.ICartManager;
import com.yummy.service.impl.CartManager;
/**
 * Function: ���û������ʳ��ŵ����ﳵ . <br/> 
 * date: 2012-9-22 ����3:32:33 <br/> 
 * 
 * @author Jiahui.wen
 */
@Component("cartAction")
@Scope("prototype")
public class CartAction extends ActionSupport {

	private int id;
	private int orderCount;
	private String itemname;
	private String picPath;
	private float price;
	private String shopname;
	
	private String type;
	@Resource(name="cartManager")
	private ICartManager manager;
	private Map session = ActionContext.getContext().getSession();
	
	@Override
	public String execute() throws Exception {

		//��ȡ���ﳵʳ����
		List<ItemDTO> itemList = (List<ItemDTO>) session.get("items");
		if (itemList == null) {
			itemList = new ArrayList<ItemDTO>();
		}
		manager.setItems(itemList);
		
		String returnType = "";
		
		if ("add".equalsIgnoreCase(type)) {
			returnType = add(manager);
		} else if ("update".equalsIgnoreCase(type)) {
			returnType = update(manager);
		} else if ("delete".equalsIgnoreCase(type)) {
			remove(manager);
			returnType = SUCCESS;
		} else if ("removeALl".equalsIgnoreCase(type)) {
			removeAll(manager);
			returnType = SUCCESS;
		} else {
			returnType = SUCCESS;
		}
		
		return returnType;
	}
	
	/**
	 * 
	 * add:���ʳ�ﵽ���ﳵ. <br/> 
	 * 
	 * @author jiahui 
	 * @param manager
	 * @return
	 */
	public String add(ICartManager manager) {
		if (id != 0 && orderCount != 0) {
			if (manager.isItemExist(id)) {  //���ﳵ�Ѿ����ڸ���ʳ��
				manager.increase(id, orderCount);
			} else {
				ItemDTO item = new ItemDTO(id, orderCount, itemname, picPath, price);
				manager.add(item);
			}
			updateMap(manager);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	/**
	 * 
	 * update:���¹��ﳵʳ������. <br/> 
	 * 
	 * @author jiahui 
	 * @param manager
	 * @return
	 */
	public String update(ICartManager manager) {
/*		if (orderCount == 0) {
			manager.remove(id);
		} else {
			manager.update(id, orderCount);
		}*/
		if (orderCount != 0) {
			manager.update(id, orderCount);
			updateMap(manager);
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * remove:ɾ�����ﳵĳЩʳ��. <br/> 
	 * 
	 * @author jiahui 
	 * @param manager
	 */
	public void remove(ICartManager manager) {
		manager.remove(id);
		updateMap(manager);
	}
	
	/**
	 * 
	 * removeAll:��չ��ﳵ. <br/> 
	 * 
	 * @author jiahui 
	 * @param manager
	 */
	public void removeAll(ICartManager manager) {
		manager.removeAll();
		updateMap(manager);
	}
	
	/**
	 * 
	 * updateMap:����session�е�����. <br/> 
	 * 
	 * @author jiahui 
	 * @param manager
	 */
	public void updateMap(ICartManager manager) {
		session.put("items", manager.getItems());
		session.put("totalPrice", manager.getTotalPrice());
		if (manager.getItems().size() != 0) {
			session.put("shopname", shopname);
		} else {
			session.remove("shopname");
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
}
