<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>���Ӳ�����Ϣ</title>
<script type="text/javascript" src="./jquery-1.7.js"></script>
<script type="text/javascript" src="./shopInfo.js"></script>
</head>
<body>

 <form action="addShop" method="post">
 <table>
 <tr><td>��������<input type="text" name="shopname"></td></tr>
 <tr><td>����logo<input type="file" id="logo_file" name="logo"><input type="button" id="upload" value="Ԥ��" /></td></tr>
 <tr><td colspan="5"><img id="logo_img" src="../images/shop/default_logo.jpg"></td></tr>
 <tr><td>��������<textarea rows="5" cols="100" name="introduction"></textarea></td></tr>
 <tr><td>��ַ<input type="text" name="address"></td></tr>
 <tr><td>�绰<input type="text" name="telephone"></td></tr>
 <tr><td>QQ<input type="text" name="qq"></td></tr>
 <tr><td>��Ӫ��Χ<input type="text" name="deliveryRange"></td></tr>
 <tr><td><input type="submit" value="����" ></td></tr>
 </table>
 </form>
</body>
</html>