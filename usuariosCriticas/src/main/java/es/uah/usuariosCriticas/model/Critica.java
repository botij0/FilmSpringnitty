package es.uah.usuariosCriticas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "criticas", schema = "usuariosfilmdbsec")
public class Critica {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCritica")
    private Integer idCritica;
    @Basic
    @Column(name = "peliculaId")
    private Integer peliculaId;
    @Basic
    @Column(name = "valoracion")
    private String valoracion;
    @Basic
    @Column(name = "nota")
    private Integer nota;
    @Basic
    @Column(name = "fecha")
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "Users_idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @JsonIgnoreProperties("criticas")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdCritica() {
        return idCritica;
    }

    public void setIdCritica(Integer idCritica) {
        this.idCritica = idCritica;
    }

    public Integer getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Critica critica = (Critica) o;
        return idCritica != null && Objects.equals(idCritica, critica.idCritica);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
