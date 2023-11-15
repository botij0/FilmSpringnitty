package es.uah.peliculasActores.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "actores", schema = "peliculasactoresdb")
public class Actor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idActor")
    private Integer idActor;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "fechaNac")
    private Date fechaNac;
    @Basic
    @Column(name = "paisNac")
    private String paisNac;
    @Basic
    @Column(name = "imagen")
    private String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Actor(){

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


    @JoinTable(name = "peliculas_has_actores",
            joinColumns = { @JoinColumn(name = "idActores", referencedColumnName = "idActor") },
            inverseJoinColumns = {@JoinColumn(name = "idPeliculas", referencedColumnName = "idPelicula")})
    @ManyToMany
    @JsonIgnoreProperties("actores")
    private List<Pelicula> peliculas;

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void addPelicula(Pelicula pelicula){
        if (pelicula != null) {
            getPeliculas().add(pelicula);
            pelicula.addActor(this);
        }
    }

    public void removePelicula(Pelicula pelicula){
        if (pelicula != null) {
            pelicula.removeActor(this);
            getPeliculas().remove(pelicula);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(idActor, actor.idActor) && Objects.equals(nombre, actor.nombre) && Objects.equals(fechaNac, actor.fechaNac) && Objects.equals(paisNac, actor.paisNac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActor, nombre, fechaNac, paisNac);
    }
}
