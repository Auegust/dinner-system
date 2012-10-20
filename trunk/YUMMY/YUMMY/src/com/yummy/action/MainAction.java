package com.yummy.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.yummy.service.impl.HighQualifiedFoodsService;
/**
 * 
 * Function: �οͷ�����վʱ�ᱻ��action���أ���ȡ���ݿ�����Ҫ��ʾ��ʳ����Ϣ . <br/> 
 * date: 2012-9-20 ����3:10:19 <br/> 
 * 
 * @author jiahui 
 * @version 1.0
 */
@Component("mainAction")
@Scope("prototype")
public class MainAction extends ActionSupport {

	private List highQualifiedFoodsList = null;
	private Map session = null;
	
	@Resource
	private HighQualifiedFoodsService highQualifiedFoodsService;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		highQualifiedFoodsList = highQualifiedFoodsService.getHighQualifiedFoods();
		session = ActionContext.getContext().getSession();
		//����ȡ����ʳ��Ŵ�session�У�Ȼ����ҳ��ʹ��OGNL���ʽȡ������ʾ
		session.put("highQualifiedFoodsList", highQualifiedFoodsList);
		
		return SUCCESS;
	}
	
}
