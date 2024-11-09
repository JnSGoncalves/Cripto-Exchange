package model.moedas;

public class CotacaoMoedas {
    private int id;
    private double cotacao;

    public CotacaoMoedas(int id, int cotacao) {
        this.id = id;
        this.cotacao = cotacao;
    }

    public int getId() {
        return id;
    }

    public double getCotacao() {
        return cotacao;
    }
    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
}
