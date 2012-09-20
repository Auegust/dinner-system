package com.yummy.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
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

	private List highQualifiedFoods = null;
	
	
	@Resource(name="highQualifiedFoodDAO")
	private IHighQualifiedFoodDAO highQualifiedFoodDAO;
	//�����ʱ�ͻ�ȡʳ���б�

	
	public HighQualifiedFoodsService() {
//		highQualifiedFoods = highQualifiedFoodDAO.getHighQualifiedFoods();
	}
	
	public List getHighQualifiedFoods() {
		// TODO Auto-generated method stub
		if (highQualifiedFoods == null) {
			highQualifiedFoods = highQualifiedFoodDAO.getHighQualifiedFoods();
		} else {
			long time = new Date().getTime();
			if (time % 100000000 <= 100000) {
				highQualifiedFoods = highQualifiedFoodDAO.getHighQualifiedFoods();
			}
		} 
		return highQualifiedFoods;
	}

}
