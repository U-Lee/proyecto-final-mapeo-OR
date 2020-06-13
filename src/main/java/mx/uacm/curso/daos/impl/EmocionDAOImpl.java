/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import mx.uacm.curso.daos.EmocionDAO;
import mx.uacm.curso.dtos.EmocionPredominanteDTO;
import mx.uacm.curso.entidades.Emocion;

public class EmocionDAOImpl extends GenericDAOImpl<Emocion, Integer> implements EmocionDAO {

    public EmocionDAOImpl(EntityManager em) {
        super(em);
    }

    @Override
    public EmocionPredominanteDTO emocionPredominantePorTweetsIds(List<Integer> tweetsIds) {
        Query consulta = em.createQuery("SELECT AVG(e.animado)as animado,AVG(e.enojo),AVG(e.felicidad),AVG(e.indiferente),AVG(e.miedo),AVG(e.tristeza)\n"
                + "FROM Emocion e WHERE e.id IN(:tweetsIds)");
        consulta.setParameter("tweetsIds", tweetsIds);
        Object[] resultado = (Object[]) consulta.getSingleResult();

        int indice = 0;
        int bandera = 0;
        double promMax = 0;
        for (Object unRenglon : resultado) {
            double emocion= (double) unRenglon;
            if (emocion > promMax) {
                promMax = emocion;
                indice = bandera;
            }
            bandera++;
        }

        EmocionPredominanteDTO e = new EmocionPredominanteDTO();
        e.setPromedio(promMax);
        switch (indice) {
            case 0:
                e.setEmocion("animado");
                break;
            case 1:
                e.setEmocion("enojo");
                break;
            case 2:
                e.setEmocion("felicidad");
                break;
            case 3:
                e.setEmocion("indiferente");
                break;
            case 4:
                e.setEmocion("miedo");
                break;
            case 5:
                e.setEmocion("tristeza");
                break;
        }
        return e;
    }
}
