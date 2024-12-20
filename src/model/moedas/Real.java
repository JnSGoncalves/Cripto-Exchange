package model.moedas;

public class Real extends Moedas implements Tarifacao {
    private final double tarifaCompra = 0;
    private final double tarifaVenda = 0;

    public Real(double quantia) {
        super("real", 0, quantia);
    }

    @Override
    public void adicionar(double valor){
        quantia += valor;
        quantia = Math.round(quantia * 100.0) / 100.0;
    }
    
    @Override
    public void remover(double valor){
        quantia -= valor;
        quantia = Math.round(quantia * 100.0) / 100.0;
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
