package model.user;

import model.moedas.Carteira;

public class Investidor extends Pessoa{
    private String senha;
    private Carteira carteira;

    public Investidor(String nome, String sobrenome, String cpf, String senha) {
        super(nome, sobrenome, cpf);
        this.senha = senha;
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
