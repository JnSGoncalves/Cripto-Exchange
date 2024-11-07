package model.user;

import model.moedas.Carteira;

public class Investidor extends Pessoa{
    private int id;
    private String senha;
    private Carteira carteira;

    // Construtor para novo investidor
    public Investidor(String nome, String sobrenome, String cpf, String senha) {
        super(nome, sobrenome, cpf);
        this.senha = senha;
        this.carteira = new Carteira();
    }
    
    // Contrutor para Login
    public Investidor(String cpf, String senha){
        super(null, null, cpf);
        this.senha = senha;
    }
    
    // Contrutor completo
    public Investidor(int id, String nome, String sobrenome, String cpf, String senha, double real, double bitcoin, 
            double ethereum, double ripple) {
        super(nome, sobrenome, cpf);
        this.id = id;
        this.senha = senha;
        this.carteira = new Carteira(real, bitcoin, ethereum, ripple);
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Carteira getCarteira() {
        return carteira;
    }
    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
}
