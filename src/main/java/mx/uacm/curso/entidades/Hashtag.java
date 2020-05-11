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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hashtags")
public class Hashtag {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sec_has", sequenceName = "hashtags_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_has", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "tweets_hashtags",
            joinColumns = @JoinColumn(name = "id_tweet"),
            inverseJoinColumns = @JoinColumn(name = "id_hashtag"))
    private List<Tweet> tweets;

    @Override
    public String toString() {
        return "{id:" + this.id + ", nombre:" + this.nombre + "}";
    }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
