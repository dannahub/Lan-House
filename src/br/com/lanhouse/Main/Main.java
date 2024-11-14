package br.com.lanhouse.Main;

import br.com.lanhouse.Enums.EnumFormaDePagamento;
import br.com.lanhouse.Enums.EnumStatusComputador;
import br.com.lanhouse.Enums.EnumTipoDeServico;
import br.com.lanhouse.Model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Map<Cliente, Sessao> sessoesAtivas = new HashMap<>();
    public static ArrayList<Desktop> desktops = new ArrayList<>();
    public static ArrayList<String> softwaresInstalados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] arg) {

        computadoresDisponiveis();
        softwaresInstalados();

        boolean rodando = true;
        while (rodando) {
            System.out.println("******************");
            System.out.println("       MENU       ");
            System.out.println("******************");
            System.out.println("1- gerenciar clientes");
            System.out.println("2- gerenciar computadores");
            System.out.println("3- iniciar sessão");
            System.out.println("4- finalizar sessão");
            System.out.println("0- sair");
            System.out.println("-------------------");
            System.out.println("escolha uma opção: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    gerenciarClientes();
                    break;
                case 2:
                    gerenciarComputadores();
                    break;
                case 3:
                    iniciarSessao();
                    break;
                case 4:
                    finalizarSessao();
                    break;
                case 0:
                    System.out.println("saindo do sistema...");
                    rodando = false;
                    break;
                default:
                    System.out.println("--> opção inválida");
            }
        }
    }

    private static void computadoresDisponiveis() {
        desktops.add(new Desktop(1, "C002", EnumStatusComputador.LIVRE, "Intel I3", 64, softwaresInstalados));
        desktops.add(new Desktop(1, "C003", EnumStatusComputador.LIVRE, "Intel I5", 32, softwaresInstalados));
        desktops.add(new Desktop(1, "C004", EnumStatusComputador.MANUTENCAO, "Intel I5", 32, softwaresInstalados));
        desktops.add(new Desktop(1, "C005", EnumStatusComputador.OCUPADO, "Intel I3", 64, softwaresInstalados));
        desktops.add(new Desktop(1, "C006", EnumStatusComputador.LIVRE, "Intel I7", 64, softwaresInstalados));
    }

    private static void softwaresInstalados(){
        softwaresInstalados.add("google");
        softwaresInstalados.add("epson scan");
        softwaresInstalados.add("roblox");
        softwaresInstalados.add("steam");
    }

    private static void gerenciarClientes() {
        System.out.println("******************");
        System.out.println("GERENCIAR CLIENTES");
        System.out.println("******************");
        System.out.println("1- cadastrar cliente"); // feito
        System.out.println("2- listar clientes"); // feito
        System.out.println("3- remover cliente"); // feito
        System.out.println("4- voltar para o menu principal");
        System.out.println("-------------------");
        System.out.println("escolha uma opção: ");

        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                listarClientes();
                break;
            case 3:
                removerCliente();
                break;
            case 4:
                voltarProMenu();
                break;
            default:
                System.out.println("--> opção inválida");
        }
    }

    private static void cadastrarCliente() {
        System.out.println("nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("idade do cliente: ");
        int idade = scanner.nextInt();
        System.out.println("saldo do cliente: ");
        double saldo = scanner.nextDouble();
        System.out.println("qual tipo de serviço você deseja?");
        System.out.println("1- JOGO");
        System.out.println("2- IMPRESSÃO");
        System.out.println("3- INTERNET");
        System.out.println("opção: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        if (op == 1) {
            Cliente cliente = new Cliente(nome, idade, saldo, EnumTipoDeServico.JOGO);
            clientes.add(cliente);
            System.out.println("--> cliente cadastrado com sucesso.");
        } else if (op == 2) {
            Cliente cliente = new Cliente(nome, idade, saldo, EnumTipoDeServico.IMPRESSAO);
            clientes.add(cliente);
            System.out.println("--> cliente cadastrado com sucesso.");
        } else if (op == 3) {
            Cliente cliente = new Cliente(nome, idade, saldo, EnumTipoDeServico.INTERNET);
            clientes.add(cliente);
            System.out.println("--> cliente cadastrado com sucesso.");
        } else {
            System.out.println("--> opção inválida");
        }
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("--> nenhum cliente cadastrado");
        } else {
            for (Cliente cliente : clientes) {
                System.out.printf("\nnome: %s\nidade: %d\nsaldo: %.2f\n"
                        , cliente.getNome(), cliente.getIdade(), cliente.getSaldo());
            }
        }
    }

    private static void removerCliente() {
        for (Cliente cliente : clientes) {
            System.out.printf("nome: %s\n", cliente.getNome());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("escolha um cliente para remover: ");
        String nomeCliente = scanner.nextLine();

        boolean remover = clientes.removeIf(cliente -> cliente.getNome().equals(nomeCliente));
        if (remover) {
            System.out.println("--> cliente removido com sucesso.");
        } else {
            System.out.println("--> não há clientes com esse nome no sistema.");
        }
    }

    private static void voltarProMenu() {
        //
    }

    private static void gerenciarComputadores() {
        System.out.println("**********************");
        System.out.println("GERENCIAR COMPUTADORES");
        System.out.println("**********************");
        System.out.println("1- limpar cachê");
        System.out.println("2- formatar");
        System.out.println("3- ver informações do computador");
        System.out.println("0- voltar para o menu principal");
        System.out.println("-------------------");
        System.out.println("escolha uma opção: ");

        int op = scanner.nextInt();
        scanner.nextLine();

        Desktop comp = new Desktop(1001, "C001", EnumStatusComputador.OCUPADO,
                "Intel I5", 32, softwaresInstalados);

        switch (op) {
            case 1:
                limparCache(comp);
                break;
            case 2:
                formatar(comp);
                break;
            case 3:
                verInfoComputadores(comp);
            case 0:
                voltarProMenu();
                break;
            default:
                System.out.println("opção inválida");
        }
    }

    private static void verInfoComputadores(Desktop desktop){
        System.out.println("ID do computador: " + desktop.getId());
        System.out.println("processador: " + desktop.getProcessador());
        System.out.println("memória RAM: " + desktop.getMemoriaRam() + "GB");
        System.out.println("softwares instalados: " + desktop.getSoftwaresIntalados());
        System.out.println("status: " + desktop.getStatus());
    }
    private static void limparCache(Computador comp) {
        Funcionario funcionario = new Funcionario("fulano", 24, 1200, 10);
        funcionario.limparCache(comp);
    }

    private static void formatar(Computador comp) {
        Funcionario funcionario = new Funcionario("joao", 23, 1200, 10);
        funcionario.formatar(comp);
    }

    private static void iniciarSessao() {
        if (clientes.isEmpty()) {
            System.out.println("--> nenhum cadastro foi feito no sistema.");
            System.out.println("--> cadastre-se para iniciar uma sessão.");
        } else {
            Cliente cliente = clientes.get(0);
            Sessao sessao = new Sessao(cliente);
            sessao.iniciarSessao(EnumFormaDePagamento.DINHEIRO, 10, desktops);
            sessoesAtivas.put(cliente, sessao);
            System.out.println("--> cliente: " + cliente.getNome());
        }
    }

    private static void finalizarSessao() {
        if (clientes.isEmpty()) {
            System.out.println("--> nenhuma sessão ativa no momento.");
        } else {
            Cliente cliente = clientes.get(0);
            Sessao sessao = sessoesAtivas.get(cliente);
            if (sessao != null) {
                sessao.finalizarSessao();
            } else {
                System.out.println("--> cliente não tem sessão ativa.");
            }
        }
    }
}
