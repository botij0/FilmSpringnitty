package es.uah.usuariosCriticas.service;

import es.uah.usuariosCriticas.dao.IRolesDAO;
import es.uah.usuariosCriticas.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    IRolesDAO rolDAO;

    @Override
    public List<Rol> buscarTodos() {
        return rolDAO.buscarTodos();
    }

    @Override
    public Rol buscarRolPorIdRol(Integer idRol) {
        return rolDAO.buscarRolPorIdRol(idRol);
    }

    @Override
    public void guardarRol(Rol rol) {
        rolDAO.guardarRol(rol);
    }

    @Override
    public void eliminarRol(Integer idRol) {
        rolDAO.eliminarRol(idRol);
    }

}
