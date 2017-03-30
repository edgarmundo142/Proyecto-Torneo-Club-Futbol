package com.ipn.mx.model.DAO;

import com.ipn.mx.model.entities.Equipo;
import com.ipn.mx.model.entities.Evento;
import com.ipn.mx.model.entities.Partido;
import com.ipn.mx.model.entities.Torneo;
import com.ipn.mx.model.entities.Coordinador;
import com.ipn.mx.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rafael
 */
public class CoordinadorDAO {
    
    public List<Coordinador> Login(Coordinador u) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        List<Coordinador> users = new ArrayList<>();
        String hql = "from Coordinador as u "
                + " where u.usuario =:nickUsuario"
                + " and u.contrasenia =:claveUsuario";
        try {
            transaccion.begin();
            Query q = sesion.createQuery(hql);
            q.setParameter("nickUsuario", u.getUsuario());
            q.setParameter("claveUsuario", u.getContrasenia());
            users = q.list();
            transaccion.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return users;
    }
    
    /**
    * 
    * @param usuario
    * @param contrasenia
    */
   public void iniciarSesion(String usuario, String contrasenia) {
           // TODO - implement Coordinador.iniciarSesion
           throw new UnsupportedOperationException();
   }

   /**
    * 
    * @param partido
    */
   public void actualizarFechaDePartido(Partido partido) {
           // TODO - implement Coordinador.actualizarFechaDePartido
           throw new UnsupportedOperationException();
   }

   /**
    * 
    * @param torneo
    */
   public void crearTorneo(Torneo torneo) {
           // TODO - implement Coordinador.crearTorneo
           throw new UnsupportedOperationException();
   }

   /**
    * 
    * @param equipo
    */
   public void asignarGrupo(Equipo equipo) {
           // TODO - implement Coordinador.asignarGrupo
           throw new UnsupportedOperationException();
   }

   /**
    * 
    * @param partido
    */
   public void registrarResultadoDePartido(Partido partido) {
           // TODO - implement Coordinador.registrarResultadoDePartido
           throw new UnsupportedOperationException();
   }

   /**
    * 
    * @param evento
    */
   public void generarReporteDeHorariosDeJuego(Evento evento) {
           // TODO - implement Coordinador.generarReporteDeHorariosDeJuego
           throw new UnsupportedOperationException();
   }

   /**
    * 
    * @param torneo
    */
   public void generarReporteDeTablaDePosiciones(Torneo torneo) {
           // TODO - implement Coordinador.generarReporteDeTablaDePosiciones
           throw new UnsupportedOperationException();
   }

   /**
    * 
    * @param torneo
    */
   public void generarReporteDeListaDeCapitanes(Torneo torneo) {
           // TODO - implement Coordinador.generarReporteDeListaDeCapitanes
           throw new UnsupportedOperationException();
   }

   /**
    * 
    * @param equipo
    */
   public void vetarEquipo(Equipo equipo) {
           // TODO - implement Coordinador.vetarEquipo
           throw new UnsupportedOperationException();
   }
   
    public static void main(String[] args) {
        CoordinadorDAO dao = new CoordinadorDAO();
        Coordinador C = new Coordinador("admin1", "root123", new HashSet<Torneo>(0));
        List<Coordinador> listaCoords = dao.Login(C);
        if (listaCoords.size() > 0) {
            for (Coordinador coord : listaCoords) {
                System.out.println("Usuario: " + coord.getUsuario());
                System.out.println("Clave: " + coord.getContrasenia());
            }
        }
    }
}
