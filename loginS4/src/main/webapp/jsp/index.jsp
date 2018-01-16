<%@include file="../init.jsp"%>
<body>
<div style="text-align: center;">
	<form action="${basePath}/movit/login/signIn" method="post">
 		username:<input type="text" name="username" value=""/><br>
 		password:<input type="password" name="password" value=""/><br>
 		<input type="submit" value="Sign in"/>
 		
	</form>
</div>

</body>
</html>
