package es.uah.usuariosCriticas.dao;

import es.uah.usuariosCriticas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuariosDAOImpl implements IUsuariosDAO {

    @Autowired
    IUsuariosJPA usuariosJPA;

    @Autowired
    ICriticasJPA criticasJPA;

    @Override
    public List<Usuario> buscarTodos() {
        return usuariosJPA.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        Optional<Usuario> optional = usuariosJPA.findById(idUsuario);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Usuario> buscarUsuarioPorNombre(String nombre) {
        return usuariosJPA.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Usuario> buscarUsuarioPorCorreo(String correo) {
        return usuariosJPA.findByCorreoContainingIgnoreCase(correo);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuariosJPA.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuariosJPA.deleteById(idUsuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuariosJPA.save(usuario);
    }


    @Override
    public void eliminarCritica(Integer idUsuario, Integer idCritica) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario != null) {
            usuario.removeCritica(criticasJPA.findById(idCritica).orElse(null));
        }
        criticasJPA.deleteById(idCritica);
    }

    @Override
    public Usuario buscarUsuarioPorCorreoClave(String correo, String clave) {
        Optional<Usuario> optional = Optional.ofNullable(usuariosJPA.findByCorreoAndPassword(correo, clave));
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;

    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email){
        Optional<Usuario> optional = Optional.ofNullable(usuariosJPA.findByCorreo(email));
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;

    }

}
