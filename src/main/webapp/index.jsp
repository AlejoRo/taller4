<%-- 
    Document   : index
    Created on : 21/03/2023, 5:35:02 p. m.
    Author     : alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <h1>El Gran Banco</h1>
            <br/>
            <!-- El Formulario para crear una cuenta nueva -->
            <form action="Servlet1" method="POST">
                <table border="1" cellpading="5">
                    <thead>
                        <tr>
                            <th>Tipo de cuenta</th>
                            <th>Nacionalidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <select name="tipo" size="2">
                                    <option value="ahorros" selected="">Ahorros</option>
                                    <option value="corriente">Corriente</option>
                                </select>
                            </td>
                            <td>
                                <select name="nacionalidad" size="2">
                                    <option value="local" selected="">Local</option>
                                    <option value="extranjero">Extranjero</option>
                                </select>
                            </td>
                        </tr>
                        <tr colspan="2">
                            <td>
                                <input type="hidden" value="accion1" name="formulario"/>
                                <input type="submit" value="Crear cuenta"/>
                            </td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <!-- Formulario para ir a la ventana cuentas.jsp -->
            <form action="Servlet1" method="POST">
                <input type="hidden" value="accion2" name="formulario"/>
                Ir a: <input type="submit" value="Cuentas"/>
            </form>
        </div>
    </body>
</html>
