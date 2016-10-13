<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="product" class="com.model.ProductBean"/>
<jsp:setProperty property="price" name="product" value="2.1"/>
<jsp:setProperty property="num" name="product" value="10"/>
单价:<jsp:getProperty property="totalPrice" name="product"/>
</body>
</html>