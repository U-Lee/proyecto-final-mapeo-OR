/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.dtos;

/**
 *
 * @author u-lee
 */
public class ConteoHashtagDTO {

    private String nombreHashtag;

    private Long totalTweets;

    public ConteoHashtagDTO() {

    }

    public ConteoHashtagDTO(String nombreHashtag, Long totalTweets) {
        this.nombreHashtag = nombreHashtag;
        this.totalTweets = totalTweets;
    }

    @Override
    public String toString() {
        return "{nombre:" + this.nombreHashtag + ", total tweets:" + this.totalTweets + "}";
    }

    public String getNombreHashtag() {
        return nombreHashtag;
    }

    public void setNombreHashtag(String nombreHashtag) {
        this.nombreHashtag = nombreHashtag;
    }

    public Long getTotalTweets() {
        return totalTweets;
    }

    public void setTotalTweets(Long totalTweets) {
        this.totalTweets = totalTweets;
    }

}
