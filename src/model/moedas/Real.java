package model.moedas;

public class Real extends Moedas implements Tarifacao {
    private final double tarifaCompra = 0;
    private final double tarifaVenda = 0;
    private double quantia;

    public Real(double quantia) {
        super("real", 0);
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
