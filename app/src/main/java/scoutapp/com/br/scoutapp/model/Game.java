package scoutapp.com.br.scoutapp.model;

import java.io.Serializable;

/**
 * Created by HenriqueKoga on 08/07/16.
 */
public class Game implements Serializable{

    int service = 0;
    int receiving = 0;
    int forehand = 0;
    int backhand = 0;
    int smash = 0;
    int slice = 0;
    int block = 0;
    int flick = 0;
    int lob =0;

    int forehandLeftLong = 0;
    int forehandLeftShort = 0;
    int forehandMiddleLong = 0;
    int forehandMiddleShort = 0;
    int forehandRightLong = 0;
    int forehandRightShort = 0;

    int total = 0;

    public Game() {
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getReceiving() {
        return receiving;
    }

    public void setReceiving(int receiving) {
        this.receiving = receiving;
    }

    public int getForehand() {
        return forehand;
    }

    public void setForehand(int forehand) {
        this.forehand = forehand;
    }

    public int getBackhand() {
        return backhand;
    }

    public void setBackhand(int backhand) {
        this.backhand = backhand;
    }

    public int getSmash() {
        return smash;
    }

    public void setSmash(int smash) {
        this.smash = smash;
    }

    public int getSlice() {
        return slice;
    }

    public void setSlice(int slice) {
        this.slice = slice;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getFlick() {
        return flick;
    }

    public void setFlick(int flick) {
        this.flick = flick;
    }

    public int getLob() {
        return lob;
    }

    public void setLob(int lob) {
        this.lob = lob;
    }

    public int getForehandLeftLong() {
        return forehandLeftLong;
    }

    public void setForehandLeftLong(int forehandLeftLong) {
        this.forehandLeftLong = forehandLeftLong;
    }

    public int getForehandLeftShort() {
        return forehandLeftShort;
    }

    public void setForehandLeftShort(int forehandLeftShort) {
        this.forehandLeftShort = forehandLeftShort;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
