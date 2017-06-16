<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "en">
	<head>
		<meta charset = "UTF-8">
		<title>Survey</title>
	</head>
	<body>
		<div id = "wrapper">
			<p>Submitted Information</p>
			<table>
				<thead>
				</thead>
				<tbody>
					<tr>
						<td>Name:</td>
						<td><c:out value="${name}"/></td>
					</tr>
					<tr>
						<td>Dojo Location:</td>
						<td><c:out value="${location}"/></td>
					</tr>
					<tr>
						<td>Favorite Language:</td>
						<td><c:out value="${language}"/></td>
					</tr>
					<tr>
						<td>Comment:</td>
						<td><c:out value="${comment}"/></td>
					</tr>
				</tbody>
			</table>
			<a href = "/">Go Back</a>
		</div>
	</body>
</html>