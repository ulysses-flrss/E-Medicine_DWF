package com.dwf.managedbeans;

import com.dwf.entities.UsuariosEntity;
import com.dwf.models.UsuariosModel;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.event.AjaxBehaviorEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@ManagedBean
@RequestScoped
public class UsuariosBean {
    private int codRol;
    private int codEspecialidad;
    private UsuariosEntity usuario;
    private UsuariosModel model;
    private List<UsuariosEntity> listUsers;

    public UsuariosBean() {
    }

    public void crearCodigo(AjaxBehaviorEvent e) {
        String tipo = null, codigo = "";
        boolean salir = false;
        do {
            switch (getCodRol()) {
                case 1:
                    tipo = "ADM";
                    break;
                case 2:
                    tipo = "DOC";
                    break;
                case 3:
                    tipo = "REC";
                    break;
                case 4:
                    tipo = "PAC";
                    break;
                default:
                    tipo = null;
                    break;
            }

            if (tipo != null) {
                SimpleDateFormat formato = new SimpleDateFormat("yy");

                Random random = new Random();
                int digitos = 1000 + random.nextInt(9000);
                codigo = tipo + "-" + formato.format(new Date()) + digitos;

                if (model.obtenerUsuario(codigo) != null) {
                    salir = true;
                }
            }else {
                codigo = "";
                salir = true;
            }
        } while (!salir);
        usuario.setCodigo(codigo);
    }

    public List<UsuariosEntity> listar() {
        return model.listarUsuarios();
    }

    public UsuariosEntity obtener() {
        usuario = model.obtenerUsuario(usuario.getCodigo());
        return usuario;
    }

    public void guardar() {
        model.guardarUsuario(usuario);
    }

    public void modificar() {
        model.modificarUsuario(usuario);
    }

    public void eliminar() {
        model.eliminarUsuario(usuario.getCodigo());
    }
    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    public List<UsuariosEntity> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<UsuariosEntity> listUsers) {
        this.listUsers = listUsers;
    }

    public int getCodRol() {
        return codRol;
    }

    public void setCodRol(int codRol) {
        this.codRol = codRol;
    }

    public int getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(int codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public UsuariosModel getModel() {
        return model;
    }

    public void setModel(UsuariosModel model) {
        this.model = model;
    }

}
