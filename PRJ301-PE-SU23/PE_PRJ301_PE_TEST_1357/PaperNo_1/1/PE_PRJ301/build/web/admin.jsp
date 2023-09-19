<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.USER}" />
        Welcome, ${user.fullname}
        <a href="MainController?btAction=LOGOUT">Log out</a>

        <form action="MainController">
            Search <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" name="btAction" value="SEARCH" />
        </form>

        <c:set var="list" value="${requestScope.dtoList}"/>
        <c:if test="${not empty list}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>UserID</th>
                        <th>FullName</th>
                        <th>RoleID</th>
                        <th>Status</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" varStatus="counter" items="${list}">
                    <form action="MainController">
                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                ${dto.userID}
                                <input type="hidden" name="txtUserID" value="${dto.userID}" />
                            </td>
                            <td>
                                <input type="text" name="txtFullname" value="${dto.fullname}" />
                            </td>
                            <td>
                                <input type="text" name="txtRoleID" value="${dto.roleID}" />
                            </td>
                            <td>
                                ${dto.status}
                            </td>
                            <td>
                                <input type="hidden" name="txtLastSearchValue" value="${param.txtSearchValue}" />
                                <input type="submit" name="btAction" value="UPDATE" />
                            </td>
                        </tr>
                    </form>

                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty list}">
        No record matched!!!
    </c:if>


</body>
</html>
