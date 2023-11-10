package es.uah.peliculasActores.service;

import es.uah.peliculasActores.dao.ActoresDAOImpl;
import es.uah.peliculasActores.dao.IActoresDAO;
import es.uah.peliculasActores.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActoresServiceImpl implements IActoresService {
    @Autowired
    IActoresDAO actoresDAO;

    @Override
    public List<Actor> buscarTodos(){
        return actoresDAO.buscarTodos();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor){
        return actoresDAO.buscarActorPorId(idActor);
    }

    @Override
    public List<Actor> buscarActorPorNombre(String nombre){
        return actoresDAO.buscarActorPorNombre(nombre);
    }

    @Override
    public void guardarActor(Actor actor){
        actoresDAO.guardarActor(actor);
    }

    @Override
    public void eliminarActor(Integer idActor){
        actoresDAO.eliminarActor(idActor);
    }

    @Override
    public void actualizarActor(Actor actor){
        actoresDAO.actualizarActor(actor);
    }

    @Override
    public void aniadirRepartoActor(Integer idActor, Integer idPelicula){
        actoresDAO.aniadirRepartoActor(idActor,idPelicula);
    }
}
