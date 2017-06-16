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
			<form action = "/result" method = "post">
				<label for="name">Your Name:</label>
				<input type="text" name="name" id="name">
				<label for="dojo">Dojo Location:</label>
				<select id = "dojo" name = "location">
					<option value = "Seattle">Seattle</option>
					<option value = "New York">New York</option>
					<option value = "Los Angeles">Los Angeles</option>
				</select>
				<label for="language">Favorite language:</label>
				<select id = "language" name = "language">
					<option value = "Ruby">Ruby</option>
					<option value = "C#">C#</option>
					<option value = "BASIC">BASIC</option>
				</select>
				<p>Comment (optional)</p>
				<textarea name = "comment"></textarea>
				<input type = "submit" name = "submit" value = "Submit">
			</form>
		</div>
	</body>
</html>