package com.yummy.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yummy.dao.impl.CustomerInfoDAO;
import com.yummy.dao.impl.OrderDAO;
import com.yummy.dao.impl.OrderInfoDAO;
import com.yummy.pojo.CustomerInfo;
import com.yummy.pojo.OrderDTO;
import com.yummy.service.IOrderService;

@Component("orderService")
@Scope("prototype")
public class OrderService  {

	@Resource(name="OrderDAO")
	private OrderDAO orderDAO;
	
	@Resource(name="OrderInfoDAO")
	private OrderInfoDAO orderInfoDAO;
	
	@Resource(name="CustomerInfoDAO")
	private CustomerInfoDAO customerInfoDAO;
	
	@Transactional
	public void save(OrderDTO orderDTO) throws SQLException{
		// TODO Auto-generated method stub
		//�洢�û�����Ϣ�����ַ���绰�ȡ�
		int customerInfoID = saveCustomerInfo(orderDTO);
		//�洢������Ϣ
		int orderID = saveOrder(orderDTO, customerInfoID);
		//�洢������ϸ��Ϣ
		saveOrderInfo(orderDTO, orderID);
	}


	public int saveOrder(OrderDTO orderDTO, int customerInfoID) {
		// TODO Auto-generated method stub
		return orderDAO.saveOrder(customerInfoID, orderDTO.getTotalPrice(),
				orderDTO.getMessage(), orderDTO.getShopname(), orderDTO.getUsername());
	}

	public void saveOrderInfo(OrderDTO orderDTO, int orderID) {
		// TODO Auto-generated method stub
		orderInfoDAO.saveOrderInfo(orderDTO, orderID);
	}

	public int saveCustomerInfo(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		String username = orderDTO.getUsername();
		String telephone = orderDTO.getTelephone();
		String address = orderDTO.getAddress();
		return customerInfoDAO.saveCustomerInfo(username, telephone, address);
	}

}
