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
    public List<String> nombresHashtags() {
        TypedQuery<String> consulta = em.createQuery("SELECT h.nombre FROM Hashtag h", String.class);
        List<String> hashtags = consulta.getResultList();
        return hashtags;
    }

    //Regresa todos los hashtags y para cada uno de ellos el total de tweets que tiene asociado.
    @Override
    public List<ConteoHashtagDTO> conteoHashtags() {
        TypedQuery<ConteoHashtagDTO> consulta = em.createQuery("SELECT new mx.uacm.curso.dtos.ConteoHashtagDTO(h.nombre,COUNT(t.id)) FROM Hashtag h LEFT OUTER JOIN h.tweets t GROUP BY h.nombre", ConteoHashtagDTO.class);
        List<ConteoHashtagDTO> resultados = consulta.getResultList();
        return resultados;
    }

    //Regresa una lista con todos los hashtags ​ cuyos nombres contengan la cadena patronCadena
    //y para cada uno de ellos el total de tweets que tiene asociado.
    @Override
    public List<ConteoHashtagDTO> conteoHashtags(String patronCadena) {
        TypedQuery<ConteoHashtagDTO> consulta = em.createQuery("SELECT new mx.uacm.curso.dtos.ConteoHashtagDTO(h.nombre,COUNT(t.id)) FROM Hashtag h INNER JOIN h.tweets t GROUP BY h.nombre HAVING h.nombre LIKE :patronCadena", ConteoHashtagDTO.class);
        consulta.setParameter("patronCadena", patronCadena);
        List<ConteoHashtagDTO> resultados = consulta.getResultList();
        return resultados;
    }
}
