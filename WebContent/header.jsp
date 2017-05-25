
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/header.css">

<title>heder</title>
</head>
<body>

<div id="menuwidth">
<a href="<s:url action="GoMainTopAction"/>"><img id="logo" src="img/Price-logo.png"></a>
<ul>
<li class="list"><a href="<s:url action="GoMainSiteSelectAction"/>">サイトから探す</a></li>
<li class="list"><a href="<s:url action="GoMainItemSelectAction"/>">商品から探す</a></li>
<li class="list"><a href="<s:url action=""/>">利用規約</a></li>
<li class="list"><a href="<s:url action="GoAdminTopAction"/>">管理者専用</a></li>
<li class="selectlist">	<form action="SelectAction">
		<span  class="selectlist"><input type="text" name="select">
		<button type="submit">検索</button></span>
	</form></li>
</ul>

</div>

</body>
</html>