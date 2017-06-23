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
<div id="ninjas">
    <h1>Dojo And Ninjas</h1>
    
    <c:forEach begin="1" end="${totalPages}" var="index">
        <a href="/pages/${index}">${index}</a>
    </c:forEach>
    <table>
        <thead>
        	<tr>
        		<th>Dojo Name</th>
            	<th>First Name</th>
            	<th>Last Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="result" items="${results.content}">               
            <tr>
            	<td><c:out value="${result[0].name}"></c:out></td>
                <td><c:out value="${result[1].firstName}"></c:out></td>
                <td><c:out value="${result[1].lastName}"></c:out></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>