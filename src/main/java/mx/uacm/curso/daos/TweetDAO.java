/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.List;
import mx.uacm.curso.entidades.Tweet;

public interface TweetDAO extends GenericDAO<Tweet, Integer> {

    List<Tweet> tweetsPorHashtags(List<String> nombresHashtags);
}
