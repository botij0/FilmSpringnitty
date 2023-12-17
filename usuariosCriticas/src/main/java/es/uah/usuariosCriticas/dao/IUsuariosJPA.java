package es.uah.usuariosCriticas.dao;

import es.uah.usuariosCriticas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuariosJPA extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    List<Usuario> findByCorreoContainingIgnoreCase(String correo);

}
