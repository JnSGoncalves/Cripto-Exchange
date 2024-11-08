package model.moedas;

public class Moedas {
    private String nomeMoeda;
    private int idMoeda;
    private double quantia;

    public Moedas(String nomeMoeda, int idMoeda, double quantia) {
        this.nomeMoeda = nomeMoeda;
        this.idMoeda = idMoeda;
        this.quantia = quantia;
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
    
    public void adicionar(double valor){
        quantia += valor;
        quantia = Math.round(quantia * 100.0) / 100.0;
    }
    public void remover(double valor){
        quantia -= valor;
        quantia = Math.round(quantia * 100.0) / 100.0;
    }
    
    public double getQuantia() {
        return quantia;
    }
    public void setQuantia(double quantia) {
        this.quantia = quantia;
    }
}
