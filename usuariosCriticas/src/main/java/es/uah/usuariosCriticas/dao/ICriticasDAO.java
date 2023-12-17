package es.uah.usuariosCriticas.dao;

import es.uah.usuariosCriticas.model.Critica;
import es.uah.usuariosCriticas.model.Usuario;

import java.util.List;

public interface ICriticasDAO {
    List<Critica> buscarTodas();

    List<Critica> buscarCriticasPorIdPelicula(Integer idPelicula);

    List<Critica> buscarCriticasPorIdUsuario(Integer usuarioId);

    Critica buscarCriticaPorId(Integer idCritica);

    void guardarCritica(Critica critica);

    void eliminarCritica(Integer idCritica);

}
