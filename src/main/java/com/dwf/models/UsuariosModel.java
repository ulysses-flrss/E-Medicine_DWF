package com.dwf.models;

import com.dwf.entities.EspecialidadesEntity;
import com.dwf.entities.RolesEntity;
import com.dwf.entities.UsuariosEntity;
import com.dwf.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

import java.util.List;

public class UsuariosModel {
    EntityManager em = JpaUtil.getEntityManager();
    public List<UsuariosEntity> listarUsuarios() {
        try {
            Query consulta = em.createQuery("SELECT u FROM UsuariosEntity u");
            List<UsuariosEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch(Exception ex){
            em.close();
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public UsuariosEntity obtenerUsuario (String cod) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            UsuariosEntity usuario = em.find(UsuariosEntity.class, cod);
            em.close();
            return usuario;
        } catch (PersistenceException ex) {
            em.close();
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public boolean existeUsuario (String cod) {
        List<UsuariosEntity> usuarios = listarUsuarios();
        for (UsuariosEntity usuario : usuarios) {
            if (usuario.getCodigo().equals(cod)) {
                return true;
            }
        }
        return false;
    }

    public int guardarUsuario (UsuariosEntity usuario, int codRol, int codEspecialidad) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            RolesEntity rolForm = em.find(RolesEntity.class, codRol);
            usuario.setRolesByCodRol(rolForm);
            if (codRol == 2){
                EspecialidadesEntity especialidadForm = em.find(EspecialidadesEntity.class, codEspecialidad);
                usuario.setEspecialidadesByCodEspecialidad(EspecialidadesEntity.class, especialidadForm);
            }
            //em.getTransaction().begin();
            em.persist(usuario);
                //em.getTransaction().commit();
            em.close();
            return 1;
        } catch (Exception ex) {
            em.close();
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    }

    public int modificarUsuario (UsuariosEntity usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
            em.close();
            return 1;
        } catch (Exception ex) {
            em.close();
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    }

    public int eliminarUsuario (String cod) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
            UsuariosEntity usuario = em.find(UsuariosEntity.class, cod);
            if (usuario != null) {
                em.getTransaction().begin();
                em.remove(usuario);
                em.getTransaction().commit();
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        } catch (Exception ex) {
            em.close();
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    }

    public UsuariosEntity iniciarSesion (UsuariosEntity usuario) {
        UsuariosEntity user = null;
        try{
            /*Query query = em.createQuery("SELECT u FROM UsuariosEntity u WHERE u.codigo=:codigo AND u.pass=:pass");
            query.setParameter("codigo", usuario.getCodigo());
            query.setParameter("pass", usuario.getPass());
            List<UsuariosEntity> result = query.getResultList();
            if (!result.isEmpty())
                user = result.get(0);*/
            List<UsuariosEntity> usuarios = listarUsuarios();
            for (UsuariosEntity usu : usuarios) {
                if (usu.getCorreo().equals(usuario.getCorreo()) && usu.getPass().equals(usuario.getPass())) {
                    return usu;
                }
            }
        } catch(Exception ex) {
            System.out.println(ex);
            System.out.println("Falló en inicio de sesión");
        }
        return user;
    }
}