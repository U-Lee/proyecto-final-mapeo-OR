/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.servicios.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import mx.uacm.curso.daos.EmocionDAO;
import mx.uacm.curso.daos.PaisDAO;
import mx.uacm.curso.daos.TweetDAO;
import mx.uacm.curso.dtos.EmocionPredominanteDTO;
import mx.uacm.curso.dtos.PaisYEmocionPredominanteDTO;
import mx.uacm.curso.entidades.Pais;
import mx.uacm.curso.servicios.EstadisticasServicio;

public class EstadisticasServicioImpl implements EstadisticasServicio {

    private TweetDAO tweetDAO;

    private EmocionDAO emocionDAO;

    private PaisDAO paisDAO;

    public PaisDAO getPaisDAO() {
        return paisDAO;
    }

    public void setPaisDAO(PaisDAO paisDAO) {
        this.paisDAO = paisDAO;
    }

    public TweetDAO getTweetDAO() {
        return tweetDAO;
    }

    public void setTweetDAO(TweetDAO tweetDAO) {
        this.tweetDAO = tweetDAO;
    }

    public EmocionDAO getEmocionDAO() {
        return emocionDAO;
    }

    public void setEmocionDAO(EmocionDAO emocionDAO) {
        this.emocionDAO = emocionDAO;
    }

    @Override
    public List<PaisYEmocionPredominanteDTO> emocionesPredominantesAgrupadasPorPais(List<String> hashtags, Date fechaMin, Date fechaMax) {
        //Crear lista vacía de tipo List<PaisYEmocionPredominanteDTO> de nombre paisesYEmociones
        List<PaisYEmocionPredominanteDTO> paisesYEmociones = new ArrayList<PaisYEmocionPredominanteDTO>();
        PaisYEmocionPredominanteDTO paisYEmocionPredominanteDTO;

        //Use el método tweetsIdsPorHashtagsYFecha de TweetDAO​para obtener ids de los tweets
        List<Integer> ids = tweetDAO.tweetsIdsPorHashtagsYFecha(hashtags, fechaMin, fechaMax);

        //Guarde el resultado de obtenPorTweetsIds de​PaisDAO en la variable paises
        List<Pais> paises = paisDAO.obtenPorTweetsIds(ids);
  
        //Por cada entidad Pais de la lista paises
        for (Pais pais : paises) {
            //Invocar filtrarTweetsIdsPorPais de TweetDAO, guarde el resultado en la variable tweetsIdsPorPaises
            List<Integer> tweetsIdsPorPaises = tweetDAO.filtrarTweetsIdsPorPais(ids, pais);
            System.out.println("Pais: " + pais.getNombre());

            //Invocar emocionPredominantePorTweetsIds de EmocionDAO pasandole la variable tweetsIdsPorPaises
            //Esto le regresa la emoción predominante para la entidad Pais
            EmocionPredominanteDTO e = (emocionDAO.emocionPredominantePorTweetsIds(tweetsIdsPorPaises));
            System.out.println("emocion: " + e.getEmocion());

            //Añadir resultados a un objeto de tipo PaisYEmocionPredominanteDTO
            paisYEmocionPredominanteDTO = new PaisYEmocionPredominanteDTO();
            paisYEmocionPredominanteDTO.setEmocionPredominante(e);
            paisYEmocionPredominanteDTO.setPais(pais);
            
            //Guardar el objeto en la lista paisesYEmociones           
            paisesYEmociones.add(paisYEmocionPredominanteDTO);
        }

        //Regrese la lista paisesYEmociones
        return paisesYEmociones;
    }

}
