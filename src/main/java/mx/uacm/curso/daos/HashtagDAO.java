/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.List;
import mx.uacm.curso.dtos.ConteoHashtagDTO;
import mx.uacm.curso.entidades.Hashtag;

public interface HashtagDAO extends GenericDAO<Hashtag, Integer> {

    List<Hashtag> nombresHashtags();    
    
    List<ConteoHashtagDTO> conteoHashtags();
    
    List<ConteoHashtagDTO> conteoHashtags(String patronCadena);
}
