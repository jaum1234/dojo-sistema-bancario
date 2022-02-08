package entidades;

import java.util.Random;

abstract public class Conta
{
    protected int agencia;
    protected int numeroConta;
    protected Cliente cliente;
    protected float saldo;

    public Conta(Cliente cliente) {
        this.agencia = 0001;
        this.numeroConta = new Random().nextInt(1000) + 1;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public int numeroConta()
    {
        return this.numeroConta;
    }

    public Cliente cliente()
    {
        return this.cliente;
    }

    public float sacar(float valor) throws Exception
    {
        if (valor < 0) {
            throw new Exception("Valor inválido");
        }

        if (valor > this.saldo) {
            throw new Exception("Saldo insuficiente.");
        }

        this.saldo -= valor;
        System.out.println("Valor sacado: " + valor);

        return this.saldo;
    }

    public float depositar(float valor, Conta conta) throws Exception
    {
        if (valor < 0) {
            throw new Exception("Valor inválido");
        }

        if (conta == this) {
            if (valor > this.saldo) {
                throw new Exception("Saldo insuficiente.");
            }
        }

        conta.saldo += valor;

        return conta.saldo;
    }
}
