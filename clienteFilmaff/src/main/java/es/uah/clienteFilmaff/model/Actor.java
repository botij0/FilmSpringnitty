package es.uah.clienteFilmaff.model;

import java.sql.Date;

public class Actor {
    private Integer idActor;
    private String nombre;
    private Date fechaNac;
    private String paisNac;

    public Actor() {
    }

    public Actor(Integer idActor, String nombre, Date fechaNac, String paisNac) {
        this.idActor = idActor;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.paisNac = paisNac;
    }

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPaisNac() {
        return paisNac;
    }

    public void setPaisNac(String paisNac) {
        this.paisNac = paisNac;
    }
}
