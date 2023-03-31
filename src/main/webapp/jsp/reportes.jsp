<%-- 
    Document   : resportes
    Created on : 24/03/2023, 12:07:34 p. m.
    Author     : alejo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <h2>Ventana de Reportes</h2>
            <table border="1" cellspacing="1" cellpadding="3">
                
                <tbody>
                    <tr>
                        <td>
                            <form action="Servlet3" methos="POST">
                                <input type="hidden" name="formulario" value="todascuentas" />
                                <input type="submit" value="Todas las cuentas"/>
                            </form>
                        </td>
                        <td>
                            <form action="Servlet3" methos="POST">
                                <input type="hidden" name="formulario" value="unacuenta" />
                                <input type="number" name="numcta" /> 
                                <input type="submit" value="Una cuenta"/>
                            </form>
                        </td>
                        <td>
                            <form action="Servlet3" methos="POST">
                                <input type="hidden" name="formulario" value="mayor" />
                                <input type="submit" value="Mayor balance"/>
                            </form>
                        </td>
                        <td>
                            <form action="Servlet3" methos="POST">
                                <input type="hidden" name="formulario" value="menor" />
                                <input type="submit" value="Menor balance"/>
                            </form>
                        </td>
                        
                    </tr>
                </tbody>
            </table>

            <br/>
            <br/>
            
            <table border="1" cellspacing="1" cellpadding="3">
                <thead>
                    <tr colspan="2">
                        <th>Su reporte de sus cuentas favoritas</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Maximo Balance</td>
                        <td><c:out value="${max.toString()}" /></td>
                    </tr>
                    <tr>
                        <td>Minimo Balance</td>
                        <td><c:out value="${min.toString()}" /></td>
                    </tr>
                </tbody>
            </table>
            <c:if test="${not empty mensaje}">
                <p style="color:red;"><c:out value="${mensaje}"/></p>
            </c:if>
            <br/>
            <br/>
            <!-- Formulario para volver a la ventana cuentas.jsp -->
            <form action="Servlet1" method="POST">
                <input type="hidden" name="formulario" value="accion2" />
                Volver a: <input type="submit" value="Cuentas" />
            </form>
        </div>
    </body>
</html>
