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
		<script type="text/javascript" src="<%=path %>/js/public.js"></script>
		<script type="text/javascript" src="<%=path %>/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function rukuDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/rukuDel.action?id="+id;
               }
           }
           
           function rukuAdd()
           {
                 var url="<%=path %>/admin/ruku/rukuAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           function rukuMingxiAdd(ruku_id)
           {
                var url="<%=path %>/admin/ruku/rukuMingxiAdd.jsp?ruku_id="+ruku_id;
                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:300});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","");
	            pop.build();
	            pop.show();
           }
           
           function rukuMingxiMana(ruku_id)
           {
                var url="<%=path %>/rukuMingxiMana.action?ruku_id="+ruku_id;
                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:300});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","");
	            pop.build();
	            pop.show();
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#367CB7" align="center" style="margin-top:8px">
				<tr bgcolor="#0DA5E3">
					<td height="14" colspan="8" background="<%=path %>/images/tbg.gif">&nbsp;进货管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">单据号</td>
					<td width="15%">进货时间</td>
					<td width="10%">总金额</td>
					<td width="10%">经手人</td>
					<td width="10%">备注</td>
					<td width="20%">明细</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.rukuList}" var="ruku">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ruku.danjuhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   ${ruku.shijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ruku.zongjiage}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${ruku.jingshouren}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${ruku.beizhu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a style="color: red" href="#" onclick="rukuMingxiMana(${ruku.id})">进货明细</a>
					    &nbsp;&nbsp;&nbsp;      
					    <a style="color: red" href="#" onclick="rukuMingxiAdd(${ruku.id})">添加进货明细</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="" name="formAdd" method="post">
						   <input type="button" value="删除" onclick="rukuDel(${ruku.id})"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="rukuAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
