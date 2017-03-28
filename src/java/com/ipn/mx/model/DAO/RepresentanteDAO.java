package com.ipn.mx.model.DAO;

import com.ipn.mx.model.entities.Equipo;
import com.ipn.mx.model.entities.Jugador;
import com.ipn.mx.model.entities.JugadorId;
import com.ipn.mx.model.entities.Mensaje;
import com.ipn.mx.model.entities.Representante;
import com.ipn.mx.model.entities.RepresentanteId;

import com.ipn.mx.utilities.HibernateUtil;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author rafael
 */
public class RepresentanteDAO {
    public void guardarRepresentante (Representante representante, Jugador datosRepresentante) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            //guardarDatosDeJugador(datosRepresentante);
            transaccion.begin();
            sesion.save(representante);
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
    }
    
    private void guardarDatosDeJugador (Jugador datosRepresentante) {
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        try {
            transaccion.begin();
            sesion.save(datosRepresentante);
            transaccion.commit();
        } catch (HibernateException e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
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
	public Set<Jugador> verPlantillaDeEquipo(Equipo equipo) {
		// TODO - implement Representante.verPlantillaDeEquipo
		throw new UnsupportedOperationException();
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
    
    public static void main(String[] args) {
        RepresentanteDAO t = new RepresentanteDAO();
        JugadorId id = new JugadorId("Nombre2", "Apellido Paterno2", "Apellido Materno2", "Correo1@jugador2");
        Jugador jugador = new Jugador(id, "Foto.jpg", false);
        RepresentanteId idRep = new RepresentanteId(jugador.getId().getNombre(), jugador.getId().getApellidoPaterno(), 
                jugador.getId().getApellidoMaterno(), jugador.getId().getCorreo());
        Representante representante = new Representante(jugador, "******", "0445455555555");
        representante.setId(idRep);
        jugador.setRepresentante(representante);
        t.guardarRepresentante(representante, jugador);
        System.out.println("Hecho!!!");
    }
}
