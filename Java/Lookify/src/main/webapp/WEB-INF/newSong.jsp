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
	<form:form method="POST" action="/songs/new" modelAttribute="song">
		<form:hidden path="id"/>
    	<form:label path="name">Title
    	<form:errors path="name"/>
    	<form:input path="name"/></form:label>
    	<form:label path="artist">Artist
    	<form:errors path="artist"/>
    	<form:textarea path="artist"/></form:label>
    	<form:label path="rating">Rating(1-10)
    	<form:errors path="rating"/>
    	<form:select path="rating">
    		<form:option value = "1" label = "1"/>
    		<form:option value = "2" label = "2"/>
    		<form:option value = "3" label = "3"/>
    		<form:option value = "4" label = "4"/>
    		<form:option value = "5" label = "5"/>
    		<form:option value = "6" label = "6"/>
    		<form:option value = "7" label = "7"/>
    		<form:option value = "8" label = "8"/>
    		<form:option value = "9" label = "9"/>
    		<form:option value = "10" label = "10"/>
    	</form:select>
    	</form:label>
    	<input type="submit" value="Add Song"/>
	</form:form>
</body>
</html>