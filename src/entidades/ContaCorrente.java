package entidades;

public class ContaCorrente extends Conta
{
    private float chequeEspecial;

    public ContaCorrente(Cliente cliente)
    {
        super(cliente);
        this.chequeEspecial = 3000;
    }




}
