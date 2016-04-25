package scoutapp.com.br.scoutapp.modelo;

import java.io.Serializable;

/**
 * Created by HenriqueKoga on 22/04/16.
 */
public class Atleta implements Serializable{

    private Long id;
    private String nome;
    private String idade;
    private String categoria;
    private String clube;
    private int mao;
    private int estilo;
    private String obs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public int getMao() {
        return mao;
    }

    public void setMao(int mao) {
        this.mao = mao;
    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString()  {
        return getId() + " - " + getNome();
    }
}
