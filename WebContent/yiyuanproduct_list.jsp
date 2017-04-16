<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="pragma"   content="no-cache">
	<title>后台首页</title>
	<link rel="stylesheet" type="text/css" href="style_css/basic.css">
	<link rel="stylesheet" type="text/css" href="style_css/product_list.css">
    <script type="text/javascript" src="style_script/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="style_script/yiyuaninfo_list.js"></script>
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
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
		<p>您的当前位置:&nbsp;<a href="">首页</a>&nbsp;&gt;&nbsp;一元夺宝管理</p>
		<span id="showtime"></span>
	</div>
	
	<!-- 产品列表 -->
	<div class="box_list">
		<div class="box_title">
			<h2>一元夺宝</h2>
		</div>
        
        <!--button group -->
        <div class="serach_form">
        	<!--<a href="javascript:;" class="btn btn-lg">店铺数据导入</a>
        	<a href="javascript:;" class="btn btn-lg">店铺数据导入</a>-->
        	<!-- <a href="javascript:;" class="btnadd btn-black btn-sm" id="xinzeng">新增</a> -->
        	<!-- <a href="javascript:;" class="btnadd btn-black btn-sm del_pro">删除</a> -->
        </div>
	
        <!-- product list -->
          <form name="yyproduct" action="${ctx}/menuServlet.action">
        <table class="pro_list">
        	<tr>
        		<th>
        		<input type="checkbox" name="check_all" id="check_all"/>
        		<label for="check_all">序号</label></th>
        		<th>ID</th>
        		<th>产品名称</th>
        		<th>归类</th>
        		<th>抢购人数</th>
        		<th>商品价格</th>
        		<th>抢购时间</th>
        		<th>抢购剩余时间</th>
        		<!-- <th>命名</th>
        		<th>命名</th> -->
        		<th>中奖人ID</th>
        		<th>机器人个数</th>
        		<th>机器人是否参与中奖</th>
        		<th>指定机器人中奖</th>
        		<th>是否页面置顶</th>
        		<th>是否展示推荐栏</th>
        		<th>备注</th>
        		<th width="15%">管理</th>
        	</tr>

            <!-- 产品列表 -->
            <c:forEach var="yiyuanInfo" items="${voResult.result}" varStatus="status">
	        	<tr>
	        		<td><input name="yyinfoId" type="checkbox" value="${yiyuanInfo.YID}"/>${status.index+1 }</td>
	        		<td>${yiyuanInfo.GID }</td>
	        		<td>${yiyuanInfo.GNAME }</td>
	        		<td>${yiyuanInfo.GSID }</td>
	        		<td>${yiyuanInfo.QGNUMBER }</td>
	        		<td>${yiyuanInfo.GPRICE }</td>
	        		<td>${yiyuanInfo.QGTIME }</td>
	        		<td>${yiyuanInfo.X }</td>
	        		<%-- <td>${yiyuanInfo.YID }</td>
	        		<td>${yiyuanInfo.YID }</td> --%>
	        		<td>${yiyuanInfo.ZJID }</td>
	        		<td>${yiyuanInfo.JQRNUMBER }</td>
	        		<td>${yiyuanInfo.ISJQRZJ }</td>
	        		<td>${yiyuanInfo.JQRZJ }</td>
	        		<td>${yiyuanInfo.ISPAGETOP }</td>
	        		<td>${yiyuanInfo.RECOMMCOLUMN }</td>
	        		<td>${yiyuanInfo.PARAMS }</td>
	        		<td>
	        		<a href="javascript:;" class="btn btn-xs yyinfoModify">修改</a>
	        		<a href="javascript:;" class="btn btn-xs xiajia">下架</a>
	        		</td>
	        	</tr>
        	</c:forEach>
            <!-- 分页条 -->
<!--         	<tr> -->
<!--         		<td colspan="1"><input type="checkbox" name="check_all" id="check_all_2"/> -->
<!--         		<label for="check_all_2">全选</label></td> -->
<!--         		<td colspan="16" align="right"> -->
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
 			<view:page form="yyproduct" colSpan="16" showPages="<%=Constants.SHOW_PAGE_INLINE %>" curPage="${voResult.beginPage}" rows="${voResult.totalRow}" pageSize="${voResult.pageSize}"></view:page>
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
    
    
    
    
    
    <!--弹出层新增  ----跟修改一样的 只不过修改的数据需要返参-->
        <div class="updateYyinfo" style="display: none">
            <div class="modal-content m3" style=" height:360px; top:40%;">
            	<input type="hidden" name="updateyyid">
                <div class="modal-title"><h4>修改数据</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                 	<div class="addshuju"><b>抢购人数</b><input type="text"  name="updateQgrs" value="" /></div> 
                    <div class="addshuju"><b>抢购时间</b>
                        <input id="qgDate" type="text" name="updateQgsj" value="" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate"/>
                    </div> 
                    <div class="addshuju"><b>剩余时间</b>
                      <input id="syDate" type="text" value="" name="updateQgsysj" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate"/>
                    </div> 
                    <div class="addshuju"><b>机器人数</b><input type="text" name="updateJqr" value="" /></div> 
                    <div class="addshuju"><b>机器人是否参与中奖</b>
                      <input name="updateisjiqirenzj" style="width:10%"  type="radio" value="0"/>否
                      <input name="updateisjiqirenzj" style="width:10%" type="radio" value="1" />是
                    </div> 
                    <div class="addshuju"><b>是否置顶</b>
                    	<input name="updateiszd" style="width:10%"  type="radio" value="0"/>否
                        <input name="updateiszd" style="width:10%" type="radio" value="1" />是
                    </div> 
                    <div class="addshuju"><b>是否展示推荐栏</b>
                       <input name="updateiszstj" style="width:10%"  type="radio" value="0"/>否
                       <input name="updateiszstj" style="width:10%" type="radio" value="1" />是
                    </div> 
                    <div class="addshuju"><b>备注</b><input type="text" name="updateparam" value="" /></div> 
                    <button type="button" id="updatequeren3" style="margin-top:10px;">修改</button>
                </div>
            </div>
        </div>
    
    
    
    
    
</body>
</html>