<%@ page isELIgnored="false" %>

<html>
<body>
<h2>Spring Demo</h2>

<a href="test/hello">Hello</a>

<br><br>	


<a href= "${pageContext.request.contextPath}/test/hello">SayHello </a>

<br><br>

<a href= "${pageContext.request.contextPath}/api/studentlist">Students </a>

</body>
</html>
