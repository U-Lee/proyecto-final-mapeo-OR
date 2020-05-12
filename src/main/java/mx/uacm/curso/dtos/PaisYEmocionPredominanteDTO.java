/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.dtos;

import mx.uacm.curso.entidades.Pais;

/**
 *
 * @author u-lee
 */
public class PaisYEmocionPredominanteDTO {

    private Pais pais;

    private EmocionPredominanteDTO emocionPredominante;

    public PaisYEmocionPredominanteDTO() {

    }

    public PaisYEmocionPredominanteDTO(Pais pais, EmocionPredominanteDTO emocionPredominante) {
        this.pais = pais;
        this.emocionPredominante = emocionPredominante;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public EmocionPredominanteDTO getEmocionPredominante() {
        return emocionPredominante;
    }

    public void setEmocionPredominante(EmocionPredominanteDTO emocionPredominante) {
        this.emocionPredominante = emocionPredominante;
    }

}
