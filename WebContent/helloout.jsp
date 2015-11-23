<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="al" items="${allist }">
		<p>
			<script type="text/javascript">
				// 			var tmp = "${al[0]}";
				// 			var tmp = "${al[1]}";
				// 			var tmps = tmp.split(",");
				//alert(tmp);
				// 			var tmps = tmp.;
				// 			alert(tmps);
				//document.getElementById("a").value=tmps[0];
			</script>
			firstname:${al[0]}; lastname:${al[1]};

			<%-- 			firstname:<%=request.getAttribute("firstname")%> --%>
			<%-- 			lastname:<%=request.getAttribute("lastname")%> --%>
			<br />
		</p>
	</c:forEach>

</body>
</html>