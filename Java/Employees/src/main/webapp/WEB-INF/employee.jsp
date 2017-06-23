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
	<h1><c:out value="${manager.first_name}"/> <c:out value="${manager.last_name}"/></h1>
	<c:forEach items="${manager.employees}" var="employee" varStatus="loop">   
    	<p><c:out value="${employee.first_name}"/> <c:out value="${employee.last_name}"/></p>
	</c:forEach>
	<form:form method="POST" action="/employee/${manager.id}" modelAttribute="employee">
		<form:hidden path="id"/>
    	<form:label path="first_name">First:
    	<form:errors path="first_name"/>
    	<form:input path="first_name"/></form:label>
    	<form:label path="last_name">Last:
    	<form:errors path="last_name"/>
    	<form:input path="last_name"/></form:label>
    	<input type="submit" value="Create"/>
	</form:form>
</body>
</html>