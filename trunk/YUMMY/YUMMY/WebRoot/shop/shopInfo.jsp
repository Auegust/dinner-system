<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="com.yummy.dao.impl.*"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>�ҵĲ���</title>
</head>
<body>
<h1>�ҵĲ���</h1>
<%
 Boolean readOnly = (Boolean)request.getAttribute("ReadOnly");
 if(readOnly==null)
  readOnly = false;
 if(readOnly){
 //	Shop myShop = (Shop)request.getAttribute("MyShop");
 %>
 <!-- 
 �������ƣ�$(myShop.shopname);
 ����logo��$(myShop.logo);
 �������ܣ�$(myShop.introdution);
 ��ַ��$(myShop.address);
 �绰��$(myShop.telephone);
 QQ:$(myShop.qq);
 ����Χ��$(myShop.deliveryRange); -->
 
 <table>
 <tr>
 <td> �������ƣ�
 </td>
 <td>
 <s:property value="#attr.myShop.shopname"/>
 </td>
 </tr>
  <tr>
 <td>  ����logo��
 </td>
 <td>
 <img alt="logo" src="<s:property value="#attr.myShop.logo"/>" >
 </td>
 </tr>
  <tr>
 <td>  �������ܣ�
 </td>
 <td>
  <s:property value="#attr.myShop.introduction"/>
 </td>
 </tr>
  <tr>
 <td>  ������ַ��
 </td>
 <td>
 <s:property value="#attr.myShop.address"/>
 </td>
 </tr>
  <tr>
 <td>�绰��
 </td>
 <td>
 <s:property value="#attr.myShop.telephone"/>
 </td>
 </tr>
  <tr>
 <td>QQ:
 </td>
 <td>
 <s:property value="#attr.myShop.qq"/>
 </td>
 </tr>
 <tr>
 <td>����Χ��
 </td>
 <td>
 <s:property value="#attr.myShop.deliveryRange"/>
 </td>
 </tr>
  <tr>
  <td><a href="./updateShopInfo.jsp">�޸�</a></td>
 </tr>
 </table>
 
<%}else{ %>
<h3>��û����д������Ϣ,����ȥ��д��</h3>
<a href="./addShopInfo.jsp">�༭�ҵĲ���</a>
<%} %>
</body>
</html>