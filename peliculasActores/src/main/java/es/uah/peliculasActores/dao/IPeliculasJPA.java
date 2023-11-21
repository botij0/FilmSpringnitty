package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Pelicula;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPeliculasJPA extends JpaRepository<Pelicula, Integer> {

    List<Pelicula> findByTituloContainingIgnoreCase(String nombre);
    List<Pelicula> findByGeneroContainingIgnoreCase(String genero);
    List<Pelicula> findByAnioBetween(Integer min, Integer max);
    List<Pelicula> findByActoresContainingIgnoreCase(String actor);
}
