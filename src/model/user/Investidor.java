package model.user;

import model.moedas.Carteira;

public class Investidor extends Pessoa{
    private String senha;
    private Carteira carteira;

    public Investidor(String nome, String sobrenome, String cpf, String senha) {
        super(nome, sobrenome, cpf);
        this.senha = senha;
        this.carteira = new Carteira();
    }
    
    public Investidor(String nome, String sobrenome, String cpf, String senha, double real, double bitcoin, 
            double ethereum, double ripple) {
        super(nome, sobrenome, cpf);
        this.senha = senha;
        this.carteira = new Carteira(real, bitcoin, ethereum, ripple);
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Carteira getCarteira() {
        return carteira;
    }
    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
}
