<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<title>SpringBoot JSP</title>
</head>
<body>
<h2>${content}</h2>
<h2><%=request.getAttribute("content") %> </h2>
</body>
</html>