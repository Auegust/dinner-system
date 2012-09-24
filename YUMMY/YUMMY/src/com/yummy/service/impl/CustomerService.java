package com.yummy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yummy.dao.impl.CustomerDAO;
import com.yummy.pojo.Customer;
import com.yummy.service.ICustomerService;

@Component("customerService")
@Scope("prototype")
public class CustomerService implements ICustomerService {

	@Resource(name="CustomerDAO")
	private CustomerDAO customerDAO;
	
	public boolean verified(String username, String password) {
		// TODO Auto-generated method stub
		/*Customer customer = customerDAO.findById(username);
		System.out.println("���͹�ȥ�ģ� " + username + " ---> " + password);
		boolean flag = false;
		if (customer == null) {
			flag = false; System.out.println("customer ������");
		} else if (password.equals(customer.getPassword())){
			flag = true;
		}
		return flag;*/
		String sql = "select new Customer(customer.username, customer.password) from Customer customer where customer.username = '"
				+ username + "'";
		System.out.println(sql);
//		List<Customer> list = customerDAO.query(sql);
		List<Customer> list = customerDAO.findAll();
		if (list != null && list.size() > 0) {
			Customer customer = list.get(0);
			System.out.println("customer ����");
			return true;
		}
		return false;
	}

}

