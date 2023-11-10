package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Actor;

import java.util.List;

public interface IActoresDAO {
    List<Actor> buscarTodos();
    Actor buscarActorPorId(Integer idActor);
    List<Actor> buscarActorPorNombre(String nombre);
    void guardarActor(Actor actor);
    void eliminarActor(Integer idActor);
    void actualizarActor(Actor actor);
    void aniadirRepartoActor(Integer idActor, Integer idPelicula);

}
