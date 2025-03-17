package concessionaria;

public class Carro {
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float valorAproximado;
    private Cliente dono;

    public Carro(String placa, String marca, String modelo, int ano, float valorAproximado, Cliente dono) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorAproximado = valorAproximado;
        this.dono = dono;
    }

    
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public float getValorAproximado() {
        return valorAproximado;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }
}