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
<title>��Ӳ˵���Ϣ</title>
<script type="text/javascript" src="./jquery-1.7.js"></script>
<script type="text/javascript" src="./dishInfo.js"></script>
</head>
<body>

 <form action="saveMyDish" method="post">
 <table>
 <tr><td>����<input type="text" name="name" value="${dishUpade.name }"></td></tr>
 <tr><td>ͼƬ<input type="file" id="logo_file" name="picOne"  value="${dishUpade.picOne }"><input type="button" id="upload" value="Ԥ��" /></td></tr>
 <tr><td colspan="5"><img id="logo_img" src="${dishUpade.picOne }"></td></tr>
 <tr><td>����<textarea rows="5" cols="100" name="introduction"  >${dishUpade.introduction}</textarea></td></tr>
 <tr><td>�۸�<input type="text" name="price" value="${dishUpade.price }">Ԫ</td></tr>
  <tr><td>����
  <input type="checkbox" name="category" value="0">��
    <input type="checkbox" name="category" value="1">��
      <input type="checkbox" name="category" value="2">��
        <input type="checkbox" name="category" value="3">��
         <input type="checkbox" name="category" value="3">��
          <input type="checkbox" name="category" value="4">��
            <input type="checkbox" name="category" value="5">��
              <input type="checkbox" name="category" value="6">��
                <input type="checkbox" name="category" value="7">����
                  <input type="checkbox" name="category" value="8">���
                    <input type="checkbox" name="category" value="9">����
                      <input type="checkbox" name="category" value="10">����
                        <input type="checkbox" name="category" value="11">���
                          <input type="checkbox" name="category" value="12s">����
  </td></tr>
 <tr><td>��ǩ<input type="text" name="tag" value="${dishUpade.tag }"></td></tr>
 <tr><td>����<input type="text" name="point" value="${dishUpade.point }"></td></tr>
<!-- --------��û�е�¼����  Ĭ���û�Ϊdfs------------------ -->
 <!-- <tr><td><input type="hidden" name="shopname" value="#myShop.shopname"></td></tr> 
 <tr><td><input type="hidden" name="shopname" value="dfs"></td></tr>-->
 <tr><td><input type="submit" value="����" ></td></tr>
 </table>
 </form>
</body>
</html>