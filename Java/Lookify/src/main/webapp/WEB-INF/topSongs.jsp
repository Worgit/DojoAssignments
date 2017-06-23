<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<p>Top Ten Songs:</p>
	<c:forEach items="${songs}" var="element" varStatus="loop">     
    	<p><c:out value="${element.rating}"/> - <a href="/songs/${element.id}"><c:out value="${element.name}"/></a> - <c:out value="${element.artist}"/></p>
	</c:forEach>
</body>
</html>