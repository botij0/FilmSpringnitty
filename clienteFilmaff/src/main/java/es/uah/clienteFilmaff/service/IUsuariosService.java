package es.uah.clienteFilmaff.service;

import es.uah.clienteFilmaff.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuariosService {

    Page<Usuario> buscarTodos(Pageable pageable);

    List<Usuario> buscarTodosLista();

    Usuario buscarUsuarioPorId(Integer idUsuario);

    Page<Usuario> buscarUsuariosPorNombre(String nombre, Pageable pageable);

    Usuario buscarUsuarioPorCorreo(String correo);
    Page<Usuario> buscarUsuariosPorCorreo(String correo, Pageable pageable);

    void guardarUsuario(Usuario usuario);

    void eliminarUsuario(Integer idUsuario);

}
