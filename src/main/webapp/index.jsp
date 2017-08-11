<%@ page language="Java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    String p = basePath+"/HACAClient/index.html";
    String p1 = "/HACAClient/index.html";
    System.out.println(p);
    System.out.println(basePath);
%>
<head>

</head>
<body>
<jsp:forward page="index.html"/>

</body>
</html>
