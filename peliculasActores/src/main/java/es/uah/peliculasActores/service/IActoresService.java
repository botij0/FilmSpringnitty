package es.uah.peliculasActores.service;

import es.uah.peliculasActores.model.Actor;
import java.util.List;

public interface IActoresService {
    List<Actor> buscarTodos();
    Actor buscarActorPorId(Integer idActor);
    List<Actor> buscarActorPorNombre(String nombre);
    void guardarActor(Actor actor);
    void eliminarActor(Integer idActor);
    void actualizarActor(Actor actor);
    void aniadirRepartoActor(Integer idActor, Integer idPelicula);
}
