<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<title>权限管理系统</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<style>
.content {
	padding: 10px;
}
</style>
</head>

<body class="easyui-layout">
	<div data-options="region:'west',title:'菜单',split:true"
		style="width:180px;">
		<div class="easyui-panel" style="padding:5px">
		<ul id="menu" class="easyui-tree" data-options="url:'getTreeNode.do',method:'get'"></ul>
		
		</div>
	</div>
	<div data-options="region:'center',title:''" style="width:100%;">
		<div id="tabs" class="easyui-tabs">
			<div title="首页" style="padding:20px;">欢迎登陆！</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('#menu').tree({
				onClick : function(node) {
					if ($('#menu').tree('isLeaf', node.target)) {
						var tabs = $("#tabs");
						var tab = tabs.tabs("getTab", node.text);
						if (tab) {
							tabs.tabs('select', node.text);
						} else {
							tabs.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
		});
	</script>
</body>
</html>
