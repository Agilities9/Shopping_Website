<%@ page language="java" import="java.util.*,cn.dao.impl.ShoppingDaoImpl,cn.bean.Shopping" pageEncoding="utf-8"%>
<%
		int goodId=Integer.parseInt(request.getParameter("goodId"));
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		ShoppingDaoImpl sdl=new ShoppingDaoImpl();
		Shopping sh=sdl.getShopping(goodId, userId);

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mainDisplay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
  body{
    background-color:#d4f2ce;
    }
	.left{
		float:left;
		width:300px;
		height:100%;
		}
	div.right{
		width:800px;
		height:100%;
		float:right;
		border:#6CE7AC solid medium;
		}
		
		#menu ul{
		
			margin-top:0px;
			padding-left:0px;
			}
		#menu ul li{
			
			
			list-style:none;  
			line-height:50px;
			background-color:#4BBB85;
			margin-bottom:15px;
			
			} 
			ul#menu_small li{
		
			list-style:none;  
			line-height:30px;
			background-color:#B3F0D2;
			margin-bottom:10px;
		
			} 
			
			#menu ul li:hover{
				
				background-color:#5DE775;
				}
			
			#menu ul li a{
				text-align:center;
				text-decoration:none;
				color:#fff;
				font-weight:bold;
				letter-spacing:5PX;
				display:block;
				font-family:黑体;
				}
				     td{
				     text-align:center;
				width:150px;
				height:50px;
				}
				table{
					border:#6CE7AC solid medium;
				}
</style>
 <script>
function display()
	{
		var flag=document.getElementById("menu_small").style.display;
		
		if(flag=="none")
		{
			document.getElementById("menu_small").style.display="block";
			}
		else{
			document.getElementById("menu_small").style.display="none";
			}
			
		}

</script>
  </head>
  
  <body>
     <div class="left">
    
     <div id="menu">
          <ul>
          <li> <marquee style="color:white;"><br/>欢迎购物</marquee></li>
          <li><a href="lookupGoods.jsp">商品查看</a></li>
          <li><a href="shopping.jsp">购物车</a></li>
          <li><a href="javascript:display()">所有订单</a></li>
          </ul>
          </div>
</div>
<div class="right">
<center style="padding-top:50px">
    <table border="1">
      <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品详情</th>
      </tr>
       <tr>
        <td><%=sh.getGoodsName() %></td>
        <td><%=sh.getGoodsPrice() %></td>
        <td><%=sh.getGoodsDe() %></td>
     </tr>      
    </table>
  </center>
</div>
  </body>
</html>
