<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GEEKCLOUD ADD ARTICLE PLATFORM</title>
</head>
<body>
<form action="/articleadd" method="post">
选择分类：<select name="articleSelectType">
<option></option>
<option>java编程</option>
<option>mysql数据库</option>
<option>linux系统</option>
<option>hadoop大数据</option>
</select>  或者增加分类：<input name="articleAddType" >
<br />
<input type="hidden"  name="type1" value="xx">
articleName						:<input name="articleName" >
<br />
articleContent:<textarea name="articleContent" rows="8" cols="150"></textarea>
<br />
<input type="submit" value="post">
</form>
</body>
</html>