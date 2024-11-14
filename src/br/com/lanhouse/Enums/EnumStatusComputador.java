package br.com.lanhouse.Enums;

public enum EnumStatusComputador {

    LIVRE(1),
    OCUPADO(2),
    MANUTENCAO(3);

    int valor;

    EnumStatusComputador(int valor){
        this.valor = valor;
    }
}
