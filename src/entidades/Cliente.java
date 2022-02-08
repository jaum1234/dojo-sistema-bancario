package entidades;

import java.util.Objects;

public class Cliente
{
    private int cpf;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String senha;
    private ContaPoupanca contaPoupanca;
    private ContaCorrente contaCorrente;

    public Cliente(int cpf, String dataNascimento, String email, String telefone, String senha)
    {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.senha = senha;
        this.email = email;

        this.contaPoupanca = null;
        this.contaCorrente = null;
    }

    public int cpf()
    {
        return this.cpf;
    }

    public String dataNascimento() {
        return dataNascimento;
    }

    public String email() {
        return email;
    }

    public String telefone() {
        return telefone;
    }

    public String senha() {
        return senha;
    }

    public ContaPoupanca contaPoupanca() {
        return contaPoupanca;
    }

    public ContaCorrente contaCorrente()
    {
        return this.contaCorrente;
    }

    public void addContaCorrente(ContaCorrente contaCorrente) throws Exception
    {
        this.contaCorrente = contaCorrente;
    }

    public void addContaPoupanca(ContaPoupanca contaPoupanca) throws Exception
    {
        this.contaPoupanca = contaPoupanca;
    }

    public boolean possuiContaCorrente()
    {
        return this.contaCorrente != null;
    }

    public boolean possuiContaPoupanca()
    {
        return this.contaPoupanca != null;
    }
}
