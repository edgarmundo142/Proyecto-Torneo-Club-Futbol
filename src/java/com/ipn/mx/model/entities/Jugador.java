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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Jugador generated by hbm2java
 */
@Entity
@Table(name="jugador"
    ,catalog="torneofutbol"
)
public class Jugador  implements java.io.Serializable {


     private JugadorId id;
     private String foto;
     private String clave;
     private boolean estaVetado;
     private Representante representante;
     private Set<Equipo> equipos = new HashSet<Equipo>(0);

    public Jugador() {
    }

	
    public Jugador(JugadorId id, String foto, boolean estaVetado) {
        this.id = id;
        this.foto = foto;
        this.estaVetado = estaVetado;
    }
    public Jugador(JugadorId id, String foto, String clave, boolean estaVetado, Representante representante, Set<Equipo> equipos) {
       this.id = id;
       this.foto = foto;
       this.clave = clave;
       this.estaVetado = estaVetado;
       this.representante = representante;
       this.equipos = equipos;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="nombre", column=@Column(name="nombre", nullable=false, length=30) ), 
        @AttributeOverride(name="apellidoPaterno", column=@Column(name="apellidoPaterno", nullable=false, length=30) ), 
        @AttributeOverride(name="apellidoMaterno", column=@Column(name="apellidoMaterno", nullable=false, length=30) ), 
        @AttributeOverride(name="correo", column=@Column(name="correo", nullable=false, length=30) ) } )
    public JugadorId getId() {
        return this.id;
    }
    
    public void setId(JugadorId id) {
        this.id = id;
    }

    
    @Column(name="foto", nullable=false)
    public String getFoto() {
        return this.foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    @Column(name="clave", length=45)
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }

    
    @Column(name="estaVetado", nullable=false)
    public boolean isEstaVetado() {
        return this.estaVetado;
    }
    
    public void setEstaVetado(boolean estaVetado) {
        this.estaVetado = estaVetado;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="jugador")
    public Representante getRepresentante() {
        return this.representante;
    }
    
    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="jugador_equipo", catalog="torneofutbol", joinColumns = { 
        @JoinColumn(name="Jugador_nombre", nullable=false, updatable=false), 
        @JoinColumn(name="Jugador_apellidoPaterno", nullable=false, updatable=false), 
        @JoinColumn(name="Jugador_apellidoMaterno", nullable=false, updatable=false), 
        @JoinColumn(name="Jugador_correo", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Equipo_nombre", nullable=false, updatable=false) })
    public Set<Equipo> getEquipos() {
        return this.equipos;
    }
    
    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
    }

}


