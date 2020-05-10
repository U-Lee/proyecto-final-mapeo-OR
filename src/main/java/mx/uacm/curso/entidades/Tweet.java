/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tweets")
public class Tweet {

    @Id
    @Column(name="id")
    @SequenceGenerator(name = "sec_twe", sequenceName = "tweets_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_twe", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name="fecha")
    private Date fecha;
    
    @Column(name="contenido")
    private String contenido;
    
    @Column(name="likes")
    private Integer likes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
    
    
}
