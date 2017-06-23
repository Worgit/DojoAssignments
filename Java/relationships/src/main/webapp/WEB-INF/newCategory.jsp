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
<body>
	<h1>New Category</h1>
	<form:form method="POST" action="/categories/new" modelAttribute="category">
		<form:hidden path="id"/>
    	<form:label path="name">Name
    	<form:errors path="name"/>
    	<form:input path="name"/></form:label>
    	<input type="submit" value="Create"/>
	</form:form>
</body>
</html>