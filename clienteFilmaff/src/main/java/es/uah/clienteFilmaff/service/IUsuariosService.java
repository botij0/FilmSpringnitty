package es.uah.clienteFilmaff.service;

import es.uah.clienteFilmaff.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IUsuariosService {

    Page<Usuario> buscarTodos(Pageable pageable);

    Usuario login(String correo, String clave);

    List<Usuario> buscarTodosLista();

    Usuario buscarUsuarioPorId(Integer idUsuario);

    Usuario buscarUsuarioAutenticado(Authentication authentication);

    Usuario buscarUsuarioPorUsername(String nombre);

    Page<Usuario> buscarUsuariosPorNombre(String nombre, Pageable pageable);

    Usuario buscarUsuarioPorCorreo(String correo);
    Page<Usuario> buscarUsuariosPorCorreo(String correo, Pageable pageable);

    void guardarUsuario(Usuario usuario);

    void eliminarUsuario(Integer idUsuario);

}
