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
<!--   <s:property value="#attr.myShop.shopname"/>-->
${shop_on.shopname }
 </td>
 </tr>
  <tr>
 <td>  ����logo��
 </td>
 <td>
 <!--   <img alt="logo" src="<s:property value="#attr.myShop.logo"/>" >-->
 <img alt="logo" src="${shop_on.logo}" >
 </td>
 </tr>
  <tr>
 <td>  �������ܣ�
 </td>
 <td>
 <!--    <s:property value="#attr.myShop.introduction"/>-->
 ${shop_on.introduction }
 </td>
 </tr>
  <tr>
 <td>  ������ַ��
 </td>
 <td>
<!--    <s:property value="#attr.myShop.address"/>-->
${shop_on.address}
 </td>
 </tr>
  <tr>
 <td>�绰��
 </td>
 <td>
 <!--   <s:property value="#attr.myShop.telephone"/>-->
 ${shop_on.telephone}
 </td>
 </tr>
  <tr>
 <td>QQ:
 </td>
 <td>
<!--    <s:property value="#attr.myShop.qq"/>-->
${shop_on.qq }
 </td>
 </tr>
 <tr>
 <td>����Χ��
 </td>
 <td>
<!--    <s:property value="#attr.myShop.deliveryRange"/>-->
${shop_on.deliveryRange }
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