package br.com.lanhouse.Model;

import br.com.lanhouse.Contracts.IPagamento;
import br.com.lanhouse.Enums.EnumFormaDePagamento;
import br.com.lanhouse.Enums.EnumTipoDeServico;

public class Cliente extends Pessoa implements IPagamento {
    private double saldo;
    private EnumTipoDeServico servico;

    public Cliente(String nome, int idade, double saldo, EnumTipoDeServico servico){
        super(nome, idade);
        this.saldo = saldo;
        this.servico = servico;
    }

    public double getSaldo(){
        return saldo;
    }
    public EnumTipoDeServico getServico() {
        return servico;
    }

    @Override
    public boolean realizarPagamento(EnumFormaDePagamento pagamento, double valor){
        if(saldo >= valor){
            saldo -= valor;
            System.out.printf("valor do pagamento: %.2f\nmétodo de pagamento: %s\nsaldo restante: %.2f\n",
                    valor, pagamento, saldo);
            return true;
        } else {
            System.out.println("--> saldo insuficiente.");
            return false;
        }
    }


}
