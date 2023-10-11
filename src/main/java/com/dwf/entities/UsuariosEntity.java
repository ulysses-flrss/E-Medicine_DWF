package com.dwf.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "usuarios", schema = "e-medicine2", catalog = "")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;
    @Basic
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    @Basic
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;
    @Basic
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    @Basic
    @Column(name = "pass", nullable = false, length = 20)
    private String pass;
    @Basic
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;
    @Basic
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;
    @Basic
    @Column(name = "peso", nullable = true, precision = 0)
    private Double peso;
    @Basic
    @Column(name = "altura", nullable = true, precision = 0)
    private Double altura;
    @Basic
    @Column(name = "genero", nullable = true, length = 10)
    private String genero;
    @Basic
    @Column(name = "municipio", nullable = true, length = 50)
    private String municipio;
    @Basic
    @Column(name = "codEspecialidad", nullable = true)
    private Integer codEspecialidad;
    @Basic
    @Column(name = "codRol", nullable = true)
    private Integer codRol;
    @OneToMany(mappedBy = "usuariosByCodUsuario")
    private Collection<AnunciosEntity> anunciosByCodigo;
    @OneToMany(mappedBy = "usuariosByCodPaciente")
    private Collection<CitasEntity> citasByCodigo;
    @OneToMany(mappedBy = "usuariosByCodDoctor")
    private Collection<CitasEntity> citasByCodigo_0;
    @OneToMany(mappedBy = "usuariosByCodUsuario")
    private Collection<FamiliaresEntity> familiaresByCodigo;
    @ManyToOne
    @JoinColumn(name = "codEspecialidad", referencedColumnName = "codigo")
    private EspecialidadesEntity especialidadesByCodEspecialidad;
    @ManyToOne
    @JoinColumn(name = "codRol", referencedColumnName = "codigo")
    private RolesEntity rolesByCodRol;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(Integer codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public Integer getCodRol() {
        return codRol;
    }

    public void setCodRol(Integer codRol) {
        this.codRol = codRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosEntity that = (UsuariosEntity) o;

        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;
        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (pass != null ? !pass.equals(that.pass) : that.pass != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (dui != null ? !dui.equals(that.dui) : that.dui != null) return false;
        if (peso != null ? !peso.equals(that.peso) : that.peso != null) return false;
        if (altura != null ? !altura.equals(that.altura) : that.altura != null) return false;
        if (genero != null ? !genero.equals(that.genero) : that.genero != null) return false;
        if (municipio != null ? !municipio.equals(that.municipio) : that.municipio != null) return false;
        if (codEspecialidad != null ? !codEspecialidad.equals(that.codEspecialidad) : that.codEspecialidad != null)
            return false;
        if (codRol != null ? !codRol.equals(that.codRol) : that.codRol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (dui != null ? dui.hashCode() : 0);
        result = 31 * result + (peso != null ? peso.hashCode() : 0);
        result = 31 * result + (altura != null ? altura.hashCode() : 0);
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (municipio != null ? municipio.hashCode() : 0);
        result = 31 * result + (codEspecialidad != null ? codEspecialidad.hashCode() : 0);
        result = 31 * result + (codRol != null ? codRol.hashCode() : 0);
        return result;
    }

    public Collection<AnunciosEntity> getAnunciosByCodigo() {
        return anunciosByCodigo;
    }

    public void setAnunciosByCodigo(Collection<AnunciosEntity> anunciosByCodigo) {
        this.anunciosByCodigo = anunciosByCodigo;
    }

    public Collection<CitasEntity> getCitasByCodigo() {
        return citasByCodigo;
    }

    public void setCitasByCodigo(Collection<CitasEntity> citasByCodigo) {
        this.citasByCodigo = citasByCodigo;
    }

    public Collection<CitasEntity> getCitasByCodigo_0() {
        return citasByCodigo_0;
    }

    public void setCitasByCodigo_0(Collection<CitasEntity> citasByCodigo_0) {
        this.citasByCodigo_0 = citasByCodigo_0;
    }

    public Collection<FamiliaresEntity> getFamiliaresByCodigo() {
        return familiaresByCodigo;
    }

    public void setFamiliaresByCodigo(Collection<FamiliaresEntity> familiaresByCodigo) {
        this.familiaresByCodigo = familiaresByCodigo;
    }

    public EspecialidadesEntity getEspecialidadesByCodEspecialidad() {
        return especialidadesByCodEspecialidad;
    }

    public void setEspecialidadesByCodEspecialidad(EspecialidadesEntity especialidadesByCodEspecialidad) {
        this.especialidadesByCodEspecialidad = especialidadesByCodEspecialidad;
    }

    public RolesEntity getRolesByCodRol() {
        return rolesByCodRol;
    }

    public void setRolesByCodRol(RolesEntity rolesByCodRol) {
        this.rolesByCodRol = rolesByCodRol;
    }
}
