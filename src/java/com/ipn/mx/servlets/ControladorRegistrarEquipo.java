/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgar
 */
public class ControladorRegistrarEquipo extends HttpServlet {

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
        String json = request.getParameter("json");
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonArray arreglo = reader.readArray();
        reader.close();
        
        JsonObject objeto = arreglo.getJsonObject(0);
        String equipo = objeto.getString("equipo");
        String torneo = objeto.getString("torneo");
        String uniforme = objeto.getString("uniforme");
        JsonArray jugadores = objeto.getJsonArray("jugadores");
        JsonObject jugador;
        for(int i = 0; i < jugadores.size(); i++){
            jugador = jugadores.getJsonObject(i);
        }

        /*El objeto json tiene los siguientes atributos
            equipo
            torneo
            uniforme
            jugadores -> este es un arreglo de objetos. Cada objeto es un jugador. Cada jugador
                            tiene un solo atributo que es 'nombre', con el siguiente formato:
                            nombre(s):apellidoPaterno:apellidoMaterno
        */
        
        /*
            Como respuesta, enviar 0 si se registro el equipo, y -1 si hubo algun error
        */
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(-1);
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
