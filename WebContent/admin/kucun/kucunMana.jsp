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
        	var str=${kucun.goods_id};
        	win1.document.write(str);
        	
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#367CB7" align="center" style="margin-top:8px">
				<tr bgcolor="#0DA5E3">
					<td height="14" colspan="3" background="<%=path %>/images/tbg.gif">&nbsp;商品库存&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					
					<td width="25%">商品名称</td>
					<td width="25%">库存数量</td>
					<td width="25%">库存报警(<50)</td>
					<td width="25%">库存位置</td>
					
		        </tr>	
				<c:forEach items="${requestScope.kucunList}" var="kucun">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					
					<td bgcolor="#FFFFFF" align="center">
						${kucun.goods_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kucun.shuliang}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${kucun.shuliang<50}">
						    <font color="red">数量低,进货吗?</font>
						</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value=点击查看 onClick="openWindow=window.open();
							 openWindow.document.writeln('<html>');
					    openWindow.document.writeln('<TITLE>仓库库存位置</TITLE>');
					    openWindow.document.writeln('<BODY>');
					    openWindow.document.writeln('<center>');
					    openWindow.document.writeln('${kucun.goods_name} 存在于仓库的  ${kucun.goods_id}号位置'); 
					    openWindow.document.writeln('<br><br>');
					    openWindow.document.writeln('<input type=button value=关闭 onclick=window.close()>'); 
					    openWindow.document.writeln('</center>');
					    openWindow.document.writeln('</BODY>'); 
					    openWindow.document.writeln('</HTML>'); 
					    openWindow.document.close();" >
					</td>
				</tr>
				</c:forEach>
				
				
				
			</table>
	</body>
</html>
