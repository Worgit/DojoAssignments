<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<meta charset="UTF-8">
  	<title>NinjaGold</title>
  </head>
  <body>
  	<div id = "mainwrapper">
  		<% Integer gold = (Integer) session.getAttribute("gold"); %>
  		<% if(gold == null){ %>
			<p>Your Gold:</p>
		<%} else{ %>
			<p>Your Gold: <%= gold %></p>
		<%} %>
		<div class = "box">
			<h2>Farm</h2>
			<p>(earns 10-20 gold)</p>
			<form id = farm action = "/gold" method = "post">
				<input type = "hidden" value = "farm" name = "type">
				<input type = "submit" value = "Find Gold!">
			</form>
		</div>
		<div class = "box">
			<h2>Cave</h2>
			<p>(earns 5-10 gold)</p>
			<form id = cave action = "/gold" method = "post">
				<input type = "hidden" value = "cave" name = "type">
				<input type = "submit" value = "Find Gold!">
			</form>
		</div>
		<div class = "box">
			<h2>House</h2>
			<p>(earns 2-5 gold)</p>
			<form id = house action = "/gold" method = "post">
				<input type = "hidden" value = "house" name = "type">
				<input type = "submit" value = "Find Gold!">
			</form>
		</div>
		<div class = "box">
			<h2>Casino</h2>
			<p>(earns/takes 0-50 gold)</p>
			<form id = casino action = "/gold" method = "post">
				<input type = "hidden" value = "casino" name = "type">
				<input type = "submit" value = "Find Gold!">
			</form>
		</div>
		<div id = "wrapper">
			<p>Activities:</p>
			<div id = "activities">
				<% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities"); %>
				<% if(activities != null){ %>
					<% for(String element: activities){%>
						<p><%= element %></p>
					<%} %>
				<%} %>
			</div>
		</div>
	</div>
  </body>
</html>
