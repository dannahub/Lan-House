package br.com.lanhouse.Model;

import br.com.lanhouse.Contracts.ITempo;
import br.com.lanhouse.Enums.EnumFormaDePagamento;
import br.com.lanhouse.Enums.EnumStatusComputador;
import java.util.ArrayList;
import java.util.Scanner;

public class Sessao implements ITempo {

    private int horaInicio;
    private int horaFim;
    private Cliente cliente;
    private Desktop computadorEscolhido;

    public Sessao(Cliente cliente) {
        this.cliente = cliente;
        this.horaInicio = 0;
        this.horaFim = 0;
    }

    @Override
    public void iniciarSessao(EnumFormaDePagamento pagamento, double valor, ArrayList<Desktop> computadoresDisponiveis) {
        if (cliente.realizarPagamento(pagamento, valor)) {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("OBS: informe o horário no formato 24h, utilizando apenas números");
                System.out.println(" ** abre às 8h, fecha às 18h **");
                System.out.println("-------------------");
                System.out.print("hora de início da sessão: \n");
                horaInicio = scanner.nextInt();
                scanner.nextLine();

                if (horaInicio >= 8 && horaInicio < 18) {
                    while (true) {
                        System.out.println("escolha um computador disponível:");
                        for (Desktop desktop : computadoresDisponiveis) {
                            if (desktop.getStatus() == EnumStatusComputador.LIVRE) {
                                System.out.printf("ID: %s, STATUS: %s, PROCESSADOR: %s, MEMÓRIA RAM: %d\n",
                                        desktop.getId(), desktop.getStatus(), desktop.getProcessador(), desktop.getMemoriaRam());
                            }
                        }
                        System.out.print("digite o ID do computador desejado: ");
                        String computadorId = scanner.nextLine();
                        boolean compEncontrado = false;
                        for (Desktop desktop : computadoresDisponiveis) {
                            if (desktop.getId().equals(computadorId) && desktop.getStatus() == EnumStatusComputador.LIVRE) {
                                computadorEscolhido = desktop;
                                desktop.setStatus(EnumStatusComputador.OCUPADO);
                                compEncontrado = true;
                                break;
                            }
                        }
                        if (compEncontrado) {
                            System.out.printf("--> sessão iniciada às %d horas\n", horaInicio);
                            break;
                        } else {
                            System.out.println("--> computador indisponível, tente novamente.");
                        }
                    }
                    break;
                } else {
                    System.out.println("--> horário inválido, tente novamente.");
                }
            }
        } else {
            System.out.println("--> falha no pagamento.");
        }
    }

    @Override
    public void finalizarSessao() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("OBS: informe o horário no formato 24h, utilizando apenas números");
            System.out.println(" ** abre às 8h, fecha às 18h **");
            System.out.println("-------------------");
            System.out.print("hora do final da sessão: ");
            horaFim = scanner.nextInt();

            if(horaFim < 8 || horaFim >= 18){
                System.out.println("--> horário inválido, tente novamente.");
            } else if (horaInicio >= horaFim){
                System.out.println("--> horário de término menor ou igual ao horário de início, tente novamente.");
            } else {
                System.out.println("--> sessão finalizada. volte sempre.");
                break;
            }
        }
    }
}