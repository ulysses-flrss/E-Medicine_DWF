package com.dwf.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "roles", schema = "e-medicine2", catalog = "")
public class RolesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @OneToMany(mappedBy = "rolesByCodRol")
    private Collection<UsuariosEntity> usuariosByCodigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (codigo != that.codigo) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    public Collection<UsuariosEntity> getUsuariosByCodigo() {
        return usuariosByCodigo;
    }

    public void setUsuariosByCodigo(Collection<UsuariosEntity> usuariosByCodigo) {
        this.usuariosByCodigo = usuariosByCodigo;
    }
}
