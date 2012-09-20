package com.yummy.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yummy.dao.IHighQualifiedFoodDAO;
import com.yummy.service.IHighQualifiedFoodsService;
/**
 * 
 * Function: ����Dao����ȡ���۱Ƚϸߵ�ʳ���б� . <br/> 
 * date: 2012-9-20 ����10:22:33 <br/> 
 * 
 * @author jiahui 
 * @version 1.0
 */

@Component
public class HighQualifiedFoodsService implements IHighQualifiedFoodsService {

	private List highQualifiedFoods;
	
	@Resource(name="highQualifiedFoodDAO")
	private IHighQualifiedFoodDAO highQualifiedFoodDAO;
	//�����ʱ�ͻ�ȡʳ���б�

	
	public HighQualifiedFoodsService() {
//		highQualifiedFoods = highQualifiedFoodDAO.getHighQualifiedFoods();
	}
	
	public List getHighQualifiedFoods() {
		// TODO Auto-generated method stub
		highQualifiedFoods = highQualifiedFoodDAO.getHighQualifiedFoods();
		return highQualifiedFoods;
	}

}
