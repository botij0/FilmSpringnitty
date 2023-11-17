package es.uah.clienteFilmaff.service;

import es.uah.clienteFilmaff.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IActoresService {
    Page<Actor> buscarTodos(Pageable pageable);

    List<Actor> listaActores();

    Actor buscarActorPorId(Integer idActor);
    Page<Actor> buscarActorPorNombre(String nombre, Pageable pageable);
    void guardarActor(Actor actor);
    void eliminarActor(Integer idActor);
    void inscribirPelicula(Integer idActor, Integer idPelicula);


}
