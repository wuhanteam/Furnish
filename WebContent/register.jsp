<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

	<head>
		<title>Register</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Luxury Furnish Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
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
		<script src="js/jquery.min.js"></script>
		<!-- Custom Theme files -->
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<!-- Custom Theme files -->
		<!--webfont-->
		<link href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
		<link href='http://fonts.useso.com/css?family=Poiret+One' rel='stylesheet' type='text/css'>
		<!--//webfont-->
		<script src="js/jquery.easydropdown.js"></script>
		<!-- Add fancyBox main JS and CSS files -->
		<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
		<link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
		<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
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
							<h2>Luxury</h2></a>
					</div>
					<div class="header_right">
						<ul class="social">
							<li>
								<a href=""> <i class="fb"> </i> </a>
							</li>
							<li>
								<a href=""><i class="tw"> </i> </a>
							</li>
							<li>
								<a href=""><i class="utube"> </i> </a>
							</li>
							<li>
								<a href=""><i class="pin"> </i> </a>
							</li>
							<li>
								<a href=""><i class="instagram"> </i> </a>
							</li>
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
						<li class="login_text">
							<a href="login.html">登录</a>
						</li>
						<li class="wish">
							<a href="checkout.html">购物清单</a>
						</li>
						<div class='clearfix'></div>
					</ul>
					<ul class="quick_access">
						<li class="view_cart">
							<a href="checkout.html">查看购物车t</a>
						</li>
						<li class="check">
							<a href="checkout.html">付款</a>
						</li>
						<div class='clearfix'></div>
					</ul>
					<div class="search">
						<input type="text" value="搜索" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
						<input type="submit" value="">
					</div>
				</div>
			</div>
		</div>
		<div class="main">
			<div class="container">
				<div class="register">
					<form>
						<div class="register-top-grid">
							<h3>个人信息</h3>
							<div>
								<span>昵称<label></label></span>
								<input type="text">
							</div>
							<div>
								<span>手机号<label></label></span>
								<input type="text">
							</div>
							<div>
								<span>邮箱<label></label></span>
								<input type="text">
							</div>
							<div class="clearfix"> </div>
							<a class="news-letter" href="#">
								<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>注册完成登录</label>
							</a>
						</div>
						<div class="register-bottom-grid">
							<h3>登录信息</h3>
							<div>
								<span>密码<label></label></span>
								<input type="password">
							</div>
							<div>
								<span>确认密码<label></label></span>
								<input type="password">
							</div>
						</div>
					</form>
					<div class="clearfix"> </div>
					<div class="register-but">
						<form>
							<input type="submit" value="注册">
							<div class="clearfix"> </div>
						</form>
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
					<li class="last"><img src='images/icon5.png' class="img-responsive" alt="" /></li>
				</ul>
			</div>
		</div>
		<div class="container">
			<div class="instagram_top">
				<div class="instagram text-center">
					<h3>Our Collections</h3>
				</div>
				<ul class="instagram_grid">
					<li>
						<a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i1.jpg" class="img-responsive" alt="" /></a>
					</li>
					<li>
						<a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i2.jpg" class="img-responsive" alt="" /></a>
					</li>
					<li>
						<a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i3.jpg" class="img-responsive" alt="" /></a>
					</li>
					<li>
						<a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i4.jpg" class="img-responsive" alt="" /></a>
					</li>
					<li>
						<a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i5.jpg" class="img-responsive" alt="" /></a>
					</li>
					<li class="last_instagram">
						<a class="popup-with-zoom-anim" href="#small-dialog1"><img src="images/i6.jpg" class="img-responsive" alt="" /></a>
					</li>
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
				<li>
					<a href="#"><i class="tw"> </i> </a>
				</li>
				<li>
					<a href="#"> <i class="fb"> </i> </a>
				</li>
				<li>
					<a href="#"><i class="pin"> </i> </a>
				</li>
				<div class="clearfix"></div>
			</ul>
		</div>
		</div>
		<div class="footer">
			<div class="container">
				<div class="footer-grid">
					<h3>Category</h3>
					<ul class="list1">
						<li>
							<a href="index.html">Home</a>
						</li>
						<li>
							<a href="about.html">About us</a>
						</li>
						<li>
							<a href="about.html">Eshop</a>
						</li>
						<li>
							<a href="about.html">Features</a>
						</li>
						<li>
							<a href="about.html">New Collections</a>
						</li>
						<li>
							<a href="typo.html">Typo</a>
						</li>
						<li>
							<a href="contact.html">Contact</a>
						</li>
					</ul>
				</div>
				<div class="footer-grid">
					<h3>Our Account</h3>
					<ul class="list1">
						<li>
							<a href="login.html">Your Account</a>
						</li>
						<li>
							<a href="contact.html">Personal information</a>
						</li>
						<li>
							<a href="contact.html">Addresses</a>
						</li>
						<li>
							<a href="#">Discount</a>
						</li>
						<li>
							<a href="checkout.html">Orders history</a>
						</li>
						<li>
							<a href="about.html">Search Terms</a>
						</li>
					</ul>
				</div>
				<div class="footer-grid">
					<h3>Our Support</h3>
					<ul class="list1">
						<li>
							<a href="contact.html">Site Map</a>
						</li>
						<li>
							<a href="about.html">Search Terms</a>
						</li>
						<li>
							<a href="about.html">Advanced Search</a>
						</li>
						<li>
							<a href="about.html">Mobile</a>
						</li>
						<li>
							<a href="contact.html">Contact Us</a>
						</li>
						<li>
							<a href="contact.html">Mobile</a>
						</li>
						<li>
							<a href="contact.html">Addresses</a>
						</li>
					</ul>
				</div>
				<div class="footer-grid">
					<h3>Newsletter</h3>
					<p class="footer_desc">Nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat</p>
					<div class="search_footer">
						<input type="text" class="text" value="Your Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Email';}">
						<input type="submit" value="Submit">
					</div>
					<img src="images/payment.png" class="img-responsive" alt="" />
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="footer_bottom">
			<div class="container">
				<div class="copy">
					<p>Copyright &copy; 2015.Company name All rights reserved.More Templates
						<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from
						<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
					</p>
				</div>
			</div>
		</div>
	</body>

</html>