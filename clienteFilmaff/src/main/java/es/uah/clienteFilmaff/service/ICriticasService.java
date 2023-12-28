package es.uah.clienteFilmaff.service;

import es.uah.clienteFilmaff.model.Critica;
import es.uah.clienteFilmaff.model.Pelicula;
import es.uah.clienteFilmaff.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICriticasService {

    Page<Critica> buscarTodas(Pageable pageable);

    Page<Critica> buscarCriticasPorIdPeliculaTabla(Integer idPelicula, Pageable pageable);

    Page<Critica> buscarCriticasPorIdUsuarioTabla(Integer idUsuario, Pageable pageable);

    List<Critica> buscarCriticaPorIdDetallePelicula(Integer idPelicula);

    String obtenerTituloPelicula(Critica critica, List<Pelicula> peliculas);

    List<Critica> buscarListaTodasCriticas();

    Critica buscarCriticaPorId(Integer idCritica);

    String guardarCritica(Critica critica);

    double obtenerNotaMediaCriticasPeliculaId(Integer idPelicula);

    void eliminarCritica(Integer idCritica);

}
