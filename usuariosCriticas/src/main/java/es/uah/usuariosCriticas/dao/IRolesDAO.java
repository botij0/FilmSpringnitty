package es.uah.usuariosCriticas.dao;

import es.uah.usuariosCriticas.model.Rol;

import java.util.List;

public interface IRolesDAO {
    List<Rol> buscarTodos();

    Rol buscarRolPorIdRol(Integer idRol);

    void guardarRol(Rol rol);

    void eliminarRol(Integer idRol);
}
