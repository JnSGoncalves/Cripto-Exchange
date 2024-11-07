package controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.funcoes.SaldoFuncoes;
import model.user.Investidor;
import model.funcoes.Consultas;
import model.funcoes.SaqueDepFuncoes;
import view.JPrincipal;

public class CPrincipal {
    private final Investidor inv;
    private final JPrincipal view;

    public CPrincipal(JPrincipal view, Investidor inv) {
        this.inv = inv;
        this.view = view;
        this.view.getLblBemVindo().setText("Bem Vindo(a) " + this.inv.getNome()+ "!");
    }
    
    public void resetVisualizacoes(){
        saldoVisualizar(view.isSaldoVisivel());
        view.getSaldoBtVisualizar().setSelected(false);
        viewSaldoSaqueDeposito(view.isSaqueSaldoVisivel());
        view.getSaqueDepBtViewSaldo().setSelected(false);
}

    // Aba Saldo
    public boolean saldoVisualizar(boolean saldoVisivel) {
        if(saldoVisivel){
            if(optionFrameVerificacaoSenha()){
                inv.setCarteira(Consultas.getCarteira(inv.getId()));
                SaldoFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
                return true;
            }else{
                view.getSaldoBtVisualizar().setSelected(false);
                return false;
            }
        }else{
            SaldoFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
            return false;
        }
    }
    
    public void saldoAtualizar(boolean saldoVisivel){
        if(saldoVisivel){
            inv.setCarteira(Consultas.getCarteira(inv.getId()));
            SaldoFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
        }else{
            inv.setCarteira(Consultas.getCarteira(inv.getId()));
        }
    }
    
    // Aba Saque e Deposito
    public boolean viewSaldoSaqueDeposito(boolean saldoVisivel){
        if(saldoVisivel){
            if(optionFrameVerificacaoSenha()){
                inv.setCarteira(Consultas.getCarteira(inv.getId()));
                SaqueDepFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
                return true;
            }else{
                view.getSaqueDepBtViewSaldo().setSelected(false);
                return false;
            }
        }else{
            SaqueDepFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
            return false;
        }
    }
    
    
    public boolean optionFrameVerificacaoSenha(){
        javax.swing.JPanel panel = new javax.swing.JPanel();
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(passwordField);

        int option = JOptionPane.showConfirmDialog(view, panel, "Digite sua senha", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            // Obtém a senha digitada (em formato de array de caracteres)
            char[] password = passwordField.getPassword();
            String senha = new String(password);
            java.util.Arrays.fill(password, '\u0000');

            if(Consultas.verSenha(inv.getId(), senha)){
                return true;
            }else{
                JOptionPane.showMessageDialog(view, "Senha incorreta!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }else{
            return false;
        }
    }
}
