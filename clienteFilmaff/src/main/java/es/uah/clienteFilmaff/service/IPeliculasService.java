package es.uah.clienteFilmaff.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import es.uah.clienteFilmaff.model.Pelicula;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPeliculasService {

    Page<Pelicula> buscarTodos(Pageable pageable);

    Pelicula buscarPeliculaPorId(Integer idPelicula);
    Page<Pelicula> buscarPeliculaPorTitulo (String titulo, Pageable pageable );

    Page<Pelicula> buscarPeliculaPorGenero (String genero, Pageable pageable);

    Page<Pelicula> buscarPeliculaPorActor (String actor, Pageable pageable);
    Page<Pelicula> buscarPeliculaPorAnio(Integer min, Integer max, Pageable pageable);

    void guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);
    public List<Integer> idActoresPelicula(Pelicula pelicula);
}
