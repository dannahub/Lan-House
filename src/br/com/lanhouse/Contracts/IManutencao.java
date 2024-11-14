package br.com.lanhouse.Contracts;

import br.com.lanhouse.Model.Computador;

public interface IManutencao {
    void limparCache(Computador comp);
    void formatar(Computador comp);
}