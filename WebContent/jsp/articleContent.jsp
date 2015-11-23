<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
				<h1>HTML5</h1>
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
	<c:forEach var="al" items="${array }">
<!-- 		<p> -->
<%-- 			firstname:${array[1]};<br /> lastname:${array[2]}; --%>
			${al[1]}
			<hr />
			<br /> ${al[2]}
			<br />
<!-- 		</p> -->
	</c:forEach>

</body>
</html>