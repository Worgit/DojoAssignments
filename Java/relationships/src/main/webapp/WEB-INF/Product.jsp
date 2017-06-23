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
	<h1><c:out value='${product.name}'/></h1>
	<h3>Categories</h3>
	<c:forEach items="${product.categories}" var="category" varStatus="loop">    
    	<p>- <c:out value="${category.name}"/></p>
	</c:forEach>
	<form method="POST" action="/products/${product.id}">
		<label>Add Category<select name = "category">
			<c:forEach items="${categories}" var="category" varStatus="loop">
    		<option value = "${category.id}" >${category.name}</option>
    		</c:forEach>
    	</select></label>
    	<input type="submit" value="Add"/>
	</form>
</body>
</html>