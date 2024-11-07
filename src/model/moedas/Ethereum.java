package model.moedas;

public class Ethereum extends Moedas implements Tarifacao {
    private final double tarifaCompra = 0.01;
    private final double tarifaVenda = 0.02;
    private double quantia;

    public Ethereum(double quantia) {
        super("ethereum", 2);
        this.quantia = quantia;
    }

    @Override
    public double taxaDeCompra(double valor){
        return tarifaCompra * valor;
    }

    @Override
    public double taxaDeVenda(double valor){
        return tarifaVenda * valor;
    }

    public double getQuantia() {
        return quantia;
    }
    public void setQuantia(double quantia) {
        this.quantia = quantia;
    }    
}