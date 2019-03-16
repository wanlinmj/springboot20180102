<%--
  Created by IntelliJ IDEA.
  User: kangwl_pc
  Date: 2018/1/18
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试页面</title>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<base href="<%=basePath%>" >

<h>haha................</h>

    <form action="<%=basePath%>fileUpload/fileUploadTest1" method="post" enctype="multipart/form-data">
        <input type="file" name="file" multiple="multiple">
        <input type="submit" value="upload">
    </form>

</body>
</html>
