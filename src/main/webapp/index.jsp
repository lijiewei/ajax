<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax测试</title>
    <script type="text/javascript"  src="<%=request.getContextPath()%>/resource/js/ajax.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/jquery3.3.1/jquery.min.js"></script>
</head>
<body>
<h1>XMLHttpRequest level 1</h1>
<button onclick="xhr1_get()">xhr level 1 get请求</button>
<button onclick="xhr1_post()">xhr level 1 post请求</button>

<h1>jQuery ajax</h1>
<button onclick="jquery_ajax_get()">jquery get请求</button>
<button onclick="jquery_ajax_post()">jquery post请求</button>

<h1>XMLHttpRequest level 1</h1>
<button onclick="xhr2_get()">xhr level 2 get请求</button>
<button onclick="xhr2_post()">xhr level 2 post请求</button>
</body>
</html>
