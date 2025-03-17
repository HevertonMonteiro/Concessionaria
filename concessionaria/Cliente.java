package concessionaria;

public class Cliente extends Pessoa {
    private String telefone;

    public Cliente(String cpf, String endereco, int idade, String nome, String telefone) {
        super(cpf, endereco, idade, nome);
        this.telefone = telefone;
    }

    
    public String getTelefone() {
        return telefone;
    }
}