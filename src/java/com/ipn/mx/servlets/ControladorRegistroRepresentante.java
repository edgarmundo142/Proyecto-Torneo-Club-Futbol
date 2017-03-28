package com.ipn.mx.servlets;

import com.ipn.mx.model.DAO.RepresentanteDAO;
import com.ipn.mx.model.entities.Jugador;
import com.ipn.mx.model.entities.JugadorId;
import com.ipn.mx.model.entities.Representante;
import com.ipn.mx.model.entities.RepresentanteId;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafal
 */
public class ControladorRegistroRepresentante extends HttpServlet {

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
        RequestDispatcher vista;
        String ruta;
        String nombre_rep = request.getParameter("nombre_representante");
        String apellido_paterno = request.getParameter("apellido_paterno");
        String apellido_materno = request.getParameter("apellido_materno");
        String telefono = request.getParameter("tel_representante");
        String correo = request.getParameter("correo_representante");
        String boleta = request.getParameter("boleta_representante");
        String password_user = request.getParameter("password_representante");
        /***Construccion de beans***/
        JugadorId representanteId = new JugadorId(nombre_rep, apellido_paterno, apellido_materno, correo);
        Jugador representante = new Jugador(representanteId, boleta, false);
        representante.setClave(password_user);
        representante.setFoto("foto.jpg");
        RepresentanteId idRep = new RepresentanteId(representante.getId().getNombre(), representante.getId().getApellidoPaterno(), 
                representante.getId().getApellidoMaterno(), representante.getId().getCorreo());
        Representante R = new Representante(representante, password_user, telefono);
        R.setId(idRep);
        representante.setRepresentante(R);
        /***Transacciones***/
        RepresentanteDAO dao = new RepresentanteDAO();
        try {
            dao.guardarDatosPersonalesRepresentante(representante);
            dao.guardarRepresentante(R);
            ruta = "login.html";
        } catch (Exception e) {
            ruta = "jsp/ErrorRegistro.jsp?error=" + e.getMessage();
        }
        try {
            vista = request.
                getRequestDispatcher(ruta);
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("Error de redireccion de pagina: " + ex.getMessage());
        }
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControladorRegistroRepresentante</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControladorRegistroRepresentante at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
