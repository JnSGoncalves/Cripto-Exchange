package model.moedas;

public interface Tarifacao {
    final double tarifaCompra = 0;
    final double tarifaVenda = 0;
    
    public double taxaDeCompra(double valor);
    
    public double taxaDeVenda(double valor);
}