package es.uah.clienteFilmaff.service;

import org.springframework.data.domain.Page;
import es.uah.clienteFilmaff.model.Pelicula;
import org.springframework.data.domain.Pageable;

public interface IPeliculasService {

    Page<Pelicula> buscarTodos(Pageable pageable);

    Pelicula buscarPeliculaPorId(Integer idPelicula);
    Page<Pelicula> buscarPeliculaPorTitulo (String titulo, Pageable pageable );

    Page<Pelicula> buscarPeliculaPorGenero (String genero, Pageable pageable);

    Page<Pelicula> buscarPeliculaPorActor (String actor, Pageable pageable);

    void guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);
}
