package com.ipn.mx.servlets;

import com.ipn.mx.model.DAO.RepresentanteDAO;
import com.ipn.mx.model.entities.Jugador;
import com.ipn.mx.model.entities.JugadorId;
import com.ipn.mx.model.entities.Representante;
import com.ipn.mx.model.entities.RepresentanteId;
import com.ipn.mx.utilities.FileUpload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author rafal
 */
@javax.servlet.annotation.MultipartConfig
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
        request.setCharacterEncoding("UTF-8");
        
        try {
            RequestDispatcher vista;
            String ruta;
            
            Part file = request.getPart("r-file-perfil");
            
            /***Captura de campos del formulario***/
            String nombre_rep = request.getParameter("nombre_representante");
            String apellido_paterno = request.getParameter("apellido_paterno");
            String apellido_materno = request.getParameter("apellido_materno");
            String telefono = request.getParameter("tel_representante");
            String correo = request.getParameter("correo_representante");
            String boleta = request.getParameter("boleta_representante");
            String password_user = request.getParameter("password_representante");
            
            if (file != null) {
                if(file.getSize() > 0) {
                    FileUpload fu = FileUpload.createUploadFile(file, correo);
                    fu.setFolder("usuarios");
                    fu.start();
                }
                /***Construccion de beans***/
                JugadorId id = new JugadorId(nombre_rep, apellido_paterno, apellido_materno, correo);
                Jugador jugador = new Jugador(id, correo, false);
                jugador.setClave(boleta);

                RepresentanteId idRep = new RepresentanteId(jugador.getId().getNombre(), jugador.getId().getApellidoPaterno(),
                        jugador.getId().getApellidoMaterno(), jugador.getId().getCorreo());
                Representante representante = new Representante(jugador, password_user, telefono);
                representante.setId(idRep);

                /***Transacciones***/
                RepresentanteDAO dao = new RepresentanteDAO();
                try {
                    dao.guardarDatosPersonalesRepresentante(jugador);
                    dao.guardarRepresentante(representante);
                    System.out.println("Representante de Equipo registrado...");
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
            } else {
                System.out.println("Archivo no cargado....");
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
        } catch (Exception ex) {
            System.out.println("Fallo al asignar archivo al sistema: " + ex.getMessage());
            ex.printStackTrace();
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
