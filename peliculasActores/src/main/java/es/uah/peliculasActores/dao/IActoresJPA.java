package es.uah.peliculasActores.dao;

import java.util.List;
import es.uah.peliculasActores.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActoresJPA extends JpaRepository<Actor, Integer> {
    List<Actor> findByNombreContainingIgnoreCase(String nombre);
    //TODO: Añadir un método que sea necesario
}
