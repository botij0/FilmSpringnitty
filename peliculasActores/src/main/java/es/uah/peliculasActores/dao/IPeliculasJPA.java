package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPeliculasJPA extends JpaRepository<Pelicula, Integer> {

    List<Pelicula> findByTituloContainingIgnoreCase(String nombre);
    List<Pelicula> findByGeneroContainingIgnoreCase(String genero);
    List<Pelicula> findByActoresContainingIgnoreCase(String actor);
}
