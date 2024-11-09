package controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.funcoes.CompraFuncoes;
import model.funcoes.SaldoFuncoes;
import model.user.Investidor;
import model.funcoes.Consultas;
import model.funcoes.FuncoesGerais;
import model.funcoes.SaqueDepFuncoes;
import model.funcoes.VendaFuncoes;
import view.JLogin;
import view.JPrincipal;

public class CPrincipal {
    private final Investidor inv;
    private final JPrincipal view;
    private CompraFuncoes compraFuncoes;
    private VendaFuncoes vendaFuncoes;

    public CPrincipal(JPrincipal view, Investidor inv) {
        this.inv = inv;
        this.view = view;
        this.view.getLblBemVindo().setText("Bem Vindo(a) " + this.inv.getNome()+ "!");
//        this.view.getLblSaldoCPF().setText("CPF: " + FuncoesGerais.formatCPF(this.inv.getCpf()));
        this.view.getLblSaldoCPF().setText("CPF: " + this.inv.getCpf());
        
        compraFuncoes = new CompraFuncoes();
        vendaFuncoes = new VendaFuncoes();
        atualizarCotacoes();
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
        viewSaldoCompra(view.isCompraSaldoVisivel());
        view.getCompraBtViewSaldo().setSelected(false);
        viewSaldoVenda(view.isVendaSaldoVisivel());
        view.getVendaBtViewSaldo().setSelected(false);
    }
    
    public void atualizarCotacoes(){
        double cotaBitcoin = Consultas.getValor(1);
        double cotaEthereum = Consultas.getValor(2);
        double cotaRipple = Consultas.getValor(3);
        
        view.getCompraCotacaoBitcoin().setText("Cotação: " + SaldoFuncoes.formatoValor.format(cotaBitcoin));
        view.getCompraCotacaoEthereum().setText("Cotação: " + SaldoFuncoes.formatoValor.format(cotaEthereum));
        view.getCompraCotacaoRipple().setText("Cotação: " + SaldoFuncoes.formatoValor.format(cotaRipple));
        
        view.getVendaCotacaoBitcoin().setText("Cotação: " + SaldoFuncoes.formatoValor.format(cotaBitcoin));
        view.getVendaCotacaoEthereum().setText("Cotação: " + SaldoFuncoes.formatoValor.format(cotaEthereum));
        view.getVendaCotacaoRipple().setText("Cotação: " + SaldoFuncoes.formatoValor.format(cotaRipple));
    }
    
    // Aba Venda
    // Possivel adição de uma visualização da taxa antes mesmo do click em comprar
    public void venda(){
        try{
            String qtdString = view.getVendaQtd().getText();
            
            if(qtdString.isBlank()){
                throw new IllegalArgumentException("Nenhum valor identificado!");
            }
            
            int idMoeda;
            
            if(view.getVendaBtBitcoin().isSelected()){
                idMoeda = 1;
            }else if(view.getVendaBtEthereum().isSelected()){
                idMoeda = 2;
            }else if(view.getVendaBtRipple().isSelected()){
                idMoeda = 3;
            }else{
                throw new IllegalArgumentException("Nenhuma moeda Selecionada");
            }
            
            qtdString = qtdString.replace(",", ".");
            double qtd = Double.parseDouble(qtdString);
            
            if(FuncoesGerais.verificacaoSenha(view, inv)){
                vendaFuncoes.venda(view, inv, qtd, idMoeda);
                vendaFuncoes.verSaldo(view, view.isVendaSaldoVisivel(), inv.getCarteira());
            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(view, "Digite apenas números!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(view, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void vendaQtdEmValor(){
        try{
            String qtdString = view.getVendaQtd().getText();
            if(qtdString.isBlank()){
                view.getVendaValorReais().setText("");
            }

            int idMoeda;

            if(view.getVendaBtBitcoin().isSelected()){
                idMoeda = 1;
            }else if(view.getVendaBtEthereum().isSelected()){
                idMoeda = 2;
            }else if(view.getVendaBtRipple().isSelected()){
                idMoeda = 3;
            }else{
                throw new IllegalArgumentException("Nenhuma moeda Selecionada");
            }
            
            qtdString = qtdString.replace(",", ".");
            double qtd = Double.parseDouble(qtdString);
            
            double valor = qtd * Consultas.getValor(idMoeda);
            valor = Math.round(valor * 100.0) / 100.0;

            view.getVendaValorReais().setText(String.format("%.2f", valor));
            
        }catch(Exception e){
            return;
        }        
    }
    
    public void vendaValorEmQtd(){
        try{
            String valorString = view.getVendaValorReais().getText();
            if(valorString.isBlank()){
                view.getVendaValorReais().setText("");
            }

            int idMoeda;

            if(view.getVendaBtBitcoin().isSelected()){
                idMoeda = 1;
            }else if(view.getVendaBtEthereum().isSelected()){
                idMoeda = 2;
            }else if(view.getVendaBtRipple().isSelected()){
                idMoeda = 3;
            }else{
                throw new IllegalArgumentException("Nenhuma moeda Selecionada");
            }
            
            valorString = valorString.replace(",", ".");
            double valor = Double.parseDouble(valorString);
            
            double qtd = valor / Consultas.getValor(idMoeda);

            view.getVendaQtd().setText(Double.toString(qtd));
            
        }catch(Exception e){
            return;
        }        
    }
    
    public boolean viewSaldoVenda(boolean saldoVisivel){
        if(saldoVisivel){
            if(FuncoesGerais.verificacaoSenha(view, inv)){
                inv.setCarteira(Consultas.getCarteira(inv.getId()));
                vendaFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
                return true;
            }else{
                view.getVendaBtViewSaldo().setSelected(false);
                return false;
            }
        }else{
            vendaFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
            return false;
        }
    }
    
    // Aba Compra
    // Possivel adição de uma visualização da taxa antes mesmo do click em comprar
    public void compra(){
        try{
            String qtdString = view.getCompraQtd().getText();
            
            if(qtdString.isBlank()){
                throw new IllegalArgumentException("Nenhum valor identificado!");
            }
            
            int idMoeda;
            
            if(view.getCompraBtBitcoin().isSelected()){
                idMoeda = 1;
            }else if(view.getCompraBtEthereum().isSelected()){
                idMoeda = 2;
            }else if(view.getCompraBtRipple().isSelected()){
                idMoeda = 3;
            }else{
                throw new IllegalArgumentException("Nenhuma moeda Selecionada");
            }
            
            qtdString = qtdString.replace(",", ".");
            double qtd = Double.parseDouble(qtdString);
            
            if(FuncoesGerais.verificacaoSenha(view, inv)){
                compraFuncoes.compra(view, inv, qtd, idMoeda);
                compraFuncoes.verSaldo(view, view.isCompraSaldoVisivel(), inv.getCarteira());
            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(view, "Digite apenas números!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(view, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void compraQtdEmValor(){
        try{
            String qtdString = view.getCompraQtd().getText();
            if(qtdString.isBlank()){
                view.getCompraValorReais().setText("");
            }

            int idMoeda;

            if(view.getCompraBtBitcoin().isSelected()){
                idMoeda = 1;
            }else if(view.getCompraBtEthereum().isSelected()){
                idMoeda = 2;
            }else if(view.getCompraBtRipple().isSelected()){
                idMoeda = 3;
            }else{
                throw new IllegalArgumentException("Nenhuma moeda Selecionada");
            }
            
            qtdString = qtdString.replace(",", ".");
            double qtd = Double.parseDouble(qtdString);
            
            double valor = qtd * Consultas.getValor(idMoeda);
            valor = Math.round(valor * 100.0) / 100.0;

            view.getCompraValorReais().setText(String.format("%.2f", valor));
            
        }catch(Exception e){
            return;
        }        
    }
    
    public void compraValorEmQtd(){
        try{
            String valorString = view.getCompraValorReais().getText();
            if(valorString.isBlank()){
                view.getCompraValorReais().setText("");
            }

            int idMoeda;

            if(view.getCompraBtBitcoin().isSelected()){
                idMoeda = 1;
            }else if(view.getCompraBtEthereum().isSelected()){
                idMoeda = 2;
            }else if(view.getCompraBtRipple().isSelected()){
                idMoeda = 3;
            }else{
                throw new IllegalArgumentException("Nenhuma moeda Selecionada");
            }
            
            valorString = valorString.replace(",", ".");
            double valor = Double.parseDouble(valorString);
            
            double qtd = valor / Consultas.getValor(idMoeda);

            view.getCompraQtd().setText(Double.toString(qtd));
            
        }catch(Exception e){
            return;
        }        
    }
    
    public boolean viewSaldoCompra(boolean saldoVisivel){
        if(saldoVisivel){
            if(FuncoesGerais.verificacaoSenha(view, inv)){
                inv.setCarteira(Consultas.getCarteira(inv.getId()));
                compraFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
                return true;
            }else{
                view.getCompraBtViewSaldo().setSelected(false);
                return false;
            }
        }else{
            compraFuncoes.verSaldo(view, saldoVisivel, inv.getCarteira());
            return false;
        }
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
