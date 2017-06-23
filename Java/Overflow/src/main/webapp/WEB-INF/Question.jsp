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
	<h1><c:out value="${question.question}"/></h1>
	<h3>Tags: 
		<c:forEach items="${question.tags}" var="tag" varStatus="loop">
    		<c:out value="${tag.subject}"/> 
    	</c:forEach> 
	</h3>
	<table>
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${question.answers}" var="answer" varStatus="loop">
			<tr>      
    			<td><c:out value="${answer.description}"/> </td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<h3>Add Your Answer</h3>
	<form:form method="POST" action="/questions/${question.id}" modelAttribute="answer">
    	<form:label path="description">Answer: 
    	<form:errors path="description"/>
    	<form:textarea path="description"/></form:label>
    	<input type="submit" value="Answer It!"/>
	</form:form>
</body>
</html>