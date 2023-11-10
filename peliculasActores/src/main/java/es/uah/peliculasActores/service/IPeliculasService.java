package es.uah.peliculasActores.service;

import es.uah.peliculasActores.model.Pelicula;

import java.util.List;

public interface IPeliculasService {
    List<Pelicula> buscarTodas();
    Pelicula buscarPeliculaPorId(Integer idPelicula);
    List<Pelicula> buscarPeliculasPorTitulo(String titulo);
    List<Pelicula> buscarPeliculasPorGenero(String genero);
    List<Pelicula> buscarPeliculasPorActor(String actor);
    void guardarPelicula(Pelicula pelicula);
    void actualizarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);

}
