/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import javax.persistence.EntityManager;
import mx.uacm.curso.daos.EmocionDAO;
import mx.uacm.curso.entidades.Emocion;

public class EmocionDAOImpl extends GenericDAOImpl<Emocion, Integer> implements EmocionDAO {

    public EmocionDAOImpl(EntityManager em) {
        super(em);
    }
}
