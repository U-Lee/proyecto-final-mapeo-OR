/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import javax.persistence.EntityManager;
import mx.uacm.curso.daos.TweetDAO;

import mx.uacm.curso.entidades.Tweet;

public class TweetDAOImpl extends GenericDAOImpl<Tweet, Integer> implements TweetDAO {

    public TweetDAOImpl(EntityManager em) {
        super(em);
    }

}
