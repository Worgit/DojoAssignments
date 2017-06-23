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
	<a href="/songs/new">Add New</a>
	<a href="/songs/top">Top Songs</a>
	<form action = "/search" method = "post">
		<input type="text" name="name" id="name">
		<input type = "submit" value = "Search Artists">
	</form>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${songs}" var="element" varStatus="loop">
			<tr>      
    			<td><a href="/songs/${element.id}"><c:out value="${element.name}"/></a></td>
    			<td><c:out value="${element.rating}"/></td>
    			<td><a href="/songs/delete/${element.id}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>