<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
<s:include value="header.jsp"/>


<s:if test="siteName !=null">
<h3>「${siteName}」の商品一覧</h3>
<s:iterator value="list">
<form action="InfoGetAction">
<s:hidden name="siteId" value="%{siteId}" theme="simple"></s:hidden>
<s:hidden name="itemId" value="%{itemId}" theme="simple"></s:hidden>
<s:hidden name="itemName" value="%{itemName}" theme="simple"></s:hidden>
<s:hidden name="siteName" value="%{siteName}" theme="simple"></s:hidden>
<s:property value="itemName"/>
<button type="submit">この商品を確認する</button>
</form>
</s:iterator>
</s:if>
<s:else>
<s:iterator value="list">
<form action="GoMainSiteSelectAction">
<s:hidden name="siteId" value="%{siteId}" theme="simple"></s:hidden>
<s:hidden name="itemId" value="%{itemId}" theme="simple"></s:hidden>
<s:hidden name="itemName" value="%{itemName}" theme="simple"></s:hidden>
<s:hidden name="siteName" value="%{siteName}" theme="simple"></s:hidden>
<s:property value="itemName"/>
<button type="submit">サイトを選択する</button>
</form>
</s:iterator>
</s:else>




<form action="ItemSelectAction">
<input type="number" name="itemId"/>
<button type="submit">検索</button>
</form>

<form action="ItemSelectAction">
<button type="submit">全検索</button>
</form>



</body>
</html>