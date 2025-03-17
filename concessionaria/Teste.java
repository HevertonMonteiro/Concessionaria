package concessionaria;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Carro");
            System.out.println("3. Listar Carros");
            System.out.println("4. Atualizar Carro");
            System.out.println("5. Vender Carro (Remover)");
            System.out.println("6. Listar Clientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1: 
                    System.out.println("\nCadastro de Cliente:");
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    Cliente cliente = new Cliente(cpf, endereco, idade, nome, telefone);
                    loja.cadastrarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2: 
                    System.out.println("\nCadastro de Carro:");
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = Integer.parseInt(scanner.nextLine());
                    System.out.print("Valor Aproximado: ");
                    float valorAproximado = Float.parseFloat(scanner.nextLine());

                    
                    System.out.print("Digite o CPF do dono do carro: ");
                    String cpfDono = scanner.nextLine();
                    Cliente dono = loja.pesquisarClientePorCpf(cpfDono);
                    if (dono == null) {
                        System.out.println("Cliente não encontrado. O carro não será cadastrado.");
                    } else {
                        Carro carro = new Carro(placa, marca, modelo, ano, valorAproximado, dono);
                        loja.cadastrarCarro(carro);
                        System.out.println("Carro cadastrado com sucesso!");
                    }
                    break;

                case 3: 
                    System.out.println("\nLista de Carros:");
                    loja.listarCarros();
                    break;

                case 4: 
                    System.out.print("\nDigite a placa do carro que deseja atualizar: ");
                    String placaAtualizar = scanner.nextLine();
                    System.out.println("Digite os novos dados do carro:");
                    System.out.print("Marca: ");
                    String novaMarca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String novoModelo = scanner.nextLine();
                    System.out.print("Ano: ");
                    int novoAno = Integer.parseInt(scanner.nextLine());
                    System.out.print("Valor Aproximado: ");
                    float novoValor = Float.parseFloat(scanner.nextLine());

                    
                    System.out.print("Digite o CPF do novo dono do carro: ");
                    String cpfDonoAtualizar = scanner.nextLine();
                    Cliente novoDono = loja.pesquisarClientePorCpf(cpfDonoAtualizar);
                    if (novoDono == null) {
                        System.out.println("Cliente não encontrado. O carro não será atualizado.");
                    } else {
                        Carro carroAtualizado = new Carro(placaAtualizar, novaMarca, novoModelo, novoAno, novoValor, novoDono);
                        loja.atualizarCarroPorPlaca(placaAtualizar, carroAtualizado);
                        System.out.println("Carro atualizado com sucesso!");
                    }
                    break;

                case 5: 
                    System.out.print("\nDigite a placa do carro que deseja vender (remover): ");
                    String placaRemover = scanner.nextLine();
                    loja.removerCarroPorPlaca(placaRemover);
                    System.out.println("Carro removido. Lista atualizada:");
                    loja.listarCarros();
                    break;

                case 6: 
                    System.out.println("\nLista de Clientes:");
                    loja.listarClientes();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);

       
        scanner.close();
    }
}