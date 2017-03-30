/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.servlets;

import com.ipn.mx.model.DAO.CoordinadorDAO;
import com.ipn.mx.model.DAO.LoginDAO;
import com.ipn.mx.model.DAO.RepresentanteDAO;
import com.ipn.mx.model.entities.Coordinador;
import com.ipn.mx.model.entities.Jugador;
import com.ipn.mx.model.entities.JugadorId;
import com.ipn.mx.model.entities.Representante;
import com.ipn.mx.model.entities.Torneo;
import com.ipn.mx.utilities.UserType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gava_
 */
public class ControladorLogin extends HttpServlet {
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
        CoordinadorDAO cdao = new CoordinadorDAO();
        RepresentanteDAO rdao = new RepresentanteDAO();
        Coordinador C = new Coordinador(request.getParameter("username"), request.getParameter("password"), new HashSet<Torneo>(0));
        List<Coordinador> listaCoords = cdao.Login(C);
        if (listaCoords.size() > 0) {
            for (Coordinador coord : listaCoords) {
                System.out.println("Usuario: " + coord.getUsuario());
                System.out.println("Clave: " + coord.getContrasenia());
            }
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("Datos", C);
            sesion.setAttribute("User-Type", UserType.COORDINADOR);
        } else {
            
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
