package es.uah.usuariosCriticas.service;

import es.uah.usuariosCriticas.model.Rol;

import java.util.List;

public interface IRolesService {

    List<Rol> buscarTodos();

    Rol buscarRolPorIdRol(Integer idRol);

    void guardarRol(Rol rol);

    void eliminarRol(Integer idRol);

}
