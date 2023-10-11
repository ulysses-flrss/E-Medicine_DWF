package com.dwf.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "especialidades", schema = "e-medicine2", catalog = "")
public class EspecialidadesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "descripcion", nullable = false, length = -1)
    private String descripcion;
    @OneToMany(mappedBy = "especialidadesByCodEspecialidad")
    private Collection<CitasEntity> citasByCodigo;
    @OneToMany(mappedBy = "especialidadesByCodEspecialidad")
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EspecialidadesEntity that = (EspecialidadesEntity) o;

        if (codigo != that.codigo) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    public Collection<CitasEntity> getCitasByCodigo() {
        return citasByCodigo;
    }

    public void setCitasByCodigo(Collection<CitasEntity> citasByCodigo) {
        this.citasByCodigo = citasByCodigo;
    }

    public Collection<UsuariosEntity> getUsuariosByCodigo() {
        return usuariosByCodigo;
    }

    public void setUsuariosByCodigo(Collection<UsuariosEntity> usuariosByCodigo) {
        this.usuariosByCodigo = usuariosByCodigo;
    }
}
