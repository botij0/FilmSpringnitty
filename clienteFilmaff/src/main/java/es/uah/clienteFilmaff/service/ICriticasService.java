package es.uah.clienteFilmaff.service;

import es.uah.clienteFilmaff.model.Critica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICriticasService {

    Page<Critica> buscarTodas(Pageable pageable);

    Page<Critica> buscarCriticasPorIdPelicula(Integer idPelicula, Pageable pageable);

    Critica buscarCriticaPorId(Integer idCritica);

    String guardarCritica(Critica critica);

    void eliminarCritica(Integer idCritica);

}
