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
	<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
		<form:hidden path="id"/>
		<form:label path="dojo">Dojo:
    	<form:errors path="dojo"/>
		<form:select path="dojo">
			<c:forEach items="${dojos}" var="element" varStatus="loop">
    		<form:option value = "${element.id}" label = "${element.name}"/>
    		</c:forEach>
    	</form:select></form:label>
    	<form:label path="firstName">First Name:
    	<form:errors path="firstName"/>
    	<form:input path="firstName"/></form:label>
    	<form:label path="lastName">Last Name:
    	<form:errors path="lastName"/>
    	<form:input path="lastName"/></form:label>
    	<form:label path="age">Age:
    	<form:errors path="age"/>
    	<form:input type = "number" path="age"/></form:label>
    	<input type="submit" value="Create"/>
	</form:form>
</body>
</html>