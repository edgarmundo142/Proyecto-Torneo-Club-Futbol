package com.ipn.mx.model.entities;
// Generated 28/03/2017 01:03:57 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Evento generated by hbm2java
 */
@Entity
@Table(name="evento"
    ,catalog="torneofutbol"
)
public class Evento  implements java.io.Serializable {


     private EventoId id;
     private Torneo torneo;
     private String tipoEvento;
     private Date fechaFin;
     private Date fechaInicio;
     private Set partidos = new HashSet(0);

    public Evento() {
    }

	
    public Evento(EventoId id, Torneo torneo, Date fechaFin, Date fechaInicio) {
        this.id = id;
        this.torneo = torneo;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
    }
    public Evento(EventoId id, Torneo torneo, String tipoEvento, Date fechaFin, Date fechaInicio, Set partidos) {
       this.id = id;
       this.torneo = torneo;
       this.tipoEvento = tipoEvento;
       this.fechaFin = fechaFin;
       this.fechaInicio = fechaInicio;
       this.partidos = partidos;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idEvento", column=@Column(name="id_Evento", nullable=false) ), 
        @AttributeOverride(name="torneoIdTorneo", column=@Column(name="Torneo_id_Torneo", nullable=false) ) } )
    public EventoId getId() {
        return this.id;
    }
    
    public void setId(EventoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Torneo_id_Torneo", nullable=false, insertable=false, updatable=false)
    public Torneo getTorneo() {
        return this.torneo;
    }
    
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    
    @Column(name="tipoEvento", length=50)
    public String getTipoEvento() {
        return this.tipoEvento;
    }
    
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaFin", nullable=false, length=19)
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaInicio", nullable=false, length=19)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="evento")
    public Set getPartidos() {
        return this.partidos;
    }
    
    public void setPartidos(Set partidos) {
        this.partidos = partidos;
    }




}

