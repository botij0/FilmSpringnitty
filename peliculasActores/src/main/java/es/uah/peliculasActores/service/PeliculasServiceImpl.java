package es.uah.peliculasActores.service;

import es.uah.peliculasActores.dao.IPeliculasDAO;
import es.uah.peliculasActores.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculasServiceImpl implements IPeliculasService {
    @Autowired
    IPeliculasDAO peliculasDAO;

    @Override
    public List<Pelicula> buscarTodas(){
        return peliculasDAO.buscarTodas();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        return peliculasDAO.buscarPeliculaPorId(idPelicula);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorTitulo(String titulo) {
        return peliculasDAO.buscarPeliculasPorTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorGenero(String genero) {
        return peliculasDAO.buscarPeliculasPorGenero(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorActor(String actor){
        return peliculasDAO.buscarPeliculasPorActor(actor);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula){
        if(peliculasDAO.buscarPeliculaPorId(pelicula.getIdPelicula()) == null)
        {
            peliculasDAO.guardarPelicula(pelicula);
        }
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula){
        if(peliculasDAO.buscarPeliculaPorId(pelicula.getIdPelicula()) != null)
        {
            peliculasDAO.actualizarPelicula(pelicula);
        }
    }

    @Override
    public void eliminarPelicula(Integer idPelicula){
        if(peliculasDAO.buscarPeliculaPorId(idPelicula) != null)
        {
            peliculasDAO.eliminarPelicula(idPelicula);
        }
    }
}
