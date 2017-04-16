<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
<title>Home</title>
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
			<div class="banner_wrap">
				<div class="bannertop_box">
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
						<input type="text" value="搜索" onFocus="this.value = '';"
							onBlur="if (this.value == '') {this.value = 'Search';}">
						<input type="submit" value="">
					</div>
					<div class="welcome_box">
						<h3>Welcome to windsur</h3>
						<p>It is a long established fact that a reader will be
							distracted by the readable content of a page</p>
					</div>
				</div>
				<div class="banner_right">
					<h1>
						Lorem Ipsum simply <br>dummy text
					</h1>
					<p>Lorem Ipsum is simply dummy text of the printing and
						typesetting industry. Lorem Ipsum has been the industry's.</p>
					<a href="#" class="banner_btn">马上购买</a>
				</div>
				<div class='clearfix'></div>
			</div>
		</div>
	</div>
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">手机网站模板</a>
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
						<div class="tags">
							<h4 class="tag_head">热门标签</h4>
							<ul class="tags_links">
								<li><a href="#">办公</a></li>
								<li><a href="#">椅子</a></li>
								<li><a href="#">木质</a></li>
								<li><a href="#">金属</a></li>
								<li><a href="#">大小</a></li>
								<li><a href="#">女性</a></li>
								<li><a href="#">衣柜</a></li>
								<li><a href="#">最新的</a></li>
								<li><a href="#">厨房</a></li>
								<li><a href="#">桌子</a></li>
								<li><a href="#">现代的</a></li>
								<li><a href="#">颜色</a></li>
								<li><a href="#">架子</a></li>
								<li><a href="#">凳子</a></li>
								<li><a href="#">躺椅</a></li>
								<li><a href="#">卧室</a></li>
							</ul>
							<a href="#" class="link1">查看所有</a>
						</div>
						<div class="tags">
							<h4 class="tag_head">Articles Experts</h4>
							<ul class="article_links">
								<li><a href="#">Eleifend option congue nihil</a></li>
								<li><a href="#">Investigationes demonst</a></li>
								<li><a href="#">Qui sequitur mutationem</a></li>
								<li><a href="#">videntur parum clar sollemnes</a></li>
								<li><a href="#">ullamcorper suscipit lobortis</a></li>
								<li><a href="#">commodo consequat. Duis autem</a></li>
								<li><a href="#">Investigationes demonst</a></li>
								<li><a href="#">ullamcorper suscipit lobortis</a></li>
								<li><a href="#">Qui sequitur mutationem</a></li>
								<li><a href="#">videntur parum clar sollemnes</a></li>
								<li><a href="#">ullamcorper suscipit lobortis</a></li>
							</ul>
							<a href="#" class="link1">View all</a>
						</div>
					</div>
					<div class="col-md-9">
						<h3 class="m_1">最新产品</h3>
						<div class="content_grid">

							<!-- 动态显示商品信息 -->
							<c:forEach items="${sessionScope.goodsList}" var="goodsItem"
								begin="0" end="2">

								<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
									<a href="single.action?goods_id=${goodsItem.goods_id }">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="${goodsItem.imageList[0]}" class="img-responsive"
													alt="${goodsItem.goods_name }" /> <a href=""
													class="button item_add item_1"> </a>
												<div class="product_container">
													<div class="cart-left">
														<p class="title">${goodsItem.goods_name }</p>
													</div>
													<span class="amount item_price">$${goodsItem.goods_price}</span>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
									</a>
								</div>

							</c:forEach>


							<div class="clearfix"></div>
						</div>
						<div class="content_grid">

							<!-- 遍历商品信息 -->
							<c:forEach items="${sessionScope.goodsList }" var="goodsItem"
								begin="3" end="5">
								<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
									<a href="single.action?goods_id=${goodsItem.goods_id }">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="${goodsItem.imageList[0]}" class="img-responsive"
													alt="${goodsItem.goods_name }" /> <a href=""
													class="button item_add item_1"> </a>
												<div class="product_container">
													<div class="cart-left">
														<p class="title">${goodsItem.goods_name }</p>
													</div>
													<span class="amount item_price">$${goodsItem.goods_price}</span>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>

							<!--  
							<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
								<a href="single.html">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="images/pic4.jpg" class="img-responsive" alt="" />
											<a href="" class="button item_add item_1"> </a>
											<div class="product_container">
												<div class="cart-left">
													<p class="title">Lorem Ipsum 2015</p>
												</div>
												<span class="amount item_price">$1700.00</span>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</a>
							</div>
							<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
								<a href="single.html">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="images/pic5.jpg" class="img-responsive" alt="" />
											<a href="" class="button item_add item_1"> </a>
											<div class="product_container">
												<div class="cart-left">
													<p class="title">Lorem Ipsum 2015</p>
												</div>
												<span class="amount item_price">$800.00</span>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</a>
							</div>
							<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem last_1">
								<a href="single.html">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="images/pic6.jpg" class="img-responsive" alt="" />
											<a href="" class="button item_add item_1"> </a>
											<div class="product_container">
												<div class="cart-left">
													<p class="title">Lorem Ipsum 2015</p>
												</div>
												<span class="amount item_price">$199.00</span>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</a>
							</div>
							
							-->
							<div class="clearfix"></div>
						</div>
						<h3 class="m_2">热门产品</h3>
						<div class="content_grid">
							<c:forEach items="${sessionScope.goodsList }" var="goodsItem"
								begin="6" end="8">
								<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
									<a href="single.action?goods_id=${goodsItem.goods_name }">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="${goodsItem.imageList[0]}" class="img-responsive"
													alt="${goodsItem.goods_name }" /> <a href=""
													class="button item_add item_1"> </a>
												<div class="product_container">
													<div class="cart-left">
														<p class="title">${goodsItem.goods_name }</p>
													</div>
													<span class="amount item_price">$${goodsItem.goods_price}</span>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>

							<!-- 
							<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
								<a href="single.html">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="images/pic7.jpg" class="img-responsive" alt="" />
											<a href="" class="button item_add item_1"> </a>
											<div class="product_container">
												<div class="cart-left">
													<p class="title">Lorem Ipsum 2015</p>
												</div>
												<span class="amount item_price">$4500.00</span>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</a>
							</div>
							<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
								<a href="single.html">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="images/pic8.jpg" class="img-responsive" alt="" />
											<a href="" class="button item_add item_1"> </a>
											<div class="product_container">
												<div class="cart-left">
													<p class="title">Lorem Ipsum 2015</p>
												</div>
												<span class="amount item_price">$1050.00</span>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</a>
							</div>
							<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem last_1">
								<a href="single.html">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="images/pic13.jpg" class="img-responsive" alt="" />
											<a href="" class="button item_add item_1"> </a>
											<div class="product_container">
												<div class="cart-left">
													<p class="title">Lorem Ipsum 2015</p>
												</div>
												<span class="amount item_price">$2000.00</span>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</a>
							</div>
							
							 -->
							<div class="clearfix"></div>
						</div>
						<h3 class="m_2">畅销产品</h3>
						<div class="content_grid">

							<c:forEach items="${sessionScope.goodsList }" var="goodsItem"
								begin="9" end="11">
								<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
									<a href="single.action?goods_id=${goodsItem.goods_id }">
										<div class="inner_content clearfix">
											<div class="product_image">
												<img src="${goodsItem.imageList[0]}" class="img-responsive"
													alt="${goodsItem.goods_name }" /> <a href=""
													class="button item_add item_1"> </a>
												<div class="product_container">
													<div class="cart-left">
														<p class="title">${goodsItem.goods_name }</p>
													</div>
													<span class="amount item_price">$${goodsItem.goods_price}</span>
													<div class="clearfix"></div>
												</div>
											</div>
										</div>
									</a>
								</div>
							</c:forEach>

							<!--  
							<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
								<a href="single.html">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="images/pic10.jpg" class="img-responsive" alt="" />
											<a href="" class="button item_add item_1"> </a>
											<div class="product_container">
												<div class="cart-left">
													<p class="title">Lorem Ipsum 2015</p>
												</div>
												<span class="amount item_price">$99.00</span>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</a>
							</div>
							<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
								<a href="single.html">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="images/pic11.jpg" class="img-responsive" alt="" />
											<a href="" class="button item_add item_1"> </a>
											<div class="product_container">
												<div class="cart-left">
													<p class="title">Lorem Ipsum 2015</p>
												</div>
												<span class="amount item_price">$60.00</span>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</a>
							</div>
							<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem last_1">
								<a href="single.html">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="images/pic12.jpg" class="img-responsive" alt="" />
											<a href="" class="button item_add item_1"> </a>
											<div class="product_container">
												<div class="cart-left">
													<p class="title">Lorem Ipsum 2015</p>
												</div>
												<span class="amount item_price">$900.00</span>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</a>
							</div>
							
							-->
							<div class="clearfix"></div>
						</div>
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
						onFocus="this.value = '';"
						onBlur="if (this.value == '') {this.value = 'Your Email';}">
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