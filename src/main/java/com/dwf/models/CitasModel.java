package com.dwf.models;

import com.dwf.entities.CitasEntity;
import com.dwf.entities.EspecialidadesEntity;
import com.dwf.entities.UsuariosEntity;
import com.dwf.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CitasModel {

    public int guardarCita (CitasEntity cita, UsuariosEntity usuario, int codEspecialidad) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {

            EspecialidadesEntity especialidad = em.find(EspecialidadesEntity.class, codEspecialidad);
            cita.setUsuariosByCodPaciente(usuario);
            cita.setEspecialidadesByCodEspecialidad(especialidad);
            tran.begin();
            em.persist(cita);
            tran.commit();
            em.close();
            return 1;
        } catch (Exception ex) {
            em.close();
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    }

}
