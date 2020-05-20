/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.curso.daos.HashtagDAO;
import mx.uacm.curso.dtos.ConteoHashtagDTO;
import mx.uacm.curso.entidades.Hashtag;

public class HashtagDAOImpl extends GenericDAOImpl<Hashtag, Integer> implements HashtagDAO {

    public HashtagDAOImpl(EntityManager em) {
        super(em);
    }

    //Regresa todos los valores de la columna nombre de la tabla hashtags.
    @Override
    public List<Hashtag> nombresHashtags() {
        TypedQuery<Hashtag> consulta = em.createQuery("SELECT h FROM Hashtag h", Hashtag.class);
        List<Hashtag> hashtags = consulta.getResultList();
        return hashtags;
    }

    @Override
    public List<ConteoHashtagDTO> conteoHashtags() {
        TypedQuery<ConteoHashtagDTO> consulta = em.createQuery("SELECT new mx.uacm.curso.dtos.ConteoHashtagDTO(h.nombre,COUNT(t.id)) FROM Hashtag h INNER JOIN h.tweets t GROUP BY h.nombre", ConteoHashtagDTO.class);
        List<ConteoHashtagDTO> resultados = consulta.getResultList();
        return resultados;
    }

}
