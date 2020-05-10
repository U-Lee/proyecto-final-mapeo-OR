/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Usuario {
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sec_usu", sequenceName = "usuarios_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_usu", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "usuario_twitter")
    private String usuario_twitter;
    
    @Column(name= "siguiendo")
    private Integer siguiendo;
    
    @Column(name="seguidores")
    private Integer seguidores;

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
