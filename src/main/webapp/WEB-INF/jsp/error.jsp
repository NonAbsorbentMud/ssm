<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isErrorPage="true"%>
<html>
<head>
    <title>异常</title>
</head>
<body>
    <h4>异常描述：</h4>
    <%
        if(request.getAttribute("ex")!=null){
            out.print(request.getAttribute("ex"));
        }else if(exception!=null){
            out.print(exception.getMessage());
        }else{
            out.print("无异常！");
        }
    %>

</body>
</html>
