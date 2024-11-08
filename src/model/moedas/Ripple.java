package model.moedas;

public class Ripple extends Moedas implements Tarifacao {
    private final double tarifaCompra = 0.01;
    private final double tarifaVenda = 0.01;

    public Ripple(double quantia) {
        super("ripple", 3, quantia);
    }

    @Override
    public double taxaDeCompra(double valor){
        return tarifaCompra * valor;
    }

    @Override
    public double taxaDeVenda(double valor){
        return tarifaVenda * valor;
    }
}