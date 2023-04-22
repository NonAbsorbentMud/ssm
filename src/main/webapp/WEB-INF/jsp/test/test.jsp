<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
    <div class="flex align-center justify-between">
        <div>
            <h3>语法：</h3>
            <dl>
                <dt>注释：<% out.println("<"+"%-- 注释内容 --%"+">"); %></dt>
                <dt>表达式：<% out.println("<"+"%= 表达式 %"+">"); %></dt>
                <dt>声明：<% out.println("<"+"%! 数据类型 变量名 %"+">"); %></dt>
            </dl>
        </div>
        <div>
            <h3>三大指令</h3>
            <ul>
                <li>page指令：定义网页依赖属性，比如脚本语言、error页面、缓存需求等等</li>
                <li>include指令：包含其他文件</li>
                <li>taglib指令：引入标签库的定义</li>
            </ul>
        </div>
        <div>
            <h3>九大隐式对象</h3>
            <ul>
                <li>request：HttpServletRequest接口的实例</li>
                <li>response：HttpServletResponse接口的实例</li>
                <li>out：JspWriter类的实例，用于把结果输出至网页上</li>
                <li>session：HttpSession类的实例</li>
                <li>application：ServletContext类的实例，与应用上下文有关</li>
                <li>config：ServletConfig类的实例</li>
                <li>pageContext：PageContext类的实例，提供对JSP页面所有对象以及命名空间的访问</li>
                <li>page：类似于Java类中的this关键字</li>
                <li>Exception：Exception类的对象，代表发生错误的JSP页面中对应的异常对象</li>
            </ul>
        </div>
        <div>
            <h3>示例效果显示</h3>
            <%!
                int a=0;String str="欢迎你！";
            %>
            <%-- jsp的变量值作为文本输出到网页 --%>
            a的值为：<%=a%>
            str：<%=str%>
            <%-- jsp的逻辑处理 --%>
            <%
                if(a>0){
                    out.println("heihei");
                }else{
                    out.println("haha");
                }
            %>
        </div>
    </div>
</body>
</html>
