package com.yummy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yummy.dao.IHighQualifiedFoodDAO;
import com.yummy.pojo.Dish;
import com.yummy.pojo.HighQualifiedFoodDTO;

public class HighQualifiedFoodDAO extends HibernateDaoSupport implements IHighQualifiedFoodDAO{

	List<Dish> highQualifiedFoods = new ArrayList<Dish>();
	/**
	 * �û����ͺ����۱Ƚϸߵ�ʳ���������ҳ����ʾ.
	 */
	public List getHighQualifiedFoods() {
		// TODO Auto-generated method stub
		
	 // ��ȡ���۽ϸߵ�ʳ�����֣��۸����֣����������ͼ����Ϣ
	 String sql = "select new Dish(dish.dishId, dish.shopname, dish.name, dish.point, dish.price , dish.picOne) "
			 + "from com.yummy.pojo.Dish dish order by dish.point asc, dish.name desc ";

	 
	 // ȷ��list�ǿ�
	 if (highQualifiedFoods != null) {
		 highQualifiedFoods.clear();
	 }
	 List highQualifiedFoods = getHibernateTemplate().find(sql);
	 
	 // �������ݿ��в�ѯ��dish����ת���� highQualifiedFoodDTO����
	/* for (int i = 0; i < tempList.size(); i++) {
		 HighQualifiedFoodDTO temp = new HighQualifiedFoodDTO();
		 temp.setDishId(((Dish)tempList.get(i)).getDishId());
		 temp.setName(((Dish)tempList.get(i)).getName());
		 temp.setPrice(((Dish)tempList.get(i)).getPrice());
		 temp.setPoint(((Dish)tempList.get(i)).getPoint());
		 temp.setShopname(((Dish)tempList.get(i)).getShopname());
		 temp.setPicOne(((Dish)tempList.get(i)).getPicOne());
		 highQualifiedFoods.add(temp);
	}*/
	 return highQualifiedFoods;
	}

}
