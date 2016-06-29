package scoutapp.com.br.scoutapp.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HenriqueKoga on 31/05/16.
 */
public class Campeonato implements Serializable{
    private Long id;
    private String name;
    private String date;
    private String state;
    private String city;
    private String idAtleta;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(String idAtleta) {
        this.idAtleta = idAtleta;
    }
}
