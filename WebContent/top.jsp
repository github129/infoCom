<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.10/c3.js"></script>



<meta charset="UTF-8">
<title>インフォコム</title>
</head>
<body>



<form action="TimerStartAction">
<button type="submit">実行</button>
</form>

<form action="InfoGetAction">
<input type="text" name="urlId">
<button type="submit">プライスゲット</button>
</form>

-----------------------------------------------
<s:iterator value="priceList">
<s:property value="price"/>
</s:iterator>

<form name="form_list">
<input name="priceList1" type="hidden" value="<s:property value="priceList.get(0).price"/>">
<input name="priceList2" type="hidden" value="<s:property value="priceList.get(1).price"/>">
<input name="priceList3" type="hidden" value="<s:property value="priceList.get(2).price"/>">
<input name="priceList4" type="hidden" value="<s:property value="priceList.get(3).price"/>">
<input name="priceList5" type="hidden" value="<s:property value="priceList.get(4).price"/>">
<input name="priceList6" type="hidden" value="<s:property value="priceList.get(5).price"/>">
<input name="priceList7" type="hidden" value="<s:property value="priceList.get(6).price"/>">
</form>













	<div id="chart"></div>
	<script type="text/javascript">

		var pl7 = document.form_list.priceList1.value;
		var pl6 = document.form_list.priceList2.value;
		var pl5 = document.form_list.priceList3.value;
		var pl4 = document.form_list.priceList4.value;
		var pl3 = document.form_list.priceList5.value;
		var pl2 = document.form_list.priceList6.value;
		var pl1 = document.form_list.priceList7.value;

		var chart = c3
				.generate({
					data : {
						columns : [
								[ '売り上げ金額', pl1, pl2, pl3, pl4, pl5, pl6,
										pl7 ] ]
					}
				});
	</script>


</body>
</html>