package com.ipn.mx.model.entities;
// Generated 28/03/2017 01:03:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Partido generated by hbm2java
 */
@Entity
@Table(name="partido"
    ,catalog="torneofutbol"
)
public class Partido  implements java.io.Serializable {


     private PartidoId id;
     private Evento evento;
     private Set partidoEquipos = new HashSet(0);

    public Partido() {
    }

	
    public Partido(PartidoId id, Evento evento) {
        this.id = id;
        this.evento = evento;
    }
    public Partido(PartidoId id, Evento evento, Set partidoEquipos) {
       this.id = id;
       this.evento = evento;
       this.partidoEquipos = partidoEquipos;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="horario", column=@Column(name="horario", nullable=false, length=19) ), 
        @AttributeOverride(name="eventoIdEvento", column=@Column(name="Evento_id_Evento", nullable=false) ), 
        @AttributeOverride(name="eventoTorneoIdTorneo", column=@Column(name="Evento_Torneo_id_Torneo", nullable=false) ) } )
    public PartidoId getId() {
        return this.id;
    }
    
    public void setId(PartidoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="Evento_id_Evento", referencedColumnName="id_Evento", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="Evento_Torneo_id_Torneo", referencedColumnName="Torneo_id_Torneo", nullable=false, insertable=false, updatable=false) } )
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="partido")
    public Set getPartidoEquipos() {
        return this.partidoEquipos;
    }
    
    public void setPartidoEquipos(Set partidoEquipos) {
        this.partidoEquipos = partidoEquipos;
    }




}


