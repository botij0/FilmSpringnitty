package es.uah.clienteFilmaff.model;

import java.util.List;

public class Usuario {
    private Integer idUsuario;
    private String nombre;
    private String password;
    private String correo;
    private boolean enable;
    private List<Rol> roles;
    private List<Critica> criticas;

    public Usuario(Integer idUsuario, String nombre, String password, String correo, boolean enable, List<Rol> roles, List<Critica> criticas) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.enable = enable;
        this.roles = roles;
        this.criticas = criticas;
    }

    public Usuario() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<Critica> criticas) {
        this.criticas = criticas;
    }
}
