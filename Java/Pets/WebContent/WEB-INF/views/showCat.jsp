<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Cat Page</title>
</head>
<body>
    <p>
        <c:out value="${cat.showAffection()}"/>
    </p>
</body>
</html>