<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
        <h3>${requestScope.msg}</h3>
        <form action="MainController">
            UserID: <input type="text" name="txtUserID" value="" /><br/>
            Password: <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" name="action" value="LOGIN" />
        </form>
    </body>

</html>

