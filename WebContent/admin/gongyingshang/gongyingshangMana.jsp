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
           function gongyingshangDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/gongyingshangDel.action?id="+id;
               }
           }
           
           
           function gongyingshangAdd()
           {
                 var url="<%=path %>/admin/gongyingshang/gongyingshangAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#367CB7" align="center" style="margin-top:8px">
				<tr bgcolor="#0DA5E3">
					<td height="14" colspan="8" background="<%=path %>/images/tbg.gif">&nbsp;供应商维护&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">供应商名称</td>
					<td width="15%">地址</td>
					<td width="15%">联系人</td>
					<td width="15%">电话</td>
					<td width="10%">邮编</td>
					<td width="10%">传真</td>
					<td width="10%">email</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.gongyingshangList}" var="gongyingshang">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${gongyingshang.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongyingshang.dizhi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${gongyingshang.lianxiren}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongyingshang.dianhua}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongyingshang.youbian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${gongyingshang.chuanzhen}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${gongyingshang.youxiang}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <form action="<%=path %>/admin/gongyingshang/gongyingshangEditPre.jsp" name="" method="post">
						    <input type="button" onclick="gongyingshangDel(${gongyingshang.id})" value="删除"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="gongyingshangAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
