<%@ page language="java" import="java.util.*,java.io.PrintWriter" pageEncoding="utf-8"%>

<%
PrintWriter outFlow = response.getWriter();
//boolean flag=Boolean.parseBoolean(request.getSession().getAttribute("flag").toString());

if(request.getSession().getAttribute("flag")!=null)
{
outFlow.println("<script>alert('此用户名不存在，可以选择重新注册！');</script>");
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
  function checkForget()
    {     
    var name=document.getElementById("username").value;
    if(name=="")
    {
     alert("用户名不能为空！");
     return false;
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
      <form action="ForgetServlet" method="post" onsubmit="return checkForget()">
        <table border="1">
          <tr>
            <td>用户名：</td>
            <td><input class="ti" type="text" id="username" name="username"/></td>
           </tr>
           <tr>
           <td>&nbsp;</td>
           </tr>
          <tr>
            <td colspan="2"><center><input class="dec" type="submit"  name="submit" value="下一步"/></center></td>
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
