package com.dwf.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "citas", schema = "e-medicine2", catalog = "")
public class CitasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCita", nullable = false)
    private int idCita;
    @Basic
    @Column(name = "codPaciente", nullable = false, length = 10)
    private String codPaciente;
    @Basic
    @Column(name = "codDoctor", nullable = true, length = 10)
    private String codDoctor;
    @Basic
    @Column(name = "codEspecialidad", nullable = false)
    private int codEspecialidad;
    @Basic
    @Column(name = "fechaCita", nullable = false)
    private Date fechaCita;
    @Basic
    @Column(name = "horaCita", nullable = false)
    private Time horaCita;
    @Basic
    @Column(name = "sintomas", nullable = true, length = -1)
    private String sintomas;
    @Basic
    @Column(name = "razonCita", nullable = false, length = -1)
    private String razonCita;
    @Basic
    @Column(name = "codFamiliar", nullable = true, length = 15)
    private String codFamiliar;
    @Basic
    @Column(name = "estado", nullable = false, length = 30)
    private String estado;
    @Basic
    @Column(name = "justificante", nullable = true, length = -1)
    private String justificante;
    @ManyToOne
    @JoinColumn(name = "codPaciente", referencedColumnName = "codigo", nullable = false)
    private UsuariosEntity usuariosByCodPaciente;
    @ManyToOne
    @JoinColumn(name = "codDoctor", referencedColumnName = "codigo")
    private UsuariosEntity usuariosByCodDoctor;
    @ManyToOne
    @JoinColumn(name = "codEspecialidad", referencedColumnName = "codigo", nullable = false)
    private EspecialidadesEntity especialidadesByCodEspecialidad;
    @ManyToOne
    @JoinColumn(name = "codFamiliar", referencedColumnName = "codFamiliar")
    private FamiliaresEntity familiaresByCodFamiliar;

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(String codPaciente) {
        this.codPaciente = codPaciente;
    }

    public String getCodDoctor() {
        return codDoctor;
    }

    public void setCodDoctor(String codDoctor) {
        this.codDoctor = codDoctor;
    }

    public int getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(int codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Time getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Time horaCita) {
        this.horaCita = horaCita;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getRazonCita() {
        return razonCita;
    }

    public void setRazonCita(String razonCita) {
        this.razonCita = razonCita;
    }

    public String getCodFamiliar() {
        return codFamiliar;
    }

    public void setCodFamiliar(String codFamiliar) {
        this.codFamiliar = codFamiliar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getJustificante() {
        return justificante;
    }

    public void setJustificante(String justificante) {
        this.justificante = justificante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitasEntity that = (CitasEntity) o;

        if (idCita != that.idCita) return false;
        if (codEspecialidad != that.codEspecialidad) return false;
        if (codPaciente != null ? !codPaciente.equals(that.codPaciente) : that.codPaciente != null) return false;
        if (codDoctor != null ? !codDoctor.equals(that.codDoctor) : that.codDoctor != null) return false;
        if (fechaCita != null ? !fechaCita.equals(that.fechaCita) : that.fechaCita != null) return false;
        if (horaCita != null ? !horaCita.equals(that.horaCita) : that.horaCita != null) return false;
        if (sintomas != null ? !sintomas.equals(that.sintomas) : that.sintomas != null) return false;
        if (razonCita != null ? !razonCita.equals(that.razonCita) : that.razonCita != null) return false;
        if (codFamiliar != null ? !codFamiliar.equals(that.codFamiliar) : that.codFamiliar != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (justificante != null ? !justificante.equals(that.justificante) : that.justificante != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCita;
        result = 31 * result + (codPaciente != null ? codPaciente.hashCode() : 0);
        result = 31 * result + (codDoctor != null ? codDoctor.hashCode() : 0);
        result = 31 * result + codEspecialidad;
        result = 31 * result + (fechaCita != null ? fechaCita.hashCode() : 0);
        result = 31 * result + (horaCita != null ? horaCita.hashCode() : 0);
        result = 31 * result + (sintomas != null ? sintomas.hashCode() : 0);
        result = 31 * result + (razonCita != null ? razonCita.hashCode() : 0);
        result = 31 * result + (codFamiliar != null ? codFamiliar.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (justificante != null ? justificante.hashCode() : 0);
        return result;
    }

    public UsuariosEntity getUsuariosByCodPaciente() {
        return usuariosByCodPaciente;
    }

    public void setUsuariosByCodPaciente(UsuariosEntity usuariosByCodPaciente) {
        this.usuariosByCodPaciente = usuariosByCodPaciente;
    }

    public UsuariosEntity getUsuariosByCodDoctor() {
        return usuariosByCodDoctor;
    }

    public void setUsuariosByCodDoctor(UsuariosEntity usuariosByCodDoctor) {
        this.usuariosByCodDoctor = usuariosByCodDoctor;
    }

    public EspecialidadesEntity getEspecialidadesByCodEspecialidad() {
        return especialidadesByCodEspecialidad;
    }

    public void setEspecialidadesByCodEspecialidad(EspecialidadesEntity especialidadesByCodEspecialidad) {
        this.especialidadesByCodEspecialidad = especialidadesByCodEspecialidad;
    }

    public FamiliaresEntity getFamiliaresByCodFamiliar() {
        return familiaresByCodFamiliar;
    }

    public void setFamiliaresByCodFamiliar(FamiliaresEntity familiaresByCodFamiliar) {
        this.familiaresByCodFamiliar = familiaresByCodFamiliar;
    }
}
