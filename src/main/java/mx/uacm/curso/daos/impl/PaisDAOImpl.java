/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import javax.persistence.EntityManager;
import mx.uacm.curso.daos.PaisDAO;
import mx.uacm.curso.entidades.Pais;

public class PaisDAOImpl extends GenericDAOImpl<Pais, Integer> implements PaisDAO {

    public PaisDAOImpl(EntityManager em) {
        super(em);
    }

}
