/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
   
   @Id
   @Column(name="id")
   @SequenceGenerator(name = "sec_usu", sequenceName = "usuarios_id_seq", allocationSize = 1)
   @GeneratedValue(generator = "sec_usu", strategy = GenerationType.SEQUENCE)
   private Integer id;
   
   @Column(name="usuario_twitter")
   private String usuario_twitter;
   
   @Column(name="siguiendo")
   private Integer siguiendo;
   
   @Column(name="seguidores")
   private Integer seguidores;
   
   @OneToMany(mappedBy="usuario")
   private List<Tweet> tweets;

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario_twitter() {
        return usuario_twitter;
    }

    public void setUsuario_twitter(String usuario_twitter) {
        this.usuario_twitter = usuario_twitter;
    }

    public Integer getSiguiendo() {
        return siguiendo;
    }

    public void setSiguiendo(Integer siguiendo) {
        this.siguiendo = siguiendo;
    }

    public Integer getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Integer seguidores) {
        this.seguidores = seguidores;
    }   
}
