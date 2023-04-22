<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" session="true" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <style type="text/css">
        .other-info{
            position: fixed;
            right: 0;
            left:0;
            bottom:0;
            height:50px;
            color: #ffffff;
            font-weight: bold;
        }
        .other-item{
            margin: 0 15px;
            color: #ffffff;
        }
        .back-img{
            width: 100%;
            height: 100%;
            position: fixed;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
        }
        .form-border{
            background: #FFFFFf;
            z-index: 3;
            color: #000000;
            width: 300px;
            height: 200px;
            line-height: 50px;
            border-radius: 10px;
            margin: auto auto auto 10vw;
        }
        .btns{
            margin: 10px 0;
        }
    </style>
    <script type="text/javascript">

    </script>
</head>
<body>
    <img src="img/P0001.jpg" class="back-img">
    <form method="post" action="${pageContext.request.contextPath}/user/login" class="flex align-center justify-center form-border fixed inset-0">
        <div>
            <div>
                <span>账号：</span><input type="text" name="account" placeholder="手机号/身份证号"/>
            </div>
            <div>
                <span>密码：</span><input type="password" name="pwd">
            </div>
            <%! String msg; %>
            <%
                msg= (String) session.getAttribute("msg");
                if(msg!=null && !msg.equals("")){
            %>
                   <div><span><%=msg%></span></div>
            <%
                }
            %>
            <div class="flex align-center justify-around btns">
                <button type="reset">重置</button>
                <button type="submit">登入</button>
                <button type="submit" formaction="${pageContext.request.contextPath}/base/navTo/user/register">注册</button>
            </div>
        </div>
    </form>
    <div class="flex align-center justify-center other-info">
        <a class="other-item" href="${pageContext.request.contextPath}/base/navTo/0/error">查看异常</a>
        <a class="other-item" href="${pageContext.request.contextPath}/base/navTo/test/test">Jsp</a>
        <a class="other-item" href="${pageContext.request.contextPath}/base/navTo/test/SpringMVC">SpringMVC</a>
    </div>
</body>
</html>
