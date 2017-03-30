package com.ipn.mx.model.DAO;

import com.ipn.mx.model.entities.Equipo;
import com.ipn.mx.model.entities.Jugador;
import com.ipn.mx.model.entities.JugadorId;
import com.ipn.mx.model.entities.Mensaje;
import com.ipn.mx.model.entities.Representante;
import com.ipn.mx.model.entities.RepresentanteId;

import com.ipn.mx.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author rafael
 */
public class RepresentanteDAO {
    public void guardarRepresentante (Representante representante) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            sesion.save(representante);
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
    }
    
    public boolean guardarDatosPersonalesRepresentante (Jugador datosRepresentante) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            sesion.save(datosRepresentante);
            transaccion.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            return false;
        }
        return true;
    }
    
    /**
    * 
    * @param jugador
    */
    public void registrarJugador(Jugador jugador) {
            // TODO - implement Representante.registrarJugador
            throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param jugador
     */
    public void eliminarJugador(Jugador jugador) {
            // TODO - implement Representante.eliminarJugador
            throw new UnsupportedOperationException();
    }

   /**
    * 
    * @param jugador
    */
    public void actualizarJugador(Jugador jugador) {
            // TODO - implement Representante.actualizarJugador
            throw new UnsupportedOperationException();
    }

   /**
    * 
    * @param equipo
    */
    public void crearEquipo(Equipo equipo) {
            // TODO - implement Representante.crearEquipo
            throw new UnsupportedOperationException();
    }

   /**
    * 
    * @param equipo
    */
    public void actualizarEquipo(Equipo equipo) {
            // TODO - implement Representante.actualizarEquipo
            throw new UnsupportedOperationException();
    }

   /**
    * 
    * @param equipo
    */
    public void eliminarEquipo(Equipo equipo) {
            // TODO - implement Representante.eliminarEquipo
            throw new UnsupportedOperationException();
    }

   /**
    * 
    * @param equipo
    * @return 
    */
    public List<Jugador> verPlantillaDeEquipo(Equipo equipo) {
            return null;
    }

   /**
    * 
    * @param equipo
    */
    public void generarReporteDePlantilla(Equipo equipo) {
            // TODO - implement Representante.generarReporteDePlantilla
            throw new UnsupportedOperationException();
    }

   /**
    * 
    * @param mensaje
    */
    public void solicitarCambioDeHorario(Mensaje mensaje) {
            // TODO - implement Representante.solicitarCambioDeHorario
            throw new UnsupportedOperationException();
    }

   /**
    * 
    * @param representante
    */
    public void modificarDatosPersonales(Representante representante) {
            // TODO - implement Representante.modificarDatosPersonales
            throw new UnsupportedOperationException();
    }

   /**
    * 
    * @param correo
    * @param contrasenia
    */
    public void iniciarSesion(String correo, String contrasenia) {
            // TODO - implement Representante.iniciarSesion
            throw new UnsupportedOperationException();
    }
    
//    public static void main(String[] args) {
//        RepresentanteDAO t = new RepresentanteDAO();
//        JugadorId id = new JugadorId("iodksdsa", "isdjfkdsfsn", "mdsjhwjwe", "osjdfksd@klsdjfsdju");
//        Jugador jugador = new Jugador(id, "Foto3.jpg", false);
//        RepresentanteId idRep = new RepresentanteId(jugador.getId().getNombre(), jugador.getId().getApellidoPaterno(), 
//                jugador.getId().getApellidoMaterno(), jugador.getId().getCorreo());
//        Representante representante = new Representante(jugador, "isjdfmksdtoot", "43534565465445");
//        representante.setId(idRep);
//        jugador.setRepresentante(representante);
//        t.guardarDatosPersonalesRepresentante(jugador);
//        //t.guardarRepresentante(representante);
//        System.out.println("Hecho!!!");
//    }

    public List<Representante> Login(Jugador o) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        List<Representante> users = new ArrayList<>();
        String hql = "from Representante as r "
                + " where r.id.jugadorCorreo =:nickUsuario"
                + " and r.contrasenia =:claveUsuario";
        try {
            transaccion.begin();
            Query q = sesion.createQuery(hql);
            q.setParameter("nickUsuario", o.getId().getCorreo());
            q.setParameter("claveUsuario", o.getRepresentante().getContrasenia());
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
    
    public static void main(String[] args) {
        RepresentanteDAO dao = new RepresentanteDAO();
        /*JugadorId id = new JugadorId("lkksdfk", "kklsdkfskl", 
                "lsmsdkfsdkl", "weojew@lksdfjsdk");
        Jugador jugador = new Jugador();
        jugador.setId(id);
        RepresentanteId idRep = new RepresentanteId("lkksdfk", "kklsdkfskl", 
                "lsmsdkfsdkl", "weojew@lksdfjsdk");
        Representante representante = new Representante(jugador, "root", "293843249832");
        representante.setId(idRep);
        jugador.setRepresentante(representante);
        List<Representante> listaCoords = dao.Login(jugador);
        if (listaCoords.size() > 0) {
            for (Representante rep : listaCoords) {
                System.out.println("Usuario: " + rep.getId().getJugadorCorreo());
                System.out.println("Clave: " + rep.getContrasenia());
            }
        }*/
    }
}
