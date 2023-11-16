package com.dwf.managedbeans;

import com.dwf.entities.UsuariosEntity;
import com.dwf.models.UsuariosModel;
import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@ManagedBean
@SessionScoped
public class UsuariosBean {
    private int codRol;
    private int codEspecialidad;
    private UsuariosEntity usuario;
    private UsuariosModel model;
    private List<UsuariosEntity> listUsers;

    public UsuariosBean() {
        usuario = new UsuariosEntity();
        model = new UsuariosModel();
    }

    public void crearCodigo() {
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

                if (!model.existeUsuario(codigo)) {
                    salir = true;
                }
            }else {
                codigo = "";
                salir = true;
            }
        } while (!salir);
        usuario.setCodigo(codigo);
    }

    public String login() {
        System.out.println("verificando usuario");
        String redirect = "";
        FacesContext context = FacesContext.getCurrentInstance();

        try{
            usuario = model.iniciarSesion(usuario);
            if (usuario != null) {
                context.getExternalContext().getSessionMap().put("usuario", usuario);
                redirect = redirectUser(usuario.getRolesByCodRol().getCodigo());
            } else {
                FacesMessage message = new FacesMessage("Usuario y/o contraseña inválido.");
                context.addMessage(null, message);
                redirect = "./login.xhtml";
            }
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error: " + ex);
        }

        return redirect;
    }

    public String register() {
        System.out.println("registrando usuario");
        String redirect = "";
        codRol = 4;
        crearCodigo();

        try{
            if (model.guardarUsuario(usuario, codRol, codEspecialidad) > 0)
                redirect = "./paciente/index.xhtml";
            else
                redirect = "./register.xhtml";
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error: " + ex);
            redirect = "./registro.xhtml";
        }

        return redirect;
    }

    public String redirectUser(int userRol) {
        switch(userRol) {
            case 1:
                return "../private/admin/index.xhtml";

            case 2:
                return "../private/doctor/index.xhtml";

            case 3:
                return "../private/recepcion/index.xhtml";

            case 4:
                return "../private/doctor/index.xhtml";

            default:
                return "./login.xhtml";
        }
    }

    public List<UsuariosEntity> listar() {
        return model.listarUsuarios();
    }

    public UsuariosEntity obtener() {
        usuario = model.obtenerUsuario(usuario.getCodigo());
        return usuario;
    }

    public void guardar() {
        if (model.guardarUsuario(usuario, codRol, codEspecialidad) > 0) {

        }
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
