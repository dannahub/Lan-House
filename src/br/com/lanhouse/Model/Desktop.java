package br.com.lanhouse.Model;

import br.com.lanhouse.Enums.EnumStatusComputador;

import java.util.ArrayList;

public class Desktop extends Computador {

    private String processador;
    private int memoriaRam;
    private ArrayList<String> softwaresIntalados;

    public Desktop(int cache, String id, EnumStatusComputador status, String processador,
                   int memoriaRam, ArrayList<String> softwaresIntalados) {
        super(cache, id, status);
        this.processador = processador;
        this.memoriaRam = memoriaRam;
        this.softwaresIntalados = softwaresIntalados;
    }

    public String getProcessador(){
        return processador;
    }
    public void setProcessador(){
        this.processador = processador;
    }
    public int getMemoriaRam(){
        return memoriaRam;
    }
    public void setMemoriaRam(){
        this.memoriaRam = memoriaRam;
    }
    public ArrayList<String> getSoftwaresIntalados(){
        return softwaresIntalados;
    }
}
