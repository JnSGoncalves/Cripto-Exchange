package model.moedas;

public class Bitcoin extends Moedas implements Tarifacao {
    private final double tarifaCompra = 0.02;
    private final double tarifaVenda = 0.03;

    public Bitcoin(double quantia) {
        super("bitcoin", 1, quantia);
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
