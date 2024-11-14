package br.com.lanhouse.Model;

import br.com.lanhouse.Contracts.IManutencao;
import br.com.lanhouse.Enums.EnumStatusComputador;

public class Funcionario extends Pessoa implements IManutencao {

    private double salario;
    private int horasTrabalhadas;

    public Funcionario (String nome, int idade, double salario, int horasTrabalhadas){
        super(nome, idade);
        this.salario = salario;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public void limparCache(Computador comp){
        if(comp.getCache()>1000){
            comp.setCache(0);
            System.out.println("--> limpeza de cachê do computador" + comp.getId() + "realizada com sucesso");
        } else {
            System.out.println("--> a limpeza de cachê ainda não é necessária");
        }
    }
    @Override
    public void formatar(Computador comp){
        comp.setCache(0);
        comp.setStatus(EnumStatusComputador.LIVRE);
        System.out.println("--> o computador " + comp.getId() + " foi formatado com sucesso");
    }
}

