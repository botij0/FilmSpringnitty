package es.uah.usuariosCriticas.dao;

import es.uah.usuariosCriticas.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolesJPA extends JpaRepository<Rol, Integer> {
}
