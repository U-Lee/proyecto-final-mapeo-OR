/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.servicios.impl;

import mx.uacm.curso.daos.EmocionDAO;
import mx.uacm.curso.daos.TweetDAO;
import mx.uacm.curso.servicios.EstadisticasServicio;

public class EstadisticasServicioImpl implements EstadisticasServicio {

    private TweetDAO tweetDAO;

    private EmocionDAO emocionDAO;

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

}
