package com.ipn.mx.model.entities;
// Generated 28/03/2017 01:03:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Equipo generated by hbm2java
 */
@Entity
@Table(name="equipo"
    ,catalog="torneofutbol"
)
public class Equipo  implements java.io.Serializable {


     private String nombre;
     private Torneo torneo;
     private String colorDeUniforme;
     private String grupo;
     private boolean estaPendiente;
     private Integer puntos;
     private int partidosJugados;
     private Integer golesAfavor;
     private Integer golesEnContra;
     private Set partidoEquipos = new HashSet(0);
     private Set jugadors = new HashSet(0);

    public Equipo() {
    }

	
    public Equipo(String nombre, Torneo torneo, String colorDeUniforme, boolean estaPendiente, int partidosJugados) {
        this.nombre = nombre;
        this.torneo = torneo;
        this.colorDeUniforme = colorDeUniforme;
        this.estaPendiente = estaPendiente;
        this.partidosJugados = partidosJugados;
    }
    public Equipo(String nombre, Torneo torneo, String colorDeUniforme, String grupo, boolean estaPendiente, Integer puntos, int partidosJugados, Integer golesAfavor, Integer golesEnContra, Set partidoEquipos, Set jugadors) {
       this.nombre = nombre;
       this.torneo = torneo;
       this.colorDeUniforme = colorDeUniforme;
       this.grupo = grupo;
       this.estaPendiente = estaPendiente;
       this.puntos = puntos;
       this.partidosJugados = partidosJugados;
       this.golesAfavor = golesAfavor;
       this.golesEnContra = golesEnContra;
       this.partidoEquipos = partidoEquipos;
       this.jugadors = jugadors;
    }
   
     @Id 

    
    @Column(name="nombre", unique=true, nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Torneo_id_Torneo", nullable=false)
    public Torneo getTorneo() {
        return this.torneo;
    }
    
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    
    @Column(name="colorDeUniforme", nullable=false, length=30)
    public String getColorDeUniforme() {
        return this.colorDeUniforme;
    }
    
    public void setColorDeUniforme(String colorDeUniforme) {
        this.colorDeUniforme = colorDeUniforme;
    }

    
    @Column(name="grupo", length=30)
    public String getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    
    @Column(name="estaPendiente", nullable=false)
    public boolean isEstaPendiente() {
        return this.estaPendiente;
    }
    
    public void setEstaPendiente(boolean estaPendiente) {
        this.estaPendiente = estaPendiente;
    }

    
    @Column(name="puntos")
    public Integer getPuntos() {
        return this.puntos;
    }
    
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    
    @Column(name="partidosJugados", nullable=false)
    public int getPartidosJugados() {
        return this.partidosJugados;
    }
    
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    
    @Column(name="golesAFavor")
    public Integer getGolesAfavor() {
        return this.golesAfavor;
    }
    
    public void setGolesAfavor(Integer golesAfavor) {
        this.golesAfavor = golesAfavor;
    }

    
    @Column(name="golesEnContra")
    public Integer getGolesEnContra() {
        return this.golesEnContra;
    }
    
    public void setGolesEnContra(Integer golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="equipo")
    public Set getPartidoEquipos() {
        return this.partidoEquipos;
    }
    
    public void setPartidoEquipos(Set partidoEquipos) {
        this.partidoEquipos = partidoEquipos;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="jugador_equipo", catalog="torneofutbol", joinColumns = { 
        @JoinColumn(name="Equipo_nombre", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Jugador_nombre", nullable=false, updatable=false) })
    public Set getJugadors() {
        return this.jugadors;
    }
    
    public void setJugadors(Set jugadors) {
        this.jugadors = jugadors;
    }




}


