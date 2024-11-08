package controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.funcoes.SaldoFuncoes;
import model.user.Investidor;
import model.funcoes.Consultas;
import model.funcoes.FuncoesGerais;
import model.funcoes.SaqueDepFuncoes;
import view.JLogin;
import view.JPrincipal;

public class CPrincipal {
    private final Investidor inv;
    private final JPrincipal view;

    public CPrincipal(JPrincipal view, Investidor inv) {
        this.inv = inv;
        this.view = view;
        this.view.getLblBemVindo().setText("Bem Vindo(a) " + this.inv.getNome()+ "!");
//        this.view.getLblSaldoCPF().setText("CPF: " + FuncoesGerais.formatCPF(this.inv.getCpf()));
        this.view.getLblSaldoCPF().setText("CPF: " + this.inv.getCpf());
    }
    
    public void sair(){
        view.dispose();
        JLogin.getInstance().setVisible(true);
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
            if(FuncoesGerais.verificacaoSenha(view, inv)){
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
            if(FuncoesGerais.verificacaoSenha(view, inv)){
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
    
    public void depositar(){
        try{
            String valorString = view.getSaqueDepValorDeposito().getText();
            
            if(valorString.isBlank()){
                throw new IllegalArgumentException("Nenhum valor identificado!");
            }
            
            valorString = valorString.replace(",", ".");
            double valor = Double.parseDouble(valorString);
            
            if(!FuncoesGerais.verfiValor(valor)){
                throw new IllegalArgumentException("Valor inválido!");
            }
            
            SaqueDepFuncoes.depositar(view, inv, valor);
            SaqueDepFuncoes.verSaldo(view, view.isSaqueSaldoVisivel(), inv.getCarteira());
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(view, "Digite apenas números!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(view, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void sacar(){
        try{
            String valorString = view.getSaqueDepValorSaque().getText();
            
            if(valorString.isBlank()){
                throw new IllegalArgumentException("Nenhum valor identificado!");
            }
            
            valorString = valorString.replace(",", ".");
            double valor = Double.parseDouble(valorString);
            
            if(!FuncoesGerais.verfiValor(valor)){
                throw new IllegalArgumentException("Valor inválido!");
            }
            
            if(FuncoesGerais.verificacaoSenha(view.getSaqueDepSenha(),view, inv)){
                SaqueDepFuncoes.sacar(view, inv, valor);
                SaqueDepFuncoes.verSaldo(view, view.isSaqueSaldoVisivel(), inv.getCarteira());
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(view, "Digite apenas números!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(view, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void viewSaqueSenha(boolean visible) {
        JPasswordField txtSenha = view.getSaqueDepSenha();
        if(visible){
            txtSenha.setEchoChar('\0');
        }else{
            txtSenha.setEchoChar('•');
        }
    }
}
