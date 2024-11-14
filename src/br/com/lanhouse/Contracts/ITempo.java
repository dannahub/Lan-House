package br.com.lanhouse.Contracts;

import br.com.lanhouse.Enums.EnumFormaDePagamento;
import br.com.lanhouse.Model.Desktop;
import java.util.ArrayList;

public interface ITempo {
    void iniciarSessao(EnumFormaDePagamento pagamento, double valor, ArrayList<Desktop> computadoresDisponiveis);
    void finalizarSessao();
}
