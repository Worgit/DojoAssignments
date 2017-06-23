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
	<table>
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${questions}" var="question" varStatus="loop">
			<tr>      
    			<td><a href="/questions/${question.id}"><c:out value="${question.question}"/></a></td>
    			<td>
    			<c:forEach items="${question.tags}" var="tag" varStatus="loop">
    				<c:out value="${tag.subject}"/> 
    			</c:forEach>
    			</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="/questions/new">New Question</a>
</body>
</html>