<%@ page language="java" import="java.util.*,java.io.PrintWriter" pageEncoding="utf-8"%>

<%
PrintWriter outFlow = response.getWriter();
//boolean flag=Boolean.parseBoolean(request.getSession().getAttribute("flag").toString());

if(request.getSession().getAttribute("flag")!=null)
{
outFlow.println("<script>alert('用户名或密码错误');</script>");
}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


	<!-- General meta information -->
	<title>Login Form by Oussama Afellad</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="robots" content="index, follow" />
	<meta charset="utf-8" />
	<!-- // General meta information -->
	
	
	<!-- Load Javascript -->
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/jquery-2.2.4.js"></script>
	<script type="text/javascript" src="./js/rainbows.js"></script>
	<!-- // Load Javascipt -->

	<!-- Load stylesheets -->
	<link type="text/css" rel="stylesheet" href="css/style.css" media="screen" />
	<!-- // Load stylesheets -->
	
<script>
  function checkLog()
    {     
    var name=document.getElementById("username").value;
    var password=document.getElementById("password").value;
    if(name=="")
    {
     alert("用户名不能为空！");
     return false;
    }
    
    if(password=="")
    {
    alert("密码不能为空！");
     return false;
    }
   return true;
    }

	$(document).ready(function(){
 
	$("#submit1").hover(
	function() {
	$(this).animate({"opacity": "0"}, "slow");
	},
	function() {
	$(this).animate({"opacity": "1"}, "slow");
	});
 	});


</script>
<style>
input.dec{
width:100px;
height:30px;
margin-left:20px;
background-color:#8AD973;
}
input.ti{
width:280px;
height:38px;
}
tr{
 padding-top:20px;
}
  table{
  border:1 solid #a4bccd;
  }

</style>	
</head>
<body style="background-image:url(images/bgp.jpg);background-size:cover;">
  <center style="margin-top:200px;">
    <div>
      <form action="LoginServlet" method="post" onsubmit="return checkLog()">
        <table border="1">
          <tr>
            <td>用户名：</td>
            <td><input class="ti" type="text" id="username" name="username"/></td>
            
           </tr>
           <tr> <td>&nbsp;</td></tr>
            <tr>
            <td>密码：</td>
            <td><input  class="ti"  type="password" id="password" name="password"/></td>
           </tr>
            <tr> <td>&nbsp;</td></tr>
            <tr>
           <tr>
             <td colspan="2">
               <center>
               <input type="submit" class="dec" name="submit" value="登录"/>
               <input type="reset"  class="dec" name="submit" value="重置"/>
               </center>
             </td>
           </tr>
            <tr>
             <td colspan="2">
               
             </td>
           </tr>
       </table>
      </form> 
           <center>
           <h1>&nbsp;</h1>
               <span style="width:40px;height:20px;"><a href="forget.jsp">忘记密码？</a></span>
               <a href="Register.jsp">注册</a>              
               </center>
</div>
</center>


</body> 
</html>
