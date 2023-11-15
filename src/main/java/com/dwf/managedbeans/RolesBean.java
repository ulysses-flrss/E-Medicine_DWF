package com.dwf.managedbeans;

import com.dwf.entities.RolesEntity;
import com.dwf.models.RolesModel;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

import java.util.List;

@ManagedBean
@RequestScoped
public class RolesBean {
    private List<RolesEntity> listRoles;
    private RolesModel model = new RolesModel();

    public RolesBean() {
        listRoles = model.listarRoles();
    }

    public List<RolesEntity> getListRoles() {
        return listRoles;
    }

    public void setListRoles(List<RolesEntity> listRoles) {
        this.listRoles = listRoles;
    }

    public RolesModel getModel() {
        return model;
    }

    public void setModel(RolesModel model) {
        this.model = model;
    }
}
