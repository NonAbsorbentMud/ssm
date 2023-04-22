<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/10/28
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果</title>
</head>
<body>
    <%
        if(request.getAttribute("field")!=null){
            out.print("field:"+request.getAttribute("field")+"\n");
        }else{
            out.print("field属性不存在!\n");
        }
        if(request.getAttribute("date")!=null){
            out.print("date:"+request.getAttribute("date")+"\n");
        }else{
            out.print("date属性不存在!\n");
        }
        if(request.getAttribute("money")!=null){
            out.print("money:"+request.getAttribute("money")+"\n");
        }else{
            out.print("money属性不存在!\n");
        }
    %>
</body>
</html>
