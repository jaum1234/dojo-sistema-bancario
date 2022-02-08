package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco
{
    private Cliente usuarioLogado;
    private ArrayList<Cliente> clientes;
    private ArrayList<ContaCorrente> contasCorrente;
    private ArrayList<ContaPoupanca> contasPoupanca;
    private ArrayList<Extrato> extratos;

    public Banco()
    {
        this.clientes = new ArrayList<>();
        this.contasCorrente = new ArrayList<>();
        this.contasPoupanca = new ArrayList<>();
        this.extratos = new ArrayList<>();
    }

    public Cliente usuarioLogado()
    {
        return this.usuarioLogado;
    }

    public void login(int cpf, String senha) throws Exception
    {
        List<Cliente> clienteFiltrado = this.clientes
                .stream()
                .filter(cliente -> cliente.cpf() == cpf && cliente.senha().equals(senha))
                .collect(Collectors.toList());

        if (clienteFiltrado.size() == 0) {
            throw new Exception("Login falhou");
        }

        Cliente cliente = clienteFiltrado.get(0);

        this.usuarioLogado = cliente;
    }

    public void abrirContaCorrente(
            int cpf,
            String dataNascimento,
            String email,
            String telefone,
            String senha
    ) throws Exception {

        Cliente cliente;

        if (this.clienteJaCadastrado(cpf)) {
            cliente = this.buscarCliente(cpf);
        } else {
            cliente = new Cliente(cpf, dataNascimento, email, telefone, senha);
        }

        ContaCorrente conta = new ContaCorrente(cliente);

        cliente.addContaCorrente(conta);
        System.out.println(cliente.contaCorrente().numeroConta());
        this.clientes.add(cliente);
        this.contasCorrente.add(conta);

        System.out.println("Conta corrente criada.");
    }

    public void abrirContaPoupanca(
        int cpf,
        String dataNascimento,
        String email,
        String telefone,
        String senha
    ) throws Exception {

        Cliente cliente;

        if (this.clienteJaCadastrado(cpf)) {
            cliente = this.buscarCliente(cpf);
        } else {
            cliente = new Cliente(cpf, dataNascimento, email, telefone, senha);
        }

        ContaPoupanca conta = new ContaPoupanca(cliente);

        cliente.addContaPoupanca(conta);

        this.clientes.add(cliente);
        this.contasPoupanca.add(conta);

        System.out.println("Conta Poupanca criada.");
    }

    public boolean clienteJaCadastrado(int cpf)
    {
        List<Cliente> clienteFiltrado = this.clientes
                .stream()
                .filter(cliente -> cliente.cpf() == cpf)
                .collect(Collectors.toList());

        return clienteFiltrado.size() != 0 ? true : false;
    }

    public Cliente buscarCliente(int cpf) throws Exception
    {
        List<Cliente> clienteFiltrado = this.clientes
                .stream()
                .filter(cliente -> cliente.cpf() == cpf)
                .collect(Collectors.toList());

        if (clienteFiltrado.size() == 0) {
            throw new Exception("Cliente nao encontrado.");
        }

        return clienteFiltrado.get(0);
    }

    public ContaCorrente buscarContaCorrente(int numeroConta) throws Exception
    {
        List<ContaCorrente> contaFiltrada = this.contasCorrente
                .stream()
                .filter(conta -> conta.numeroConta() == numeroConta)
                .collect(Collectors.toList());

        if (contaFiltrada.size() == 0) {
            throw new Exception("Conta nao encontrada.");
        }

        return contaFiltrada.get(0);
    }

    public ContaPoupanca buscarContaPoupanca(int numeroConta) throws Exception
    {
        List<ContaPoupanca> contaFiltrada = this.contasPoupanca
                .stream()
                .filter(conta -> conta.numeroConta() == numeroConta)
                .collect(Collectors.toList());

        if (contaFiltrada.size() == 0) {
            throw new Exception("Conta nao encontrada.");
        }

        return contaFiltrada.get(0);
    }

    public void realizarSaqueContaCorrente(float valor) throws Exception
    {
        this.usuarioLogado.contaCorrente().sacar(valor);
    }

    public void realizarSaqueContaPoupanca(float valor) throws Exception
    {
        this.usuarioLogado.contaPoupanca().sacar(valor);
    }

    public void realizarPixViaCPF(float valor, int cpf) throws Exception
    {

    }

    public void realizarDeposito(float valor, int numeroConta)
    {

    }



}
