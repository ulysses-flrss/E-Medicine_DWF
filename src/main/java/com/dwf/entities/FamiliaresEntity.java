package com.dwf.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "familiares", schema = "e-medicine2", catalog = "")
public class FamiliaresEntity {
    @Basic
    @Column(name = "codUsuario", nullable = false, length = 10)
    private String codUsuario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codFamiliar", nullable = false, length = 15)
    private String codFamiliar;
    @Basic
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    @Basic
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;
    @Basic
    @Column(name = "peso", nullable = false, precision = 0)
    private double peso;
    @Basic
    @Column(name = "altura", nullable = false, precision = 0)
    private double altura;
    @Basic
    @Column(name = "genero", nullable = false, length = 10)
    private String genero;
    @Basic
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;
    @OneToMany(mappedBy = "familiaresByCodFamiliar")
    private Collection<CitasEntity> citasByCodFamiliar;
    @ManyToOne
    @JoinColumn(name = "codUsuario", referencedColumnName = "codigo", nullable = false)
    private UsuariosEntity usuariosByCodUsuario;

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCodFamiliar() {
        return codFamiliar;
    }

    public void setCodFamiliar(String codFamiliar) {
        this.codFamiliar = codFamiliar;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamiliaresEntity that = (FamiliaresEntity) o;

        if (Double.compare(peso, that.peso) != 0) return false;
        if (Double.compare(altura, that.altura) != 0) return false;
        if (codUsuario != null ? !codUsuario.equals(that.codUsuario) : that.codUsuario != null) return false;
        if (codFamiliar != null ? !codFamiliar.equals(that.codFamiliar) : that.codFamiliar != null) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (genero != null ? !genero.equals(that.genero) : that.genero != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = codUsuario != null ? codUsuario.hashCode() : 0;
        result = 31 * result + (codFamiliar != null ? codFamiliar.hashCode() : 0);
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        temp = Double.doubleToLongBits(peso);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(altura);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        return result;
    }

    public Collection<CitasEntity> getCitasByCodFamiliar() {
        return citasByCodFamiliar;
    }

    public void setCitasByCodFamiliar(Collection<CitasEntity> citasByCodFamiliar) {
        this.citasByCodFamiliar = citasByCodFamiliar;
    }

    public UsuariosEntity getUsuariosByCodUsuario() {
        return usuariosByCodUsuario;
    }

    public void setUsuariosByCodUsuario(UsuariosEntity usuariosByCodUsuario) {
        this.usuariosByCodUsuario = usuariosByCodUsuario;
    }
}
