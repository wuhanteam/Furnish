<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
<title>About</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Luxury Furnish Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	
	
			addEventListener("load", function() {
				setTimeout(hideURLbar, 0);
			}, false);

			function hideURLbar() {
				window.scrollTo(0, 1);
			}
		









</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/simpleCart.min.js">
	
</script>
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/component.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<link
	href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<!--//webfont-->
<script src="js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
<script>
	$(document).ready(function() {
		$('.popup-with-zoom-anim').magnificPopup({
			type : 'inline',
			fixedContentPos : false,
			fixedBgPos : true,
			overflowY : 'auto',
			closeBtnInside : true,
			preloader : false,
			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});
	});
</script>
</head>

<body>
	<div class="header">
		<div class="container">
			<div class="header-top">
				<div class="logo">
					<a href="index.html">
						<h6>Online Furnish</h6>
						<h2>Luxury</h2>
					</a>
				</div>
				<div class="header_right">
					<ul class="social">
						<li><a href=""> <i class="fb"> </i>
						</a></li>
						<li><a href=""><i class="tw"> </i> </a></li>
						<li><a href=""><i class="utube"> </i> </a></li>
						<li><a href=""><i class="pin"> </i> </a></li>
						<li><a href=""><i class="instagram"> </i> </a></li>
					</ul>
					<div class="lang_list">
						<select tabindex="4" class="dropdown">
							<option value="" class="label" value="">En</option>
							<option value="1">English</option>
							<option value="2">French</option>
							<option value="3">German</option>
						</select>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="about_box">
				<ul class="login">
					<li class="login_text"><a href="login.html">登录</a></li>
					<li class="wish"><a href="checkout.html">购物清单</a></li>
					<div class='clearfix'></div>
				</ul>
				<div class="cart_bg">
					<ul class="cart">
						<a href="checkout.html">
							<h4>
								<i class="cart_icon"> </i>
								<p>
									购物车: <span class="simpleCart_total"></span> (<span
										id="simpleCart_quantity" class="simpleCart_quantity"></span>
									items)
								</p>
								<div class="clearfix"></div>
							</h4>
						</a>
						<h5 class="empty">
							<a href="javascript:;" class="simpleCart_empty">空</a>
						</h5>
						<div class="clearfix"></div>
					</ul>
				</div>
				<ul class="quick_access">
					<li class="view_cart"><a href="checkout.html">查看购物车</a></li>
					<li class="check"><a href="checkout.html">付款</a></li>
					<div class='clearfix'></div>
				</ul>
				<div class="search">
					<input type="text" value="搜索" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Search';}"> <input
						type="submit" value="">
				</div>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="content_box">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="menu_box">
							<h3 class="menu_head">菜单</h3>
							<ul class="nav">
								<li><a href="category.action?cate_id=-1">查看所有</a></li>

								<!-- 遍历session中的categoryList -->
								<c:forEach items="${sessionScope.categoryList}"
									var="categoryItem">
									<li><a href="category.action?cate_id=${categoryItem.cate_id }">${categoryItem.cate_name }</a></li>
								</c:forEach>
							</ul>
						</div>
						<div class="category">
							<!-- 分类选择 -->
						</div>
						<div class="category">
							<!-- 品牌选择 -->
						</div>
						<div class="tags">
							<!-- 热门标签 -->
						</div>
						<div class="side_banner">
							<div class="banner_img">
								<img src="images/pic9.jpg" class="img-responsive" alt="" />
							</div>
							<div class="banner_holder">
								<h3>
									Now <br> is <br> Open!
								</h3>
							</div>
						</div>
					</div>
					<div class="col-md-9">
						<div class="dreamcrub">
							<ul class="breadcrumbs">
								<li class="home"><a href="index.html"
									title="Go to Home Page">主页</a>&nbsp; <span>&gt;</span></li>
								<li class="home">&nbsp; 关于&nbsp; <span>&gt;</span>&nbsp;
								</li>
							</ul>
							<ul class="previous">
								<li><a href="index.html">回到主页</a></li>
							</ul>
							<div class="clearfix"></div>
						</div>
						<div class="mens-toolbar">
							<div class="sort">
								<div class="sort-by">
									<label>排序</label> <select>
										<option value="">Position</option>
										<option value="">Name</option>
										<option value="">Price</option>
									</select> <a href=""><img src="images/arrow2.gif" alt=""
										class="v-middle"></a>
								</div>
							</div>
							<ul class="women_pagenation dc_paginationA dc_paginationA06">
								<li><a href="#" class="previous">页码:</a></li>
								<li><a href="category.action?page_num=1">首页</a></li>
								<c:forEach items="${sessionScope.page_bean.pageList }"
									var="pageItem">
									<c:choose>
										<c:when test="${pageItem == sessionScope.page_bean.currentPage }">
											<li class="active"><a
												href="category.action?page_num=${pageItem }">${pageItem }</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="category.action?page_num=${pageItem }">${pageItem }</a></li>
										</c:otherwise>
									</c:choose>

								</c:forEach>
								<!-- 
								<li class="active"><a href="category.action?page_num=1">1</a></li>
								<li><a href="category.action?page_num=2">2</a></li>
								<li><a href="category.action?page_num=3">3</a></li>
 								-->
								<li><a
									href="category.action?page_num=${sessionScope.page_bean.pageCount }">尾页</a></li>
							</ul>
							<div class="clearfix"></div>
						</div>
						<div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">
							<div class="cbp-vm-options">
								<a href="#" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected"
									data-view="cbp-vm-view-grid" title="grid">表格显示</a> <a href="#"
									class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list"
									title="list">列表显示</a>
							</div>

							<div class="clearfix"></div>
							<ul>
							
							<!-- 商品显示 -->
								<c:forEach items="${sessionScope.page_bean.goodsList }"
									var="goodsItem">
									<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
										href="single.action?goods_id=${goodsItem.goods_id }">
											<div class="inner_content clearfix">
												<div class="product_image">
													<img src="${goodsItem.imageList[0]}" class="img-responsive"
														alt="${goodsItem.goods_name}" />
													<div class="product_container">
														<div class="cart-left">
															<p class="title">${goodsItem.goods_name}</p>
														</div>
														<div class="mount item_price price">￥${goodsItem.goods_price }</div>
														<div class="clearfix"></div>
													</div>
												</div>
											</div>
									</a>
										<div class="cbp-vm-details">${goodsItem.goods_desc}</div> <a
										class="button item_add cbp-vm-icon cbp-vm-add" href="#">加入购物车</a>
									</li>
								</c:forEach>




								<!--   
								<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
									href="single.html">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="images/pic12.jpg" class="img-responsive" alt="" />
												<div class="product_container">
													<div class="cart-left">
														<p class="title">Lorem Ipsum 2015</p>
													</div>
													<div class="mount item_price price">￥99.00</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
								</a>
									<div class="cbp-vm-details">Silver beet shallot wakame
										tomatillo salsify mung bean beetroot groundnut.</div> <a
									class="button item_add cbp-vm-icon cbp-vm-add" href="#">加入购物车</a>
								</li>
								<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
									href="single.html">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="images/pic11.jpg" class="img-responsive" alt="" />
												<div class="product_container">
													<div class="cart-left">
														<p class="title">Lorem Ipsum 2015</p>
													</div>
													<div class="price">$99.00</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
								</a>
									<div class="cbp-vm-details">Wattle seed bunya nuts spring
										onion okra garlic bitterleaf zucchini.</div> <a
									class="button item_add cbp-vm-icon cbp-vm-add" href="#">Add
										to cart</a></li>
								<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
									href="single.html">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="images/pic10.jpg" class="img-responsive" alt="" />
												<div class="product_container">
													<div class="cart-left">
														<p class="title">Lorem Ipsum 2015</p>
													</div>
													<div class="price">$99.00</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
								</a>
									<div class="cbp-vm-details">Kohlrabi bok choy broccoli
										rabe welsh onion spring onion tatsoi ricebean.</div> <a
									class="button item_add cbp-vm-icon cbp-vm-add" href="#">Add
										to cart</a></li>
								<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
									href="single.html">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="images/pic4.jpg" class="img-responsive" alt="" />
												<div class="product_container">
													<div class="cart-left">
														<p class="title">Lorem Ipsum 2015</p>
													</div>
													<div class="price">$99.00</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
								</a>
									<div class="cbp-vm-details">Kohlrabi bok choy broccoli
										rabe welsh onion spring onion tatsoi ricebean kombu chard.</div> <a
									class="button item_add cbp-vm-icon cbp-vm-add" href="#">Add
										to cart</a></li>
								<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
									href="single.html">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="images/pic8.jpg" class="img-responsive" alt="" />
												<div class="product_container">
													<div class="cart-left">
														<p class="title">Lorem Ipsum 2015</p>
													</div>
													<div class="price">$99.00</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
								</a>
									<div class="cbp-vm-details">Kohlrabi bok choy broccoli
										rabe welsh onion spring onion tatsoi ricebean kombu chard.</div> <a
									class="button item_add cbp-vm-icon cbp-vm-add" href="#">Add
										to cart</a></li>
								<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
									href="single.html">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="images/pic7.jpg" class="img-responsive" alt="" />
												<div class="product_container">
													<div class="cart-left">
														<p class="title">Lorem Ipsum 2015</p>
													</div>
													<div class="price">$99.00</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
								</a>
									<div class="cbp-vm-details">Kohlrabi bok choy broccoli
										rabe welsh onion spring onion tatsoi ricebean kombu chard.</div> <a
									class="button item_add cbp-vm-icon cbp-vm-add" href="#">Add
										to cart</a></li>
								<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
									href="single.html">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="images/pic6.jpg" class="img-responsive" alt="" />
												<div class="product_container">
													<div class="cart-left">
														<p class="title">Lorem Ipsum 2015</p>
													</div>
													<div class="price">$99.00</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
								</a>
									<div class="cbp-vm-details">Kohlrabi bok choy broccoli
										rabe welsh onion spring onion tatsoi ricebean kombu chard.</div> <a
									class="button item_add cbp-vm-icon cbp-vm-add" href="#">Add
										to cart</a></li>
								<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
									href="single.html">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="images/pic5.jpg" class="img-responsive" alt="" />
												<div class="product_container">
													<div class="cart-left">
														<p class="title">Lorem Ipsum 2015</p>
													</div>
													<div class="price">$99.00</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
								</a>
									<div class="cbp-vm-details">Kohlrabi bok choy broccoli
										rabe welsh onion spring onion tatsoi ricebean kombu chard.</div> <a
									class="cbp-vm-icon cbp-vm-add" href="#">Add to cart</a></li>
								<li class="simpleCart_shelfItem"><a class="cbp-vm-image"
									href="single.html">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="images/pic4.jpg" class="img-responsive" alt="" />
												<div class="product_container">
													<div class="cart-left">
														<p class="title">Lorem Ipsum 2015</p>
													</div>
													<div class="price">$99.00</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
								</a>
									<div class="cbp-vm-details">Kohlrabi bok choy broccoli
										rabe welsh onion spring onion tatsoi ricebean kombu chard.</div> <a
									class="button item_add cbp-vm-icon cbp-vm-add" href="#">Add
										to cart</a></li>
										
										-->
							</ul>
						</div>
						<script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
						<script src="js/classie.js" type="text/javascript"></script>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="brands">
				<ul class="brand_icons">
					<li><img src='images/icon1.png' class="img-responsive" alt="" /></li>
					<li><img src='images/icon2.png' class="img-responsive" alt="" /></li>
					<li><img src='images/icon3.png' class="img-responsive" alt="" /></li>
					<li><img src='images/icon4.png' class="img-responsive" alt="" /></li>
					<li class="last"><img src='images/icon5.png'
						class="img-responsive" alt="" /></li>
				</ul>
			</div>
		</div>
		<div class="container">
			<div class="instagram_top">
				<div class="instagram text-center">
					<h3>Our Collections</h3>
				</div>
				<ul class="instagram_grid">
					<li><a class="popup-with-zoom-anim" href="#small-dialog1"><img
							src="images/i1.jpg" class="img-responsive" alt="" /></a></li>
					<li><a class="popup-with-zoom-anim" href="#small-dialog1"><img
							src="images/i2.jpg" class="img-responsive" alt="" /></a></li>
					<li><a class="popup-with-zoom-anim" href="#small-dialog1"><img
							src="images/i3.jpg" class="img-responsive" alt="" /></a></li>
					<li><a class="popup-with-zoom-anim" href="#small-dialog1"><img
							src="images/i4.jpg" class="img-responsive" alt="" /></a></li>
					<li><a class="popup-with-zoom-anim" href="#small-dialog1"><img
							src="images/i5.jpg" class="img-responsive" alt="" /></a></li>
					<li class="last_instagram"><a class="popup-with-zoom-anim"
						href="#small-dialog1"><img src="images/i6.jpg"
							class="img-responsive" alt="" /></a></li>
					<div class="clearfix"></div>
					<div id="small-dialog1" class="mfp-hide">
						<div class="pop_up">
							<h4>A Sample Photo Stream</h4>
							<img src="images/i_zoom.jpg" class="img-responsive" alt="" />
						</div>
					</div>
				</ul>
			</div>
			<ul class="footer_social">
				<li><a href="#"><i class="tw"> </i> </a></li>
				<li><a href="#"> <i class="fb"> </i>
				</a></li>
				<li><a href="#"><i class="pin"> </i> </a></li>
				<div class="clearfix"></div>
			</ul>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<div class="footer-grid">
				<h3>Category</h3>
				<ul class="list1">
					<li><a href="index.html">Home</a></li>
					<li><a href="about.html">About us</a></li>
					<li><a href="about.html">Eshop</a></li>
					<li><a href="about.html">Features</a></li>
					<li><a href="about.html">New Collections</a></li>
					<li><a href="typo.html">Typo</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
			</div>
			<div class="footer-grid">
				<h3>Our Account</h3>
				<ul class="list1">
					<li><a href="login.html">Your Account</a></li>
					<li><a href="contact.html">Personal information</a></li>
					<li><a href="contact.html">Addresses</a></li>
					<li><a href="#">Discount</a></li>
					<li><a href="checkout.html">Orders history</a></li>
					<li><a href="about.html">Search Terms</a></li>
				</ul>
			</div>
			<div class="footer-grid">
				<h3>Our Support</h3>
				<ul class="list1">
					<li><a href="contact.html">Site Map</a></li>
					<li><a href="about.html">Search Terms</a></li>
					<li><a href="about.html">Advanced Search</a></li>
					<li><a href="about.html">Mobile</a></li>
					<li><a href="contact.html">Contact Us</a></li>
					<li><a href="contact.html">Mobile</a></li>
					<li><a href="contact.html">Addresses</a></li>
				</ul>
			</div>
			<div class="footer-grid">
				<h3>Newsletter</h3>
				<p class="footer_desc">Nostrud exerci tation ullamcorper
					suscipit lobortis nisl ut aliquip ex ea commodo consequat</p>
				<div class="search_footer">
					<input type="text" class="text" value="Your Email"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Your Email';}">
					<input type="submit" value="Subscribe">
				</div>
				<img src="images/payment.png" class="img-responsive" alt="" />
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="footer_bottom">
		<div class="container">
			<div class="copy">
				<p>
					Copyright &copy; 2015.Company name All rights reserved.More
					Templates <a href="http://www.cssmoban.com/" target="_blank"
						title="模板之家">模板之家</a> - Collect from <a
						href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
				</p>
			</div>
		</div>
	</div>
</body>

</html>