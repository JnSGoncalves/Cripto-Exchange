package model.moedas;

public class Carteira {
    private Real real;
    private Bitcoin bitcoin;
    private Ethereum ethereum;
    private Ripple ripple;

    public Carteira() {
        real = new Real(0);
        bitcoin = new Bitcoin(0);
        ethereum = new Ethereum(0);
        ripple = new Ripple(0);
    }

    public Carteira(double real, double bitcoin, double ethereum, double ripple) {
        this.real = new Real(real);
        this.bitcoin = new Bitcoin(bitcoin);
        this.ethereum = new Ethereum(ethereum);
        this.ripple = new Ripple(ripple);
    }
    
    public Real getReal() {
        return real;
    }

    public Bitcoin getBitcoin() {
        return bitcoin;
    }

    public Ethereum getEthereum() {
        return ethereum;
    }
    
    public Ripple getRipple() {
        return ripple;
    }
}
