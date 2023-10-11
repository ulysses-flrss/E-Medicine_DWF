package com.dwf.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "anuncios", schema = "e-medicine2", catalog = "")
public class AnunciosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "codUsuario", nullable = false, length = 10)
    private String codUsuario;
    @Basic
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;
    @Basic
    @Column(name = "contenido", nullable = false, length = -1)
    private String contenido;
    @Basic
    @Column(name = "fechaPublicacion", nullable = false)
    private Timestamp fechaPublicacion;
    @ManyToOne
    @JoinColumn(name = "codUsuario", referencedColumnName = "codigo", nullable = false)
    private UsuariosEntity usuariosByCodUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnunciosEntity that = (AnunciosEntity) o;

        if (id != that.id) return false;
        if (codUsuario != null ? !codUsuario.equals(that.codUsuario) : that.codUsuario != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (contenido != null ? !contenido.equals(that.contenido) : that.contenido != null) return false;
        if (fechaPublicacion != null ? !fechaPublicacion.equals(that.fechaPublicacion) : that.fechaPublicacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (codUsuario != null ? codUsuario.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (contenido != null ? contenido.hashCode() : 0);
        result = 31 * result + (fechaPublicacion != null ? fechaPublicacion.hashCode() : 0);
        return result;
    }

    public UsuariosEntity getUsuariosByCodUsuario() {
        return usuariosByCodUsuario;
    }

    public void setUsuariosByCodUsuario(UsuariosEntity usuariosByCodUsuario) {
        this.usuariosByCodUsuario = usuariosByCodUsuario;
    }
}
