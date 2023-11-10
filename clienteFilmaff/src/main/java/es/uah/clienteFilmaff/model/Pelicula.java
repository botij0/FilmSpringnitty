package es.uah.clienteFilmaff.model;

import java.util.List;
public class Pelicula {

    private Integer idPelicula;
    private String titulo;
    private Integer anio;
    private Integer duracion;
    private String pais;
    private String direccion;
    private String sinopsis;
    private String imagen;
    private String genero;
    private List<Actor> actores;

    public Pelicula() {
    }

    public Pelicula(Integer idPelicula, String titulo, Integer anio, Integer duracion, String pais,
                    String direccion,String sinopsis, String imagen, String genero, List<Actor> actores)
    {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.anio = anio;
        this.duracion = duracion;
        this.pais = pais;
        this.direccion = direccion;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
        this.genero = genero;
        this.actores = actores;
    }

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }


}
