package es.uah.usuariosCriticas.dao;

import es.uah.usuariosCriticas.model.Critica;
import es.uah.usuariosCriticas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CriticasDAOImpl implements ICriticasDAO {

    @Autowired
    ICriticasJPA criticasJPA;

    @Autowired
    IUsuariosJPA usuariosJPA;

    @Override
    public List<Critica> buscarTodas() {
        return criticasJPA.findAll();
    }

    @Override
    public List<Critica> buscarCriticasPorIdPelicula(Integer peliculaId) {
        return criticasJPA.findByPeliculaId(peliculaId);
    }

    @Override
    public Critica buscarCriticaPorId(Integer idCritica) {
        Optional<Critica> optional = criticasJPA.findById(idCritica);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Critica> buscarCriticasPorIdUsuario(Integer usuarioId) {
        Optional<Usuario> optional = usuariosJPA.findById(usuarioId);
        if(optional.isPresent()){
            return criticasJPA.findByUsuario(optional.get());
        }
        return null;
    }

    @Override
    public void guardarCritica(Critica critica) {
        criticasJPA.save(critica);
    }

    @Override
    public void eliminarCritica(Integer idCritica) {
        criticasJPA.deleteById(idCritica);
    }

}
