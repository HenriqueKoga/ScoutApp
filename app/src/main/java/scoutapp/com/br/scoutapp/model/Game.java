package scoutapp.com.br.scoutapp.model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by HenriqueKoga on 08/07/16.
 */
public class Game implements Serializable{

    //total
    int service = 0;
    int reception = 0;
    int forehand = 0;
    int backhand = 0;
    int smash = 0;
    int slice = 0;
    int block = 0;
    int flick = 0;
    int lob =0;

    int total = 0;

    //service spec
    int serviceLeftLongCrossed = 0;
    int serviceLeftLongParallel = 0;
    int serviceLeftShortCrossed = 0;
    int serviceLeftShortParallel = 0;
    int serviceMiddleLongCrossed = 0;
    int serviceMiddleLongParallel = 0;
    int serviceMiddleShortCrossed = 0;
    int serviceMiddleShortParallel = 0;
    int serviceRightLongCrossed = 0;
    int serviceRightLongParallel = 0;
    int serviceRightShortCrossed = 0;
    int serviceRightShortParallel = 0;

    //reception spec
    int receptionLeftLongCrossed = 0;
    int receptionLeftLongParallel = 0;
    int receptionLeftShortCrossed = 0;
    int receptionLeftShortParallel = 0;
    int receptionMiddleLongCrossed = 0;
    int receptionMiddleLongParallel = 0;
    int receptionMiddleShortCrossed = 0;
    int receptionMiddleShortParallel = 0;
    int receptionRightLongCrossed = 0;
    int receptionRightLongParallel = 0;
    int receptionRightShortCrossed = 0;
    int receptionRightShortParallel = 0;

    //forehand spec
    int forehandLeftLongCrossed = 0;
    int forehandLeftLongParallel = 0;
    int forehandLeftShortCrossed = 0;
    int forehandLeftShortParallel = 0;
    int forehandMiddleLongCrossed = 0;
    int forehandMiddleLongParallel = 0;
    int forehandMiddleShortCrossed = 0;
    int forehandMiddleShortParallel = 0;
    int forehandRightLongCrossed = 0;
    int forehandRightLongParallel = 0;
    int forehandRightShortCrossed = 0;
    int forehandRightShortParallel = 0;

    //backhand spec
    int backhandLeftLongCrossed = 0;
    int backhandLeftLongParallel = 0;
    int backhandLeftShortCrossed = 0;
    int backhandLeftShortParallel = 0;
    int backhandMiddleLongCrossed = 0;
    int backhandMiddleLongParallel = 0;
    int backhandMiddleShortCrossed = 0;
    int backhandMiddleShortParallel = 0;
    int backhandRightLongCrossed = 0;
    int backhandRightLongParallel = 0;
    int backhandRightShortCrossed = 0;
    int backhandRightShortParallel = 0;

    //smash spec
    int smashLeftLongCrossed = 0;
    int smashLeftLongParallel = 0;
    int smashLeftShortCrossed = 0;
    int smashLeftShortParallel = 0;
    int smashMiddleLongCrossed = 0;
    int smashMiddleLongParallel = 0;
    int smashMiddleShortCrossed = 0;
    int smashMiddleShortParallel = 0;
    int smashRightLongCrossed = 0;
    int smashRightLongParallel = 0;
    int smashRightShortCrossed = 0;
    int smashRightShortParallel = 0;

    //slice spec
    int sliceLeftLongCrossed = 0;
    int sliceLeftLongParallel = 0;
    int sliceLeftShortCrossed = 0;
    int sliceLeftShortParallel = 0;
    int sliceMiddleLongCrossed = 0;
    int sliceMiddleLongParallel = 0;
    int sliceMiddleShortCrossed = 0;
    int sliceMiddleShortParallel = 0;
    int sliceRightLongCrossed = 0;
    int sliceRightLongParallel = 0;
    int sliceRightShortCrossed = 0;
    int sliceRightShortParallel = 0;

    //block spec
    int blockLeftLongCrossed = 0;
    int blockLeftLongParallel = 0;
    int blockLeftShortCrossed = 0;
    int blockLeftShortParallel = 0;
    int blockMiddleLongCrossed = 0;
    int blockMiddleLongParallel = 0;
    int blockMiddleShortCrossed = 0;
    int blockMiddleShortParallel = 0;
    int blockRightLongCrossed = 0;
    int blockRightLongParallel = 0;
    int blockRightShortCrossed = 0;
    int blockRightShortParallel = 0;

    //flick spec
    int flickLeftLongCrossed = 0;
    int flickLeftLongParallel = 0;
    int flickLeftShortCrossed = 0;
    int flickLeftShortParallel = 0;
    int flickMiddleLongCrossed = 0;
    int flickMiddleLongParallel = 0;
    int flickMiddleShortCrossed = 0;
    int flickMiddleShortParallel = 0;
    int flickRightLongCrossed = 0;
    int flickRightLongParallel = 0;
    int flickRightShortCrossed = 0;
    int flickRightShortParallel = 0;

    //lob spec
    int lobLeftLongCrossed = 0;
    int lobLeftLongParallel = 0;
    int lobLeftShortCrossed = 0;
    int lobLeftShortParallel = 0;
    int lobMiddleLongCrossed = 0;
    int lobMiddleLongParallel = 0;
    int lobMiddleShortCrossed = 0;
    int lobMiddleShortParallel = 0;
    int lobRightLongCrossed = 0;
    int lobRightLongParallel = 0;
    int lobRightShortCrossed = 0;
    int lobRightShortParallel = 0;


    public Game() {
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getReception() {
        return reception;
    }

    public void setReception(int reception) {
        this.reception = reception;
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

    public int getServiceLeftLongCrossed() {
        return serviceLeftLongCrossed;
    }

    public void setServiceLeftLongCrossed(int serviceLeftLongCrossed) {
        this.serviceLeftLongCrossed = serviceLeftLongCrossed;
    }

    public int getServiceLeftLongParallel() {
        return serviceLeftLongParallel;
    }

    public void setServiceLeftLongParallel(int serviceLeftLongParallel) {
        this.serviceLeftLongParallel = serviceLeftLongParallel;
    }

    public int getServiceLeftShortCrossed() {
        return serviceLeftShortCrossed;
    }

    public void setServiceLeftShortCrossed(int serviceLeftShortCrossed) {
        this.serviceLeftShortCrossed = serviceLeftShortCrossed;
    }

    public int getServiceLeftShortParallel() {
        return serviceLeftShortParallel;
    }

    public void setServiceLeftShortParallel(int serviceLeftShortParallel) {
        this.serviceLeftShortParallel = serviceLeftShortParallel;
    }

    public int getServiceMiddleLongCrossed() {
        return serviceMiddleLongCrossed;
    }

    public void setServiceMiddleLongCrossed(int serviceMiddleLongCrossed) {
        this.serviceMiddleLongCrossed = serviceMiddleLongCrossed;
    }

    public int getServiceMiddleLongParallel() {
        return serviceMiddleLongParallel;
    }

    public void setServiceMiddleLongParallel(int serviceMiddleLongParallel) {
        this.serviceMiddleLongParallel = serviceMiddleLongParallel;
    }

    public int getServiceMiddleShortCrossed() {
        return serviceMiddleShortCrossed;
    }

    public void setServiceMiddleShortCrossed(int serviceMiddleShortCrossed) {
        this.serviceMiddleShortCrossed = serviceMiddleShortCrossed;
    }

    public int getServiceMiddleShortParallel() {
        return serviceMiddleShortParallel;
    }

    public void setServiceMiddleShortParallel(int serviceMiddleShortParallel) {
        this.serviceMiddleShortParallel = serviceMiddleShortParallel;
    }

    public int getServiceRightLongCrossed() {
        return serviceRightLongCrossed;
    }

    public void setServiceRightLongCrossed(int serviceRightLongCrossed) {
        this.serviceRightLongCrossed = serviceRightLongCrossed;
    }

    public int getServiceRightLongParallel() {
        return serviceRightLongParallel;
    }

    public void setServiceRightLongParallel(int serviceRightLongParallel) {
        this.serviceRightLongParallel = serviceRightLongParallel;
    }

    public int getServiceRightShortCrossed() {
        return serviceRightShortCrossed;
    }

    public void setServiceRightShortCrossed(int serviceRightShortCrossed) {
        this.serviceRightShortCrossed = serviceRightShortCrossed;
    }

    public int getServiceRightShortParallel() {
        return serviceRightShortParallel;
    }

    public void setServiceRightShortParallel(int serviceRightShortParallel) {
        this.serviceRightShortParallel = serviceRightShortParallel;
    }

    public int getReceptionLeftLongCrossed() {
        return receptionLeftLongCrossed;
    }

    public void setReceptionLeftLongCrossed(int receptionLeftLongCrossed) {
        this.receptionLeftLongCrossed = receptionLeftLongCrossed;
    }

    public int getReceptionLeftLongParallel() {
        return receptionLeftLongParallel;
    }

    public void setReceptionLeftLongParallel(int receptionLeftLongParallel) {
        this.receptionLeftLongParallel = receptionLeftLongParallel;
    }

    public int getReceptionLeftShortCrossed() {
        return receptionLeftShortCrossed;
    }

    public void setReceptionLeftShortCrossed(int receptionLeftShortCrossed) {
        this.receptionLeftShortCrossed = receptionLeftShortCrossed;
    }

    public int getReceptionLeftShortParallel() {
        return receptionLeftShortParallel;
    }

    public void setReceptionLeftShortParallel(int receptionLeftShortParallel) {
        this.receptionLeftShortParallel = receptionLeftShortParallel;
    }

    public int getReceptionMiddleLongCrossed() {
        return receptionMiddleLongCrossed;
    }

    public void setReceptionMiddleLongCrossed(int receptionMiddleLongCrossed) {
        this.receptionMiddleLongCrossed = receptionMiddleLongCrossed;
    }

    public int getReceptionMiddleLongParallel() {
        return receptionMiddleLongParallel;
    }

    public void setReceptionMiddleLongParallel(int receptionMiddleLongParallel) {
        this.receptionMiddleLongParallel = receptionMiddleLongParallel;
    }

    public int getReceptionMiddleShortCrossed() {
        return receptionMiddleShortCrossed;
    }

    public void setReceptionMiddleShortCrossed(int receptionMiddleShortCrossed) {
        this.receptionMiddleShortCrossed = receptionMiddleShortCrossed;
    }

    public int getReceptionMiddleShortParallel() {
        return receptionMiddleShortParallel;
    }

    public void setReceptionMiddleShortParallel(int receptionMiddleShortParallel) {
        this.receptionMiddleShortParallel = receptionMiddleShortParallel;
    }

    public int getReceptionRightLongCrossed() {
        return receptionRightLongCrossed;
    }

    public void setReceptionRightLongCrossed(int receptionRightLongCrossed) {
        this.receptionRightLongCrossed = receptionRightLongCrossed;
    }

    public int getReceptionRightLongParallel() {
        return receptionRightLongParallel;
    }

    public void setReceptionRightLongParallel(int receptionRightLongParallel) {
        this.receptionRightLongParallel = receptionRightLongParallel;
    }

    public int getReceptionRightShortCrossed() {
        return receptionRightShortCrossed;
    }

    public void setReceptionRightShortCrossed(int receptionRightShortCrossed) {
        this.receptionRightShortCrossed = receptionRightShortCrossed;
    }

    public int getReceptionRightShortParallel() {
        return receptionRightShortParallel;
    }

    public void setReceptionRightShortParallel(int receptionRightShortParallel) {
        this.receptionRightShortParallel = receptionRightShortParallel;
    }

    public int getForehandLeftLongCrossed() {
        return forehandLeftLongCrossed;
    }

    public void setForehandLeftLongCrossed(int forehandLeftLongCrossed) {
        this.forehandLeftLongCrossed = forehandLeftLongCrossed;
    }

    public int getForehandLeftLongParallel() {
        return forehandLeftLongParallel;
    }

    public void setForehandLeftLongParallel(int forehandLeftLongParallel) {
        this.forehandLeftLongParallel = forehandLeftLongParallel;
    }

    public int getForehandLeftShortCrossed() {
        return forehandLeftShortCrossed;
    }

    public void setForehandLeftShortCrossed(int forehandLeftShortCrossed) {
        this.forehandLeftShortCrossed = forehandLeftShortCrossed;
    }

    public int getForehandLeftShortParallel() {
        return forehandLeftShortParallel;
    }

    public void setForehandLeftShortParallel(int forehandLeftShortParallel) {
        this.forehandLeftShortParallel = forehandLeftShortParallel;
    }

    public int getForehandMiddleLongCrossed() {
        return forehandMiddleLongCrossed;
    }

    public void setForehandMiddleLongCrossed(int forehandMiddleLongCrossed) {
        this.forehandMiddleLongCrossed = forehandMiddleLongCrossed;
    }

    public int getForehandMiddleLongParallel() {
        return forehandMiddleLongParallel;
    }

    public void setForehandMiddleLongParallel(int forehandMiddleLongParallel) {
        this.forehandMiddleLongParallel = forehandMiddleLongParallel;
    }

    public int getForehandMiddleShortCrossed() {
        return forehandMiddleShortCrossed;
    }

    public void setForehandMiddleShortCrossed(int forehandMiddleShortCrossed) {
        this.forehandMiddleShortCrossed = forehandMiddleShortCrossed;
    }

    public int getForehandMiddleShortParallel() {
        return forehandMiddleShortParallel;
    }

    public void setForehandMiddleShortParallel(int forehandMiddleShortParallel) {
        this.forehandMiddleShortParallel = forehandMiddleShortParallel;
    }

    public int getForehandRightLongCrossed() {
        return forehandRightLongCrossed;
    }

    public void setForehandRightLongCrossed(int forehandRightLongCrossed) {
        this.forehandRightLongCrossed = forehandRightLongCrossed;
    }

    public int getForehandRightLongParallel() {
        return forehandRightLongParallel;
    }

    public void setForehandRightLongParallel(int forehandRightLongParallel) {
        this.forehandRightLongParallel = forehandRightLongParallel;
    }

    public int getForehandRightShortCrossed() {
        return forehandRightShortCrossed;
    }

    public void setForehandRightShortCrossed(int forehandRightShortCrossed) {
        this.forehandRightShortCrossed = forehandRightShortCrossed;
    }

    public int getForehandRightShortParallel() {
        return forehandRightShortParallel;
    }

    public void setForehandRightShortParallel(int forehandRightShortParallel) {
        this.forehandRightShortParallel = forehandRightShortParallel;
    }

    public int getBackhandLeftLongCrossed() {
        return backhandLeftLongCrossed;
    }

    public void setBackhandLeftLongCrossed(int backhandLeftLongCrossed) {
        this.backhandLeftLongCrossed = backhandLeftLongCrossed;
    }

    public int getBackhandLeftLongParallel() {
        return backhandLeftLongParallel;
    }

    public void setBackhandLeftLongParallel(int backhandLeftLongParallel) {
        this.backhandLeftLongParallel = backhandLeftLongParallel;
    }

    public int getBackhandLeftShortCrossed() {
        return backhandLeftShortCrossed;
    }

    public void setBackhandLeftShortCrossed(int backhandLeftShortCrossed) {
        this.backhandLeftShortCrossed = backhandLeftShortCrossed;
    }

    public int getBackhandLeftShortParallel() {
        return backhandLeftShortParallel;
    }

    public void setBackhandLeftShortParallel(int backhandLeftShortParallel) {
        this.backhandLeftShortParallel = backhandLeftShortParallel;
    }

    public int getBackhandMiddleLongCrossed() {
        return backhandMiddleLongCrossed;
    }

    public void setBackhandMiddleLongCrossed(int backhandMiddleLongCrossed) {
        this.backhandMiddleLongCrossed = backhandMiddleLongCrossed;
    }

    public int getBackhandMiddleLongParallel() {
        return backhandMiddleLongParallel;
    }

    public void setBackhandMiddleLongParallel(int backhandMiddleLongParallel) {
        this.backhandMiddleLongParallel = backhandMiddleLongParallel;
    }

    public int getBackhandMiddleShortCrossed() {
        return backhandMiddleShortCrossed;
    }

    public void setBackhandMiddleShortCrossed(int backhandMiddleShortCrossed) {
        this.backhandMiddleShortCrossed = backhandMiddleShortCrossed;
    }

    public int getBackhandMiddleShortParallel() {
        return backhandMiddleShortParallel;
    }

    public void setBackhandMiddleShortParallel(int backhandMiddleShortParallel) {
        this.backhandMiddleShortParallel = backhandMiddleShortParallel;
    }

    public int getBackhandRightLongCrossed() {
        return backhandRightLongCrossed;
    }

    public void setBackhandRightLongCrossed(int backhandRightLongCrossed) {
        this.backhandRightLongCrossed = backhandRightLongCrossed;
    }

    public int getBackhandRightLongParallel() {
        return backhandRightLongParallel;
    }

    public void setBackhandRightLongParallel(int backhandRightLongParallel) {
        this.backhandRightLongParallel = backhandRightLongParallel;
    }

    public int getBackhandRightShortCrossed() {
        return backhandRightShortCrossed;
    }

    public void setBackhandRightShortCrossed(int backhandRightShortCrossed) {
        this.backhandRightShortCrossed = backhandRightShortCrossed;
    }

    public int getBackhandRightShortParallel() {
        return backhandRightShortParallel;
    }

    public void setBackhandRightShortParallel(int backhandRightShortParallel) {
        this.backhandRightShortParallel = backhandRightShortParallel;
    }

    public int getSmashLeftLongCrossed() {
        return smashLeftLongCrossed;
    }

    public void setSmashLeftLongCrossed(int smashLeftLongCrossed) {
        this.smashLeftLongCrossed = smashLeftLongCrossed;
    }

    public int getSmashLeftLongParallel() {
        return smashLeftLongParallel;
    }

    public void setSmashLeftLongParallel(int smashLeftLongParallel) {
        this.smashLeftLongParallel = smashLeftLongParallel;
    }

    public int getSmashLeftShortCrossed() {
        return smashLeftShortCrossed;
    }

    public void setSmashLeftShortCrossed(int smashLeftShortCrossed) {
        this.smashLeftShortCrossed = smashLeftShortCrossed;
    }

    public int getSmashLeftShortParallel() {
        return smashLeftShortParallel;
    }

    public void setSmashLeftShortParallel(int smashLeftShortParallel) {
        this.smashLeftShortParallel = smashLeftShortParallel;
    }

    public int getSmashMiddleLongCrossed() {
        return smashMiddleLongCrossed;
    }

    public void setSmashMiddleLongCrossed(int smashMiddleLongCrossed) {
        this.smashMiddleLongCrossed = smashMiddleLongCrossed;
    }

    public int getSmashMiddleLongParallel() {
        return smashMiddleLongParallel;
    }

    public void setSmashMiddleLongParallel(int smashMiddleLongParallel) {
        this.smashMiddleLongParallel = smashMiddleLongParallel;
    }

    public int getSmashMiddleShortCrossed() {
        return smashMiddleShortCrossed;
    }

    public void setSmashMiddleShortCrossed(int smashMiddleShortCrossed) {
        this.smashMiddleShortCrossed = smashMiddleShortCrossed;
    }

    public int getSmashMiddleShortParallel() {
        return smashMiddleShortParallel;
    }

    public void setSmashMiddleShortParallel(int smashMiddleShortParallel) {
        this.smashMiddleShortParallel = smashMiddleShortParallel;
    }

    public int getSmashRightLongCrossed() {
        return smashRightLongCrossed;
    }

    public void setSmashRightLongCrossed(int smashRightLongCrossed) {
        this.smashRightLongCrossed = smashRightLongCrossed;
    }

    public int getSmashRightLongParallel() {
        return smashRightLongParallel;
    }

    public void setSmashRightLongParallel(int smashRightLongParallel) {
        this.smashRightLongParallel = smashRightLongParallel;
    }

    public int getSmashRightShortCrossed() {
        return smashRightShortCrossed;
    }

    public void setSmashRightShortCrossed(int smashRightShortCrossed) {
        this.smashRightShortCrossed = smashRightShortCrossed;
    }

    public int getSmashRightShortParallel() {
        return smashRightShortParallel;
    }

    public void setSmashRightShortParallel(int smashRightShortParallel) {
        this.smashRightShortParallel = smashRightShortParallel;
    }

    public int getSliceLeftLongCrossed() {
        return sliceLeftLongCrossed;
    }

    public void setSliceLeftLongCrossed(int sliceLeftLongCrossed) {
        this.sliceLeftLongCrossed = sliceLeftLongCrossed;
    }

    public int getSliceLeftLongParallel() {
        return sliceLeftLongParallel;
    }

    public void setSliceLeftLongParallel(int sliceLeftLongParallel) {
        this.sliceLeftLongParallel = sliceLeftLongParallel;
    }

    public int getSliceLeftShortCrossed() {
        return sliceLeftShortCrossed;
    }

    public void setSliceLeftShortCrossed(int sliceLeftShortCrossed) {
        this.sliceLeftShortCrossed = sliceLeftShortCrossed;
    }

    public int getSliceLeftShortParallel() {
        return sliceLeftShortParallel;
    }

    public void setSliceLeftShortParallel(int sliceLeftShortParallel) {
        this.sliceLeftShortParallel = sliceLeftShortParallel;
    }

    public int getSliceMiddleLongCrossed() {
        return sliceMiddleLongCrossed;
    }

    public void setSliceMiddleLongCrossed(int sliceMiddleLongCrossed) {
        this.sliceMiddleLongCrossed = sliceMiddleLongCrossed;
    }

    public int getSliceMiddleLongParallel() {
        return sliceMiddleLongParallel;
    }

    public void setSliceMiddleLongParallel(int sliceMiddleLongParallel) {
        this.sliceMiddleLongParallel = sliceMiddleLongParallel;
    }

    public int getSliceMiddleShortCrossed() {
        return sliceMiddleShortCrossed;
    }

    public void setSliceMiddleShortCrossed(int sliceMiddleShortCrossed) {
        this.sliceMiddleShortCrossed = sliceMiddleShortCrossed;
    }

    public int getSliceMiddleShortParallel() {
        return sliceMiddleShortParallel;
    }

    public void setSliceMiddleShortParallel(int sliceMiddleShortParallel) {
        this.sliceMiddleShortParallel = sliceMiddleShortParallel;
    }

    public int getSliceRightLongCrossed() {
        return sliceRightLongCrossed;
    }

    public void setSliceRightLongCrossed(int sliceRightLongCrossed) {
        this.sliceRightLongCrossed = sliceRightLongCrossed;
    }

    public int getSliceRightLongParallel() {
        return sliceRightLongParallel;
    }

    public void setSliceRightLongParallel(int sliceRightLongParallel) {
        this.sliceRightLongParallel = sliceRightLongParallel;
    }

    public int getSliceRightShortCrossed() {
        return sliceRightShortCrossed;
    }

    public void setSliceRightShortCrossed(int sliceRightShortCrossed) {
        this.sliceRightShortCrossed = sliceRightShortCrossed;
    }

    public int getSliceRightShortParallel() {
        return sliceRightShortParallel;
    }

    public void setSliceRightShortParallel(int sliceRightShortParallel) {
        this.sliceRightShortParallel = sliceRightShortParallel;
    }

    public int getBlockLeftLongCrossed() {
        return blockLeftLongCrossed;
    }

    public void setBlockLeftLongCrossed(int blockLeftLongCrossed) {
        this.blockLeftLongCrossed = blockLeftLongCrossed;
    }

    public int getBlockLeftLongParallel() {
        return blockLeftLongParallel;
    }

    public void setBlockLeftLongParallel(int blockLeftLongParallel) {
        this.blockLeftLongParallel = blockLeftLongParallel;
    }

    public int getBlockLeftShortCrossed() {
        return blockLeftShortCrossed;
    }

    public void setBlockLeftShortCrossed(int blockLeftShortCrossed) {
        this.blockLeftShortCrossed = blockLeftShortCrossed;
    }

    public int getBlockLeftShortParallel() {
        return blockLeftShortParallel;
    }

    public void setBlockLeftShortParallel(int blockLeftShortParallel) {
        this.blockLeftShortParallel = blockLeftShortParallel;
    }

    public int getBlockMiddleLongCrossed() {
        return blockMiddleLongCrossed;
    }

    public void setBlockMiddleLongCrossed(int blockMiddleLongCrossed) {
        this.blockMiddleLongCrossed = blockMiddleLongCrossed;
    }

    public int getBlockMiddleLongParallel() {
        return blockMiddleLongParallel;
    }

    public void setBlockMiddleLongParallel(int blockMiddleLongParallel) {
        this.blockMiddleLongParallel = blockMiddleLongParallel;
    }

    public int getBlockMiddleShortCrossed() {
        return blockMiddleShortCrossed;
    }

    public void setBlockMiddleShortCrossed(int blockMiddleShortCrossed) {
        this.blockMiddleShortCrossed = blockMiddleShortCrossed;
    }

    public int getBlockMiddleShortParallel() {
        return blockMiddleShortParallel;
    }

    public void setBlockMiddleShortParallel(int blockMiddleShortParallel) {
        this.blockMiddleShortParallel = blockMiddleShortParallel;
    }

    public int getBlockRightLongCrossed() {
        return blockRightLongCrossed;
    }

    public void setBlockRightLongCrossed(int blockRightLongCrossed) {
        this.blockRightLongCrossed = blockRightLongCrossed;
    }

    public int getBlockRightLongParallel() {
        return blockRightLongParallel;
    }

    public void setBlockRightLongParallel(int blockRightLongParallel) {
        this.blockRightLongParallel = blockRightLongParallel;
    }

    public int getBlockRightShortCrossed() {
        return blockRightShortCrossed;
    }

    public void setBlockRightShortCrossed(int blockRightShortCrossed) {
        this.blockRightShortCrossed = blockRightShortCrossed;
    }

    public int getBlockRightShortParallel() {
        return blockRightShortParallel;
    }

    public void setBlockRightShortParallel(int blockRightShortParallel) {
        this.blockRightShortParallel = blockRightShortParallel;
    }

    public int getFlickLeftLongCrossed() {
        return flickLeftLongCrossed;
    }

    public void setFlickLeftLongCrossed(int flickLeftLongCrossed) {
        this.flickLeftLongCrossed = flickLeftLongCrossed;
    }

    public int getFlickLeftLongParallel() {
        return flickLeftLongParallel;
    }

    public void setFlickLeftLongParallel(int flickLeftLongParallel) {
        this.flickLeftLongParallel = flickLeftLongParallel;
    }

    public int getFlickLeftShortCrossed() {
        return flickLeftShortCrossed;
    }

    public void setFlickLeftShortCrossed(int flickLeftShortCrossed) {
        this.flickLeftShortCrossed = flickLeftShortCrossed;
    }

    public int getFlickLeftShortParallel() {
        return flickLeftShortParallel;
    }

    public void setFlickLeftShortParallel(int flickLeftShortParallel) {
        this.flickLeftShortParallel = flickLeftShortParallel;
    }

    public int getFlickMiddleLongCrossed() {
        return flickMiddleLongCrossed;
    }

    public void setFlickMiddleLongCrossed(int flickMiddleLongCrossed) {
        this.flickMiddleLongCrossed = flickMiddleLongCrossed;
    }

    public int getFlickMiddleLongParallel() {
        return flickMiddleLongParallel;
    }

    public void setFlickMiddleLongParallel(int flickMiddleLongParallel) {
        this.flickMiddleLongParallel = flickMiddleLongParallel;
    }

    public int getFlickMiddleShortCrossed() {
        return flickMiddleShortCrossed;
    }

    public void setFlickMiddleShortCrossed(int flickMiddleShortCrossed) {
        this.flickMiddleShortCrossed = flickMiddleShortCrossed;
    }

    public int getFlickMiddleShortParallel() {
        return flickMiddleShortParallel;
    }

    public void setFlickMiddleShortParallel(int flickMiddleShortParallel) {
        this.flickMiddleShortParallel = flickMiddleShortParallel;
    }

    public int getFlickRightLongCrossed() {
        return flickRightLongCrossed;
    }

    public void setFlickRightLongCrossed(int flickRightLongCrossed) {
        this.flickRightLongCrossed = flickRightLongCrossed;
    }

    public int getFlickRightLongParallel() {
        return flickRightLongParallel;
    }

    public void setFlickRightLongParallel(int flickRightLongParallel) {
        this.flickRightLongParallel = flickRightLongParallel;
    }

    public int getFlickRightShortCrossed() {
        return flickRightShortCrossed;
    }

    public void setFlickRightShortCrossed(int flickRightShortCrossed) {
        this.flickRightShortCrossed = flickRightShortCrossed;
    }

    public int getFlickRightShortParallel() {
        return flickRightShortParallel;
    }

    public void setFlickRightShortParallel(int flickRightShortParallel) {
        this.flickRightShortParallel = flickRightShortParallel;
    }

    public int getLobLeftLongCrossed() {
        return lobLeftLongCrossed;
    }

    public void setLobLeftLongCrossed(int lobLeftLongCrossed) {
        this.lobLeftLongCrossed = lobLeftLongCrossed;
    }

    public int getLobLeftLongParallel() {
        return lobLeftLongParallel;
    }

    public void setLobLeftLongParallel(int lobLeftLongParallel) {
        this.lobLeftLongParallel = lobLeftLongParallel;
    }

    public int getLobLeftShortCrossed() {
        return lobLeftShortCrossed;
    }

    public void setLobLeftShortCrossed(int lobLeftShortCrossed) {
        this.lobLeftShortCrossed = lobLeftShortCrossed;
    }

    public int getLobLeftShortParallel() {
        return lobLeftShortParallel;
    }

    public void setLobLeftShortParallel(int lobLeftShortParallel) {
        this.lobLeftShortParallel = lobLeftShortParallel;
    }

    public int getLobMiddleLongCrossed() {
        return lobMiddleLongCrossed;
    }

    public void setLobMiddleLongCrossed(int lobMiddleLongCrossed) {
        this.lobMiddleLongCrossed = lobMiddleLongCrossed;
    }

    public int getLobMiddleLongParallel() {
        return lobMiddleLongParallel;
    }

    public void setLobMiddleLongParallel(int lobMiddleLongParallel) {
        this.lobMiddleLongParallel = lobMiddleLongParallel;
    }

    public int getLobMiddleShortCrossed() {
        return lobMiddleShortCrossed;
    }

    public void setLobMiddleShortCrossed(int lobMiddleShortCrossed) {
        this.lobMiddleShortCrossed = lobMiddleShortCrossed;
    }

    public int getLobMiddleShortParallel() {
        return lobMiddleShortParallel;
    }

    public void setLobMiddleShortParallel(int lobMiddleShortParallel) {
        this.lobMiddleShortParallel = lobMiddleShortParallel;
    }

    public int getLobRightLongCrossed() {
        return lobRightLongCrossed;
    }

    public void setLobRightLongCrossed(int lobRightLongCrossed) {
        this.lobRightLongCrossed = lobRightLongCrossed;
    }

    public int getLobRightLongParallel() {
        return lobRightLongParallel;
    }

    public void setLobRightLongParallel(int lobRightLongParallel) {
        this.lobRightLongParallel = lobRightLongParallel;
    }

    public int getLobRightShortCrossed() {
        return lobRightShortCrossed;
    }

    public void setLobRightShortCrossed(int lobRightShortCrossed) {
        this.lobRightShortCrossed = lobRightShortCrossed;
    }

    public int getLobRightShortParallel() {
        return lobRightShortParallel;
    }

    public void setLobRightShortParallel(int lobRightShortParallel) {
        this.lobRightShortParallel = lobRightShortParallel;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void hitPoint(String position, String action, String direction){
        switch (action){
            case "service":
                this.setService(this.getService()+1);
                if (position == "left_long"){
                    if (direction == "crossed"){
                        this.setServiceLeftLongCrossed(this.getServiceLeftLongCrossed()+1);
                    } else{
                        this.setServiceLeftLongParallel(this.getServiceLeftLongParallel()+1);
                    }
                }
                if (position == "left_short"){
                    if (direction == "crossed"){
                        this.setServiceLeftShortCrossed(this.getServiceLeftShortCrossed()+1);
                    } else{
                        this.setServiceLeftShortParallel(this.getServiceLeftShortParallel()+1);
                    }
                }
                if (position == "middle_short"){
                    if (direction == "crossed"){
                        this.setServiceMiddleShortCrossed(this.getServiceMiddleShortCrossed()+1);
                    } else{
                        this.setServiceMiddleShortParallel(this.getServiceMiddleShortParallel()+1);
                    }
                }
                if (position == "middle_long"){
                    if (direction == "crossed"){
                        this.setServiceMiddleLongCrossed(this.getServiceMiddleLongCrossed()+1);
                    } else{
                        this.setServiceMiddleLongParallel(this.getServiceMiddleLongParallel()+1);
                    }
                }
                if (position == "right_short"){
                    if (direction == "crossed"){
                        this.setServiceRightShortCrossed(this.getServiceRightShortCrossed()+1);
                    } else{
                        this.setServiceRightShortParallel(this.getServiceRightShortParallel()+1);
                    }
                }
                if (position == "right_long"){
                    if (direction == "crossed"){
                        this.setServiceRightLongCrossed(this.getServiceRightLongCrossed()+1);
                    } else{
                        this.setServiceRightLongParallel(this.getServiceRightLongParallel()+1);
                    }
                }
                break;

            case "reception":
                this.setReception(this.getReception()+1);
                if (position == "left_long"){
                    if (direction == "crossed"){
                        this.setReceptionLeftLongCrossed(this.getReceptionLeftLongCrossed()+1);
                    } else{
                        this.setReceptionLeftLongParallel(this.getReceptionLeftLongParallel()+1);
                    }
                }
                if (position == "left_short"){
                    if (direction == "crossed"){
                        this.setReceptionLeftShortCrossed(this.getReceptionLeftShortCrossed()+1);
                    } else{
                        this.setReceptionLeftShortParallel(this.getReceptionLeftShortParallel()+1);
                    }
                }
                if (position == "middle_short"){
                    if (direction == "crossed"){
                        this.setReceptionMiddleShortCrossed(this.getReceptionMiddleShortCrossed()+1);
                    } else{
                        this.setReceptionMiddleShortParallel(this.getReceptionMiddleShortParallel()+1);
                    }
                }
                if (position == "middle_long"){
                    if (direction == "crossed"){
                        this.setReceptionMiddleLongCrossed(this.getReceptionMiddleLongCrossed()+1);
                    } else{
                        this.setReceptionMiddleLongParallel(this.getReceptionMiddleLongParallel()+1);
                    }
                }
                if (position == "right_short"){
                    if (direction == "crossed"){
                        this.setReceptionRightShortCrossed(this.getReceptionRightShortCrossed()+1);
                    } else{
                        this.setReceptionRightShortParallel(this.getReceptionRightShortParallel()+1);
                    }
                }
                if (position == "right_long"){
                    if (direction == "crossed"){
                        this.setReceptionRightLongCrossed(this.getReceptionRightLongCrossed()+1);
                    } else{
                        this.setReceptionRightLongParallel(this.getReceptionRightLongParallel()+1);
                    }
                }
                break;

            case "forehand":
                this.setForehand(this.getForehand()+1);
                if (position == "left_long"){
                    if (direction == "crossed"){
                        this.setForehandLeftLongCrossed(this.getForehandLeftLongCrossed()+1);
                        Log.d("Left Long Crossed", ""+ this.getForehandLeftLongCrossed());
                    } else{
                        this.setForehandLeftLongParallel(this.getForehandLeftLongParallel()+1);
                        Log.d("Left Long Parallel", ""+ this.getForehandLeftLongParallel());
                    }
                }
                if (position == "left_short"){
                    if (direction == "crossed"){
                        this.setForehandLeftShortCrossed(this.getForehandLeftShortCrossed()+1);
                        Log.d("Left Short Crossed", ""+ this.getForehandLeftShortCrossed());
                    } else{
                        this.setForehandLeftShortParallel(this.getForehandLeftShortParallel()+1);
                        Log.d("Left Short Parallel", ""+ this.getForehandLeftShortParallel());
                    }
                }
                if (position == "middle_short"){
                    if (direction == "crossed"){
                        this.setForehandMiddleShortCrossed(this.getForehandMiddleShortCrossed()+1);
                    } else{
                        this.setForehandMiddleShortParallel(this.getForehandMiddleShortParallel()+1);
                    }
                }
                if (position == "middle_long"){
                    if (direction == "crossed"){
                        this.setForehandMiddleLongCrossed(this.getForehandMiddleLongCrossed()+1);
                    } else{
                        this.setForehandMiddleLongParallel(this.getForehandMiddleLongParallel()+1);
                    }
                }
                if (position == "right_short"){
                    if (direction == "crossed"){
                        this.setForehandRightShortCrossed(this.getForehandRightShortCrossed()+1);
                    } else{
                        this.setForehandRightShortParallel(this.getForehandRightShortParallel()+1);
                    }
                }
                if (position == "right_long"){
                    if (direction == "crossed"){
                        this.setForehandRightLongCrossed(this.getForehandRightLongCrossed()+1);
                    } else{
                        this.setForehandRightLongParallel(this.getForehandRightLongParallel()+1);
                    }
                }
                break;

            case "backhand":
                this.setBackhand(this.getBackhand()+1);
                if (position == "left_long"){
                    if (direction == "crossed"){
                        this.setBackhandLeftLongCrossed(this.getBackhandLeftLongCrossed()+1);
                    } else{
                        this.setBackhandLeftLongParallel(this.getBackhandLeftLongParallel()+1);
                    }
                }
                if (position == "left_short"){
                    if (direction == "crossed"){
                        this.setBackhandLeftShortCrossed(this.getBackhandLeftShortCrossed()+1);
                    } else{
                        this.setBackhandLeftShortParallel(this.getBackhandLeftShortParallel()+1);
                    }
                }
                if (position == "middle_short"){
                    if (direction == "crossed"){
                        this.setBackhandMiddleShortCrossed(this.getBackhandMiddleShortCrossed()+1);
                    } else{
                        this.setBackhandMiddleShortParallel(this.getBackhandMiddleShortParallel()+1);
                    }
                }
                if (position == "middle_long"){
                    if (direction == "crossed"){
                        this.setBackhandMiddleLongCrossed(this.getBackhandMiddleLongCrossed()+1);
                    } else{
                        this.setBackhandMiddleLongParallel(this.getBackhandMiddleLongParallel()+1);
                    }
                }
                if (position == "right_short"){
                    if (direction == "crossed"){
                        this.setBackhandRightShortCrossed(this.getBackhandRightShortCrossed()+1);
                    } else{
                        this.setBackhandRightShortParallel(this.getBackhandRightShortParallel()+1);
                    }
                }
                if (position == "right_long"){
                    if (direction == "crossed"){
                        this.setBackhandRightLongCrossed(this.getBackhandRightLongCrossed()+1);
                    } else{
                        this.setBackhandRightLongParallel(this.getBackhandRightLongParallel()+1);
                    }
                }
                break;

            case "smash":
                this.setSmash(this.getSmash()+1);
                if (position == "left_long"){
                    if (direction == "crossed"){
                        this.setSmashLeftLongCrossed(this.getSmashLeftLongCrossed()+1);
                    } else{
                        this.setSmashLeftLongParallel(this.getSmashLeftLongParallel()+1);
                    }
                }
                if (position == "left_short"){
                    if (direction == "crossed"){
                        this.setSmashLeftShortCrossed(this.getSmashLeftShortCrossed()+1);
                    } else{
                        this.setSmashLeftShortParallel(this.getSmashLeftShortParallel()+1);
                    }
                }
                if (position == "middle_short"){
                    if (direction == "crossed"){
                        this.setSmashMiddleShortCrossed(this.getSmashMiddleShortCrossed()+1);
                    } else{
                        this.setSmashMiddleShortParallel(this.getSmashMiddleShortParallel()+1);
                    }
                }
                if (position == "middle_long"){
                    if (direction == "crossed"){
                        this.setSmashMiddleLongCrossed(this.getSmashMiddleLongCrossed()+1);
                    } else{
                        this.setSmashMiddleLongParallel(this.getSmashMiddleLongParallel()+1);
                    }
                }
                if (position == "right_short"){
                    if (direction == "crossed"){
                        this.setSmashRightShortCrossed(this.getSmashRightShortCrossed()+1);
                    } else{
                        this.setSmashRightShortParallel(this.getSmashRightShortParallel()+1);
                    }
                }
                if (position == "right_long"){
                    if (direction == "crossed"){
                        this.setSmashRightLongCrossed(this.getSmashRightLongCrossed()+1);
                    } else{
                        this.setSmashRightLongParallel(this.getSmashRightLongParallel()+1);
                    }
                }
                break;

            case "slice":
                this.setSlice(this.getSlice()+1);
                if (position == "left_long"){
                    if (direction == "crossed"){
                        this.setSliceLeftLongCrossed(this.getSliceLeftLongCrossed()+1);
                    } else{
                        this.setSliceLeftLongParallel(this.getSliceLeftLongParallel()+1);
                    }
                }
                if (position == "left_short"){
                    if (direction == "crossed"){
                        this.setSliceLeftShortCrossed(this.getSliceLeftShortCrossed()+1);
                    } else{
                        this.setSliceLeftShortParallel(this.getSliceLeftShortParallel()+1);
                    }
                }
                if (position == "middle_short"){
                    if (direction == "crossed"){
                        this.setSliceMiddleShortCrossed(this.getSliceMiddleShortCrossed()+1);
                    } else{
                        this.setSliceMiddleShortParallel(this.getSliceMiddleShortParallel()+1);
                    }
                }
                if (position == "middle_long"){
                    if (direction == "crossed"){
                        this.setSliceMiddleLongCrossed(this.getSliceMiddleLongCrossed()+1);
                    } else{
                        this.setSliceMiddleLongParallel(this.getSliceMiddleLongParallel()+1);
                    }
                }
                if (position == "right_short"){
                    if (direction == "crossed"){
                        this.setSliceRightShortCrossed(this.getSliceRightShortCrossed()+1);
                    } else{
                        this.setSliceRightShortParallel(this.getSliceRightShortParallel()+1);
                    }
                }
                if (position == "right_long"){
                    if (direction == "crossed"){
                        this.setSliceRightLongCrossed(this.getSliceRightLongCrossed()+1);
                    } else{
                        this.setSliceRightLongParallel(this.getSliceRightLongParallel()+1);
                    }
                }
                break;

            case "block":
                this.setBlock(this.getBlock()+1);
                if (position == "left_long"){
                    if (direction == "crossed"){
                        this.setBlockLeftLongCrossed(this.getBlockLeftLongCrossed()+1);
                    } else{
                        this.setBlockLeftLongParallel(this.getBlockLeftLongParallel()+1);
                    }
                }
                if (position == "left_short"){
                    if (direction == "crossed"){
                        this.setBlockLeftShortCrossed(this.getBlockLeftShortCrossed()+1);
                    } else{
                        this.setBlockLeftShortParallel(this.getBlockLeftShortParallel()+1);
                    }
                }
                if (position == "middle_short"){
                    if (direction == "crossed"){
                        this.setBlockMiddleShortCrossed(this.getBlockMiddleShortCrossed()+1);
                    } else{
                        this.setBlockMiddleShortParallel(this.getBlockMiddleShortParallel()+1);
                    }
                }
                if (position == "middle_long"){
                    if (direction == "crossed"){
                        this.setBlockMiddleLongCrossed(this.getBlockMiddleLongCrossed()+1);
                    } else{
                        this.setBlockMiddleLongParallel(this.getBlockMiddleLongParallel()+1);
                    }
                }
                if (position == "right_short"){
                    if (direction == "crossed"){
                        this.setBlockRightShortCrossed(this.getBlockRightShortCrossed()+1);
                    } else{
                        this.setBlockRightShortParallel(this.getBlockRightShortParallel()+1);
                    }
                }
                if (position == "right_long"){
                    if (direction == "crossed"){
                        this.setBlockRightLongCrossed(this.getBlockRightLongCrossed()+1);
                    } else{
                        this.setBlockRightLongParallel(this.getBlockRightLongParallel()+1);
                    }
                }
                break;

            case "flick":
                this.setFlick(this.getFlick()+1);
                if (position == "left_long"){
                    if (direction == "crossed"){
                        this.setFlickLeftLongCrossed(this.getFlickLeftLongCrossed()+1);
                    } else{
                        this.setFlickLeftLongParallel(this.getFlickLeftLongParallel()+1);
                    }
                }
                if (position == "left_short"){
                    if (direction == "crossed"){
                        this.setFlickLeftShortCrossed(this.getFlickLeftShortCrossed()+1);
                    } else{
                        this.setFlickLeftShortParallel(this.getFlickLeftShortParallel()+1);
                    }
                }
                if (position == "middle_short"){
                    if (direction == "crossed"){
                        this.setFlickMiddleShortCrossed(this.getFlickMiddleShortCrossed()+1);
                    } else{
                        this.setFlickMiddleShortParallel(this.getFlickMiddleShortParallel()+1);
                    }
                }
                if (position == "middle_long"){
                    if (direction == "crossed"){
                        this.setFlickMiddleLongCrossed(this.getFlickMiddleLongCrossed()+1);
                    } else{
                        this.setFlickMiddleLongParallel(this.getFlickMiddleLongParallel()+1);
                    }
                }
                if (position == "right_short"){
                    if (direction == "crossed"){
                        this.setFlickRightShortCrossed(this.getFlickRightShortCrossed()+1);
                    } else{
                        this.setFlickRightShortParallel(this.getFlickRightShortParallel()+1);
                    }
                }
                if (position == "right_long"){
                    if (direction == "crossed"){
                        this.setFlickRightLongCrossed(this.getFlickRightLongCrossed()+1);
                    } else{
                        this.setFlickRightLongParallel(this.getFlickRightLongParallel()+1);
                    }
                }
                break;

            case "lob":
                this.setLob(this.getLob()+1);
                if (position == "left_long"){
                    if (direction == "crossed"){
                        this.setLobLeftLongCrossed(this.getLobLeftLongCrossed()+1);
                    } else{
                        this.setLobLeftLongParallel(this.getLobLeftLongParallel()+1);
                    }
                }
                if (position == "left_short"){
                    if (direction == "crossed"){
                        this.setLobLeftShortCrossed(this.getLobLeftShortCrossed()+1);
                    } else{
                        this.setLobLeftShortParallel(this.getLobLeftShortParallel()+1);
                    }
                }
                if (position == "middle_short"){
                    if (direction == "crossed"){
                        this.setLobMiddleShortCrossed(this.getLobMiddleShortCrossed()+1);
                    } else{
                        this.setLobMiddleShortParallel(this.getLobMiddleShortParallel()+1);
                    }
                }
                if (position == "middle_long"){
                    if (direction == "crossed"){
                        this.setLobMiddleLongCrossed(this.getLobMiddleLongCrossed()+1);
                    } else{
                        this.setLobMiddleLongParallel(this.getLobMiddleLongParallel()+1);
                    }
                }
                if (position == "right_short"){
                    if (direction == "crossed"){
                        this.setLobRightShortCrossed(this.getLobRightShortCrossed()+1);
                    } else{
                        this.setLobRightShortParallel(this.getLobRightShortParallel()+1);
                    }
                }
                if (position == "right_long"){
                    if (direction == "crossed"){
                        this.setLobRightLongCrossed(this.getLobRightLongCrossed()+1);
                    } else{
                        this.setLobRightLongParallel(this.getLobRightLongParallel()+1);
                    }
                }
                break;
        }
        this.setTotal(this.getTotal()+1);
    }

    public ArrayList<Integer> getActionList(String action){
        ArrayList<Integer>techniques = new ArrayList<>();
        switch (action){
            case "service":
                techniques.add(this.getServiceLeftLongCrossed());
                techniques.add(this.getServiceLeftLongParallel());
                techniques.add(this.getServiceLeftShortCrossed());
                techniques.add(this.getServiceLeftShortParallel());

                techniques.add(this.getServiceMiddleLongCrossed());
                techniques.add(this.getServiceMiddleLongParallel());
                techniques.add(this.getServiceMiddleShortCrossed());
                techniques.add(this.getServiceMiddleShortParallel());

                techniques.add(this.getServiceRightLongCrossed());
                techniques.add(this.getServiceRightLongParallel());
                techniques.add(this.getServiceRightShortCrossed());
                techniques.add(this.getServiceRightShortParallel());
                break;
            case "reception":
                techniques.add(this.getReceptionLeftLongCrossed());
                techniques.add(this.getReceptionLeftLongParallel());
                techniques.add(this.getReceptionLeftShortCrossed());
                techniques.add(this.getReceptionLeftShortParallel());

                techniques.add(this.getReceptionMiddleLongCrossed());
                techniques.add(this.getReceptionMiddleLongParallel());
                techniques.add(this.getReceptionMiddleShortCrossed());
                techniques.add(this.getReceptionMiddleShortParallel());

                techniques.add(this.getReceptionRightLongCrossed());
                techniques.add(this.getReceptionRightLongParallel());
                techniques.add(this.getReceptionRightShortCrossed());
                techniques.add(this.getReceptionRightShortParallel());
                break;
            case "forehand":
                techniques.add(this.getForehandLeftLongCrossed());
                techniques.add(this.getForehandLeftLongParallel());
                techniques.add(this.getForehandLeftShortCrossed());
                techniques.add(this.getForehandLeftShortParallel());

                techniques.add(this.getForehandMiddleLongCrossed());
                techniques.add(this.getForehandMiddleLongParallel());
                techniques.add(this.getForehandMiddleShortCrossed());
                techniques.add(this.getForehandMiddleShortParallel());

                techniques.add(this.getForehandRightLongCrossed());
                techniques.add(this.getForehandRightLongParallel());
                techniques.add(this.getForehandRightShortCrossed());
                techniques.add(this.getForehandRightShortParallel());
                break;
            case "backhand":
                techniques.add(this.getBackhandLeftLongCrossed());
                techniques.add(this.getBackhandLeftLongParallel());
                techniques.add(this.getBackhandLeftShortCrossed());
                techniques.add(this.getBackhandLeftShortParallel());

                techniques.add(this.getBackhandMiddleLongCrossed());
                techniques.add(this.getBackhandMiddleLongParallel());
                techniques.add(this.getBackhandMiddleShortCrossed());
                techniques.add(this.getBackhandMiddleShortParallel());

                techniques.add(this.getBackhandRightLongCrossed());
                techniques.add(this.getBackhandRightLongParallel());
                techniques.add(this.getBackhandRightShortCrossed());
                techniques.add(this.getBackhandRightShortParallel());
                break;
            case "smash":
                techniques.add(this.getSmashLeftLongCrossed());
                techniques.add(this.getSmashLeftLongParallel());
                techniques.add(this.getSmashLeftShortCrossed());
                techniques.add(this.getSmashLeftShortParallel());

                techniques.add(this.getSmashMiddleLongCrossed());
                techniques.add(this.getSmashMiddleLongParallel());
                techniques.add(this.getSmashMiddleShortCrossed());
                techniques.add(this.getSmashMiddleShortParallel());

                techniques.add(this.getSmashRightLongCrossed());
                techniques.add(this.getSmashRightLongParallel());
                techniques.add(this.getSmashRightShortCrossed());
                techniques.add(this.getSmashRightShortParallel());
                break;
            case "slice":
                techniques.add(this.getSliceLeftLongCrossed());
                techniques.add(this.getSliceLeftLongParallel());
                techniques.add(this.getSliceLeftShortCrossed());
                techniques.add(this.getSliceLeftShortParallel());

                techniques.add(this.getSliceMiddleLongCrossed());
                techniques.add(this.getSliceMiddleLongParallel());
                techniques.add(this.getSliceMiddleShortCrossed());
                techniques.add(this.getSliceMiddleShortParallel());

                techniques.add(this.getSliceRightLongCrossed());
                techniques.add(this.getSliceRightLongParallel());
                techniques.add(this.getSliceRightShortCrossed());
                techniques.add(this.getSliceRightShortParallel());
                break;
            case "block":
                techniques.add(this.getBlockLeftLongCrossed());
                techniques.add(this.getBlockLeftLongParallel());
                techniques.add(this.getBlockLeftShortCrossed());
                techniques.add(this.getBlockLeftShortParallel());

                techniques.add(this.getBlockMiddleLongCrossed());
                techniques.add(this.getBlockMiddleLongParallel());
                techniques.add(this.getBlockMiddleShortCrossed());
                techniques.add(this.getBlockMiddleShortParallel());

                techniques.add(this.getBlockRightLongCrossed());
                techniques.add(this.getBlockRightLongParallel());
                techniques.add(this.getBlockRightShortCrossed());
                techniques.add(this.getBlockRightShortParallel());
                break;
            case "flick":
                techniques.add(this.getFlickLeftLongCrossed());
                techniques.add(this.getFlickLeftLongParallel());
                techniques.add(this.getFlickLeftShortCrossed());
                techniques.add(this.getFlickLeftShortParallel());

                techniques.add(this.getFlickMiddleLongCrossed());
                techniques.add(this.getFlickMiddleLongParallel());
                techniques.add(this.getFlickMiddleShortCrossed());
                techniques.add(this.getFlickMiddleShortParallel());

                techniques.add(this.getFlickRightLongCrossed());
                techniques.add(this.getFlickRightLongParallel());
                techniques.add(this.getFlickRightShortCrossed());
                techniques.add(this.getFlickRightShortParallel());
                break;
            case "lob":
                techniques.add(this.getLobLeftLongCrossed());
                techniques.add(this.getLobLeftLongParallel());
                techniques.add(this.getLobLeftShortCrossed());
                techniques.add(this.getLobLeftShortParallel());

                techniques.add(this.getLobMiddleLongCrossed());
                techniques.add(this.getLobMiddleLongParallel());
                techniques.add(this.getLobMiddleShortCrossed());
                techniques.add(this.getLobMiddleShortParallel());

                techniques.add(this.getLobRightLongCrossed());
                techniques.add(this.getLobRightLongParallel());
                techniques.add(this.getLobRightShortCrossed());
                techniques.add(this.getLobRightShortParallel());
                break;
        }
        return techniques;
    }
}
