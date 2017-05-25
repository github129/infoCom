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
<link rel="stylesheet" href="css/adminAdd.css">
<link rel="stylesheet" href="css/adminItemAdd.css">


<meta charset="UTF-8">
<title>登録サイト確認</title>
</head>
<body>
	<div id="main">
		<div id="left">

			<form action="GoAdminTopAction">
				<button type="submit" id="topbutton">TOPに戻る</button>
			</form>

			<div id="menudisplay">
				<dl id="menu">
					<dt id="adddt">登録</dt>
					<dd><a href='<s:url action="GoAdminSiteAddAction"></s:url>'>サイト登録</a></dd>
					<dd><a href="<s:url action="GoAdminItemAddAction"/>">商品登録</a></dd>
					<dd><a href="<s:url action="GoAdminUrlAddAction"/>">URL登録</a></dd>
				</dl>
			</div>
			<div id="upadedisplay">
				<dl id="updatemenu">
					<dt id="updatedt">更新</dt>
					<dd><a href='<s:url action="GoAdminSiteUpdateAction"></s:url>'>サイト情報更新</a></dd>
					<dd><a href='<s:url action="GoAdminItemUpdateAction"></s:url>'>商品情報更新</a></dd>
					<dd><a href='<s:url action="GoAdminUrlUpdateAction"></s:url>'>URL情報更新</a></dd>
				</dl>
			</div>
			<div id="testdisplay">
				<dl id="testmenu">
					<dt id="testdt">テスト一覧</dt>
					<dd>取得パステスト</dd>
				</dl>
			</div>
			<div id="selectdisplay">
				<dl id="selectmenu">
					<dt id="selectdt">登録情報一覧</dt>
					<dd><a href="<s:url action="GoAdminSiteAction"/>">サイト</a></dd>
					<dd><a href="<s:url action="GoAdminItemAction"/>">商品</a></dd>
				</dl>
			</div>


		</div>
		<div id="right">

		<div id="itemaddcenter">
<h4>${msg}</h4>

<h3>登録サイト一覧</h3>
<s:iterator value="list">
<table id="listtable">
<tr>
<td id="siteId"><s:property value="siteId"/></td><td id="siteName"><s:property value="siteName"/></td>
</tr>
</table>
</s:iterator>


				</div>

			</div>
		</div>


	<script type="text/javascript">
		var color = "rgb(0, 128, 192)"
		var color2 = "rgb(255, 255, 255)"
		var dt = document.getElementById("adddt");
		var dt2 = document.getElementById("selectdt");
		var dt3 = document.getElementById("updatedt");
		var dt4 = document.getElementById("testdt");

		dt.addEventListener("click", function() {
			if (dt.style.backgroundColor != color) {
				dt.style.backgroundColor = color;
			} else {
				dt.style.backgroundColor = color2;
			}
		})
		dt2.addEventListener("click", function() {
			if (dt2.style.backgroundColor != color) {
				dt2.style.backgroundColor = color;
			} else {
				dt2.style.backgroundColor = color2;
			}
		})
		dt3.addEventListener("click", function() {
			if (dt3.style.backgroundColor != color) {
				dt3.style.backgroundColor = color;
			} else {
				dt3.style.backgroundColor = color2;
			}
		})
		dt4.addEventListener("click", function() {
			if (dt4.style.backgroundColor != color) {
				dt4.style.backgroundColor = color;
			} else {
				dt4.style.backgroundColor = color2;
			}
		})


	</script>

	</body></html>