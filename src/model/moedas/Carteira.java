package model.moedas;

public class Carteira {
    private Real real;
    private Bitcoin bitcoin;
    private Ethereum ethereum;
    private Ripple ripple;

    public Real getReal() {
        return real;
    }
    public void setReal(Real real) {
        this.real = real;
    }

    public Bitcoin getBitcoin() {
        return bitcoin;
    }
    public void setBitcoin(Bitcoin bitcoin) {
        this.bitcoin = bitcoin;
    }

    public Ethereum getEthereum() {
        return ethereum;
    }
    public void setEthereum(Ethereum ethereum) {
        this.ethereum = ethereum;
    }

    public Ripple getRipple() {
        return ripple;
    }
    public void setRipple(Ripple ripple) {
        this.ripple = ripple;
    }
}
