package wen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBTool {
	private final String driverName = "com.mysql.jdbc.Driver";
	private final String url = "jdbc://localhost:3306/test"; 
	private final String userName = "root";
	private final String password = "root";
	
	public boolean cnonnection2DB() {
		
		boolean flag = true;
		
		try {
			Class.forName(driverName);
			Connection conn =  DriverManager.getConnection(url, userName, password);
			PreparedStatement stmt = conn.prepareStatement(null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			flag = false;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("��ȡ���ݿ�����ʧ��");
			flag = flag;
		}
		
		return flag;
	}
	
	public boolean close() {
		boolean flag = true;
		
		
		return flag;
	}
 }
