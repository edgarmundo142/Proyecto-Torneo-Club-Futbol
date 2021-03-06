/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.servlets;

import com.ipn.mx.model.DAO.RepresentanteDAO;
import com.ipn.mx.model.entities.Jugador;
import com.ipn.mx.model.entities.JugadorId;
import com.ipn.mx.utilities.FileUpload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author edgar
 */
@javax.servlet.annotation.MultipartConfig
public class ControladorRegistrarJugador extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        /*
        Nombre de atributos
        nombre, apellidoPaterno, apellidoMaterno, correo, telefono
        */
        Part file = request.getPart("foto");
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String correo = request.getParameter("correo");
        
        System.out.println("Nombre: " + nombre);
        System.out.println("apellidoPaterno: " + apellidoPaterno);
        System.out.println("apellidoMaterno: " + apellidoMaterno);
        System.out.println("correo: " + correo);
        //String telefono = request.getParameter("telefono");
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (file != null) {
                JugadorId cveJugador = new JugadorId(nombre, apellidoPaterno, apellidoMaterno, correo);
                Jugador jugador = new Jugador(cveJugador, correo, false);
                jugador.setFoto(correo);
                RepresentanteDAO rdao = new RepresentanteDAO();
                System.out.println("Archivo existente...");
                if(file.getSize() > 0) {
                    /*
                        regresar -1 si no se pudo registrar.
                                  0 si se registro correctamente
                    */
                    if (!rdao.guardarDatosPersonalesRepresentante(jugador))
                        out.println("-1");
                    else{
                        System.out.println("Archivo existente...");
                        FileUpload fu = FileUpload.createUploadFile(file, correo);
                        fu.setFolder("jugadores");
                        fu.start();
                        out.println("0");
                    }
                } else {
                    System.out.println("Archivo no cargado....");
                    out.println("-1");
                }
            } else {
                System.out.println("Archivo no cargado....");
                out.println("-1");
            }
            out.flush();
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
