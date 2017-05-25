
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<!-- javascript関係の読み込み -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/menu.js"></script>
<!-- css -->
<link rel="stylesheet" href="css/adminTop.css">
<link rel="stylesheet" href="css/mainTop.css">
<meta charset="UTF-8">
<title>Price.コム</title>
</head>
<body>
	<s:include value="header.jsp" />

<div class="center">
	<h2>このサイト説明</h2>
	<dl id="menu">
		<dt id="adddt">サイトを探す</dt>
		<dd>サイトを選択後商品を選択できます。</dd>
	</dl>
	<dl id="selectmenu">
		<dt id="selectdt">商品を探す</dt>
		<dd>商品を選択後サイトを選択できます</dd>
	</dl>
	<dl id="updatemenu">
		<dt id="updatedt">表示されているグラフ</dt>
		<dd>直近７日間の価格変動となります。</dd>
	</dl>
	<dl id="testmenu">
		<dt id="testdt">取得頻度</dt>
		<dd>登録されているサイトから１日１回自動取得します。</dd>
	</dl>
</div>





	<p>${itemMsg}</p>
	<s:if test="itemList.size !=0">
		<table border="1">
			<tr>
				<th>商品名</th>
				<td>説明</td>
			</tr>
			<s:iterator value="itemList">
				<tr>
					<td>${itemName}</td>
					<td>${itemDetail01}</td>
				</tr>
			</s:iterator>

		</table>
	</s:if>

	<p>${siteMsg}</p>

	<s:if test="siteList.size !=0">
		<table border="1">
			<tr>
				<th>サイト名</th>
				<td></td>
			</tr>
			<s:iterator value="siteList">
				<tr>
					<td>${siteName}</td>
					<td></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
</body>
</html>




