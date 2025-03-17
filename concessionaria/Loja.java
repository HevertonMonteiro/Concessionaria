package concessionaria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Loja {
    private List<Carro> carrosCadastrados;
    private List<Cliente> clientesCadastrados;

    public Loja() {
        this.carrosCadastrados = new ArrayList<>();
        this.clientesCadastrados = new ArrayList<>();
    }

    public void cadastrarCarro(Carro carro) {
        carrosCadastrados.add(carro);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientesCadastrados.add(cliente);
    }

    public List<Carro> pesquisarCarrosPorCpfDono(String cpf) {
        List<Carro> carrosDoDono = new ArrayList<>();
        for (Carro carro : carrosCadastrados) {
            if (carro.getDono().getCpf().equals(cpf)) {
                carrosDoDono.add(carro);
            }
        }
        return carrosDoDono;
    }

    public void listarCarros() {
        for (Carro carro : carrosCadastrados) {
            System.out.println("Placa: " + carro.getPlaca() + ", Marca: " + carro.getMarca() +
                    ", Modelo: " + carro.getModelo() + ", Ano: " + carro.getAno() +
                    ", Valor: " + carro.getValorAproximado() + ", Dono: " + carro.getDono().getNome());
        }
    }

    public void removerCarroPorPlaca(String placa) {
        carrosCadastrados.removeIf(carro -> carro.getPlaca().equals(placa));
    }

    public void atualizarCarroPorPlaca(String placa, Carro novoCarro) {
        for (int i = 0; i < carrosCadastrados.size(); i++) {
            if (carrosCadastrados.get(i).getPlaca().equals(placa)) {
                carrosCadastrados.set(i, novoCarro);
                return;
            }
        }
    }

    public Cliente pesquisarClientePorCpf(String cpf) {
        for (Cliente cliente : clientesCadastrados) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void listarClientes() {
        for (Cliente cliente : clientesCadastrados) {
            System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf() +
                    ", Endereço: " + cliente.getEndereco() + ", Idade: " + cliente.getIdade() +
                    ", Telefone: " + cliente.getTelefone());
        }
    }

    public void listarCarrosOrdenadosPorAnoDecrescente() {
        carrosCadastrados.stream()
                .sorted(Comparator.comparingInt(Carro::getAno).reversed())
                .forEach(carro -> System.out.println("Placa: " + carro.getPlaca() + ", Ano: " + carro.getAno()));
    }

    public Cliente buscarClienteMaisVelho() {
        return clientesCadastrados.stream()
                .max(Comparator.comparingInt(Cliente::getIdade))
                .orElse(null);
    }
}