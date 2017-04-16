<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<meta http-equiv="pragma"   content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	<title>后台首页</title>
	<link rel="stylesheet" type="text/css" href="style_css/basic.css">
	<link rel="stylesheet" type="text/css" href="style_css/colorbox.css">
	<link rel="stylesheet" type="text/css" href="style_css/product_list.css">
    <script type="text/javascript" src="style_script/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="style_script/produc_list.js"></script>
	<script type="text/javascript" src="js/jquery-form.js"></script>
	<script type="text/javascript" src="js/jquery.colorbox-min.js"></script>
	<script type="text/javascript" src="js/currentTime.js"></script>
	<script type="text/javascript" src="js/take_poto.js"></script>
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
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
		<p>您的当前位置:&nbsp;<a href="">首页</a>&nbsp;&gt;&nbsp;商品信息录入</p>
		<span id="showtime"></span>
	</div>
	
	<!-- 产品列表 -->
	<div class="box_list">
		<div class="box_title">
			<h2>商品信息录入</h2>
		</div>
        
        <!--button group -->
        <div class="serach_form">
        	<!--<a href="javascript:;" class="btn btn-lg">店铺数据导入</a>
        	<a href="javascript:;" class="btn btn-lg">店铺数据导入</a>-->
        	<a href="javascript:;" class="btnadd btn-black btn-sm" id="xinzeng">新增</a>
        	<a href="javascript:;" class="btnadd btn-black btn-sm del_pro">删除</a>
        </div>

        <!-- product list -->
        <form name=product action="${ctx}/menuServlet.action">
        <table class="pro_list">
        	<tr>
        		<th>
        		<input type="checkbox" name="check_all" id="check_all"/>
        		<!-- <label for="check_all">商品序号</label></th> -->
        		<th>序号</th>
        		<th>商品名称</th>
        		<th>商品分类</th>
        		<th>上架时间</th>
        		<th>商品详情</th>
        		<th>是否过期</th>
        		<th>商品价格</th>
        		<th>商品图片1</th>
        		<th>商品图片2</th>
        		<th>商品图片3</th>
        		<th>期号</th>
        		<th>购买剩余量</th>
        		<th width="15%">管理</th>
        	</tr>

            <!-- 产品列表 -->
            <c:forEach var="goodsInfo" items="${voResult.result}" varStatus="status">
            	<tr>
        		<td><input name="pro_id" type="checkbox" value="${goodsInfo.GID}"/>&nbsp;</td>
        		<td>${status.index+1}</td>
        		<td>${goodsInfo.GNAME}</td>
        		<td>${goodsInfo.GSID}</td>
        		<td>${goodsInfo.GDATE}</td>
        		<td>${goodsInfo.GDETAIL}</td>
        		<td>
        		<c:choose>
        			<c:when test="${goodsInfo.ISEXPIRE==1}">是</c:when>
        			<c:otherwise>否</c:otherwise>
        		</c:choose>
        		</td>
        		<td>${goodsInfo.GPRICE}</td>
        		<td>
        		<p>
        		  <a class="group1" href="<%=Constants.IMAGE_SERVER_CONTEXTPATH%>${goodsInfo.GIMG1}" title="图片1">
        		  <img alt="" src="<%=Constants.IMAGE_SERVER_CONTEXTPATH%>${goodsInfo.GIMG1}" width="40px;" height="40px;">
        		 </a>
        		</p>
        		</td>
        		<td>
	        		<p>
	        		  <a class="group2" href="<%=Constants.IMAGE_SERVER_CONTEXTPATH%>${goodsInfo.GIMG2}" title="图片1">
	        		  <img alt="" src="<%=Constants.IMAGE_SERVER_CONTEXTPATH%>${goodsInfo.GIMG2}" width="40px;" height="40px;">
	        		 </a>
	        		</p>
        		 </td>
        		<td>
	        		<p>
	        		  <a class="group3" href="<%=Constants.IMAGE_SERVER_CONTEXTPATH%>${goodsInfo.GIMG3}" title="图片1">
	        		  <img alt="" src="<%=Constants.IMAGE_SERVER_CONTEXTPATH%>${goodsInfo.GIMG3}" width="40px;" height="40px;">
	        		 </a>
	        		</p>
        		</td>
        		<td>${goodsInfo.GNUMBER}</td>
        		<td>${goodsInfo.GSYNUMBER}</td>
        		<td><!-- <a href="javascript:;" class="btn btn-xs" id="chakan">查看</a> -->
        		<a href="javascript:;" class="btn btn-xs updategoods">修改</a>
        		<a href="javascript:;" class="btn btn-xs shangjia">上架</a></td>
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
			<view:page form="product" colSpan="14" showPages="<%=Constants.SHOW_PAGE_INLINE %>" curPage="${voResult.beginPage}" rows="${voResult.totalRow}" pageSize="${voResult.pageSize}"></view:page>
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
                    <p>您确认删除选中数据吗</p>
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
        <div id="addGoodsInfo" class="modal3" style="display: none">
        <form id="addGoodsInfoForm" name="addGoodsInfoForm"  method="post" enctype="multipart/form-data">
            <div class="modal-content m3" style=" height:500px; top:30%;">
                <div class="modal-title"><h4>新增数据</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                	<!-- <div class="addshuju"><b>商品序号</b><input id="gid" readonly="readonly" type="text" value="" /></div>  -->
                    <div class="addshuju"><b>商品分类</b><input id="gsid" type="text" value="" /></div> 
                    <div class="addshuju"><b>商品名称</b><input id="gName" type="text" value="" /></div> 
                    <div class="addshuju"><b>上架时间</b>
                     <input id="gDate" type="text" value="" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate"/>
                    </div> 
                    <div class="addshuju"><b>商品详情</b><input id="gDetail" type="text" value="" /></div> 
                    <div class="addshuju"><b>是否过期</b>
                       <input name="addisExpire" style="width:10%"  type="radio" value="0" checked="checked"/>否
                       <input name="addisExpire" style="width:10%" type="radio" value="1" />是
                    </div> 
                    <div class="addshuju"><b>商品价格</b><input id="gPrice" type="text" value="" /></div> 
                    <div class="addshuju"><b style="float: left;padding-left: 35px;line-height: 50px;">商品图片1</b>
                     <div id="preview1" class="pic">
                        <img id="imghead1" src="${ctx}/image/photo_icon.png" width="50" height="50" onclick="$('#addgIMG1').click();">
                     </div>         
                     <input type="file" name="addgIMG1" onchange="previewImage(this,'preview1','imghead1',this.id)" style="display: none;" id="addgIMG1">
                    </div> 
                    <div class="addshuju"><b style="float: left;padding-left: 35px;line-height: 50px;">商品图片2</b>
                     <div id="preview2" class="pic">
                        <img id="imghead2" src="${ctx}/image/photo_icon.png" width="50" height="50" onclick="$('#addgIMG2').click();">
                     </div>
                     <input type="file" name="addgIMG2" onchange="previewImage(this,'preview2','imghead2',this.id)" style="display: none;" id="addgIMG2"> 
                    </div> 
                    <div class="addshuju"><b style="float: left;padding-left: 35px;line-height: 50px;">商品图片3</b>
                       <div id="preview3" class="pic">
                        <img id="imghead3"  src="${ctx}/image/photo_icon.png" width="50" height="50" onclick="$('#addgIMG3').click();">
                     </div>
                     <input type="file" name="addgIMG3" onchange="previewImage(this,'preview3','imghead3',this.id)" style="display: none;" id="addgIMG3"> 
                    </div>
                    <div class="addshuju"><b>期号</b><input id="gNumber" type="text" value="" /></div> 
                    <div class="addshuju"><b>购买剩余量</b><input id="gSYNumber" type="text" value="" /></div> 
                    <button type="button" id="queren3" style="margin-top:10px;">确认</button>
                </div>
            </div>
            </form>
        </div>
        
        <div id="updateGoodsInfo" class="modal3" style="display: none">
            <div class="modal-content m3" style=" height:470px; top:40%;">
                <div class="modal-title"><h4>修改数据</h4><a href="javascript:;"><i class="close-btn"></i></a></div>
                <div class="modal-sec error msg_code">
                	<div class="addshuju"><b>商品序号</b><input id="updategid" readonly="readonly" type="text" value="" /></div> 
                    <div class="addshuju"><b>商品分类ID</b><input id="updategsid" type="text" value="" /></div> 
                    <div class="addshuju"><b>商品名称</b><input id="updategName" readonly="readonly" type="text" value="" /></div> 
                    <div class="addshuju"><b>上架时间</b><input id="updategDate" type="text" value="" /></div> 
                    <div class="addshuju"><b>商品详情</b><input id="updategDetail" type="text" value="" /></div> 
                    <div class="addshuju"><b>是否过期</b><input id="updateisExpire" type="text" value="" /></div> 
                    <div class="addshuju"><b>商品价格</b><input id="updategPrice" type="text" value="" /></div> 
                    <div class="addshuju"><b>商品图片1</b><input id="updategIMG1" type="text" value="" /></div> 
                    <div class="addshuju"><b>商品图片2</b><input id="updategIMG2" type="text" value="" /></div> 
                    <div class="addshuju"><b>商品图片3</b><input id="updategIMG3" type="text" value="" /></div> 
                    <div class="addshuju"><b>期号</b><input id="updategNumber" type="text" value="" /></div> 
                    <div class="addshuju"><b>购买剩余量</b><input id="updategSYNumber" type="text" value="" /></div> 
                    <button type="button" id="queren4" style="margin-top:10px;">确认</button>
                </div>
            </div>
        </div>
    <script type="text/javascript">
    //新增
    $("#queren3").click(function(){
    	// ajax 请求添加 管理员数据
    	// var cusID = $("#cusID").val();
    	var gsid = $("#gsid").val().trim();
    	var gName = $("#gName").val().trim();
    	var gDate = $("#gDate").val().trim();
    	var gDetail = $("#gDetail").val().trim();
    	var isExpire = $("input[name='addisExpire']").val().trim();
    	var gPrice = $("#gPrice").val().trim();
    	var gNumber = $("#gNumber").val().trim();
    	var gSYNumber = $("#gSYNumber").val().trim();
    	//保存信息
		var addgIMG1 = $("#addgIMG1").val().trim();
    	var addgIMG1 = $("#addgIMG2").val().trim();
    	var addgIMG1 = $("#addgIMG3").val().trim();
    	
    	var pricePtn = /^(d*.d{0,2}|d+).*$/;
    	var digitalPattern = new RegExp("^[0-9]*$");
//    	var params = {};
//    	params.push("",);
    	// 需要增加前台校验
    	if(gsid == ""){
    		alert("请输入产品分类ID");
    		return;
    	}else if(!digitalPattern.test(gsid)){
    		alert("产品分类ID为数字");
    		return;
    	}else if(gName == ""){
    		alert("请输入商品名称");
    		return;
    	}else if(gDate=="" ){
    		alert("请输入商品上架日期");
    		return;
    		
    	}else if(gDetail == ""){
    		alert("请输入商品详情");
    		return;
    	}else if(gPrice == "" && !pricePtn.test(gPrice)){
    		alert("请输入商品价格，如00.00");
    		return;
    	}else if(gNumber == ""&& !digitalPattern.test(gNumber)){
    		alert("请输入商品所属期号");
    		return;
    	}else if(gSYNumber == "" && !digitalPattern.test(gSYNumber)){
    		alert("请输入商品购买剩余量");
    		return;
    	}else if($("#addgIMG1").val().length>0){
    		 var strs = new Array();
    	     var pic1= $("#addgIMG1").val();
    	     strs = pic1.split('.');
    	     var suffix = strs [strs .length - 1].toUpperCase();
    	     if (suffix != 'JPG' && suffix != 'GIF' && suffix != 'JPEG' && suffix != 'PNG') {
    	         alert("商品图片1不是图片,请选择图片！");
    	         return false;
    	     }
    	}else if($("#addgIMG2").val().length>0){
    		 var strs = new Array();
    	     var pic1= $("#addgIMG2").val();
    	     strs = pic1.split('.');
    	     var suffix = strs [strs .length - 1].toUpperCase();
    	     if (suffix != 'JPG' && suffix != 'GIF' && suffix != 'JPEG' && suffix != 'PNG') {
    	    	 alert("商品图片2不是图片,请选择图片！");
    	         return false;
    	     }
    	}else if($("#addgIMG3").val().length>0){
    		 var strs = new Array();
    	     var pic1= $("#addgIMG3").val();
    	     strs = pic1.split('.');
    	     var suffix = strs [strs .length - 1].toUpperCase();
    	     if (suffix != 'JPG' && suffix != 'GIF' && suffix != 'JPEG' && suffix != 'PNG') {
    	    	 alert("商品图片3不是图片,请选择图片！");
    	         return false;
    	     }
    	}
    	var r = new Date().getTime();
    	$.ajax({
    		  type: "post",
    		    data: {"gsid":gsid,"r":r,"operType":"checkGsID"},
    		    //方法所在页面和方法名      
    		    url: "services/QueryGoodsByIDServlet.action",
    		    async:false,
    		    success: function(data) {
    		    	if(data == '1'){
    		    		alert("已经有相同的编号");
    		    		return ;
    		    	}else if(data == '0'){
    		    		var url="services/AddGoodsInfoServlet.action?gsid="+gsid+"&gName="+encodeURI(gName)+"&gDate="+encodeURI(gDate)+"&gDetail="+encodeURI(gDetail)+"&isExpire="+isExpire+"&gPrice="+gPrice+"&gNumber="+gNumber+"&gSYNumber="+gSYNumber+"&r="+r;
				        $("#queren3").css("display","none");
				            $("#addGoodsInfoForm").ajaxSubmit({
				            	url:url,
				            	type : "post",
				            	cache: false,
				                success : function(msg) {
				                	alert(msg);
				                },  
				                error : function(msg) {  
				                	alert(msg);
				                   console.error(msg);  
				                }  
				            });
				            $("#queren3").css("display","block");	
				            
				        
    		    	}else{
    		    		console.info("other");
    		    	}	
    		    	
    		    },     
    		    error: function(err) {
    		       alert("服务器出错！");    
    		    }     
    	});
    	$("#addGoodsInfo").hide();
    	location.reload(true);
    	
    });
    
    
    //图片缩略显示
    $(document).ready(function(){
				$(".group1").colorbox({rel:'group1', transition:"none", width:"75%", height:"75%"});
				$(".group2").colorbox({rel:'group2', transition:"none", width:"75%", height:"75%"});
				$(".group3").colorbox({rel:'group2', transition:"none", width:"75%", height:"75%"});
    });				
    
    </script>
</body>
</html>