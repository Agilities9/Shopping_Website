<%@ page language="java" import="java.util.*,cn.dao.impl.GoodsTypeDaoImpl,cn.bean.GoodsType" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
GoodsTypeDaoImpl gtl=new GoodsTypeDaoImpl();
List<GoodsType> types=gtl.selAllGoodsType();
session.setAttribute("types",types);


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
				 td,th{
              width:120px;
              text-align:center;
              }
             input.dec{
               width:80px;
               height:30px;
               margin-left:20px;
               background-color:#8AD973;
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
          <li><a href="UserAllOrders.jsp">所有订单</a></li>
          </ul>
          </div>
</div>
<div class="right">
 <center style="padding-top:50px">
      <form action="<%=path %>/selAllGoodsServletAnoA" method="post" onsubmit="return check()">
       <table>
      <tr>
        <th>商品查询</th>
      </tr>
        <tr>
        <td>商品类型：</td>
        <td>
           <select name="goodsType" style="width:45% ;color:#566984">
			 <option value="-1">请选择</option>	
			 <c:forEach items='${types }' var="type">
			   <option value="${type.id}"> ${type.typeName} </option>	
			 </c:forEach>		
			</select>
        </td>
        <td>商品名称：</td>
        <td><input type="text" name="goodsName" id="goodsName"></td>
        <td><input class="dec" type="submit" value="查询"></td>
        </tr>      
        </table>
        </form>
        <table border="1">
           <TR>
			 <th>商品名称</th>
			 <th>商品价格</th>
			 <th>商品类型</th>
			 <th>查看详情</th>			
			</TR>
			<c:forEach items='${lgg }' var="lgsingle">
			  <tr>				
				<td>${lgsingle.goodsName }</td>
				<td>${lgsingle.goodsPrice }元</td>	
				
				<td>${lgsingle.goodsType }</td>
				<td><a href="<%=path %>/EditDelGoodsServlet?goodsid=${lgsingle.goodsId}&op=sel">查看详情 </a></td>
				
			</tr>
          </c:forEach> 
			
		</table>
</center>
</div>
  </body>
</html>
