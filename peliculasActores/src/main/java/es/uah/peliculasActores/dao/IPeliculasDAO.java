package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Pelicula;

import java.util.List;

public interface IPeliculasDAO {
    List<Pelicula> buscarTodas();
    Pelicula buscarPeliculaPorId(Integer idPelicula);
    List<Pelicula> buscarPeliculasPorTitulo(String titulo);
    List<Pelicula> buscarPeliculasPorGenero(String genero);
    List<Pelicula> buscarPeliculasPorActor(String actor);
    List<Pelicula> buscarPeliculaPorAnio(Integer min, Integer max);
    void guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);
    void actualizarPelicula(Pelicula pelicula);

}
