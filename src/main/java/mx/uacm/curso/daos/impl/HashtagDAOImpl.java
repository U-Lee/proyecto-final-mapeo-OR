/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import javax.persistence.EntityManager;
import mx.uacm.curso.daos.HashtagDAO;
import mx.uacm.curso.entidades.Hashtag;

public class HashtagDAOImpl extends GenericDAOImpl<Hashtag, Integer> implements HashtagDAO {

    public HashtagDAOImpl(EntityManager em) {
        super(em);
    }

}
