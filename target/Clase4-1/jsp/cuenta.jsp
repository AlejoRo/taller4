<%-- 
    Document   : cuenta
    Created on : 23/03/2023, 4:54:39 p. m.
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
            <h1>Cuenta Seleccionada</h1>
            <br/>
            <table border="1" cellpadding="3">
                <tbody>
                    <tr colspan="3">
                        <td>Cuenta: </td>
                        <td><c:out value="${cuenta}"/></td>
                    </tr>
                    <tr>
                        <td>Extranjero</td>
                        <td><c:out value="${nacionalidad}" /></td>
                        <td>
                            <form action="Servlet2" method="POST">
                                <input type="hidden" name="cuenta" value="${cuenta}" />
                                <input type="hidden" name="nacionalidad"
                                       <c:if test="${nacionalidad}">
                                           value="false"
                                       </c:if>
                                       <c:if test="${not nacionalidad}">
                                           value="true"
                                       </c:if> />
                                <input type="hidden" name="balance" value="${balance}" />
                                <input type="hidden" name="formulario" value="nacionalidad" />
                                <input type="submit" value="Cambiar"/>
                            </form>
                        </td>
                    </tr>
                    <tr colspan="3">
                        <td>Balance</td>
                        <td><c:out value="${balance}" /></td>
                    </tr>
                    <tr>
                        <td>Hacer depósito</td>
                        <td>
                            <form action="Servlet2" method="POST">
                                <input type="hidden" name="cuenta" value="${cuenta}" />
                                <input type="hidden" name="nacionalidad" value="${nacionalidad}" />
                                <input type="text" name="balance" style="width: 120px;" />
                                <input type="hidden" name="formulario" value="depositar" />
                                <input type="submit" value="Depositar"/>
                            </form>
                        </td>
                        <td>
                            <c:if test="${not empty mensaje1}">
                                <p style="color: red;">
                                    <c:out value="${mensaje1}" />
                                </p>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>Autorizar préstamo</td>
                        <td>
                            <form action="Servlet2" method="POST">
                                <input type="hidden" name="cuenta" value="${cuenta}" />
                                <input type="hidden" name="nacionalidad" value="${nacionalidad}" />
                                <input type="text" name="balance" style="width: 120px;" />
                                <input type="hidden" name="formulario" value="prestamo" />
                                <input type="submit" value="Solicitar"/>
                            </form>
                        </td>
                        <td>
                            <c:if test="${not empty mensaje2}">
                                <p style="color: red;">
                                    <c:out value="${mensaje2}" />
                                </p>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>Sumar interés</td>
                        <td>
                            <form action="Servlet2" method="POST">
                                <input type="hidden" name="cuenta" value="${cuenta}" />
                                <input type="hidden" name="nacionalidad" value="${nacionalidad}" />
                                <input type="hidden" name="balance" value="${balance}" />
                                <input type="hidden" name="formulario" value="interes" />
                                <input type="submit" value="Sumar"/>
                            </form>
                        </td>
                        <td>
                            <c:if test="${not empty mensaje3}">
                                <p style="color: red;">
                                    <c:out value="${mensaje3}" />
                                </p>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>Retirar</td>
                        <td>
                            <form action="Servlet2" method="POST">
                                <input type="hidden" name="cuenta" value="${cuenta}" />
                                <input type="hidden" name="nacionalidad" value="${nacionalidad}" />
                                <input type="text" name="balance" style="width: 120px;" />
                                <input type="hidden" name="formulario" value="retiro" />
                                <input type="submit" value="Retirar"/>
                            </form>
                        </td>
                        <td>
                            <c:if test="${not empty mensaje4}">
                                <p style="color: red;">
                                    <c:out value="${mensaje4}" />
                                </p>
                            </c:if>
                        </td>
                    </tr>
                </tbody>
            </table>                 
            <br/>
            <br/>
            <!-- Formulario para ir a movimientos.jsp -->
            <form action="Servlet4" method="POST">
                <input type="hidden" name="formulario" value="todosmovimientos" />
                Ir a: <input type="submit" value="Ver todos los movimientos" />
            </form>
            <br/>
            <br/>
            <!-- Formulario para ir a movimientos.jsp -->
            <form action="Servlet4" method="POST">
                <input type="hidden" name="formulario" value="ultimomovimiento" />
                Ir a: <input type="submit" value="Ver el ultimo movimiento" />
            </form>
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








