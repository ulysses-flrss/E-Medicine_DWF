package com.dwf.managedbeans;
import com.dwf.entities.UsuariosEntity;
import com.dwf.models.UsuariosModel;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

import java.util.List;

@ManagedBean
@RequestScoped
public class UsuariosBean {
    private UsuariosEntity usuario;
    private UsuariosModel modelo;
    private List<UsuariosEntity> listUsers;

    public UsuariosBean() {
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

    public List<UsuariosEntity> listar() {
        return modelo.listarUsuarios();
    }

    public UsuariosEntity obtener() {
        usuario = modelo.obtenerUsuario(usuario.getCodigo());
        return usuario;
    }

    public void guardar() {
        modelo.guardarUsuario(usuario);
    }

    public void modificar() {
        modelo.modificarUsuario(usuario);
    }

    public void eliminar() {
        modelo.eliminarUsuario(usuario.getCodigo());
    }
}
