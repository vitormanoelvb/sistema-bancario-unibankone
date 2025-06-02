/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemabancario;

/**
 *
 * @author Vitor
 */
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Desktop;
import java.net.URI;

public class SistemaBancario {
    static Set<String> menoresComTermoAssinado = new HashSet<>();
    static Map<String, String> dadosResponsaveis = new HashMap<>();
    static Banco banco = new Banco("Banco VM");
    Set<String> cpfsResponsaveis = new HashSet<>();
    
    public static void main(String[] args) throws InterruptedException {
        limparTela();
        System.out.println("===============================================================");
        System.out.println("=               ATENCAO - ANTES DE CONTINUAR...               =");
        System.out.println("===============================================================");
        System.out.println("= Para melhor visualizacao do sistema, recomendo:             =");
        System.out.println("= -> Aumentar o tamanho da tela do terminal da IDE            =");
        System.out.println("= -> (Ex: Eclipse, IntelliJ, NetBeans, VS Code, etc.)         =");
        System.out.println("= -> Usar o terminal em tela cheia, se possivel               =");
        System.out.println("=                                                             =");
        System.out.println("= Isso garantira uma melhor leitura dos menus e relatorios.   =");
        System.out.println("===============================================================");
        System.out.print("\nPressione ENTER para continuar...");
        new Scanner(System.in).nextLine();
        limparTela();

        System.out.println("=====================================");
        System.out.println("==  DESENVOLVIDO POR VITOR MANOEL  ==");
        System.out.println("=====================================");
        Thread.sleep(1500);
        limparTela();

        System.out.println("==================================");
        System.out.println("==          VM SYSTEMS          ==");
        System.out.println("==================================");
        Thread.sleep(1500);
        limparTela();

        System.out.println("=================================");
        System.out.println("|-------------------------------|");
        System.out.println("== VM ENGINE DEVELOPMENT V:1.5 ==");
        System.out.println("|-------------------------------|");
        System.out.println("=================================");
        Thread.sleep(1500);
        limparTela();

        System.out.println("==================================");
        System.out.println("|--------------------------------|");
        System.out.println("== SISTEMA BANCARIO: UNIBANKONE ==");
        System.out.println("|--------------------------------|");
        System.out.println("==================================");
        Thread.sleep(1500);
        limparTela();

        exibirMenuPrincipal();
    }

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void exibirMenuPrincipal() throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            limparTela();
            System.out.println("===========================================");
            System.out.println("|-----------------------------------------|");
            System.out.println("|=     SISTEMA BANCARIO - UNIBANKONE     =|");
            System.out.println("|-----------------------------------------|");
            System.out.println("===========================================");
            System.out.println("=|---------------------------------------|=");
            System.out.println("=| 1 - Cadastrar cliente                 |=");
            System.out.println("=| 2 - Abrir conta corrente              |=");
            System.out.println("=| 3 - Abrir conta poupanca              |=");
            System.out.println("=| 4 - Listar contas do cliente          |=");
            System.out.println("=| 5 - Depositar                         |=");
            System.out.println("=| 6 - Sacar                             |=");
            System.out.println("=| 7 - Transferir                        |=");
            System.out.println("=| 8 - BackOffice UnibankOne             |=");
            System.out.println("=| 9 - Sobre o Sistema                   |=");
            System.out.println("=| 10 - Sair do Sistema                  |=");
            System.out.println("=|---------------------------------------|=");
            System.out.println("===========================================");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
    case 1: {
    boolean cancelado = false;

    java.util.function.Function<String, Boolean> verificarCancelamento = entrada -> {
        if (entrada.equals("0")) {
            System.out.print("Tem certeza que deseja cancelar o cadastro? (S/N): ");
            String confirma = sc.nextLine().trim().toUpperCase();
            if (confirma.equals("S")) {
                try {
                    limparTela();
                    System.out.println("========================================");
                    System.out.println("=         CADASTRO CANCELADO.          =");
                    System.out.println("========================================");
                    Thread.sleep(1500);
                    limparTela();
                } catch (InterruptedException e) {
                    System.out.println("Erro ao pausar a execucao.");
                }
                return true;
            } else {
                System.out.println("\nContinuando cadastro...");
                try {
                    Thread.sleep(1000);
                    limparTela();
                    System.out.println("===========================================");
                    System.out.println("==         CADASTRO DE CLIENTE           ==");
                    System.out.println("===========================================");
                } catch (InterruptedException e) {
                    System.out.println("Erro ao limpar a tela.");
                }
            }
        }
        return false;
    };

    limparTela();
    System.out.println("===========================================");
    System.out.println("==         CADASTRO DE CLIENTE           ==");
    System.out.println("===========================================");

    String nome;
    while (true) {
        System.out.print(">> Nome completo (ou 0 para cancelar): ");
        nome = sc.nextLine().trim();
        if (verificarCancelamento.apply(nome)) {
            cancelado = true;
            break;
        }
        if (!nome.isEmpty() && nome.matches("^[A-Za-zÀ-ÿ\\s]+$")) break;

        limparTela();
        System.out.println("===========================================");
        System.out.println("==         CADASTRO DE CLIENTE           ==");
        System.out.println("===========================================");
        System.out.println("Nome invalido! Tente novamente.");
    }
    if (cancelado) break;

    String cpf;
    while (true) {
    System.out.print(">> CPF (ou 0 para cancelar): ");
    cpf = sc.nextLine().replaceAll("[^0-9]", "").trim();
    if (verificarCancelamento.apply(cpf)) {
        cancelado = true;
        break;
    }

    if (!cpf.matches("\\d{11}")) {
        limparTela();
        System.out.println("===========================================");
        System.out.println("==         CADASTRO DE CLIENTE           ==");
        System.out.println("===========================================");
        System.out.println("CPF invalido! Digite 11 numeros.");
        continue;
    }

    if (banco.buscarClientePorCpf(cpf) != null) {
        limparTela();
        System.out.println("===========================================");
        System.out.println("==         CADASTRO DE CLIENTE           ==");
        System.out.println("===========================================");
        System.out.println("CPF ja cadastrado! Cliente existente.");
        Thread.sleep(1500);
        limparTela();
        break;
    }

    break; 

}
    if (cancelado) break;

    String endereco;
    while (true) {
        System.out.print(">> Endereco (ou 0 para cancelar): ");
        endereco = sc.nextLine().trim();
        if (verificarCancelamento.apply(endereco)) {
            cancelado = true;
            break;
        }
        if (!endereco.isEmpty()) break;

        limparTela();
        System.out.println("===========================================");
        System.out.println("==         CADASTRO DE CLIENTE           ==");
        System.out.println("===========================================");
        System.out.println("Endereco invalido! Tente novamente.");
    }
    if (cancelado) break;

    String numeroCliente;
    while (true) {
        System.out.print(">> Numero do cliente (ou 0 para cancelar): ");
        numeroCliente = sc.nextLine().trim();
        if (verificarCancelamento.apply(numeroCliente)) {
            cancelado = true;
            break;
        }
        if (!numeroCliente.isEmpty()) {
            boolean duplicado = false;
            for (Cliente c : banco.getListaClientes()) {
                if (c.getNumeroCliente().equals(numeroCliente)) {
                    limparTela();
                    System.out.println("===========================================");
                    System.out.println("==         CADASTRO DE CLIENTE           ==");
                    System.out.println("===========================================");
                    System.out.println("Erro: Ja existe um cliente com este numero.");
                    Thread.sleep(1500);
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) break;
        }

        limparTela();
        System.out.println("===========================================");
        System.out.println("==         CADASTRO DE CLIENTE           ==");
        System.out.println("===========================================");
        System.out.println("Numero do cliente invalido! Tente novamente.");
    }
    if (cancelado) break;

    Cliente cliente = new Cliente();
    cliente.setNome(nome);
    String cpfFormatado = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    cliente.setCpf(cpfFormatado);
    cliente.setEndereco(endereco);
    cliente.setNumeroCliente(numeroCliente);

    LocalDate dataNascimento = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    while (true) {
        System.out.print(">> Data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = sc.nextLine().trim();
        try {
            dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
            break;
        } catch (Exception e) {
            System.out.println("Data invalida! Tente novamente no formato dd/MM/yyyy.");
        }
    }

    cliente.setDataNascimento(dataNascimento);

    banco.cadastrarCliente(cliente);

    System.out.println();
    System.out.println("===========================================");
    System.out.println("==    CLIENTE CADASTRADO COM SUCESSO!    ==");
    System.out.println("===========================================");
    System.out.print("\nPressione ENTER para voltar ao menu...");
    sc.nextLine();
    limparTela();
    break;
}
   case 2: {
    boolean cancelado = false;

    java.util.function.Function<String, Boolean> verificarCancelamento = entrada -> {
        if (entrada.equals("0")) {
            System.out.print("Tem certeza que deseja cancelar a abertura da conta? (S/N): ");
            String confirma = sc.nextLine().trim().toUpperCase();
            if (confirma.equals("S")) {
                try {
                    limparTela();
                    System.out.println("========================================");
                    System.out.println("=      ABERTURA DE CONTA CANCELADA.    =");
                    System.out.println("========================================");
                    Thread.sleep(1500);
                    limparTela();
                } catch (InterruptedException e) {
                    System.out.println("Erro ao pausar a execucao.");
                }
                return true;
            } else {
                System.out.println("\nContinuando abertura de conta...");
                try {
                    Thread.sleep(1000);
                    System.out.println("==============================================");
                    System.out.println("== ABERTURA DE CONTA CORRENTE - UNIBANKONE ==");
                    System.out.println("==============================================");
                    Thread.sleep(1000); 
                    limparTela();
            } catch (InterruptedException e) {
                System.out.println("Erro ao limpar a tela.");
            }
        }

    }
     return false;
};

    limparTela();
    System.out.println("==============================================");
    System.out.println("== ABERTURA DE CONTA CORRENTE - UNIBANKONE ==");
    System.out.println("==============================================");

    String cpf;
    while (true) {
        System.out.print(">> Informe o CPF do cliente (ou 0 para cancelar): ");
        cpf = sc.nextLine().replaceAll("[^0-9]", "").trim();
        if (verificarCancelamento.apply(cpf)) {
            cancelado = true;
            break;
        }

        if (cpf.matches("\\d{11}")) {
            cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
            break;
        }

        limparTela();
        System.out.println("CPF invalido! Digite 11 numeros.");
    }
    if (cancelado) break;

    Cliente cli = banco.buscarClientePorCpf(cpf);
    if (cli == null) {
        limparTela();
        System.out.println("Cliente nao encontrado!");
        Thread.sleep(1500);
        limparTela();
        break;
    }

    if (cli.getIdade() < 18 && !menoresComTermoAssinado.contains(cli.getCpf())) {
        System.out.println("\nMenor de idade detectado. Autorizacao necessaria.");

        System.out.print(">> Nome do responsavel: ");
        String nomeResp = sc.nextLine().trim();

        String cpfResp;
        while (true) {
            System.out.print(">> CPF do responsavel: ");
            cpfResp = sc.nextLine().replaceAll("[^0-9]", "").trim();
            if (!cpfResp.matches("\\d{11}")) {
                System.out.println("CPF invalido! Digite 11 numeros.");
                continue;
            }
            
            cpfResp = cpfResp.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

           if (dadosResponsaveis.containsValue(cpfResp)) {
                System.out.println("Erro: Este CPF de responsavel ja esta vinculado a outro menor.");
                Thread.sleep(1500);
                limparTela();
                break;
            }
            break;
        }
        System.out.print(">> Data de autorizacao (DD/MM/AAAA): ");
        String data = sc.nextLine().trim();

        limparTela();
        System.out.println("\n=============================================================");
        System.out.println("|     TERMO DE AUTORIZACAO PARA ABERTURA DE CONTA          |");
        System.out.println("=============================================================");
        System.out.println("Responsavel: " + nomeResp);
        System.out.println("CPF do Responsavel: " + cpfResp);
        System.out.println("Menor: " + cli.getNome());
        System.out.println("CPF do Menor: " + cli.getCpf());
        System.out.println("Data: " + data);
        System.out.println("\nAUTORIZO a abertura da conta bancaria em nome do menor acima.");
        System.out.println("=============================================================");

        menoresComTermoAssinado.add(cli.getCpf());
        dadosResponsaveis.put(cli.getCpf(), nomeResp + " (CPF: " + cpfResp + ")");

        System.out.print("Pressione ENTER para continuar...");
        sc.nextLine();
        limparTela();
    }

    if (cli.getIdade() >= 18 || menoresComTermoAssinado.contains(cli.getCpf())) {
        String numeroConta;
        while (true) {
            System.out.print(">> Numero da nova conta (ou 0 para cancelar): ");
            numeroConta = sc.nextLine().trim();
            if (verificarCancelamento.apply(numeroConta)) {
                cancelado = true;
                break;
            }
            if (!numeroConta.isEmpty()) {
                if (banco.buscarContaPorNumero(numeroConta) != null) {
                    limparTela();
                    System.out.println("Erro: Ja existe uma conta com este numero.");
                    Thread.sleep(1500);
                    continue;
                }
                break;
            }
            limparTela();
            System.out.println("Numero da conta invalido!");
        }
        if (cancelado) break;

        double limite = 0;
        while (true) {
            System.out.print(">> Limite do cheque especial (ou 0 para cancelar): ");
            String entrada = sc.nextLine().trim();
            if (verificarCancelamento.apply(entrada)) {
                cancelado = true;
                break;
            }
            try {
                limite = Double.parseDouble(entrada);
                if (limite >= 0) break;
                limparTela();
                System.out.println("O limite nao pode ser negativo!");
            } catch (NumberFormatException e) {
                limparTela();
                System.out.println("Entrada invalida! Use numeros decimais.");
            }
        }
        if (cancelado) break;

        ContaCorrente cc = new ContaCorrente(numeroConta, cli, limite);
        cli.abrirConta(cc);
        banco.adicionarConta(cc);

        System.out.println();
        System.out.println("==============================================");
        System.out.println("==     CONTA CORRENTE CRIADA COM SUCESSO!   ==");
        System.out.println("==============================================");
        System.out.print("\nPressione ENTER para voltar ao menu...");
        sc.nextLine();
        limparTela();
    }
    break;
}
    case 3: {
    boolean cancelado = false;

    java.util.function.Function<String, Boolean> verificarCancelamento = entrada -> {
        if (entrada.equals("0")) {
            System.out.print("Tem certeza que deseja cancelar a abertura da conta? (S/N): ");
            String confirma = sc.nextLine().trim().toUpperCase();
            if (confirma.equals("S")) {
                try {
                    limparTela();
                    System.out.println("==============================================");
                    System.out.println("=   ABERTURA DE CONTA POUPANCA CANCELADA.   =");
                    System.out.println("==============================================");
                    Thread.sleep(1500);
                    limparTela();
                } catch (InterruptedException e) {
                    System.out.println("Erro ao pausar a execucao.");
                }
                return true;
           } else {
               System.out.println("\nContinuando abertura de conta...");
               try {
                   Thread.sleep(1000);
                   System.out.println("==============================================");
                   System.out.println("== ABERTURA DE CONTA POUPANCA - UNIBANKONE ==");
                   System.out.println("==============================================");
                   Thread.sleep(1000); 
                   limparTela();
               } catch (InterruptedException e) {
                   System.out.println("Erro ao limpar a tela.");
            }
        }

    }
    return false;
};
    limparTela();
    System.out.println("==============================================");
    System.out.println("== ABERTURA DE CONTA POUPANCA - UNIBANKONE ==");
    System.out.println("==============================================");

    String cpf;
    while (true) {
        System.out.print(">> Informe o CPF do cliente (ou 0 para cancelar): ");
        cpf = sc.nextLine().replaceAll("[^0-9]", "").trim();
        if (verificarCancelamento.apply(cpf)) {
            cancelado = true;
            break;
        }

        if (cpf.matches("\\d{11}")) {
            cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
            break;
        }

        limparTela();
        System.out.println("==============================================");
        System.out.println("==    ABERTURA DE CONTA POUPANCA - UNIBO    ==");
        System.out.println("==============================================");
        System.out.println("CPF invalido! Digite 11 numeros.");
    }
    if (cancelado) break;

    Cliente cli = banco.buscarClientePorCpf(cpf);
    if (cli == null) {
        limparTela();
        System.out.println("==============================================");
        System.out.println("==    ABERTURA DE CONTA POUPANCA - UNIBO    ==");
        System.out.println("==============================================");
        System.out.println("\nCliente nao encontrado!");
        Thread.sleep(1500);
        limparTela();
        break;
    }

    if (cli.getIdade() < 18 && !menoresComTermoAssinado.contains(cli.getCpf())) {
        System.out.println("\nMenor de idade detectado. Autorizacao necessaria.");

        System.out.print(">> Nome do responsavel: ");
        String nomeResp = sc.nextLine().trim();

        System.out.print(">> CPF do responsavel: ");
        String cpfResp = sc.nextLine().replaceAll("[^0-9]", "").trim();
        cpfResp = cpfResp.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

        if (dadosResponsaveis.containsValue(cpfResp)) {
        System.out.println("Erro: Este CPF de responsavel ja esta vinculado a outro menor.");
        Thread.sleep(1500);
        limparTela();
        break;
    }
        System.out.print(">> Data de autorizacao (DD/MM/AAAA): ");
        String data = sc.nextLine().trim();

        limparTela();
        System.out.println("\n=============================================================");
        System.out.println("|     TERMO DE AUTORIZACAO PARA ABERTURA DE CONTA          |");
        System.out.println("=============================================================");
        System.out.println("Responsavel: " + nomeResp);
        System.out.println("CPF do Responsavel: " + cpfResp);
        System.out.println("Menor: " + cli.getNome());
        System.out.println("CPF do Menor: " + cli.getCpf());
        System.out.println("Data: " + data);
        System.out.println("\nAUTORIZO a abertura da conta bancaria em nome do menor acima.");
        System.out.println("=============================================================");

        menoresComTermoAssinado.add(cli.getCpf());
        dadosResponsaveis.put(cli.getCpf(), nomeResp + " (CPF: " + cpfResp + ")");

        System.out.print("Pressione ENTER para continuar...");
        sc.nextLine();
        limparTela();
    }

    if (cli.getIdade() >= 18 || menoresComTermoAssinado.contains(cli.getCpf())) {
        String numeroConta;
        while (true) {
            System.out.print(">> Numero da nova conta (ou 0 para cancelar): ");
            numeroConta = sc.nextLine().trim();
            if (verificarCancelamento.apply(numeroConta)) {
                cancelado = true;
                break;
            }
            if (!numeroConta.isEmpty()) {
                if (banco.buscarContaPorNumero(numeroConta) != null) {
                    limparTela();
                    System.out.println("==============================================");
                    System.out.println("==    ABERTURA DE CONTA POUPANCA - UNIBO    ==");
                    System.out.println("==============================================");
                    System.out.println("Erro: Ja existe uma conta com este numero.");
                    Thread.sleep(1500);
                    continue;
                }
                break;
            }
            limparTela();
            System.out.println("==============================================");
            System.out.println("==    ABERTURA DE CONTA POUPANCA - UNIBO    ==");
            System.out.println("==============================================");
            System.out.println("Numero da conta invalido!");
        }
        if (cancelado) break;

        double taxa = 0;
        while (true) {
            System.out.print(">> Taxa de juros (ex: 0.05) (ou 0 para cancelar): ");
            String entrada = sc.nextLine().trim();
            if (verificarCancelamento.apply(entrada)) {
                cancelado = true;
                break;
            }
            try {
                taxa = Double.parseDouble(entrada);
                if (taxa >= 0 && taxa <= 1) break;

                limparTela();
                System.out.println("==============================================");
                System.out.println("==    ABERTURA DE CONTA POUPANCA - UNIBO    ==");
                System.out.println("==============================================");
                System.out.println("Taxa invalida! Digite um valor entre 0.00 e 1.00");
            } catch (NumberFormatException e) {
                limparTela();
                System.out.println("==============================================");
                System.out.println("==    ABERTURA DE CONTA POUPANCA - UNIBO    ==");
                System.out.println("==============================================");
                System.out.println("Entrada invalida! Use numeros decimais.");
            }
        }
        if (cancelado) break;

        ContaPoupanca cp = new ContaPoupanca(numeroConta, cli, taxa);
        cli.abrirConta(cp);
        banco.adicionarConta(cp);

        System.out.println();
        System.out.println("==============================================");
        System.out.println("==    CONTA POUPANCA CRIADA COM SUCESSO!    ==");
        System.out.println("==============================================");
        System.out.print("\nPressione ENTER para voltar ao menu...");
        sc.nextLine();
        limparTela();
    }
    break;
}
   case 4: { 
    boolean cancelado = false;

    java.util.function.Function<String, Boolean> verificarCancelamento = entrada -> {
        if (entrada.equals("0")) {
            System.out.print("Tem certeza que deseja cancelar a consulta? (S/N): ");
            String confirma = sc.nextLine().trim().toUpperCase();
            if (confirma.equals("S")) {
                try {
                    limparTela();
                    System.out.println("===========================================");
                    System.out.println("=      CONSULTA DE CONTAS CANCELADA.      =");
                    System.out.println("===========================================");
                    Thread.sleep(1500);
                    limparTela();
                } catch (InterruptedException e) {
                    System.out.println("Erro ao pausar a execucao.");
                }
                return true;
            } else {
                System.out.println("\nContinuando consulta...");
                try {
                    Thread.sleep(1000);
                    limparTela();
                    System.out.println("===============================================");
                    System.out.println("==       CONSULTA DE CONTAS DO CLIENTE       ==");
                    System.out.println("===============================================");
                } catch (InterruptedException e) {
                    System.out.println("Erro ao limpar a tela.");
                }
            }
        }
        return false;
    };

    limparTela();
    System.out.println("==============================================");
    System.out.println("==       CONSULTA DE CONTAS DO CLIENTE       ==");
    System.out.println("==============================================");

    String cpf;
    while (true) {
        System.out.print(">> Informe o CPF do cliente (ou 0 para cancelar): ");
        cpf = sc.nextLine().replaceAll("[^0-9]", "").trim();
        if (verificarCancelamento.apply(cpf)) {
            cancelado = true;
            break;
        }
        if (cpf.matches("\\d{11}")) {
            cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
            break;
        }

        limparTela();
        System.out.println("==============================================");
        System.out.println("==       CONSULTA DE CONTAS DO CLIENTE       ==");
        System.out.println("==============================================");
        System.out.println("CPF invalido! Digite 11 numeros.");
    }

    if (cancelado) break;

    Cliente cli = banco.buscarClientePorCpf(cpf);
    if (cli != null) {
        limparTela();
        System.out.println("==============================================");
        System.out.println("==       DADOS DO CLIENTE CONSULTADO        ==");
        System.out.println("==============================================");
        System.out.println("Nome do Cliente: " + cli.getNome());
        System.out.println("CPF do Cliente: " + cli.getCpf());

        if (cli.getIdade() < 18 && dadosResponsaveis.containsKey(cli.getCpf())) {
            System.out.println("\n=== DADOS DO RESPONSAVEL LEGAL ===");
            String dados = dadosResponsaveis.get(cli.getCpf());
            System.out.println("Responsavel Legal: " + dados);
        }

        System.out.println("\n=== CONTAS ASSOCIADAS ===");
        cli.listarContas();
    } else {
        System.out.println("Cliente nao encontrado.");
    }

    System.out.print("\nPressione ENTER para voltar ao menu...");
    sc.nextLine();
    limparTela();
    break;
}
    case 5: {
    boolean cancelado = false;

    java.util.function.Function<String, Boolean> verificarCancelamento = entrada -> {
        if (entrada.equals("0")) {
            System.out.print("Tem certeza que deseja cancelar o deposito? (S/N): ");
            String confirma = sc.nextLine().trim().toUpperCase();
            if (confirma.equals("S")) {
                try {
                    limparTela();
                    System.out.println("=========================================");
                    System.out.println("=          DEPOSITO CANCELADO.          =");
                    System.out.println("=========================================");
                    Thread.sleep(1500);
                    limparTela();
                } catch (InterruptedException e) {
                    System.out.println("Erro ao pausar a execucao.");
                }
                return true;
            } else {
                try {
                    System.out.println("\nContinuando operacao...");
                    Thread.sleep(1000);
                    limparTela();
                    System.out.println("=================================");
                    System.out.println("==      DEPOSITO BANCARIO      ==");
                    System.out.println("=================================");
                } catch (InterruptedException e) {}
                return false;
            }
        }
        return false;
    };

    limparTela();
    System.out.println("=================================");
    System.out.println("==      DEPOSITO BANCARIO      ==");
    System.out.println("=================================");

    String numeroConta;
    while (true) {
        System.out.print(">> Numero da conta (ou 0 para cancelar): ");
        numeroConta = sc.nextLine().trim();
        if (verificarCancelamento.apply(numeroConta)) {
            cancelado = true;
            break;
        }
        if (numeroConta.equals("0")) continue;
        if (!numeroConta.isEmpty()) break;

        limparTela();
        System.out.println("Numero da conta invalido!");
    }
    if (cancelado) break;

    Conta conta = banco.buscarContaPorNumero(numeroConta);
    if (conta == null) {
        System.out.println("Conta nao encontrada.");
        Thread.sleep(1500);
        limparTela();
        break;
    }

    double valor = 0;
    while (true) {
        System.out.print(">> Valor para deposito (ou 0 para cancelar): ");
        String entrada = sc.nextLine().trim();
        if (verificarCancelamento.apply(entrada)) {
            cancelado = true;
            break;
        }
        if (entrada.equals("0")) continue;
        try {
            valor = Double.parseDouble(entrada);
            if (valor > 0) break;
            System.out.println("O valor deve ser maior que zero.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida! Use numeros decimais.");
        }
    }
    if (cancelado) break;

    conta.depositar(valor);
    System.out.println("\nDeposito realizado com sucesso!");
    System.out.print("Pressione ENTER para voltar ao menu...");
    sc.nextLine();
    limparTela();
    break;
}
    case 6: {
    boolean cancelado = false;

    java.util.function.Function<String, Boolean> verificarCancelamento = entrada -> {
        if (entrada.equals("0")) {
            System.out.print("Tem certeza que deseja cancelar o saque? (S/N): ");
            String confirma = sc.nextLine().trim().toUpperCase();
            if (confirma.equals("S")) {
                try {
                    limparTela();
                    System.out.println("========================================");
                    System.out.println("=           SAQUE CANCELADO.           =");
                    System.out.println("========================================");
                    Thread.sleep(1500);
                    limparTela();
                } catch (InterruptedException e) {}
                return true;
            } else {
                try {
                    System.out.println("\nContinuando operacao...");
                    Thread.sleep(1000);
                    limparTela();
                    System.out.println("=================================");
                    System.out.println("==         SAQUE BANCARIO       ==");
                    System.out.println("=================================");
                } catch (InterruptedException e) {}
                return false;
            }
        }
        return false;
    };

    limparTela();
    System.out.println("=================================");
    System.out.println("==         SAQUE BANCARIO       ==");
    System.out.println("=================================");

    String numeroConta;
    while (true) {
        System.out.print(">> Numero da conta (ou 0 para cancelar): ");
        numeroConta = sc.nextLine().trim();
        if (verificarCancelamento.apply(numeroConta)) {
            cancelado = true;
            break;
        }
        if (numeroConta.equals("0")) continue;
        if (!numeroConta.isEmpty()) break;

        limparTela();
        System.out.println("Numero da conta invalido!");
    }
    if (cancelado) break;

    Conta conta = banco.buscarContaPorNumero(numeroConta);
    if (conta == null) {
        System.out.println("Conta nao encontrada.");
        Thread.sleep(1500);
        limparTela();
        break;
    }

    double valor = 0;
    while (true) {
        System.out.print(">> Valor para saque (ou 0 para cancelar): ");
        String entrada = sc.nextLine().trim();
        if (verificarCancelamento.apply(entrada)) {
            cancelado = true;
            break;
        }
        if (entrada.equals("0")) continue;
        try {
            valor = Double.parseDouble(entrada);
            if (valor > 0) break;
            System.out.println("O valor deve ser maior que zero.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida! Use numeros decimais.");
        }
    }
    if (cancelado) break;

    conta.sacar(valor);
    System.out.println("\nSaque realizado com sucesso!");
    System.out.print("Pressione ENTER para voltar ao menu...");
    sc.nextLine();
    limparTela();
    break;
}
    case 7: {
    boolean cancelado = false;

    java.util.function.Function<String, Boolean> verificarCancelamento = entrada -> {
        if (entrada.equals("0")) {
            System.out.print("Tem certeza que deseja cancelar a transferencia? (S/N): ");
            String confirma = sc.nextLine().trim().toUpperCase();
            if (confirma.equals("S")) {
                try {
                    limparTela();
                    System.out.println("=========================================");
                    System.out.println("=       TRANSFERENCIA CANCELADA.       ==");
                    System.out.println("=========================================");
                    Thread.sleep(1500);
                    limparTela();
                } catch (InterruptedException e) {}
                return true;
            } else {
                try {
                    System.out.println("\nContinuando transferencia...");
                    Thread.sleep(1000);
                    limparTela();
                    System.out.println("=================================");
                    System.out.println("==    TRANSFERENCIA - UNIBO    ==");
                    System.out.println("=================================");
                } catch (InterruptedException e) {}
                return false;
            }
        }
        return false;
    };

    limparTela();
    System.out.println("=================================");
    System.out.println("==    TRANSFERENCIA - UNIBO    ==");
    System.out.println("=================================");

    String origem;
    while (true) {
        System.out.print(">> Conta de origem (ou 0 para cancelar): ");
        origem = sc.nextLine().trim();
        if (verificarCancelamento.apply(origem)) {
            cancelado = true;
            break;
        }
        if (origem.equals("0")) continue;
        if (!origem.isEmpty()) break;

        limparTela();
        System.out.println("Conta de origem invalida!");
    }
    if (cancelado) break;

    String destino;
    while (true) {
        System.out.print(">> Conta de destino (ou 0 para cancelar): ");
        destino = sc.nextLine().trim();
        if (verificarCancelamento.apply(destino)) {
            cancelado = true;
            break;
        }
        if (destino.equals("0")) continue;
        if (!destino.isEmpty()) break;

        limparTela();
        System.out.println("Conta de destino invalida!");
    }
    if (cancelado) break;

    Conta cOrigem = banco.buscarContaPorNumero(origem);
    Conta cDestino = banco.buscarContaPorNumero(destino);
    if (cOrigem == null || cDestino == null) {
        System.out.println("Conta de origem ou destino nao encontrada.");
        Thread.sleep(1500);
        limparTela();
        break;
    }

    double valor = 0;
    while (true) {
        System.out.print(">> Valor para transferir (ou 0 para cancelar): ");
        String entrada = sc.nextLine().trim();
        if (verificarCancelamento.apply(entrada)) {
            cancelado = true;
            break;
        }
        if (entrada.equals("0")) continue;
        try {
            valor = Double.parseDouble(entrada);
            if (valor > 0) break;
            System.out.println("O valor deve ser maior que zero.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida! Use numeros decimais.");
        }
    }
    if (cancelado) break;

    cOrigem.transferir(valor, cDestino);
    System.out.println("\nTransferencia realizada com sucesso!");
    System.out.print("Pressione ENTER para voltar ao menu...");
    sc.nextLine();
    limparTela();
    break;
}

case 8: {
    int tentativas = 3;
    boolean autenticado = false;

    while (tentativas > 0) {
        limparTela();
        System.out.println("===============================================");
        System.out.println("=       LOGIN - BACKOFFICE UNIBANKONE         =");
        System.out.println("===============================================");
        System.out.print("Usuario: ");
        String usuario = sc.nextLine().trim();
        System.out.print("Senha: ");
        String senha = sc.nextLine().trim();

        if (usuario.equalsIgnoreCase("Admin") && senha.equals("1234")) {
            autenticado = true;
            break;
        } else {
            tentativas--;
            System.out.println("\nCredenciais invalidas. Tentativas restantes: " + tentativas);
            Thread.sleep(1500);
        }
    }

    if (!autenticado) {
        System.out.println("\nAcesso negado. Retornando ao menu principal...");
        Thread.sleep(2000);
        limparTela();
        break;
    }

    boolean voltarMenu = false;
    while (!voltarMenu) {
        limparTela();
        System.out.println("===============================================");
        System.out.println("=        BACKOFFICE UNIBANKONE - ADM          =");
        System.out.println("===============================================");
        System.out.println("= 1 - Lista de clientes e contas              =");
        System.out.println("= 2 - Estatisticas do sistema                 =");
        System.out.println("= 3 - Buscar cliente por CPF                  =");
        System.out.println("= 4 - Listar contas abertas no polo bancario  =");
        System.out.println("= 5 - Total de contas por tipo                =");
        System.out.println("= 6 - Listar responsaveis por menores         =");
        System.out.println("= 7 - Verificar contas com saldo zerado       =");
        System.out.println("= 8 - Alterar dados de cliente                =");
        System.out.println("= 9 - Excluir conta bancaria                  =");
        System.out.println("= 10 - Voltar ao menu principal               =");
        System.out.println("===============================================");
        System.out.print("Escolha uma opcao: ");
        int opcaoADM = sc.nextInt();
        sc.nextLine();

        switch (opcaoADM) {
            case 1:
                listarClientesEContas();
                break;
            case 2:
                mostrarEstatisticas();
                break;
            case 3:
                buscarClientePorCPF();
                break;
            case 4:
                listarContasAbertas();
                break;
            case 5:
                totalContasPorTipo();
                break;
            case 6:
                listarResponsaveisPorMenores();
                break;
            case 7:
                verificarContasZeradas();
                break;
            case 8:
                alterarDadosCliente();
                break;
            case 9:
                excluirContaBancaria();
                break;
           case 10: {
               String confirmarVolta;
               while (true) {
                   System.out.print("\nDeseja realmente voltar ao menu principal? (S/N): ");
                   confirmarVolta = sc.nextLine().trim().toUpperCase();
                   if (confirmarVolta.equals("S")) {
                       voltarMenu = true;
                       break;
                   } else if (confirmarVolta.equals("N")) {
                       voltarMenu = false;
                       break;
                   } else {
                       System.out.println("Entrada invalida! Digite apenas 'S' para Sim ou 'N' para Nao.");
                   }
                }
                break;
            }
        }
        
    }
    break;       
}  
    case 9: {
        limparTela();
        sobreOSistema();
        break;
    }
                case 10: {
                    String confirmarSaida;
                    while (true) {
                        System.out.print("\nDeseja realmente sair? (S/N): ");
                        confirmarSaida = sc.nextLine().trim().toUpperCase();
                        if (confirmarSaida.equals("S") || confirmarSaida.equals("N")) {
                            break;
                        } else {
                            System.out.println("Entrada invalida! Digite apenas 'S' para Sim ou 'N' para Nao.");
                        }
                    }
                    if (confirmarSaida.equals("S")) {
                        limparTela();
                        System.out.println("============================");
                        System.out.println("= Finalizando o sistema... =");
                        System.out.println("============================");
                        Thread.sleep(1500);
                        limparTela();
                        System.out.println("=============================================");
                        System.out.println("  Obrigado por utilizar o sistema UnibankOne ");
                        System.out.println("=    Sua confianca e a nossa prioridade.    =");
                        System.out.println("=  Volte sempre. Estamos a sua disposicao.  =");
                        System.out.println("=============================================");
                        Thread.sleep(2000);
                    } else {
                        opcao = -1;
                    }
                    break;
                }
            }

        } while (opcao != 10);

        sc.close();
    }

   public static void listarClientesEContas() throws InterruptedException {
      limparTela();
      System.out.println("===============================================");
      System.out.println("=     LISTAGEM DE CLIENTES E SUAS CONTAS      =");
      System.out.println("===============================================");

      if (banco.getListaClientes().isEmpty()) {
          System.out.println("Nenhum cliente cadastrado.");
      } else {
           for (Cliente cliente : banco.getListaClientes()) {
              System.out.println("-----------------------------------------------");
              System.out.println("Nome: " + cliente.getNome());
              System.out.println("CPF: " + cliente.getCpf());
              System.out.println("Contas:");
              for (Conta conta : cliente.getContas()) {
                  System.out.println(" - No: " + conta.getNumeroConta() + " | Saldo: R$ " + conta.getSaldo());
                }
            }
        }
        System.out.print("\nPressione ENTER para voltar...");
        new Scanner(System.in).nextLine();
        limparTela();
    }

public static void mostrarEstatisticas() throws InterruptedException {
    limparTela();
    System.out.println("===============================================");
    System.out.println("=         ESTATISTICAS DO SISTEMA             =");
    System.out.println("===============================================");
    System.out.println("Total de clientes: " + banco.getListaClientes().size());
    System.out.println("Total de contas: " + banco.getListaContas().size());

    int menores = 0;
    for (Cliente c : banco.getListaClientes()) {
        if (c.getIdade() < 18) menores++;
    }
    System.out.println("Clientes menores de idade: " + menores);
    System.out.print("\nPressione ENTER para voltar...");
    new Scanner(System.in).nextLine();
    limparTela();
}

public static void buscarClientePorCPF() throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    limparTela();
    System.out.print("Digite o CPF do cliente: ");
    String cpf = sc.nextLine().replaceAll("[^0-9]", "");
    cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

    Cliente cliente = null;
    for (Cliente c : banco.getListaClientes()) {
        if (c.getCpf().equals(cpf)) {
            cliente = c;
            break;
        }
    }

    if (cliente != null) {
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Data de nascimento: " + cliente.getDataNascimento());
        System.out.println("Contas:");
        for (Conta conta : cliente.getContas()) {
            System.out.println(" - No: " + conta.getNumeroConta() + " | Saldo: R$ " + conta.getSaldo());
        }
    } else {
        System.out.println("Cliente nao encontrado.");
    }

    System.out.print("\nPressione ENTER para voltar...");
    sc.nextLine();
    limparTela();
}

public static void listarContasAbertas() throws InterruptedException {
    limparTela();
    System.out.println("===============================================");
    System.out.println("=         CONTAS ABERTAS NO SISTEMA           =");
    System.out.println("===============================================");

    if (banco.getListaContas().isEmpty()) {
        System.out.println("Nenhuma conta cadastrada.");
    } else {
        for (Conta conta : banco.getListaContas()) {
            System.out.println("Conta: " + conta.getNumeroConta());
            System.out.println("Titular: " + conta.getTitular().getNome());
            System.out.println("-----------------------------------------------");
        }
    }
    System.out.print("\nPressione ENTER para voltar...");
    new Scanner(System.in).nextLine();
    limparTela();
}

public static void totalContasPorTipo() throws InterruptedException {
    int cc = 0, cp = 0;
    for (Conta conta : banco.getListaContas()) {
        if (conta instanceof ContaCorrente) cc++;
        else if (conta instanceof ContaPoupanca) cp++;
    }

    limparTela();
    System.out.println("===============================================");
    System.out.println("=       TOTAL DE CONTAS POR TIPO              =");
    System.out.println("===============================================");
    System.out.println("Contas Corrente: " + cc);
    System.out.println("Contas Poupanca: " + cp);
    System.out.print("\nPressione ENTER para voltar...");
    new Scanner(System.in).nextLine();
    limparTela();
}

public static void listarResponsaveisPorMenores() throws InterruptedException {
    limparTela();
    System.out.println("===============================================");
    System.out.println("=     RESPONSAVEIS LEGAIS CADASTRADOS         =");
    System.out.println("===============================================");
    if (dadosResponsaveis.isEmpty()) {
        System.out.println("Nenhum responsavel legal registrado.");
    } else {
        for (Map.Entry<String, String> entry : dadosResponsaveis.entrySet()) {
            String cpfMenor = entry.getKey();
            String dadosResp = entry.getValue();
            System.out.println("Menor (CPF): " + cpfMenor);
            System.out.println("Responsavel: " + dadosResp);
            System.out.println("-----------------------------------------------");
        }
    }
    System.out.print("\nPressione ENTER para voltar...");
    new Scanner(System.in).nextLine();
    limparTela();
}

public static void verificarContasZeradas() throws InterruptedException {
    limparTela();
    System.out.println("===============================================");
    System.out.println("=         CONTAS COM SALDO ZERADO             =");
    System.out.println("===============================================");
    boolean encontrou = false;
    for (Conta conta : banco.getListaContas()) {
        if (conta.getSaldo() == 0) {
            System.out.println("Conta: " + conta.getNumeroConta());
            System.out.println("Titular: " + conta.getTitular().getNome());
            System.out.println("-----------------------------------------------");
            encontrou = true;
        }
    }
    if (!encontrou) {
        System.out.println("Nenhuma conta com saldo zerado.");
    }
    System.out.print("\nPressione ENTER para voltar...");
    new Scanner(System.in).nextLine();
    limparTela();
}

public static void alterarDadosCliente() throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    limparTela();
    System.out.print("CPF do cliente a alterar: ");
    String cpf = sc.nextLine().replaceAll("[^0-9]", "");
    cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

    Cliente cliente = null;
    for (Cliente c : banco.getListaClientes()) {
        if (c.getCpf().equals(cpf)) {
            cliente = c;
            break;
        }
    }

    if (cliente == null) {
        System.out.println("Cliente nao encontrado.");
        Thread.sleep(1500);
        limparTela();
        return;
    }

    System.out.print("Novo nome: ");
    String novoNome = sc.nextLine().trim();
    System.out.print("Novo endereco: ");
    String novoEndereco = sc.nextLine().trim();

    cliente.setNome(novoNome);
    cliente.setEndereco(novoEndereco);

    System.out.println("Dados atualizados com sucesso!");
    System.out.print("Pressione ENTER para voltar...");
    sc.nextLine();
    limparTela();
}

public static void excluirContaBancaria() throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    limparTela();
    System.out.print("Numero da conta para excluir: ");
    String numero = sc.nextLine().trim();

    Conta contaRemover = null;
    for (Conta conta : banco.getListaContas()) {
        if (conta.getNumeroConta().equals(numero)) {
            contaRemover = conta;
            break;
        }
    }

    if (contaRemover == null) {
        System.out.println("Conta nao encontrada.");
        Thread.sleep(1500);
        limparTela();
        return;
    }

    banco.getListaContas().remove(contaRemover);
    contaRemover.getTitular().getContas().remove(contaRemover);

    System.out.println("Conta removida com sucesso.");
    System.out.print("Pressione ENTER para voltar...");
    sc.nextLine();
    limparTela();
}

    public static void sobreOSistema() {
        Scanner sc = new Scanner(System.in);
    
    limparTela();
    System.out.println("=============================================");
    System.out.println("|-------------------------------------------|");
    System.out.println("|= CREDITOS: SISTEMA BANCARIO - UNIBANKONE =|");
    System.out.println("|-------------------------------------------|");
    System.out.println("=============================================");
    System.out.println("= Sistema Bancario - UniBankOne             =");
    System.out.println("= Desenvolvido em Java com POO              =");
    System.out.println("= Utilizando as classes:                    =");
    System.out.println("= -> SistemaBancario (Main)                 =");
    System.out.println("= -> Pessoa                                 =");
    System.out.println("= -> Funcionario                            =");
    System.out.println("= -> ContaPoupanca                          =");
    System.out.println("= -> ContaCorrente                          =");
    System.out.println("= -> Conta                                  =");
    System.out.println("= -> Cliente                                =");
    System.out.println("= -> Banco                                  =");
    System.out.println("=-------------------------------------------=");
    System.out.println("= Autor: Vitor Manoel Vidal Braz            =");
    System.out.println("= Orientacao: Vitor Silva Ribeiro           =");
    System.out.println("= Univale - 3o periodo de SI                =");
    System.out.println("= Disciplina de POO                         =");
    System.out.println("=-------------------------------------------=");
    System.out.println("= Desenvolvido com a engine grafica         =");
    System.out.println("= VM ENGINE DEVELOPMENT - Versao 1.5        =");
    System.out.println("=============================================");
    System.out.print("\nPressione ENTER para ver mais informacoes....");
    sc.nextLine();

    limparTela();
    System.out.println();
    System.out.println(" __      __ __  __     _____  __     _______ _______ __  __ ");
    System.out.println(" \\ \\    / /|  \\/  |   / ____| \\ \\   / / ____|__   __|  \\/  |");
    System.out.println("  \\ \\  / / | \\  / |  | (___    \\ \\_/ / (___    | |  | \\  / |");
    System.out.println("   \\ \\/ /  | |\\/| |   \\___ \\    \\   / \\___ \\   | |  | |\\/| |");
    System.out.println("    \\  /   | |  | |   ____) |    | |  ____) |  | |  | |  | |");
    System.out.println("     \\/    |_|  |_|  |_____/     |_| |_____/   |_|  |_|  |_|");
    System.out.println("                        V M   S Y S T E M S                  ");
    System.out.println();
    System.out.println("Sistema desenvolvido com a engine: VM ENGINE DEVELOPMENT v1.5");
    System.out.println("Desenvolvedor: Vitor Manoel Vidal Braz");
    System.out.println("GitHub: https://github.com/vitormanoelvb");
    System.out.println("Pagina do Codigo no GitHub:");
    System.out.println("https://github.com/vitormanoelvb/sistema-bancario-unibankone");
    System.out.println();

    System.out.print("Deseja abrir o perfil do GitHub? (s/n): ");
    String opcaoPerfil = sc.nextLine().trim().toLowerCase();
    if (opcaoPerfil.equals("s")) {
        abrirLink("https://github.com/vitormanoelvb");
    }

    System.out.print("Deseja abrir a pagina do codigo no GitHub? (s/n): ");
    String opcaoCodigo = sc.nextLine().trim().toLowerCase();
    if (opcaoCodigo.equals("s")) {
        abrirLink("https://github.com/vitormanoelvb/sistema-bancario-unibankone");
    }

    System.out.println();
    System.out.println("Pressione ENTER para voltar ao menu principal...");
    sc.nextLine(); 
    limparTela();
}

public static void abrirLink(String url) {
    try {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI(url));
            System.out.println("Link aberto no navegador.");
        } else {
            System.out.println("Desktop nao suportado neste ambiente.");
        }
    } catch (Exception e) {
        System.out.println("Erro ao tentar abrir o link: " + e.getMessage());
    }
  }
}