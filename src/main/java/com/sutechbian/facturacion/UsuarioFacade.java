/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
import javax.persistence.Query;
import java.util.List;
 */
package com.sutechbian.facturacion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 

/**
 *
 * @author Dell_
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "com.su-techbian_facturacion_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findUserToLogin(String nombre, String contrasena){
        Usuario usuario = null;
        String consulta;
        try{
            consulta = "FROM Usuario u WHERE u.name = ?1 AND u.password = ?2";
             Query query = em.createQuery(consulta);
             query.setParameter(1, nombre);
             query.setParameter(2, contrasena);
            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        }catch(Exception e){
             throw e;
         }
         //finally{
             //em.close();
         //}
         return usuario;
    }
    
}
