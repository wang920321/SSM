<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
success!
<br>


<a href="${basePath}/movit/login/removeSession">removeSession</a>

<br>

<a href="${basePath}/movit/login/testFilter">testFilter</a>

<br>
<a href="${basePath}/movit/login/logout">logout</a>

<br>
<a href="${basePath}/movit/weather/query?city=suzhou">query weather</a>
<form action="${basePath}/movit/weather/query">
    cityname:<input type="text" name="cityname" value=""/><br>
 	<input type="submit" value="查询"/>
</form>


</body>


<script type="text/javascript">



</script>

</html>
