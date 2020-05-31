/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.Date;
import java.util.List;
import mx.uacm.curso.entidades.Pais;
import mx.uacm.curso.entidades.Tweet;

public interface TweetDAO extends GenericDAO<Tweet, Integer> {

    List<Tweet>tweetsPorHashtags(List<String> nombresHashtags);
    List<Integer>tweetsIdsPorHashtagsYFecha(List<String> nombresHashtags, Date fechaMin, Date fechaMax);
    List<Integer> filtrarTweetsIdsPorPais(List<Integer> tweetsIds, Pais pais);
}
