package model.moedas;

public class Ethereum extends Moedas implements Tarifacao {
    private final double tarifaCompra = 0.01;
    private final double tarifaVenda = 0.02;

    public Ethereum(double quantia) {
        super("ethereum", 2, quantia);
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