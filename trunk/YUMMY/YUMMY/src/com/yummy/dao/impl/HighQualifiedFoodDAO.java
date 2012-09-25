package com.yummy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
	 String sql = "select new Dish(dish.dishId, dish.shop, dish.name, dish.point, dish.price , dish.picOne) "
			 + "from com.yummy.pojo.Dish dish order by dish.point asc, dish.name desc ";
		
	 // ȷ��list�ǿ�
	 if (highQualifiedFoods != null) {
		 highQualifiedFoods.clear();
	 }
	 List highQualifiedFoods = getHibernateTemplate().find(sql);
	 
	 return highQualifiedFoods;
	}

}
