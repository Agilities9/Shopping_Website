<%@ page language="java" import="java.util.*,java.io.PrintWriter,cn.dao.impl.UserDaoImpl,cn.bean.User" pageEncoding="utf-8"%>

<%
   String username=request.getSession().getAttribute("username").toString();
   UserDaoImpl udl=new UserDaoImpl();
   User user=(User)udl.findUserSecret(username);
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
  function checkEmpty()
    {     
    var pwd=document.getElementById("pwd").value;
     var relPwd=document.getElementById("relPwd").value;
    if(pwd=="")
    {
     alert("密码不能为空！");
     return false;
    }
    if(relPwd!=pwd)
    {
     alert("密码不一致！");
    }
   return true;
    }
    
   
    
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
  a.ad{
  text-decoration:none;
  width:80px;
  height:60px;
  display:block;
  background-color:#8AD973;
}
</style>	
</head>
<body style="background-image:url(images/bgp.jpg);background-size:cover;">
  <center style="margin-top:200px;">
    <div>
      <form action="modifyServlet" method="post" onsubmit="return checkEmpty()">
        <table border="1">
          <tr>
            <td>新密码：</td>
            <td><input  class="ti" type="password" id="pwd" name="pwd"/></td>
           </tr>
           <tr>
           <td>&nbsp;</td>
           </tr>
           <tr>
          <td>确认密码：</td>
            <td><input class="ti" type="password" id="relPwd" name="relPwd" /></td>
            </tr>
            <tr>
           <td>&nbsp;</td>
           </tr>
          <tr>
            <td colspan="2"><center><input class="dec" type="submit"  name="submit" value="提交"/></center></td>
          </tr>
          <tr>
           <td>&nbsp;</td>
           </tr>
          <tr>
            <td colspan="2"><center><a class="ad" href="register.jsp"><br/>&nbsp;注册</a></center></td>
          </tr>
               </center> 
             </td>
           </tr>
       </table>
      </form> 
</div>
</center>


</body>
</html>
