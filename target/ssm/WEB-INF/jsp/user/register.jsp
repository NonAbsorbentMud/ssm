<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>注冊</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/user/registerAction">
            <div>
                <label>姓名：</label>
                <input type="text" value="user.userName" required>
            </div>
            <div>
                <label>性别：</label>
                <select name="user.sex" required>
                    <option label="" value="0" selected>男</option>
                    <option label="" value="1" >女</option>
                 </select>
            </div>
            <div>
                <label>头像图片：</label>
                <input type="file" value="user.headImg">
            </div>
            <div>
                <label>家庭地址：</label>
                <input type="text" value="user.address">
            </div>
            <div>
                <label>联系电话：</label>
                <input type="text" value="user.phone" required>
            </div>
            <div>
                <label>QQ：</label>
                <input type="text" value="user.qq">
            </div>
            <div>
                <label>微信号：</label>
                <input type="text" value="user.wechatId">
            </div>
            <div>
                <label>身份证号：</label>
                <input type="text" value="user.idCard" required>
            </div>
            <div>
                <label>email：</label>
                <input type="text" value="user.email">
            </div>
            <div>
                <label>设置密码：</label>
                <input type="text" value="user.passWord" required>
            </div>
            <div>
                <label>确认密码：</label>
                <input type="text" value="confirmPassword" required>
            </div>
        </form>
    </div>
</body>
</html>
