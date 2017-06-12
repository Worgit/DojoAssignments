<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList" import = "java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculator</title>
</head>
<body>
	<form action = "calculator" method = "post">
		<% if (session.getAttribute("calculation") == null) {%>
			<input type = "text" name = "calculation">
		<%} else{%>
			<input type = "text" name = "calculation" value ="<%= session.getAttribute("calculation") %>">
		<% } %>

		<button name="character" value= "1">1</button>
		<button name="character" value= "2">2</button>
		<button name="character" value= "3">3</button>
		<button name="character" value= "4">4</button>
		<button name="character" value= "5">5</button>
		<button name="character" value= "6">6</button>
		<button name="character" value= "7">7</button>
		<button name="character" value= "8">8</button>
		<button name="character" value= "9">9</button>
		<button name="character" value= " + ">+</button>
		<button name="character" value= " - ">-</button>
		<button name="character" value= " * ">*</button>
		<button name="character" value= " / ">/</button>
		<button name="character" value= "=">=</button>
		<button name="character" value= "c">c</button>
	</form>
	<h3>Previous results:</h3>
	<% if (session.getAttribute("previous") != null) {
		ArrayList<Integer> previous = (ArrayList<Integer>) session.getAttribute("previous");
		for(int i = 0; i < previous.size(); i++){ %>
			<p><%= i + 1 %>) <%= previous.get(i) %>
		<%}
	} %>
</body>
</html>