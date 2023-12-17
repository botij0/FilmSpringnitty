package es.uah.usuariosCriticas.dao;

import es.uah.usuariosCriticas.model.Critica;
import es.uah.usuariosCriticas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICriticasJPA extends JpaRepository<Critica, Integer> {
    List<Critica> findByPeliculaId(int peliculaId);

    List<Critica> findByUsuario(Usuario usuario);
}
