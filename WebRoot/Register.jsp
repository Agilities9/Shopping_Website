<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册</title>
    <style>
    a{
		text-decoration:none;
		}
    li{
		list-style:none;
		}
		
	input.dec{
                   width:80px;
                   height:30px;
                   margin-left:20px;
                   background-color:#8AD973;
                         }
                td{
				width:100px;
				height:40px;
				}
				table{
				    background-color:#fff;
					border:#6CE7AC solid medium;
				}
    </style>
    <script type="text/javascript">
	
	/*
	onBlur事件，即当文本框失去焦点时，调用相应方法
	
	*/
	
	   function checkName()
	   {
		   var name=document.getElementById("username").value;
		   if(name=="")
		   {
			   alert("用户名不能为空！");
			   }
		   }
		   
	 function checkPwd()
	   {
		   var password=document.getElementById("password").value;
		   if(password=="")
		   {
			   alert("密码不能为空！");
			}else if(password.length<6)
			{
				alert("密码不能小于6位！");
			}
		   }
		   
      function checkRePwd()
	   {
		    var password=document.getElementById("password").value;
		   var repwd=document.getElementById("repwd").value;
		   if(repwd!=password)
		   {
			   alert("密码不一致！");
			   }
		   }
		   
	function look()
	{
		var flag=document.getElementById("ag").style.display;
		
		if(flag=="none")
		{
			document.getElementById("ag").style.display="block";
			document.getElementById("sp").innerHTML="关闭";
			}
		else{
			document.getElementById("ag").style.display="none";
			document.getElementById("sp").innerHTML="同意相关协议";
			}
			
		}
	function checkAdd()
	{
		var add=document.getElementById("address").value;
		   if(add=="")
		   {
			   alert("地址不能为空！");
		   }
	}
	     var arr = new  Array();
     arr[0]="东城,西城,崇文,宣武,朝阳,丰台,石景山,海淀";  
     arr[1]="太原,大同,阳泉,长治,晋城,朔州,吕梁,忻州,晋中,临汾,运城";

     function init()
     {
        var city = document.getElementById("city");
        var cityArr = arr[0].split(",");
        for(var i=0;i<cityArr.length;i++)
        {
             city[i]=new Option(cityArr[i],cityArr[i]);
        }
     }

     function getCity()
     {    
         var pro = document.getElementById("province");
         var city = document.getElementById("city");
         var index = pro.selectedIndex;
         var cityArr = arr[index].split(",");   
    
         city.length = 0;
         //将城市数组中的值填充到城市下拉框中
         for(var i=0;i<cityArr.length;i++)
         {
             city[i]=new Option(cityArr[i],cityArr[i]);
         }
      }
	
      function getAnswer()
      {
      		var ans=document.getElementById("answer").value;
		   if(ans=="")
		   {
			   alert("答案不能为空！");
		   }
      }	 
    </script>

  </head>
  <body style="background-image:url(images/bgp.jpg);background-size:cover;" onload="init()">
    <center style="margin-top:90px;">
      <h3>用户注册</h3>
      <form action="RegisterServlet" method="post">
        <table border="0">
          <tr>
            <td>用户名：</td>
            <td><input type="text" id="username" name="username" onBlur="checkName()"/></td>
          </tr>
          <tr>
            <td>密码：</td>
             <td><input type="password" id="password" name="password" onBlur="checkPwd()"/></td>
          </tr>
          <tr>
            <td>确认密码：</td>
             <td><input type="password" id="repwd" name="repwd" onBlur="checkRePwd()"/></td>
          </tr>
          <tr>
            <td>性别：</td>
             <td style="text-align:left">
              <input type="radio" id="sex1" name="sex" value="男" checked="checked"/>男
              <input type="radio" id="sex2" name="sex" value="女" />女
             </td>
          </tr>
          <tr>
            <td>地址：</td>
            <td><select id="province" name="address" size=1 onchange="getCity()"> 
    				<option value= "北京">北京</option> 
    				<option value= "山西">山西</option>   
  				</select>
  				<select id="city" name="city" style="width:60px"></select> 
  			</td>
          </tr>
          <tr>
            <td>密保问题：</td>
             <td>
               <select id="question" name="question" size="1"> 
               		<option value="最喜欢的颜色：">最喜欢的颜色：</option>
               		<option value="你父亲的生日：">你父亲的生日：</option>
               		<option value="你母亲的生日：">你母亲的生日：</option>
               		<option value="你的生日：">你的生日：</option>
               </select>
             </td>
          </tr>
          <tr>
            <td>密保答案：</td>
             <td><input type="text" id="answer" name="answer" onBlur="getAnswer()"/></td>
          </tr>
          <tr>
          <td colspan="2" style="text-align:center">
            <input class="dec" type="submit" id="reg" value="注册"/>
            <input class="dec" type="reset" id="reset" value="重置"/>
          </td>
          </tr>
        </table>
      </form>
    </center>
  </body>
</html>