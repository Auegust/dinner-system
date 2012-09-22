package com.yummy.service.impl;

import java.util.Iterator;
import java.util.List;

import com.yummy.pojo.ItemDTO;
import com.yummy.service.ICartManager;
/**
 * 
 * Function: �߼�bean�������ﳵ��ʳ� . <br/>
 * 			���� ���ʳ� �޸�ʳ�������� ɾ��ʳ� <br> 
 * 
 * date: 2012-9-22 ����9:57:57 <br/> 
 * @author Jiahui.wen
 */
public class CartManager implements ICartManager {
	
	/**
	 * ���ﳵ���ʳ��
	 */
	private List<ItemDTO> items;
	

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	/**
	 * 
	 * TODO �����ﳵ���ʳ���ѡ��. 
	 * @see com.yummy.service.ICartManager#add(com.yummy.pojo.ItemDTO)
	 */
	public void add(ItemDTO item) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		if(!flag) {
			items.add(item);
		}
	}

	/**
	 * 
	 * TODO ɾ�����ﳵ�����ʳ���ѡ��. 
	 * @see com.yummy.service.ICartManager#delete(int)
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		Iterator iterator = items.iterator();
		while (iterator.hasNext()) {
			ItemDTO temp = (ItemDTO) iterator.next();
			if (temp.getId() == id) {
				items.remove(temp);
				break;
			}
		}
	}

	/**
	 * 
	 * TODO �޸Ĺ��ﳵ��ʳ�����������ѡ��. 
	 * @see com.yummy.service.ICartManager#update(int, int)
	 */
	public void update(int id, int quantities) {
		// TODO Auto-generated method stub
		for (int i = 0; i < items.size(); i++) {
			ItemDTO temp = items.get(i);
			if (temp.getId() == id) {
				temp.setOrderCount(quantities);
			}
		}
	}

	/**
	 * 
	 * TODO �жϹ��ﳵ�Ƿ�������ͬʳ����ڣ���ѡ��. 
	 * @see com.yummy.service.ICartManager#isItemExist(int)
	 */
	public boolean isItemExist(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (int i = 0; i < items.size(); i++) {
			ItemDTO temp = items.get(i);
			if (temp.getId() == id) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 
	 * TODO �����������û��ظ�������빺�ﳵʱ���á�����ѡ��. 
	 * @see com.yummy.service.ICartManager#increase(int, int)
	 */
	public void increase(int id, int quantities) {
		// TODO Auto-generated method stub
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == id) {
				ItemDTO temp = items.get(i);
				temp.setOrderCount(temp.getOrderCount() + quantities);
				break;
			} 
		}
	}

	/**
	 * 
	 * TODO ��չ��ﳵ����ѡ��. 
	 * @see com.yummy.service.ICartManager#removeAll()
	 */
	public void removeAll() {
		// TODO Auto-generated method stub
		items.clear();
	}

	public float getTotalPrice() {
		// TODO Auto-generated method stub
		float totalPrice = 0;
		if (items.size() > 0) {
			for (int i = 0; i < items.size(); i++) {
				ItemDTO item = items.get(i);
				totalPrice += item.getPrice() * item.getOrderCount();
			}
		}
		return totalPrice;
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == id) {
				items.remove(i);
				break;
			} 
		}
	}

}
