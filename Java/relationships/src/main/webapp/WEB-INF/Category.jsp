<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value='${category.name}'/></h1>
	<h3>Products</h3>
	<c:forEach items="${category.products}" var="product" varStatus="loop">    
    	<p>- <c:out value="${product.name}"/></p>
	</c:forEach>
	<form method="POST" action="/categories/${category.id}">
		<label>Add Product<select name = "product">
			<c:forEach items="${products}" var="product" varStatus="loop">
    		<option value = "${product.id}">${product.name}</option>
    		</c:forEach>
    	</select></label>
    	<input type="submit" value="Add"/>
	</form>
</body>
</html>