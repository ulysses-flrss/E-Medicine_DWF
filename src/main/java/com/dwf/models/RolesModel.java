package com.dwf.models;

import com.dwf.entities.RolesEntity;
import com.dwf.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class RolesModel {
    public List<RolesEntity> listarRoles() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT R FROM RolesEntity R");
            List<RolesEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch(Exception ex){
            em.close();
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
}
