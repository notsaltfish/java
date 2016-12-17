<%@ page language="java" pageEncoding="UTF-8"%>
<%-- <%@ include file="../../base.jsp"%> --%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script src="../../js/datepicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function getFactoryName(val){
			var factory = document.getElementById("factoryName");
			factory.value = val;
		}
	</script>
</head>
<body>
<form method="post" >

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');">确定</a></li>
<li id="back"><a href="${ctx }/cargo/extcproduct/tocreate.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		修改货物附件信息
    </div> 
    </div>
    </div>
<div>
 <input type="hidden" name="contractProductId" value="${obj.contractProductId}"/>
 <input type="hidden" name="id" value="${obj.id}"/>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	          <td class="tableContent">
	         		 <select name="factoryId" onchange="getFactoryName(this.options[this.selectedIndex].text)">
							<option value="">请选择</option>
	          		<c:forEach items="${factoryList }" var="o">
	          				<option value="${o.id}" <c:if test="${o.id==obj.factoryId }">selected</c:if>  >${o.factoryName}</option>
	         		 </c:forEach>
	         		 
	         		 </select>
	         		 <input type="hidden" name="factoryName" id="factoryName" value="${obj.factoryName }"/>
	          </td>   
	            <td class="columnTitle_mustbe">货号：</td>
	            <td class="tableContent"><input type="text" name="productNo"  value="${obj.productNo }"/></td>
	        </tr>
	         <tr>
	            <td class="columnTitle_mustbe">货物照片：</td>
	          <td class="tableContent">
	         		 <input type="text" name="productImage" value="${obj.productImage }"/>
	          </td>   
	            <td class="columnTitle_mustbe">货物描述：</td>
	            <td class="tableContentAuto">
	            <input type="text"  name="productDesc" value="${obj.productDesc }"/>
	            </td>
	        </tr>
	         <tr>
	            <td class="columnTitle_mustbe">数量：</td>
	          <td class="tableContent">
	         		 <input type="text" name="cNumber" value="${obj.cNumber}"/>
	          </td>   
	          
	          <td class="columnTitle_mustbe">包装类型：</td>
	          <td class="tableContent">
	         		 <select name="cType" >
							<option value="">请选择</option>
	          		<c:forEach items="${cTypeList }" var="cl">
	          				<option value="${cl.id}" <c:if test="${cl.id==obj.cType }">selected</c:if> >${cl.name}</option>
	         		 </c:forEach>
	         		 </select>
	          </td>
	        </tr>
	        <tr>
	             <td class="columnTitle_mustbe">包装单位：</td>
	          <td class="tableContent">
	         		 <input type="text" name="packingUnit" value="${obj.packingUnit}" />
	             <td class="columnTitle_mustbe">单价：</td>
	          <td class="tableContent">
	         		 <input type="text" name="price" value="${obj.price }"/>
	          </td>  
	        </tr>
	          <tr>
	             <td class="columnTitle_mustbe">总金额：</td>
	          <td class="tableContent">
	         		 <input type="text" name="amount" value="${obj.amount }"/>
	             <td class="columnTitle_mustbe">排序号：</td>
	          <td class="tableContent">
	         		 <input type="text" name="orderNo" value="${obj.orderNo }" />
	          </td>  
	        </tr>
		</table>
	</div>
</div>
 
</form>
 
</body>
</html>

