<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.ebergstein.timer.models.Timer" 
    import = "java.util.ArrayList" import="java.util.Date" import = "java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StopWatch</title>
</head>
<body>
	<% SimpleDateFormat formatter = new SimpleDateFormat("K:mm a"); %>
	<form action = "timer" method = "get">
		<input type = "hidden" id = "type" name = "type" value = "start">
		<input type = "submit"  value = "Start">
	</form>
	<form action = "timer" method = "get">
		<input type = "hidden" id = "type" name = "type" value = "stop">
		<input type = "submit" value = "Stop">
	</form>
	<form action = "timer" method = "get">
		<input type = "hidden" id = "type" name = "type" value = "reset">
		<input type = "submit" value = "Reset">
	</form>
	<% if(session.getAttribute("timer") != null){ %>
  		<% Timer timer =  (Timer) session.getAttribute("timer");%>
  		<% timer.update(); %>
  		<p>Start: <%= formatter.format(timer.getStart()) %> Current: <%= formatter.format(timer.getCurrent()) %> Running Time: <%= timer.getMinutes() %>m <%= timer.getSeconds() %>s</p>
  	<%} %>
	<table>
		<tr>
    		<th>Start</th>
    		<th>Stop</th>
    		<th>Total</th>
  		</tr>
  		<% ArrayList<Timer> timers = (ArrayList<Timer>) session.getAttribute("timers"); %>
  		<% if (timers != null){ %>
			<%for (Timer timer: timers){ %>
  			<tr>
    			<td><%= timer.getStart() %></td>
    			<td><%= timer.getStop() %></td>
    			<td><%= timer.getMinutes() %>m <%= timer.getSeconds() %>s</td>
  			</tr>
  			<%} %>
  		<%} %>
	</table>
</body>
</html>