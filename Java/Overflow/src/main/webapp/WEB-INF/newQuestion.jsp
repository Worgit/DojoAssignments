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
	<p><c:out value="${errors}"/></p>
	<h1>What is your question?</h1>
		<form method="POST" action="/questions/new">
    		<label>Question: <textarea name = "question"></textarea></label>
    		<label>Tags: <input type = "text" name = "tags"/></label>
    		<input type="submit" value="Create"/>
		</form>
</body>
</html>