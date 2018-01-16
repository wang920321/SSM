<%@include file="../init.jsp"%>
<%@page isELIgnored="false"%>

<body>
<div style="text-align: center;">
	
	<c:forEach items="${cityList}" var="city">
		<div>
			${city.city }<br/>
			${city.cnty }<br/>
			${city.id }<br/>
			${city.lat }<br/>
			${city.lon }<br/>
			<br/>
			<br/>
			<br/>
			<br/>
		</div>
	</c:forEach>
</div>

</body>
</html>
