<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form method="post" >


	<input type="hidden" name="id" value="${obj.id}"/>


<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="back"><a href="list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		浏览厂家信息
    </div> 
    </div>
    </div>
<div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">厂家全称：</td>
	          <td class="tableContent">
	         	${obj.fullName }
	          </td>   
	            <td class="columnTitle">简称：</td>
	            <td class="tableContent">
	            ${obj.factoryName }
	        </tr>
	         <tr>
	            <td class="columnTitle">联系人：</td>
	          <td class="tableContent">
	         		${obj.contacts }
	          </td>   
	            <td class="columnTitle">电话号码：</td>
	            <td class="tableContent">${obj.phone }</td>
	        </tr>
	         <tr>
	            <td class="columnTitle">手机号码：</td>
	          <td class="tableContent">
	         		 ${obj.mobile }
	          </td>   
	            <td class="columnTitle">传真：</td>
	            <td class="tableContent">${obj.fax }</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">排序号：</td>
	          <td class="tableContent">
	         		 ${obj.orderNo }
	          </td>  
	            <td class="columnTitle">检查员：</td>
	            <td class="tableContent">${obj.inspector }</td>
	        </tr>
	        <tr>
	             <td class="columnTitle">备注：</td>
	          <td class="tableContent">
	         		<pre> ${obj.note }</pre>
	          </td>  
	        </tr>
	        
		</table>
	</div>
</div>
 
</form>
</body>
</html>

