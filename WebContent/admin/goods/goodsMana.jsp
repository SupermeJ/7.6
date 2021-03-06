<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function goodsDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/goodsDel.action?id="+id;
               }
           }
           
           function goodsAdd()
           {
                 var url="<%=path %>/admin/goods/goodsAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#367CB7" style="margin-bottom:8px">
				<tr bgcolor="#0DA5E3">
					<td height="10" colspan="8" background="<%=path %>/img/tbg.gif">&nbsp;商品管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">名称</td>
					<td width="15%">产地</td>
					<td width="15%">单位</td>
					<td width="15%">规格</td>
					<td width="10%">备注</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.goodsList}" var="goods">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${goods.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${goods.chandi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${goods.danwei}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${goods.guige}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${goods.beizhu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/admin/goods/goodsEditPre.jsp" name="formAdd" method="post">
						     <input type="button" value="删除" onclick="goodsDel(${goods.id})"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="goodsAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
