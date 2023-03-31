/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ces2.clase4.servlets;

import ces2.clase4.entidades.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alejo
 */
public class Servlet2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            //Para traer la sesión
            HttpSession sesion = request.getSession();

            //Para traer el objeto banco
            Banco banco = (Banco) sesion.getAttribute("banco");

            String formulario = request.getParameter("formulario");

            String varcuenta = request.getParameter("cuenta");
            String varnacionalidad = request.getParameter("nacionalidad");
            String varbalance = request.getParameter("balance");

            //Para cambiar la nacionalidad
            if (formulario.equals("nacionalidad")) {
                banco.cambiarNacionalidad(Boolean.valueOf(varnacionalidad), Integer.parseInt(varcuenta));

            } else if (formulario.equals("depositar")) {

                String mensaje1 = "";

                if (!(varbalance.trim().isEmpty()) && (varbalance != null)) {
                    if (numerico(varbalance)) {
                        if (Double.parseDouble(varbalance) < 0) {
                            mensaje1 = "La cantidad a depositar debe ser un valor mayor a 0";
                        } else {
                            //Actualizar el balance de cuenta
                            banco.depositar(Double.parseDouble(varbalance), Integer.parseInt(varcuenta));

                            mensaje1 = "El deposito se realizo exitosamente";
                        }

                    } else {
                        mensaje1 = "La cantidad a depositar debe ser un valor numérico";
                    }
                } else {
                    mensaje1 = "Debe ingresar la cantidad a depositar";
                }
                //Obtenemos el balance actualizado
                varbalance = Double.toString(banco.getBalance(Integer.parseInt(varcuenta)));
                request.setAttribute("mensaje1", mensaje1);

            } else if (formulario.equals("prestamo")) {

                String mensaje2 = "";

                if (!(varbalance.trim().isEmpty()) && (varbalance != null)) {
                    if (numerico(varbalance)) {
                        if (Double.parseDouble(varbalance) < 0) {
                            mensaje2 = "La cantidad del prestamo debe ser un valor mayor a 0";
                        } else {
                            Boolean resultado = false;

                            //Realizamos la solicitud del prestamo
                            resultado = banco.autorizarPrestamo(Double.parseDouble(varbalance), Integer.parseInt(varcuenta));

                            if (resultado) {

                                mensaje2 = "El prestamo fue aprobado exitosamente";
                            } else {
                                mensaje2 = "No cumple con las condiciones para el prestamo";
                            }
                        }

                    } else {
                        mensaje2 = "La cantidad del prestamo debe ser un valor numérico";
                    }
                } else {
                    mensaje2 = "Debe ingresar la cantidad del prestamo";
                }
                //Obtenemos el balance actualizado
                varbalance = Double.toString(banco.getBalance(Integer.parseInt(varcuenta)));
                request.setAttribute("mensaje2", mensaje2);

            } else if (formulario.equals("interes")) {
                String mensaje3 = "";
                boolean resultado = false;

                //Sumar el interes a la cuenta
                resultado = banco.addInteres(Integer.parseInt(varcuenta));
                if (resultado) {
                    mensaje3 = "Se ha sumado el interes a su cuenta";
                } else {
                    mensaje3 = "Esta es una cuenta corriente que no tiene interes.";
                }
                //Obtenemos el balance actualizado
                varbalance = Double.toString(banco.getBalance(Integer.parseInt(varcuenta)));
                request.setAttribute("mensaje3", mensaje3);
            } else if (formulario.equals("retiro")) {
                String mensaje4 = "";

                if (!(varbalance.trim().isEmpty()) && (varbalance != null)) {
                    if (numerico(varbalance)) {
                        if (Double.parseDouble(varbalance) > banco.getBalance(Integer.parseInt(varcuenta))) {
                            mensaje4 = "La cantidad a retirar debe ser un valor menor al balance";
                        } else {
                            //Actualizar el balance de cuenta
                            banco.retirar(Double.parseDouble(varbalance), Integer.parseInt(varcuenta));

                            mensaje4 = "El retiro se realizo exitosamente";
                        }

                    } else {
                        mensaje4 = "La cantidad a retirar debe ser un valor numérico";
                    }
                } else {
                    mensaje4 = "Debe ingresar la cantidad a retirar";
                }
                //Obtenemos el balance actualizado
                varbalance = Double.toString(banco.getBalance(Integer.parseInt(varcuenta)));
                request.setAttribute("mensaje4", mensaje4);
            }

            request.setAttribute("cuenta", varcuenta);
            request.setAttribute("nacionalidad", varnacionalidad);
            request.setAttribute("balance", varbalance);

            request.getRequestDispatcher("jsp/cuenta.jsp").forward(request, response);

        }
    }

    public boolean numerico(String strNum) {
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
