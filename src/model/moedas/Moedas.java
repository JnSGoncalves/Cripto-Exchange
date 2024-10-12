package model.moedas;

public class Moedas {
    private String nomeMoeda;
    private int idMoeda;
    private double valor; // Valor da moeda com base no Real

    public Moedas(String nomeMoeda, int idMoeda, double valor) {
        this.nomeMoeda = nomeMoeda;
        this.idMoeda = idMoeda;
        this.valor = valor;
    }

    public String getNomeMoeda() {
        return nomeMoeda;
    }
    public void setNomeMoeda(String nomeMoeda) {
        this.nomeMoeda = nomeMoeda;
    }

    public int getIdMoeda() {
        return idMoeda;
    }
    public void setIdMoeda(int idMoeda) {
        this.idMoeda = idMoeda;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
