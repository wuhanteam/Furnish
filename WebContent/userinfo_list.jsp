<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="pragma"   content="no-cache">
	<title>后台首页</title>
	<link rel="stylesheet" type="text/css" href="style_css/basic.css">
	<link rel="stylesheet" type="text/css" href="style_css/user_list.css">
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
		<p>您的当前位置:&nbsp;<a href="">首页</a>&nbsp;&gt;&nbsp;用户管理</p>
		<span id="showtime"></span>
	</div>
	
	<!-- 产品列表 -->
	<div class="box_list">
		<div class="box_title">
			<h2>管理员信息录入</h2>
		</div>
        
        <!--button group -->
        <div class="serach_form">
        	<a href="javascript:;" class="btnadd btn-black btn-sm" id="xinzengUser">新增</a>
        	<a href="javascript:;" class="btnadd btn-black btn-sm del_pro">删除</a>
        </div>

        <!-- product list -->
        <form name="userInfo" action="${ctx}/menuServlet.action">
        <table class="pro_list">
        	<tr>
        		<th>
        		<input type="checkbox" name="check_all" id="check_all"/>
        		<!-- <label for="check_all">用户ID</label></th> -->
        		<th>序号</th>
        		<th>工号</th>
        		<th>用户名称</th>
        		<th>备注信息</th>
        		<th>邮箱</th>
        		<th>手机号码</th>
        		<th>用户状态</th>
        		<th>上次登录时间</th>
        		<th width="15%">管理</th>
        	</tr>

            <!-- 用户列表 -->
            <c:forEach var="userInfo" items="${voResult.result}" varStatus="status">
            	<tr>
        		<td><input name="pro_id" type="checkbox" value="${userInfo.USERID}"/></td>
        		<td>${status.index + 1}</td>
        		<td>${userInfo.USERCODE}</td>
        		<td>${userInfo.USERNAME}</td>
        		<td>${userInfo.PARAMS1}</td>
        		<td>${userInfo.EMAIL}</td>
        		<td>${userInfo.MOBILE}</td>
        		<td>
        		<c:choose>
        			<c:when test="${userInfo.STATUS==1}">启用</c:when>
        			<c:otherwise>停用</c:otherwise>
        		</c:choose>
        		</td>
        		<td>${userInfo.LAST_LOGIN_TIME}</td>
        		<td><a href="javascript:;" class="btn btn-xs" id="chakan">查看</a>
        		<a href="javascript:;" class="btn btn-xs updateuser"  id="updateuser">修改</a></td>
        		</tr>
            </c:forEach>
        	<view:page form="userInfo" colSpan="10" showPages="<%=Constants.SHOW_PAGE_INLINE %>" curPage="${voResult.beginPage}" rows="${voResult.totalRow}" pageSize="${voResult.pageSize}"></view:page>
            <input type="hidden" name="beginPage" value="${beginPage}"/>
            <input type="hidden" name="pageSize" value="${pageSize}"/>
            <input type="hidden" name="flag" value="${flag}"/>
        </table>
        </form>
		
	</div>
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

	<!--查看弹出层-->
         <div  id="lookUpUser" class="modal3" style="display: none">
            <div class="modal-lookupcontent lookupm3">
                <div class="modal-title"><h4>查看</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
	                <div class="modal-sec error msg_code">
	                 	<div class="lookupshuju"><b>工号</b><input id="lookUpUserCode" type="text" /></div> 
	                 	<div class="lookupshuju"><b>用户名称</b><input id="lookUpUserName" type="text"/></div> 
	                    <div class="lookupshuju"><b>密码</b><input id="lookUpUserPwd" type="password" /></div> 
	                    <div class="lookupshuju"><b>状态</b><input id="lookUpUserStatus" type="text" /></div> 
	                    <div class="lookupshuju"><b>备注信息</b><input id="lookUpParams" type="text" /></div> 
	                    <div class="lookupshuju"><b>创建时间</b><input id="lookUpCreatetime" type="text" /></div> 
	                    <div class="lookupshuju"><b>上次登录</b><input id="lookUpLastLoginTime" type="text" /></div> 
	                    <div class="lookupshuju"><b>手机号</b><input id="lookUpMobile" type="text" /></div> 
	                    <div class="lookupshuju"><b>邮箱</b><input id="lookUpEmail" type="text"/></div> 
	                </div>
                </div>
          </div>
    
    
    
    
    <!--弹出层新增  ------>
        <div id="adduserinfo" class="modal3" style="display: none">
            <div class="modal-content m3" style=" height:360px; top:40%;">
                <div class="modal-title"><h4>新增数据</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                 	<div class="addshuju"><b>帐号</b><input id="addUserCode" type="text" placeholder="请输入帐号" /></div> 
                 	<div class="addshuju"><b>用户名称</b><input id="addUserName" type="text" placeholder="请输入用户名称" /></div> 
                    <div class="addshuju"><b>密码</b><input id="addUserPwd" type="password" placeholder="请输入密码" /></div> 
                    <div class="addshuju"><b>备注信息</b><input id="addParams" type="text" placeholder="备注信息"/></div> 
                    <div class="addshuju"><b>手机号</b><input id="addMobile" type="text" placeholder="手机号"/></div> 
                    <div class="addshuju"><b>邮箱</b><input id="addEmail" type="text" placeholder="邮箱"/></div> 
                    <button type="button" id="queren3" style="margin-top:10px;">确认增加</button>
                </div>
            </div>
        </div>
        
        <!-- 跟修改一样的 只不过修改的数据需要返参 -->
        <div id="updateuserinfo" class="modal3" style="display: none">
            <div class="modal-content m3" style=" height:360px; top:40%;">
                <div class="modal-title"><h4>修改数据</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                 	<div class="addshuju"><b>工号</b>
                 	    <input id="updateUserCode" type="text" readonly="readonly" />
                 	</div> 
                 	<div class="addshuju"><b>用户名</b>
                 	  <input id="updateUserName" type="text"  />
                 	 </div> 
                    <div class="addshuju"><b>密码</b><input id="updateUserPwd" type="password" value="" />
                      <input id="updateUserID" type="hidden" value="" />
                      <input id="UpdateOldUserPwd" type="hidden" value="" />
                    </div>
                    <div class="addshuju"><b>状态</b>
                      <input name="status" style="width:10%"  type="radio" value="1" />启用
                      <input name="status" style="width:10%" type="radio" value="0" />停用
                    </div>  
                    <div class="addshuju"><b>备注信息</b><input id="updateParams" type="text" value="" /></div> 
                    <div class="addshuju"><b>手机号</b><input id="updateMobile" type="text" value="" /></div> 
                    <div class="addshuju"><b>邮箱</b><input id="updateEmail" type="text" value="" /></div> 
                    <button type="button" id="queren4" style="margin-top:10px;">确认修改</button>
                </div>
            </div>
        </div>
        
    
</body>
</html>