<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>注册页面</title>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/customer/css/style.css" type=text/css rel=stylesheet>
<link href="${pageContext.request.contextPath}/customer/css/boot-crm.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath}/customer/js/chur.min.js"></script>
<script src="${pageContext.request.contextPath}/customer/js/jquery-1.11.3.min.js"></script>
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<script>
// 判断是登录账号和密码是否为空
function register(){
    var usercode = $("#user_code").val();
    var password = $("#user_password").val();
    var username = $("#user_name").val();
    if(usercode =="" || password=="" || username==""){
    	$("#message").text("注册信息不能为空！");	
        return false;
    }  
    
    return true;
}
</script>
</head>
<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"
	background="${pageContext.request.contextPath}/customer/images/cloud.jpg">
<div ALIGN="center">
<table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
	<tr>
		<td height="93"></td>
		<td></td>
	</tr>
	<tr>
   <td
		width="740" height="412">
   </td>
   <td class="register_msg" width="400" align="center">
	 <!-- margin:0px auto; 控制当前标签居中 -->
	 <fieldset style="width: auto; margin: 0px auto;">
		  <legend>
		     <font style="font-size:15px" face="宋体">
		          欢迎使用BOOT客户管理系统
		     </font>
		  </legend> 
		<font color="red">
			 <%-- 提示信息--%>
			 <span id="message">${msg}</span>
		</font>
		<%-- 提交后的位置：/WEB-INF/jsp/customer.jsp--%>
		<form action="${pageContext.request.contextPath }/customer/register.action" 
			                       method="post" onsubmit="return register()">
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br /><br />
          账&nbsp;&nbsp;&nbsp;号：<input id="user_code" type="text" name="user_code" />
          <br /><br />
          账户名：<input id="user_name" type="text" name="user_name" />
          <br /><br />
           密&nbsp;&nbsp;&nbsp;码：<input id="user_password" type="password" name="user_password" />
          <br /><br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <center><input type="submit" value="注册" /></center>
		 </form>
	 </fieldset>
	</td>
	</tr>
</table>
</div>
</body>
</html>
