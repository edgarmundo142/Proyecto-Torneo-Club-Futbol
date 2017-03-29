/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.DAO;

import com.ipn.mx.model.entities.Coordinador;
import com.ipn.mx.model.entities.Jugador;
import com.ipn.mx.model.entities.JugadorId;
import com.ipn.mx.model.entities.Representante;
import com.ipn.mx.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gava_
 */
public class LoginDAO {
    public int Login(Coordinador c) {
        int result=0;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaccion = sesion.getTransaction();
        List<Coordinador> c2 = new ArrayList<>();
        String hql = "from coordinador as c "
                + " where c.usuario =:user"
                + " and c.contrasenia =:password";
        try {
            transaccion.begin();
            Query q = sesion.createQuery(hql);
            q.setParameter("user", c.getUsuario());
            q.setParameter("password", c.getContrasenia());
            c2 = q.list();
            transaccion.commit();
            if(c2.get(0)!=null){
                result = 1;
            }else{
                transaccion = sesion.getTransaction();
                JugadorId jid = new JugadorId("","","",c.getUsuario());
                Jugador j = new Jugador (jid,"",false);
                Representante r = new Representante(j,c.getContrasenia(),"");
                List<Representante> r2 = new ArrayList<>();
                hql = "from representante as r "
                + " where r.jugador_nombre =:user"
                + " and r.contrasenia =:password";
                q = sesion.createQuery(hql);
                q.setParameter("user", r.getId().getJugadorCorreo());
                q.setParameter("password", r.getContrasenia());
                r2 = q.list();
                if(r2.get(0)!=null){
                    result = 2;
                }else
                    result = 0;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
        }
        return result;
    }
}
