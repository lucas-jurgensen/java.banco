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

    public void buscarConta(String cpf) {
        if (contas.isEmpty()) {
            System.out.println("não existem contas cadastradas no banco");
            return;
        }

        for (Conta conta : contas) {
            if (conta.getCliente().getCpf().equals(cpf)) {
                System.out.println(conta.getCliente().getNome() + " - saldo: R$ " + conta.getSaldo() + " - " + conta.getToken_conta());
                return;
            }
        }
        System.out.println("não foi encontrada uma conta com esse token");
    }

    //todo - pix / deposito / saque

}


