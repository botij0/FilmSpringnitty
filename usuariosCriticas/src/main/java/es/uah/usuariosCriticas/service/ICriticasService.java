package es.uah.usuariosCriticas.service;

import es.uah.usuariosCriticas.model.Critica;

import java.util.List;

public interface ICriticasService {
    List<Critica> buscarTodas();

    List<Critica> buscarCriticasPorIdPelicula(Integer idPelicula);

    List<Critica> buscarCriticasPorIdUsuario(Integer idUsuario);

    Critica buscarCriticaPorId(Integer idCritica);

    void guardarCritica(Critica critica);

    void eliminarCritica(Integer idCritica);
}
