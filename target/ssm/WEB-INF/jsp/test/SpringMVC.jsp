<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date" %>
<html>
<head>
    <title>SpringMVC</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <style type="text/css">

    </style>
    <script type="text/javascript">
        function selectFile(e){
            console.log("选择的文件信息："+JSON.stringify(e));
        }
    </script>
</head>
<body>
<div class="flex align-center justify-around">
    <div class="row">
        <h3>参数传递：</h3>
        <ol>
            <li>
                <a href="${pageContext.request.contextPath}/test/beanParam?fieldParam=实体类bean传参">
                    <h3>实体类bean传参</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/shapeParam?fieldParam=形参传参">
                    <h3>形参传参</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/httpRequestParam?fieldParam=HttpServletRequest传参">
                    <h3>HttpServletRequest传参</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/pathValue/@PathVariable传参">
                    <h3>@PathVariable传参</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/requestParam?fieldParam=@RequestParam传参">
                    <h3>@RequestParam传参</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/modelAttributeParam?fieldParam=@ModelAttribute传参">
                    <h3>@ModelAttribute传参</h3>
                </a>
            </li>
        </ol>
    </div>
    <div class="row">
        <h3>Controller类的返回类型：</h3>
        <ol>
            <li>
                <a href="${pageContext.request.contextPath}/test/modelAndView">
                    <h3>ModelAndView</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/string">
                    <h3>返回类型为String</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/result">
                    <h3>返回类型为Void</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/anyData">
                    <h3>返回类型为任何数据类型</h3>
                </a>
            </li>
        </ol>
    </div>
    <div class="row">
        <h3>Controller的跳转方式：</h3>
        <ol>
            <li>
                <a href="${pageContext.request.contextPath}/test/navToTypeByForwardForModel">
                    <h3>ModelAndView转发</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/navToTypeByRedirectForModel">
                    <h3>ModelAndView重定向</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/navToTypeByForwardForString">
                    <h3>String转发</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/navToTypeByRedirectForString">
                    <h3>String重定向</h3>
                </a>
            </li>
        </ol>
    </div>
    <div class="row">
        <h3>Controller的转化器：</h3>
        <ol>
            <li>
                <a href="${pageContext.request.contextPath}/test/testConverter?str=2022 12 12">
                    <h3>类型转换器Converter</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/testFormatter?money=￥99999">
                    <h3>格式化转换器Formatter</h3>
                </a>
            </li>
        </ol>
    </div>
    <div class="row">
        <h3>Controller的异常处理：</h3>
        <ol>
            <li>
                <a href="${pageContext.request.contextPath}/test/testDefaultHandlerExceptionResolver">
                    <h3>DefaultHandlerExceptionResolver默认处理</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/testResponseStatusExceptionResolver">
                    <h3>ResponseStatusExceptionResolver的@ResponseStatus默认处理</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/testExceptionHandlerExceptionResolver">
                    <h3>ExceptionHandlerExceptionResolver的@ExceptionHandler默认处理</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/testExceptionHandlerExceptionResolveByGlobal">
                    <h3>ExceptionHandlerExceptionResolver的@ControllerAdvice全局处理</h3>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/test/testSimpleMappingExceptionResolver">
                    <h3>SimpleMappingExceptionResolver自定义全局异常处理</h3>
                </a>
            </li>
        </ol>
    </div>
    <div class="row">
        <h3>文件上传下载</h3>
        <form action="${pageContext.request.contextPath}/test/upload" method="post" enctype="multipart/form-data">
            <input type="text" name="name"/>
            <input type="text" name="txt"/>
            <input type="file" name="fileData"/>
            <button type="submit" onclick="upload">上传</button>
        </form>
    </div>
</div>
</body>
</html>
