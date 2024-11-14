package br.com.lanhouse.Contracts;

import br.com.lanhouse.Enums.EnumFormaDePagamento;

public interface IPagamento {
    boolean realizarPagamento(EnumFormaDePagamento pagamento, double valor);
}
