<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="taglibs.jsp" flush="true"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title>后台首页</title>
	<link rel="stylesheet" type="text/css" href="style_css/basic.css">
	<link rel="stylesheet" type="text/css" href="style_css/product_list.css">
    <script type="text/javascript" src="style_script/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="style_script/user_list.js"></script>
	<script type="text/javascript" src="js/currentTime.js"></script>
	<script type="text/javascript">
		setInterval(function(){$("#showtime").text(showTime())},1000); 
		 $(document).ready(function(){
			
		});
	
	</script>
</head>
<body>
	<!-- 面包屑 -->
<div id="pro_wrap">
	<div class="breadcrumb">
		<span id="showtime"></span>
	</div>
	<div class="right_welcomeMsg" style="text-align: center;padding:200px;font-size: 17px;color: #1C1C1C;">欢迎登录!
	</div>
	
</div>    
</body>
</html>