package model.moedas;

public class Bitcoin extends Moedas implements Tarifacao {
    private final double tarifaCompra = 0.02;
    private final double tarifaVenda = 0.03;
    private double quantia;

    public Bitcoin(double quantia, String nomeMoeda, double valor) {
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
