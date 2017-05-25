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
<link rel="stylesheet" href="css/adminItemUpdate.css">


<meta charset="UTF-8">
<title>商品更新</title>
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

		<div id="center">
<h4>${msg}</h4>
<s:iterator value="list">
<form action="AdminItemUpdateAction">


<table id="itemtable">
<tr>
<th>商品ID</th>
<th>レベル</th>
<th>商品名</th>
<th>イメージ</th>
<th>商品説明</th>
<th>詳細説明</th>
<th>ステータス</th>
</tr>



<tr>
<td><input type="number" min="1" max="99999" value="${itemId}" name="itemId"></td>
<td><input type="number" min="0" max="20" value="${level}" name="level"></td>
<td><input type="text" maxlength="200" value="${itemName}" name="itemName"></td>
<td><input type="text" value="${itemImg01}" name="itemImg01"></td>
<td><textarea name="itemDetail01"  rows="3" cols="30"><s:property value="itemDetail01"/></textarea></td>
<td><textarea name="itemDetail02"  rows="3" cols="30"><s:property value="itemDetail02"/></textarea></td>
<td><input type="text" value="${status}" name="status"></td>
<td><button type="submit" id="updatebutton">更新</button>
</td>
</tr>


</table>


</form>
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