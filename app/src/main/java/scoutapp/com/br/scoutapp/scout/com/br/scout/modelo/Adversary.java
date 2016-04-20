package scoutapp.com.br.scoutapp.scout.com.br.scout.modelo;

import java.io.Serializable;

/**
 * Created by HenriqueKoga on 20/04/16.
 */

public class Adversary implements Serializable{
    private Long id;
    private String name;
    private String category;
    private String genre;
    private String club;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return getId() + " - " + getName();
    }
}
