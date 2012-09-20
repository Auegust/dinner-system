package com.yummy.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.yummy.service.impl.HighQualifiedFoodsService;
/**
 * 
 * Function: �οͷ�����վʱ�ᱻ��action���أ���ȡ���ݿ�����Ҫ��ʾ��ʳ����Ϣ . <br/> 
 * date: 2012-9-20 ����3:10:19 <br/> 
 * 
 * @author jiahui 
 * @version 1.0
 */
@Component
public class MainAction extends ActionSupport {

	private List highQualifiedFoodsList = null;
	@Resource
	private HighQualifiedFoodsService highQualifiedFoodsService;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		highQualifiedFoodsList = highQualifiedFoodsService.getHighQualifiedFoods();
		System.out.println("ʳ�����������ǣ�" + highQualifiedFoodsList.size());
		return SUCCESS;
	}

	public List getHighQualifiedFoodsList() {
		return highQualifiedFoodsList;
	}

	public void setHighQualifiedFoodsList(List highQualifiedFoodsList) {
		this.highQualifiedFoodsList = highQualifiedFoodsList;
	}

	public HighQualifiedFoodsService getHighQualifiedFoodsService() {
		return highQualifiedFoodsService;
	}

	public void setHighQualifiedFoodsService(
			HighQualifiedFoodsService highQualifiedFoodsService) {
		this.highQualifiedFoodsService = highQualifiedFoodsService;
	}

	
}
