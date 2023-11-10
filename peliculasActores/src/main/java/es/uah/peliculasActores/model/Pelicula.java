package es.uah.peliculasActores.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name = "peliculas", schema = "peliculasactoresdb")
public class Pelicula {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPelicula")
    private Integer idPelicula;
    @Basic
    @Column(name = "titulo")
    private String titulo;
    @Basic
    @Column(name = "anio")
    private Integer anio;
    @Basic
    @Column(name = "duracion")
    private Integer duracion;
    @Basic
    @Column(name = "pais")
    private String pais;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "sinopsis")
    private String sinopsis;
    @Basic
    @Column(name = "imagen")
    private String imagen;
    @Basic
    @Column(name = "genero")
    private String genero;

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @ManyToMany(mappedBy = "peliculas")
    @JsonIgnoreProperties("peliculas")
    private List<Actor> actores;

    public List<Actor> getActores(){return actores;}

    public void setActores(List<Actor> actores){this.actores = actores;}

    public void addActor(Actor actor) {
        if (actor != null) {
            getActores().add(actor);
        }
    }

    public void removeActor(Actor actor) {
        if (actor != null) {
            getActores().remove(actor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(idPelicula, pelicula.idPelicula) && Objects.equals(titulo, pelicula.titulo) && Objects.equals(anio, pelicula.anio) && Objects.equals(duracion, pelicula.duracion) && Objects.equals(pais, pelicula.pais) && Objects.equals(direccion, pelicula.direccion) && Objects.equals(sinopsis, pelicula.sinopsis) && Objects.equals(imagen, pelicula.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, titulo, anio, duracion, pais, direccion, sinopsis, imagen);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
