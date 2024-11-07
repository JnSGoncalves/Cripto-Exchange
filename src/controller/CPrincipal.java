package controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.funcoes.SaldoFuncoes;
import model.user.Investidor;
import model.funcoes.Consultas;
import view.JPrincipal;

public class CPrincipal {
    private final Investidor inv;
    private final JPrincipal view;

    public CPrincipal(JPrincipal view, Investidor inv) {
        this.inv = inv;
        this.view = view;
    }

    // Saldo
    public boolean saldoVisualizar(boolean saldoVisivel) {
        if(saldoVisivel){
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
                    SaldoFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
                    return true;
                }else{
                    JOptionPane.showMessageDialog(view, "Senha incorreta!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }else{
            SaldoFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
            return false;
        }
        return false;
    }
    
    public void saldoAtualizar(boolean saldoVisivel){
        if(saldoVisivel){
            inv.setCarteira(Consultas.getCarteira(inv.getId()));
            SaldoFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
        }
    }
}
