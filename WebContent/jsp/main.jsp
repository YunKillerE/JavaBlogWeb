<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>极客云</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="../js/cufon-yui.js" type="text/javascript"></script>
<script src="../js/Pirulen_400.font.js" type="text/javascript"></script>
<script type="text/javascript">
	Cufon.replace('h1'); // Works without a selector engine
	Cufon.replace('#sub1'); // Requires a selector engine for IE 6-7, see above
</script>
</head>
<body>
	<br />
	<br />
	<div id="page">
		<div id="logo">
			<div id="logoleft">
				<h1>geekcloud</h1>
			</div>
			<div id="logoright">
				<div id="searchBoxOne">
					<form action="?" method="get">
						<input type="text" class="search" /> <input type="submit"
							class="submit" value="Submit" />
					</form>
				</div>
			</div>
		</div>
		<!-- menu start -->
		<ul id="nav">
			<li class="current"><a href="http://localhost:8080/main">Home</a></li>

			<li><a href="page.html">About Us</a></li>

			<li><a href="page.html#">Services</a></li>

			<li><a href="page.html">Reviews</a></li>

			<li><a href="media.html">Media</a></li>

			<li><a href="page.html">Drop Down</a>
				<ul>
					<li><a href="page.html">Menu Item</a></li>
					<li><a href="page.html">Menu Item</a></li>
					<li><a href="page.html">Menu Item</a>
				</ul></li>

			<li><a href="page.html">Multi Drop Down</a>
				<ul>
					<li><a href="page.html">Menu Item</a>
						<ul>
							<li><a href="#page.html">Sub-Level Item</a></li>
							<li><a href="page.html">Sub-Level Item</a>
								<ul>
									<li><a href="page.html">Sub-Level Item</a></li>
									<li><a href="page.html">Sub-Level Item</a></li>
									<li><a href="page.html">Sub-Level Item</a></li>
								</ul></li>
							<li><a href="page.html">Sub-Level Item</a></li>
						</ul></li>
					<li><a href="page.html">Menu Item</a></li>
					<li><a href="page.html">Menu Item</a></li>
					<li><a href="page.html">Menu Item</a>
						<ul>
							<li><a href="page.html">Sub-Level Item</a></li>
							<li><a href="page.html">Sub-Level Item</a></li>
							<li><a href="page.html">Sub-Level Item</a></li>
						</ul></li>
				</ul></li>
			<li><a href="contact.php">Contact</a></li>
		</ul>
		<br> <br>
		<!-- menu end -->
		<div class="inner_copyright">
			Collect from <a href="http://www.cssmoban.com/" target="_blank"
				title="模板之家">模板之家</a>
		</div>
		<div id="content">
			<div id="textarea">
				<c:forEach var="al" items="${array }">
					<h2>
						<a href=http://localhost:8080/main?id=${al[0]}&type=1>${al[1]}</a>
					</h2>
					<hr />
					<h3>
						<a style="height:10; color: black;"
							href=http://localhost:8080/main?id=${al[0]}&type=1>${al[2]}......
						</a> <a style="height:10; color: red;"
							href=http://localhost:8080/main?id=${al[0]}&type=1>Read More</a>
					</h3>
					<h4></h4>
					</br>
				</c:forEach>
			</div>
			<div id="sidebar">
				<!-- 				<hr /> -->
				<h2>分类</h2>
				<hr />
				<h2>
					<c:forEach var="altype" items="${arraytype}">
						<h2>
							<a href=http://localhost:8080/main?id=${altype[0]}&type=2>${altype[1]}</a>
						</h2>
					</c:forEach>
				</h2>
				<!-- 				<h2>type1</h2> -->
				<!-- 				<h2>type2</h2> -->
				<!-- 				<h2>type3</h2> -->
				<!-- 				<h2>type3</h2> -->
				<!-- 				<h2>type3</h2> -->
				<!-- 				<h2>About</h2> -->
				<!-- 				<p> -->
				<!-- 					<strong> html5 template</strong> can be downloaded free and edited -->
				<!-- 					in your favorite html editor. -->
				<!-- 				</p> -->
				<!-- 				<p> -->
				<!-- 					Template has been designed using valid <a -->
				<!-- 						href="http://validator.w3.org/check?uri=referer" target="_blank">html5</a>. -->
				<!-- 					This template is also <a -->
				<!-- 						href="http://cufon.shoqolate.com/generate/" target="_blank">cufon</a> -->
				<!-- 					enabled for more infomation please refer to the templates notes -->
				<!-- 					text document. -->
				<!-- 				</p> -->
				<!-- 				<p> -->
				<!-- 					You can download this template free for your personal and -->
				<!-- 					commercial web sites providing you leave theCollect from <a -->
				<!-- 						href="http://www.cssmoban.com/" title="网站模板" target="_blank">网站模板</a> -->
				<!-- 					link in the footer. -->
				<!-- 				</p> -->
				<!-- 				<img src="images/blue_html5_colouredbig.png" alt="html5 blue" -->
				<!-- 					width="219" height="218"> -->

				<!-- 				<hr /> -->
				<br />
				<h2>推荐</h2>
				<hr />
				<c:forEach var="al" items="${array }">
					<h2>
						<a href=http://localhost:8080/main?id=${al[0]}&type=1>${al[1]}</a>
					</h2>
				</c:forEach>
				<!-- 				<h2>Recommend</h2> -->
				<!-- 				<h2>Recommend</h2> -->
				<!-- 				<h2>Recommend</h2> -->
				<!-- 				<h2>Recommend</h2> -->
				<!-- 				<h2>Recommend</h2> -->
			</div>
			<div style="clear: both;">&nbsp;</div>
			<img src="images/bg_banner_grey.gif" width="880" height="5"
				alt="logo_banner" />
			<div id="footer">
				<div id="footerleft">
					HTML5 Template 2011 | Collect from <a
						href="http://localhost:8080/main" title="website moder"
						target="_blank">website moder</a>
				</div>
				<div id="footerright">
					<a href="#"><img src="../images/facebook.png" alt="facebook"
						width="32" height="32"></a> <a href="#"> <img
						src="../images/twitter.png" alt="twitter" width="32" height="32"></a>
					<a href="#"> <img src="../images/linkedin.png" alt="linkedin"
						width="32" height="32"></a> <a href="#"> <img
						src="../images/youtube.png" alt="youtube" width="32" height="32"></a>
					<a href="#"> <img src="../images/rss.png" alt="rss" width="32"
						height="32"></a>
				</div>
			</div>
		</div>
	</div>
	<br />
	<br />
</body>
</html>
