package com.yummy.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.yummy.dao.ISearchDAO;

public class SearchDAO extends HibernateDaoSupport implements ISearchDAO {

	private List searchFoods = null;
	private List searchShops = null;
	
	public List getFoods(String searchItem) {
		// TODO Auto-generated method stub
		String sql = "select dish.name, dish.price from Dish dish where dish.name like " 
				+ "'%" + "�׷�" + "%'";
		System.out.println("��ѯʳ�" + sql);
		String testSQL = "from Dish where name like '%�׷�%'";
		searchFoods = getHibernateTemplate().find(testSQL);
		if (searchFoods != null) {
			System.out.println("��ѯ����ʳ�� ��" + searchFoods.size());
		}
		return searchFoods;
	}

	public List getShops(String searchItem) {
		// TODO Auto-generated method stub
		String sql = "select shopname from com.yummy.pojo.Shop where shopname like " 
				+ "'%" + "����" + "%'";
		System.out.println("��ѯ���̣�" + sql);
		String testSQL = "from Shop";
		searchShops = getHibernateTemplate().find(testSQL);
		if (searchShops != null) {
			System.out.println("��ѯ����ʳ�� ��" + searchShops.size());
		}
		return searchShops;
	}

}
