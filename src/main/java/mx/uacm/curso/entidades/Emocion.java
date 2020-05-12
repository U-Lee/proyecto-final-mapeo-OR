/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="emociones")
public class Emocion {

    @Id
    @Column(name="id")
    @SequenceGenerator(name = "sec_emo", sequenceName = "emociones_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_emo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name="felicidad")
    private Double felicidad;
    
    @Column(name="tristeza")
    private Double tristeza;
    
    @Column(name="enojo")
    private Double enojo;
    
    @Column(name="miedo")
    private Double miedo;
    
    @Column(name="animado")
    private Double animado;
    
    @Column(name="indiferente")
    private Double indiferente;
    
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "id_tweet")
    private Tweet tweet;

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFelicidad() {
        return felicidad;
    }

    public void setFelicidad(Double felicidad) {
        this.felicidad = felicidad;
    }

    public Double getTristeza() {
        return tristeza;
    }

    public void setTristeza(Double tristeza) {
        this.tristeza = tristeza;
    }

    public Double getEnojo() {
        return enojo;
    }

    public void setEnojo(Double enojo) {
        this.enojo = enojo;
    }

    public Double getMiedo() {
        return miedo;
    }

    public void setMiedo(Double miedo) {
        this.miedo = miedo;
    }

    public Double getAnimado() {
        return animado;
    }

    public void setAnimado(Double animado) {
        this.animado = animado;
    }

    public Double getIndiferente() {
        return indiferente;
    }

    public void setIndiferente(Double indiferente) {
        this.indiferente = indiferente;
    }
    
    
}
