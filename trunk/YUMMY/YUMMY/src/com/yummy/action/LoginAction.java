package com.yummy.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yummy.pojo.Customer;
import com.yummy.service.impl.CustomerService;

@Component("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	
	@Resource(name="CustomerService")
	private CustomerService customerService;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean isLogin = customerService.verified(username, password);
		if (isLogin) {
			Map session = ActionContext.getContext().getSession();
			session.put("username", username);
			return SUCCESS;
		}else {
			return INPUT;
		}
	}

	@Override
	public void validate() {   
		//����û�������û����Ϸ���
		if (username == null || username.length() < 4 || username.length() > 15) {
			addFieldError("username", "�û������Ȳ�����Ҫ��");
			System.out.println("�û������Ϸ�Ҫ��");
		}
		//�����������ĺϷ���
		if (password == null || password.length() < 4 || password.length() > 15) {
			addFieldError("password", "���볤�Ȳ�����Ҫ��");
			System.out.println("���볤�Ȳ�����Ҫ��");
		} 
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
