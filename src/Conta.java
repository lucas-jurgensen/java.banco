import java.util.UUID;

public class Conta {

    private Cliente cliente;
    private String token_conta;
    private float saldo;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.token_conta = UUID.randomUUID().toString();
        this.saldo = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getToken_conta() {
        return token_conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public boolean addSaldo(float saldo_add) {
        if (saldo_add <= 0) {
            System.out.println("o saldo a ser adicionado precisa ser válido");
            return false;
        }

        this.saldo += saldo_add;
        return true;
    }

    public boolean removeSaldo(float saldo_rm) {
        if (saldo_rm <= 0 || saldo_rm > this.saldo) {
            System.out.println("saldo insuficiente");
            return false;
        }

        this.saldo -= saldo_rm;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Conta conta = (Conta) obj;
        return this.token_conta.equals(conta.getToken_conta());
    }

    @Override
    public int hashCode() {
        return token_conta.hashCode();
    }
}

