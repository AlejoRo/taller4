<%-- 
    Document   : movimientos
    Created on : 24/03/2023, 7:37:10 p. m.
    Author     : alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <<h1>Movimiento(s) de la cuenta</h1>
            <c:choose>
                <c:when test="${m}">
                    <table border="1" cellpading="5">
                        <thead>
                            <tr>
                                <th>Movimientos de la cuenta</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:when test="">
                                <c:forEach var="movimiento" items="${movimientos}">
                                    <tr>
                                        <td><c:out value="${movimiento.toString()}"/></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:when test="">
                                <tr>
                                    <td><c:out value="movimiento"/></td>
                                </tr>
                            </c:when>
                        </tbody>
                    </table>
                </c:when>
                <c:when test="${l}">
                    <h2>No existen movimientos</h2>
                </c:when>
            </c:choose>
        </div>
    </body>
</html>
