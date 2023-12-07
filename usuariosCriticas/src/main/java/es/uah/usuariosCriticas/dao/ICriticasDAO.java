package es.uah.usuariosCriticas.dao;

import es.uah.usuariosCriticas.model.Critica;

import java.util.List;

public interface ICriticasDAO {
    List<Critica> buscarTodas();

    List<Critica> buscarCriticasPorIdPelicula(Integer idPelicula);

    Critica buscarCriticaPorId(Integer idCritica);

    void guardarCritica(Critica critica);

    void eliminarCritica(Integer idCritica);

}
