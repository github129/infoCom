
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>サイト詳細ページ</title>
</head>
<body>
<s:include value="header.jsp"/>

<s:if test="itemId >0">
<s:iterator value="list">
<form action="InfoGetAction">
<s:hidden name="siteId" value="%{siteId}" theme="simple"></s:hidden>
<s:hidden name="itemId" value="%{itemId}" theme="simple"></s:hidden>
<s:hidden name="itemName" value="%{itemName}" theme="simple"></s:hidden>
<s:hidden name="siteName" value="%{siteName}" theme="simple"></s:hidden>
<span>${itemName}の${siteName} <button type="submit">を確認する</button></span>
</form>
</s:iterator>
</s:if>
<s:else>
<s:iterator value="list">
<form action="GoMainItemSelectAction">
<s:hidden name="siteId" value="%{siteId}" theme="simple"></s:hidden>
<s:hidden name="itemId" value="%{itemId}" theme="simple"></s:hidden>
<s:hidden name="itemName" value="%{itemName}" theme="simple"></s:hidden>
<s:hidden name="siteName" value="%{siteName}" theme="simple"></s:hidden>
<span>${siteName} <button type="submit">このサイトの商品を確認する</button></span>
</form>
</s:iterator>
</s:else>



</body>
</html>