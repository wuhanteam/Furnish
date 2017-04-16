<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>后台首页</title>
	<link rel="stylesheet" type="text/css" href="style_css/basic.css">
	<link rel="stylesheet" type="text/css" href="style_css/admin.css">
</head>
<body>
    <!-- 左侧用户图像 -->
    <div id="container_left">
        <div id="left_top">
            <div class="left_topimg"><img src="image/user_ico.jpg" alt=""></div>
            <h2>欢迎登入!</h2>
        </div>
    
        <!-- 左侧菜单 -->
        <div id="menu">
            <ul>
                <li><a href="#">用户管理</a></li>
                <li><a href="#">客户管理</a></li>
                <li class="active">
                <a href="product_list.html" target="main_frame">商品信息录入</a></li>
                
                <li><a href="#">1元夺宝</a></li>
                <li><a href="#">退出系统</a></li>
            </ul>
        </div>
</div>
</body>
</html>