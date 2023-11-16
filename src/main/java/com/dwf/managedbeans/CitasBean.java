package com.dwf.managedbeans;

import com.dwf.entities.EspecialidadesEntity;
import com.dwf.entities.UsuariosEntity;
import com.dwf.models.UsuariosModel;
import com.dwf.entities.CitasEntity;
import com.dwf.models.CitasModel;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.event.AjaxBehaviorEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@ManagedBean
@RequestScoped
public class CitasBean {

    private CitasEntity cita = new CitasEntity();
    private UsuariosEntity usuario = new UsuariosEntity();
    private EspecialidadesEntity especialidad;
    private CitasModel model = new CitasModel();
    private UsuariosModel model2 = new UsuariosModel();

    private String codUsuario;
    private int codEspecialidad;

    private double peso;
    private double altura;

    public CitasBean() {


    }

    public String programarCita () {
        usuario = model2.obtenerUsuario(codUsuario);
        usuario.setAltura(altura);
        usuario.setPeso(peso);
        model.guardarCita(cita, usuario, codEspecialidad);
        return "index.xhtml?faces-redirect=true";
    }

    // Getters y Setters

    public CitasEntity getCita() {
        return cita;
    }

    public void setCita(CitasEntity cita) {
        this.cita = cita;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(int codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    public EspecialidadesEntity getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadesEntity especialidad) {
        this.especialidad = especialidad;
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

}
