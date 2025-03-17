package concessionaria;

public class Pessoa {
    private String cpf;
    private String endereco;
    private int idade;
    private String nome;

    public Pessoa(String cpf, String endereco, int idade, String nome) {
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
        this.nome = nome;
    }

    
    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }
}