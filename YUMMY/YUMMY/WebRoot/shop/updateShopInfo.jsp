<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�޸Ĳ�����Ϣ</title>
<script type="text/javascript" src="./jquery-1.7.js"></script>
<script type="text/javascript" src="./shopInfo.js"></script>
</head>
<body>
<s:form action="saveShop">
<table>
<tr>
<td>�������ƣ�</td>
<td> <input type="text" name="shopname"  value="<s:property value="#attr.myShop.shopname"/>"/></td>
</tr>
<tr>
<td rowspan="2">����logo:</td><td><input type="file" id="logo_file" name="logo"><input type="button" id="upload" value="Ԥ��" /></td></tr>
<tr><td><img alt="logo" id="logo_img"  src="<s:property value='#attr.myShop.logo'/>"/></td></tr>
<tr>
<td>�������ܣ�</td><td><textarea  name="introduction" ><s:property value='#attr.myShop.introduction'/></textarea></td></tr>
<tr>
<td>��ַ��</td><td><input type="text"  name="address" value="<s:property value='#attr.myShop.address'/>"/></td></tr>
<tr>
<td>�绰��</td><td><input type="text"  name="telephone" value="<s:property value='#attr.myShop.telephone'/>"/></td></tr>
<tr><td>QQ:</td><td><input type="text"  name="qq" value="<s:property value='#attr.myShop.qq'/>"/></td></tr>
<tr><td>����Χ��</td><td><input type="text"  name="deliveryRange" value="<s:property value='#attr.myShop.deliveryRange'/>"/></td></tr>
<tr><td><s:submit value="����"></s:submit></td></tr>
</table>
</s:form>

</body>
</html>