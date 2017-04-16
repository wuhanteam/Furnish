<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cxt" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
	<link rel="stylesheet" type="text/css" href="style_css/basic.css">
	<link rel="stylesheet" type="text/css" href="style_css/admin.css">
	<link rel="stylesheet" type="text/css" href="style_css/product_list.css">
	<script type="text/javascript" src="style_script/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	
	<script type="text/javascript">
		
	</script>
	
	</head>

	<body>
		<div id="header">
			<a href="#" title="1元购后台OA管理系统"><img class="logo" src="image/admin_logo.jpg" alt=""></a>
			<h2>1元购后台OA管理系统</h2>
		</div>
		<div id="container" class="clearfix">
		<!-- 左侧用户图像 -->
	    <div id="container_left">
	        <div id="left_top">
	            <div class="left_topimg"><img src="image/user_ico.jpg" alt=""></div>
	            <h2><%=request.getSession().getId()%>欢迎登入!</h2>
	        </div>
	    
	        <!-- 左侧菜单 -->
	        <div id="menu">
	            <ul>
	                <li class="menuli"  onclick="atagClick(1)">用户管理</li>
	                <li class="menuli" onclick="atagClick(2)">客户管理</li>
	                <li class="active" class="menuli"  onclick="atagClick(3)">商品信息录入</li>
	                
	                <li class="menuli" onclick="atagClick(4)">1元夺宝</li>
	                <li class="menuli" onclick="atagClick(5)">退出系统</li>
	            </ul>
	        </div>
		</div>
		<iframe src="product_list.jsp" width="80%" height="100%" style="float:right" frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe>
   </div>
     <!--弹出层确认删除-->
        <div class="modal1" style="display: none">
            <div class="modal-content m3">
                <div class="modal-title"><h4>提示</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                    <p>您确认删除这条数据吗</p>
                    <button type="button" id="fanhui" style="background:#ddd; color:#888; margin-right:10px;">返回</button>
                    <button type="button" id="queren">确认</button>
                </div>
            </div>
        </div>

	<!--弹出层查看-->
        <div class="modal2" style="display: none">
            <div class="modal-content m3">
                <div class="modal-title"><h4>新增数据</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                  <table border="1" style="width:92%; margin:0 auto; border:1px solid #dddd;">
  <tr>
    <th scope="col">序号</th>
    <th scope="col">早期</th>
    <th scope="col">产品名称</th>
    <th scope="col">归类</th>
    <th scope="col">属性</th>
    <th scope="col">大小</th>
    <th scope="col">颜色</th>
    <th scope="col">性能</th>
    <th scope="col">命名</th>
  </tr>
  <tr>
    <td>gggggg</td>
    <td>ggg</td>
    <td>ggg</td>
    <td>gggg</td>
    <td>ggg</td>
    <td>gggg</td>
    <td>gggg</td>
    <td>ggg</td>
    <td>ggg</td>
  </tr>

</table>

                   
                    <button type="button" id="queren" style="margin-top:10px;">确认</button>
                </div>
            </div>
        </div>
    
    
    
    
    <p class="footer">@2016 1元购办公OA管理系统 &copy;1元购版权所有</p>
    <!--弹出层新增  ----跟修改一样的 只不过修改的数据需要返参-->
        <div class="modal3" style="display: none">
            <div class="modal-content m3" style=" height:360px; top:40%;">
                <div class="modal-title"><h4>新增数据</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                 	<div class="addshuju"><b>名称</b><input type="text" value="这里是文本输入框" /></div> 
                    <div class="addshuju"><b>名称</b><input type="text" value="这里是文本输入框" /></div> 
                    <div class="addshuju"><b>名称</b><input type="text" value="这里是文本输入框" /></div> 
                    <div class="addshuju"><b>名称</b><input type="text" value="这里是文本输入框" /></div> 
                    <div class="addshuju"><b>名称</b><input type="text" value="这里是文本输入框" /></div> 
                    <div class="addshuju"><b>名称</b><input type="text" value="这里是文本输入框" /></div> 
                    <div class="addshuju"><b>名称</b><input type="text" value="这里是文本输入框" /></div> 
                    <div class="addshuju"><b>名称</b><input type="text" value="这里是文本输入框" /></div> 
                    <button type="button" id="queren3" style="margin-top:10px;">确认</button>
                </div>
            </div>
        </div>
    
    <script type="text/javascript" src="style_script/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="style_script/produc_list.js"></script>
	</body>

</html>