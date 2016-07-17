<%@ page language="java" import="java.util.*,cn.bean.Goods,java.io.PrintWriter" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
PrintWriter outFlow = response.getWriter();

if(session.getAttribute("flag")!=null)
{
outFlow.println("<script>alert('删除成功！');</script>");
}
List<Goods> lg=(List<Goods>)session.getAttribute("lg");

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
				input.dec{
                   width:60px;
                   height:30px;
                   margin-left:20px;
                   background-color:#8AD973;
                         }
              td{
              width:100px;
              text-align:center;
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
          <li> <marquee style="color:white;"><br/>欢迎来到管理员系统</marquee></li>
          <li><a href="content/userManager/selUserManage.jsp">用户管理</a></li>
          <li><a href="javascript:display()">商品管理</a></li>
          </ul>
          <ul id="menu_small" style="display:none;">
          <li><a href="content/goodsManage/addGoodsTypef.jsp">商品分类</a></li>
           <li><a href="content/goodsManage/addGoods.jsp">商品添加</a></li>
            <li><a href="content/goodsManage/searchGoods.jsp">商品查询</a></li>
          </ul>
          </div>
  </div>
   <div class="right">
     <center style="padding-top:50px">
      <form action="<%=path %>/selAllGoodsServlet" method="post" onsubmit="return check()">
       <table>
      <tr>
        <th>商品查询</th>
      </tr>
        <tr>
        <td>商品ID：</td>
        <td><input type="text" name="productID" id="productID"></td>
        <td>商品名称：</td>
        <td><input type="text" name="productName" id="productName"></td>
        <td><input class="dec" type="submit" value="查询"></td>
        </tr>      
        </table>
        </form>
        <table border="1">
           <TR>
			 <th >商品Id</th>
			 <th >商品名称</TH>
			 <th>商品价格</th>
			 <th >商品数量</th>
			 <th>商品描述</th>
			 <th >商品类别</th>
			 <th>更新</TH>
			 <th >删除</TH>
			</TR>
			<c:forEach items='${lg }' var="lgsingle">
			  <tr>
				<td>${lgsingle.goodsId }</td>
				<td>${lgsingle.goodsName }</td>
				<td>${lgsingle.goodsPrice }元</td>
				<td>${lgsingle.goodsCount }</td>
				<td>${lgsingle.goodsDe }</td>
				<td>${lgsingle.goodsType }</td>
				<td><a  class=cmdField  href="<%=path %>/EditDelGoodsServlet?goodsid=${lgsingle.goodsId}&op=edit">编辑 </a></td>
				<td><a  class=cmdField  href="<%=path %>/EditDelGoodsServlet?goodsid=${lgsingle.goodsId}&op=del">删除 </a></td>
			</tr>
          </c:forEach> 
			
		</table>
</center>

</div>
  </body>
</html>
