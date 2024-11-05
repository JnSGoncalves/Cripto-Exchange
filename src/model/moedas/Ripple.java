package model.moedas;

public class Ripple extends Moedas implements Tarifacao {
    private final double tarifaCompra = 0.01;
    private final double tarifaVenda = 0.01;
    private double quantia;

    public Ripple(double quantia, String nomeMoeda, double valor) {
        super(nomeMoeda, 1, valor);
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