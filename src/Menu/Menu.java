package Menu;

import entidades.Banco;
import entidades.Cliente;

import java.util.Scanner;

public class Menu {

    protected Scanner scanner = new Scanner(System.in);
    protected Banco banco = new Banco();

    public void menuEntrada() throws Exception
    {
        System.out.println("BEM VINDO AO BANCO!\n");

        System.out.println("[1] Já possuo uma conta");
        System.out.println("[2] Criar nova conta");
        System.out.println("\n[3] Sair");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                menuLogin();
                break;
            case 2:
                menuAberturaConta();
                break;
        }
    }

    public void menuLogin() throws Exception
    {
        System.out.println("CPF: ");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        try {
            banco.login(cpf, senha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            menuEntrada();
            return;
        }
        menuPrincipal();
    }

    public void menuPrincipal()
    {
        System.out.println("[1] Depósito");
        System.out.println("[2] Saque");
        System.out.println("[3] Extratos");
        System.out.println("[4] PIX");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                break;
            case 2:
                menuSaque();
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public void menuAberturaConta()
    {
        try {
            selecionarTipoConta();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        menuAberturaConta();
    }

    public void selecionarTipoConta() throws Exception
    {
        System.out.println("Que tipo de conta deseja abrir? ");
        System.out.println("[1] Conta corrente");
        System.out.println("[2] Conta poupança");
        System.out.println("\n[3] Voltar");

        int tipoConta = scanner.nextInt();

        switch (tipoConta) {
            case 1:
                subMenuContaCorrente();
                break;
            case 2:
                subMenuContaPoupanca();
                break;
            case 3:
                menuEntrada();
                break;
        }
    }

    public void subMenuContaCorrente() throws Exception
    {
        System.out.println("Insira seu CPF: ");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        if (banco.clienteJaCadastrado(cpf)) {
            Cliente cliente = banco.buscarCliente(cpf);

            if (cliente.possuiContaCorrente()) {
                throw new Exception("Cliente ja possui Conta Corrente");
            }

            if (cliente.possuiContaPoupanca()) {
                banco.abrirContaCorrente(cliente.cpf(), cliente.dataNascimento(), cliente.email(), cliente.telefone(), cliente.senha());

                menuAberturaConta();
                return;
            }
        }

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        System.out.println("Número de telefone: ");
        String telefone = scanner.nextLine();

        System.out.println("Defina sua senha: ");
        String senha = scanner.nextLine();

        banco.abrirContaCorrente(cpf, dataNascimento, email, telefone, senha);

        menuEntrada();
    }

    public void subMenuContaPoupanca() throws Exception
    {
        System.out.println("Insira seu CPF: ");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        if (banco.clienteJaCadastrado(cpf)) {
            Cliente cliente = banco.buscarCliente(cpf);

            if (cliente.possuiContaPoupanca()) {
                throw new Exception("Cliente ja possui Conta Poupanca");
            }

            if (cliente.possuiContaCorrente()) {
                banco.abrirContaPoupanca(cliente.cpf(), cliente.dataNascimento(), cliente.email(), cliente.telefone(), cliente.senha());

                menuAberturaConta();
                return;
            }
        }

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        System.out.println("Número de telefone: ");
        String telefone = scanner.nextLine();

        System.out.println("Defina sua senha: ");
        String senha = scanner.nextLine();

        banco.abrirContaPoupanca(cpf, dataNascimento, email, telefone, senha);

        menuEntrada();
    }

    public void menuSaque()
    {
        System.out.println("\nConta a ser sacada: ");
        System.out.println("[1] Corrente");
        System.out.println("[2] Poupanca");
        System.out.println("\n[3] Voltar");

        int conta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Valor a ser sacado: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();

        try {
            switch (conta) {
                case 1:
                    banco.realizarSaqueContaCorrente(valor);
                    break;
                case 2:
                    banco.realizarSaqueContaPoupanca(valor);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        menuPrincipal();
    }

    public void menuPix()
    {
        System.out.println("Escolha a forma que será utilizada para a transferencia");
        System.out.println("[1] CPF");
        System.out.println("[2] E-mail");
        System.out.println("[3] Telefone");
        //System.out.println("[4] Chave aleatória");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public void menuPixPorCPF()
    {
        System.out.println("CPF: ");
        int cpf = scanner.nextInt();


    }


    public void menuDeposito()
    {
        System.out.println("Numero da conta que deseja depositar: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Valor a ser depositado: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("De qual de suas contas deseja retirar o valor?");
        System.out.println("[1] Corrente");
        System.out.println("[2] Poupanca");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                break;
            case 2:
                break;
        }
    }
}
