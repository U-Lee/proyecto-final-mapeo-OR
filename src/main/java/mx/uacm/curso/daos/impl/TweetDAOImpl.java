/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.curso.daos.TweetDAO;
import mx.uacm.curso.entidades.Pais;

import mx.uacm.curso.entidades.Tweet;

public class TweetDAOImpl extends GenericDAOImpl<Tweet, Integer> implements TweetDAO {

    public TweetDAOImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Tweet> tweetsPorHashtags(List<String> nombresHashtags) {

        TypedQuery<Tweet> consulta = em.createQuery("SELECT t FROM Tweet t INNER JOIN t.hashtags h WHERE h.nombre IN(:nombresHashtags)", Tweet.class);
        consulta.setParameter("nombresHashtags", nombresHashtags);
        List<Tweet> resultados = consulta.getResultList();
        return resultados;
    }

    @Override
    public List<Integer> tweetsIdsPorHashtagsYFecha(List<String> nombresHashtags, Date fechaMin, Date fechaMax) {
        TypedQuery<Integer> consulta = em.createQuery("SELECT t.id FROM Tweet t INNER JOIN t.hashtags h WHERE h.nombre IN(:nombresHashtags) AND t.fecha BETWEEN :fechaMin AND :fechaMax GROUP BY t.id", Integer.class);
        consulta.setParameter("nombresHashtags", nombresHashtags);
        consulta.setParameter("fechaMin", fechaMin);
        consulta.setParameter("fechaMax", fechaMax);
        List<Integer> resultados = consulta.getResultList();
        return resultados;
    }

    @Override
    public List<Integer> filtrarTweetsIdsPorPais(List<Integer> tweetsIds, Pais pais) {      
        TypedQuery<Integer> consulta = em.createQuery("SELECT t.id FROM Tweet t INNER JOIN t.lugar l WHERE l.id IN(:tweetsIds) AND l.pais.id=:paisId",Integer.class);
        consulta.setParameter("tweetsIds", tweetsIds);         
        consulta.setParameter("paisId", pais.getId());
        List<Integer> resultados = consulta.getResultList();
        return resultados;
    }

}
