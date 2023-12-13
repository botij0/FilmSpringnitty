package es.uah.usuariosCriticas.controller;


import es.uah.usuariosCriticas.model.Rol;
import es.uah.usuariosCriticas.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolesController {
    @Autowired
    IRolesService rolesService;

    @GetMapping("/roles")
    public List<Rol> buscarTodos() {
        return rolesService.buscarTodos();
    }

    @GetMapping("/roles/{idRol}")
    public Rol buscarRolPorId(@PathVariable("idRol") Integer idRol) {
        return rolesService.buscarRolPorIdRol(idRol);
    }

    @PostMapping("/roles")
    public void guardarRol(@RequestBody Rol rol) {
        rolesService.guardarRol(rol);
    }

    @DeleteMapping("/roles/{idRol}")
    public void eliminarRol(@PathVariable("idRol") Integer idRol) {
        rolesService.eliminarRol(idRol);
    }
}
