package es.uah.peliculasActores.dao;

import es.uah.peliculasActores.model.Actor;
import es.uah.peliculasActores.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PeliculasDAOImpl implements IPeliculasDAO {

    @Autowired
    IPeliculasJPA peliculasJPA;

    @Override
    public List<Pelicula> buscarTodas(){
        return peliculasJPA.findAll();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula){
        Optional<Pelicula> optional = peliculasJPA.findById(idPelicula);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Pelicula> buscarPeliculasPorTitulo(String titulo){
        return peliculasJPA.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorGenero(String genero){
        return peliculasJPA.findByGeneroContainingIgnoreCase(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorAnio(Integer min, Integer max){
        return peliculasJPA.findByAnioBetween(min,max);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorActor(String actor){
        List<Pelicula> peliculaList = peliculasJPA.findAll();
        List<Pelicula> returnList = new ArrayList<>();

        for (Pelicula peli: peliculaList)
        {
            List<Actor> actoresPeli = peli.getActores();
            for (Actor actorInPeli: actoresPeli)
            {
                if(actorInPeli.getNombre().toLowerCase().contains(actor.toLowerCase())){
                    returnList.add(peli);
                    break;
                }
            }
        }
        return returnList;
    }

    @Override
    public void guardarPelicula(Pelicula pelicula){
        peliculasJPA.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula){
        Optional<Pelicula> optional = peliculasJPA.findById(idPelicula);
        if(optional.isPresent())
        {
            Pelicula pelicula = optional.get();
            List<Actor> actores = pelicula.getActores();
            actores.remove(pelicula);
            /*for(Actor actor: actores)
            {
                pelicula.removeActor(actor);
            }*/
        }
        peliculasJPA.deleteById(idPelicula);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula){
        peliculasJPA.save(pelicula);
    }
}
