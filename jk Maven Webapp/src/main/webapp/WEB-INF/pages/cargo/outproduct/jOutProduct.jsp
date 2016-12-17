<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<script src="../../js/datepicker/WdatePicker.js"></script>
</head>
<body>
<form method="post" >

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('print.action','_self');">确定</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		打印出货表
    </div> 
    </div>
    </div>
<div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	         <tr>
	            <td class="columnTitle_mustbe">出货日期：</td>
	          <td class="tableContent">
	         		 <input type="text" name="outPutTime"
	         		  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM'});" />
	          </td>   
	        </tr>
		</table>
	</div>
</div>
 
</form>
</body>
</html>

