<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="pragma"   content="no-cache">
	<title>后台首页</title>
	<link rel="stylesheet" type="text/css" href="style_css/basic.css">
	<link rel="stylesheet" type="text/css" href="style_css/customer_list.css">
    <script type="text/javascript" src="style_script/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="style_script/customer_list.js"></script>
	<script type="text/javascript" src="js/currentTime.js"></script>
	<script type="text/javascript" src="js/take_poto.js"></script>
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
		<p>您的当前位置:&nbsp;<a href="">首页</a>&nbsp;&gt;&nbsp;客户管理</p>
		<span id="showtime"></span>
	</div>
	
	<!-- 产品列表 -->
	<div class="box_list">
		<div class="box_title">
			<h2>客户信息管理</h2>
		</div>
        
        <!--button group -->
        <div class="serach_form">
        	<!--<a href="javascript:;" class="btn btn-lg">店铺数据导入</a>
        	<a href="javascript:;" class="btn btn-lg">店铺数据导入</a>-->
        	<a href="javascript:;" class="btnadd btn-black btn-sm" id="xinzeng">新增</a>
        	<a href="javascript:;" class="btnadd btn-black btn-sm del_pro">删除</a>
        </div>

        <!-- product list -->
        <form name="cusInfo" action="${ctx}/menuServlet.action">
        <table class="pro_list">
        	<tr>
        		<th>
        		<input type="checkbox" name="check_all" id="check_all"/>
        		<!-- <label for="check_all">序号</label></th>-->
        		<th>序号</th>
        		<th>客户名称</th>
        		<th>平台名称</th>
        		<th width="10%">地址</th>
        		<th width="10%">QQ</th>
        		<th>支付宝账号</th>
        		<th>手机号码</th>
        		<th width="5%">机器人</th>
        		<th width="7%">游戏币数量</th>
        		<th width="10%">备注1</th>
        		<th width="10%">备注2</th>
        		<th width="5%" style="text-align: center;">管理</th>
        	</tr>


            <!-- 客户信息列表 -->
            <c:forEach var="cusInfo" items="${voResult.result}" varStatus="status">
            	<tr>
        		<td><input name="pro_id" type="checkbox" value="${cusInfo.CID}"/>&nbsp;${cusInfo.cid}</td>
        		<td>${status.index + 1}</td>
        		<td>${cusInfo.UNAME}</td>
        		<td>${cusInfo.PTNAME}</td>
        		<td>${cusInfo.ADDRESS}</td>
        		<td>${cusInfo.QQ}</td>
        		<td>${cusInfo.ZFBNUM}</td>
        		<td>${cusInfo.TELPHONE}</td>
        		<td>
        		<c:choose>
        			<c:when test="${cusInfo.JQRFLAG==1}">是</c:when>
        			<c:otherwise>否</c:otherwise>
        		</c:choose>
        		</td>
        		<td>${cusInfo.YXBTOTALNUM}</td>
        		<td>${cusInfo.PARAMS1}</td>
        		<td>${cusInfo.PARAMS2}</td>
        		<td style="text-align: center;">
        		  <!-- <a href="javascript:;" class="btn btn-xs" id="chakan">查看</a> -->
        		  <a href="javascript:;" class="btn btn-xs updatecus">修改</a>
        		</td>
        	</tr>
            </c:forEach>
        	
            
            <!-- 分页条 -->
<!--         	<tr> -->
<!--         		<td colspan="1"><input type="checkbox" name="check_all" id="check_all_2"/> -->
<!--         		<label for="check_all_2">全选</label></td> -->
<!--         		<td colspan="12" align="right"> -->
<!--         			<ul class="page"> -->
<!--         				<li style="border:0;">共21条记录,1/5页</li> -->
<!--         				<li class="active"><a href="#">1</a></li> -->
<!--         				<li><a href="#">2</a></li> -->
<!--         				<li><a href="#">3</a></li> -->
<!--         				<li><a href="#">4</a></li> -->
<!--         				<li><a href="#">5</a></li> -->
<!--         				<li class="go_page">到第&nbsp;&nbsp;<input type="text" value="5"/>&nbsp;&nbsp;页</li> -->
<!--         				<li class="next_page"><a href="#">前往</a></li> -->
<!--         			</ul> -->
<!--         		</td> -->
<!--         	</tr> -->
			<view:page form="cusInfo" colSpan="13" showPages="<%=Constants.SHOW_PAGE_INLINE %>" curPage="${voResult.beginPage}" rows="${voResult.totalRow}" pageSize="${voResult.pageSize}"></view:page>
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

	<!--弹出层查看-->
        <!-- <div class="modal2" style="display: none">
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
        </div> -->
    
    
    
    
    
    <!--弹出层新增  ----跟修改一样的 只不过修改的数据需要返参-->
        <div  id="addCusInfo"  class="modal3" style="display: none">
            <div class="modal-content m3">
                <div class="modal-title"><h4>新增数据</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                 	<!-- <div id="cusID" class="addshuju"><b>客户ID</b><input type="text" value="这里是文本输入框" /></div>  -->
                    <div  class="addshuju"><b>客户名称</b><input id="cusName" type="text" value="" /></div> 
                    <div  class="addshuju"><b>密码</b><input id="cusPwd" type="text" value="" /></div> 
                    <div class="addshuju"><b>平台名称</b><input id="ptName"  type="text" value="" /></div> 
                    <div class="addshuju"><b>地址</b><input id="cusAddress"  type="text" value="" /></div> 
                    <div class="addshuju"><b>QQ</b><input id="qq"  type="text" value="" /></div> 
                    <div  class="addshuju"><b>支付宝账号</b><input id="zhfbNum" type="text" value="" /></div> 
                    <div class="addshuju"><b>手机号码</b><input id="phoneNum"  type="text" value="" /></div> 
                    <div  class="addshuju"><b>是否机器人</b><input type="radio" style="width:10%" name="isJQR" value="0"  checked="checked">否<input type="radio" style="width:10%" name="isJQR" value="1">是</div>
                    <div class="addshuju"><b>游戏币数量</b><input id="yxbNum" type="text" value="" /></div> 
                    <div class="addshuju"><b>备注1</b><input id="param1" type="text" value="" /></div> 
                    <div  class="addshuju"><b>备注2</b><input id="param2" type="text" value="" /></div> 
                    <button type="button" id="queren3" style="margin-top:10px;">确认</button>
                </div>
            </div>
        </div>
    
    
     <div  id="updateCusInfo"  class="modal3" style="display: none">
            <div class="modal-content m3" style=" height:430px; top:50%;">
                <div class="modal-title"><h4>修改数据</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                 	<!-- <div id="cusID" class="addshuju"><b>客户ID</b><input type="text" value="这里是文本输入框" /></div>  -->
                    <div  class="addshuju"><b>客户名称</b><input id="updatecusName" readonly="readonly" type="text" value="" /></div> 
                    <div  class="addshuju"><b>密码</b><input id="updatecusPwd" type="text" value="" /></div> 
                    <div class="addshuju"><b>平台名称</b><input id="updateptName"  type="text" value="" /></div> 
                    <div class="addshuju"><b>地址</b><input id="updatecusAddress"  type="text" value="" /></div> 
                    <div class="addshuju"><b>QQ</b><input id="updateqq"  type="text" value="" /></div> 
                    <div  class="addshuju"><b>支付宝账号</b><input id="updatezhfbNum" type="text" value="" /></div> 
                    <div class="addshuju"><b>手机号码</b><input id="updatephoneNum"  type="text" value="" /></div> 
                    <div  class="addshuju"><b>是否机器人</b><input type="radio" style="width:10%" name="updateisJQR" value="0">否<input type="radio" style="width:10%" name="updateisJQR" value="1">是</div> 
                    <div class="addshuju"><b>游戏币数量</b><input id="updateyxbNum" type="text" value="" /></div> 
                    <div class="addshuju"><b>备注1</b><input id="updateparam1" type="text" value="" /></div> 
                    <div  class="addshuju"><b>备注2</b><input id="updateparam2" type="text" value="" /></div> 
                    <button type="button" id="queren4" style="margin-top:10px;">确认</button>
                </div>
            </div>
        </div>
    
</body>
</html>