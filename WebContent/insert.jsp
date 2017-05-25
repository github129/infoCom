<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>


サイト登録
<form action="SiteInsertAction">
<input type="text" name="siteName">
<input type="text" name="pass">
<button type="submit">登録</button>
</form>

<br>
商品登録
<form action="ItemInsertAction">
<input type="text" name="itemName">
<button type="submit">登録</button>
</form>


url登録
<form action="UrlInsertAction">
url
<input type="text" name="url">
サイト名
<input type="text" name="siteName">
商品名
<input type="text" name="itemName">
<button type="submit">登録</button>
</form>


</body>
</html>