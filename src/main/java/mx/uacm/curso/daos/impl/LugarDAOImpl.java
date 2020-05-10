/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import javax.persistence.EntityManager;
import mx.uacm.curso.daos.LugarDAO;
import mx.uacm.curso.entidades.Lugar;

public class LugarDAOImpl extends GenericDAOImpl<Lugar, Integer> implements LugarDAO {

    public LugarDAOImpl(EntityManager em) {
        super(em);
    }

}
