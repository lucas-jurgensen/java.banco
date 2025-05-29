import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas;
    private ArrayList<Cliente> clientes;

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    //métodos clientes
    public void criarCliente(Cliente cliente) {
        //teste
        if (clientes.contains(cliente)) {
            System.out.println("cpf já cadastrado");
            return;
        }

        clientes.add(cliente);
        System.out.println("cliente adicionado");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("não existem clientes cadastrados no banco");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + " - " + cliente.getCpf());
        }
    }

    public Cliente buscarCliente(String cpf) {
        if (clientes.isEmpty()) {
            System.out.println("não existem clientes cadastrados no banco");
            return null;
        }

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println(cliente.getNome() + " - " + cliente.getCpf());
                return cliente;
            }
        }
        System.out.println("cliente não encontrado");
        return null;
    }

    //métodos conta
    public void criarConta(String cpf, Conta novaConta) {
        for (Conta conta : contas) {
            if (conta.getToken_conta().equals(novaConta.getToken_conta())) {
                System.out.println("conta já existente");
                return;
            }
        }

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                contas.add(novaConta);
                System.out.println("conta criada com sucesso");
                return;
            }
        }

        System.out.println("cliente não encontrado, crie um cliente antes de associar uma conta");
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("não existem contas cadastradas no banco");
            return;
        }

        for (Conta conta : contas) {
            System.out.println(conta.getCliente().getNome() + " - " + conta.getToken_conta());
        }
    }

    public Conta buscarConta(String cpf) {
        if (contas.isEmpty()) {
            System.out.println("não existem contas cadastradas no banco");
            return null;
        }

        for (Conta conta : contas) {
            if (conta.getCliente().getCpf().equals(cpf)) {
                System.out.println(conta.getCliente().getNome() + " - saldo: R$ " + conta.getSaldo() + " - " + conta.getToken_conta());
                return conta;
            }
        }
        System.out.println("não foi encontrada uma conta com esse cpf");
        return null;
    }

    //todo - pix / deposito / saque

    //interação entre contas
    public void depositarSaldo(String cpf, float saldo) {
        Conta conta = buscarConta(cpf);

        if (conta == null) {
            return;
        }

        if (saldo <= 0) {
            System.out.println("saldo inválido para depósito");
            return;
        }

        conta.addSaldo(saldo);
    }

    public void sacarSaldo(String cpf, float saldo) {
        Conta conta = buscarConta(cpf);

        if (conta == null) {
            return;
        }

        if (saldo <= 0) {
            System.out.println("saldo inválido para depósito");
            return;
        }

        conta.removeSaldo(saldo);
    }

    public void transferirSaldo(String cpf_o, String cpf_d, float saldo) {
        Conta conta_o = buscarConta(cpf_o);
        Conta conta_d = buscarConta(cpf_d);

        if (conta_o == null || conta_d == null) {
            return;
        }

        if (saldo <= 0) {
            System.out.println("saldo inválido para depósito");
            return;
        }

        if (conta_o.removeSaldo(saldo)) {
            if (conta_d.addSaldo(saldo)) {
                System.out.println("transferência concluida");
            } else {
                conta_o.addSaldo(saldo);
                System.out.println("transferência cancelada devido a um erro");
            }
        } else {
            System.out.println("saldo insuficiente");
        }
    }
}


