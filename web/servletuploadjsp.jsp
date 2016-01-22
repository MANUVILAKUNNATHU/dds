<%-- 
    Document   : servletuploadjsp
    Created on : Dec 6, 2015, 9:09:54 AM
    Author     : MANU WILSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" id="bulk-form" action="servletuploadjsp" enctype="multipart/form-data">
    <input type="hidden" name="product" value="${param.product}" />
    <input type="file" multiple name="fname">
    <input type="submit" class="btn red-btn" value="SUBMIT"/>
</form>
    </body>
</html>
