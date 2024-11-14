package br.com.lanhouse.Enums;

public enum EnumFormaDePagamento {

    DINHEIRO(1),
    CARTAO(2),
    PIX(3);

    int valor;

    EnumFormaDePagamento(int valor) {
        this.valor = valor;
    }
}