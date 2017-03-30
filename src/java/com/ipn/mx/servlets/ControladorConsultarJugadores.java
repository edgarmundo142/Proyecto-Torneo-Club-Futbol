/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.servlets;

import com.ipn.mx.model.entities.Jugador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgar
 */
public class ControladorConsultarJugadores extends HttpServlet {

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
        String representante; /*Debe obtenerse de la cookie, sesion*/
        /*
        Consultar de la base de datos los jugadores del representante
        */
        String nombre = "edgar";
        String apellidoPaterno = "arredondo";
        String apellidoMaterno = "basurto";
        String correo = "edgar@edgar.com";
        String foto = "unaFoto.jpg";
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*
            Dentro de un ciclo for recorrer el set resultante y por cada jugador enviar la siguiente
            cadena
            */
            out.print("<tr>\n" +
                            "<th scope='row'>1</th>\n" +
                            "<td>" + nombre + "</td>\n" +
                            "<td>" + apellidoPaterno + "</td>\n" +
                            "<td>" + apellidoMaterno + "</td>\n" +
                            "<td>" + correo + "</td>\n" +
                            "<td>" + foto + "</td>\n" +
                            "<td>\n" +
                            "<i class='fa fa-edit fa-1x editPlayer icono' aria-hidden='true' data-name='" + nombre + ":" + apellidoPaterno + ":" + apellidoMaterno + "'></i>\n" +
                            "<i class='fa fa-close fa-1x deletePlayer icono' aria-hidden='true' data-name='" + nombre + ":" + apellidoPaterno + ":" + apellidoMaterno + "'></i>\n" +
                            "</td>\n" +
                        "</tr>");
        }
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
