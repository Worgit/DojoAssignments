<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CheckerBoard</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
<body>
    <%
    String rawWidth = request.getParameter("width");
    if(rawWidth == null){
    	rawWidth = "0";
    }
    String rawHeight = request.getParameter("height");
    if(rawHeight == null){
    	rawHeight = "0";
    }
    int width = Integer.valueOf(rawWidth).intValue(); 
    int height = Integer.valueOf(rawHeight).intValue();
    %> 
    <h1>CheckerBoard: <%= width %>w X <%= height %>h</h1>
    <%for(int i = 0; i < height; i++){%>
    	<div class = "row">
    		<% for(int j = 0; j < width; j++){ 
    			if(j % 2 == 1){ %>
    				<div class = "blue"></div>
    			<% }
    			else{  %>
					<div class = "pink"></div><%
				}
    		} %>
    	</div><%
    }%>
</body>
</html>