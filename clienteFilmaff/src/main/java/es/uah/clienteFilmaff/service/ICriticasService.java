package es.uah.clienteFilmaff.service;

import es.uah.clienteFilmaff.model.Critica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICriticasService {

    Page<Critica> buscarTodas(Pageable pageable);

    Page<Critica> buscarCriticasPorIdPeliculaTabla(Integer idPelicula, Pageable pageable);

    Critica buscarCriticaPorId(Integer idCritica);

    String guardarCritica(Critica critica);

    void eliminarCritica(Integer idCritica);

}
