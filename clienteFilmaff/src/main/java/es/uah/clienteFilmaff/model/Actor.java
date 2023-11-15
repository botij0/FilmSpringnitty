package es.uah.clienteFilmaff.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;

import java.sql.Date;
import java.util.List;

public class Actor {
    private Integer idActor;
    private String nombre;
    private Date fechaNac;
    private String paisNac;

    private String imagen;



    private List<Pelicula> peliculas;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Actor() {
    }

    public Actor(Integer idActor, String nombre, Date fechaNac, String paisNac, String imagen, List<Pelicula> peliculas) {
        this.idActor = idActor;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.paisNac = paisNac;
        this.imagen = imagen;
        this.peliculas = peliculas;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
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
