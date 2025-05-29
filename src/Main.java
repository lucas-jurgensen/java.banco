import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[1] - criar cliente");
            System.out.println("[2] - listar clientes");
            System.out.println("[3] - buscar cliente");
            System.out.println("[4] - criar conta");
            System.out.println("[5] - listar contas");
            System.out.println("[6] - buscar conta");
            System.out.println("[0] - sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.println("digite o nome: ");
                    String nome = sc.nextLine();
                    System.out.println("digite o cpf: ");
                    String cpf = sc.nextLine();

                    if (nome.isBlank() || cpf.isBlank()) {
                        System.out.println("campos precisam ser preenchidos");
                        break;
                    }

                    Cliente cliente = new Cliente(nome, cpf);
                    banco.criarCliente(cliente);
                    break;
                }

                case 2:
                    banco.listarClientes();
                    break;

                case 3: {
                    System.out.println("digite o cpf do cliente: ");
                    String cpf = sc.nextLine();
                    banco.buscarCliente(cpf);
                    break;
                }

                case 4: {
                    System.out.println("digite o cpf do cliente para criar a conta: ");
                    String cpf = sc.nextLine();

                    if (cpf.isBlank()) {
                        System.out.println("cpf precisa ser informado");
                        break;
                    }

                    Cliente cliente = banco.buscarCliente(cpf);

                    if (cliente == null) {
                        System.out.println("cliente não encontrado, crie um cliente antes de criar uma conta");
                        break;
                    }

                    Conta novaConta = new Conta(cliente);
                    banco.criarConta(cpf, novaConta);
                    break;
                }

                case 5:
                    banco.listarContas();
                    break;

                case 6: {
                    System.out.println("digite o cpf do cliente dono da conta: ");
                    String cpf = sc.nextLine();

                    if (cpf.isBlank()) {
                        System.out.println("o cpf deve ser informado");
                        break;
                    }

                    banco.buscarConta(cpf);
                    break;
                }

                case 0:
                    System.out.println("system down...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("opção inválida");
                    break;
            }
        }
    }
}
