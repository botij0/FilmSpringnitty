package es.uah.usuariosCriticas.model;

import jakarta.persistence.*;

@Entity
@Table(name="Authorities", schema = "usuariosfilmdbsec")
public class Rol {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idRol")
    private Integer id;
    @Basic
    @Column(name = "authority")
    private String authority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
