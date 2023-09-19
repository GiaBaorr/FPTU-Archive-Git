<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h3>Welcome, ${sessionScope.user.fullName}</h3>
        <a href="MainController?action=LOGOUT">Logout</a>
        <form action="MainController">
            Search <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" name="action" value="SEARCH" />
        </form>

        <c:set var="result" value="${requestScope.result}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>no</th>
                        <th>id</th>
                        <th>price</th>
                        <th>size</th>
                        <th>description</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${result}" var="dto" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.id}</td>
                            <td>${dto.price}</td>
                            <td>${dto.size}</td>
                            <td>${dto.description}</td>
                            <td>
                                <c:url var="deleteLink" value="MainController">
                                    <c:param name="action" value="DELETE" />
                                    <c:param name="pk" value="${dto.id}" />
                                    <c:param name="lastSearchValue" value="${param.txtSearchValue}" />
                                </c:url>
                                <a href="${deleteLink}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

    </body>
</html>
