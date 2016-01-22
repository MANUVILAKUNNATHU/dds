<%-- 
    Document   : run
    Created on : Dec 5, 2015, 11:21:27 PM
    Author     : MANU WILSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="readcsv.read"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
             read obj=new read();
             obj.run();
             
             
            %>
              <script>alert(' successfull...!!');</script>
              
    </body>
</html>
