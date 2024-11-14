package br.com.lanhouse.Model;

import br.com.lanhouse.Enums.EnumStatusComputador;

public abstract class Computador {

    private int cache;
    private String id;
    private EnumStatusComputador status;

    public Computador(int cache, String id, EnumStatusComputador status){
        this.cache = cache;
        this.id = id;
        this.status = status;
    }
    public void setCache(int cache){
        this.cache = cache;
    }
    public int getCache(){
        return cache;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setStatus(EnumStatusComputador status) {
        this.status = status;
    }
    public EnumStatusComputador getStatus(){
        return status;
    }
}
