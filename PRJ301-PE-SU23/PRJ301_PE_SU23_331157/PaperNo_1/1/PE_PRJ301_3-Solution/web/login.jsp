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
        <c:set var="msg" value="${requestScope.ERROR}" />
        ${msg}
        <form action="MainController">
            UserID <input type="text" name="txtUserID" value="" />
            Password <input type="password" name="txtPassword" value="" />
            <input type="submit" value="LOGIN" name="action" />
        </form>
    </body>

</html>

