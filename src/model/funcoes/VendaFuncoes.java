package model.funcoes;

import DAO.Conexao;
import DAO.InvestidoresDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.moedas.Carteira;
import model.moedas.CotacaoMoedas;
import model.user.Investidor;
import view.JPrincipal;

public class VendaFuncoes {
    private static final DecimalFormat formatoValor = new DecimalFormat("R$ #,##0.00");
    private static final NumberFormat formatoQtd = new DecimalFormat("#0.######################", 
    DecimalFormatSymbols.getInstance(new Locale("pt", "BR")));
    private ArrayList<CotacaoMoedas> cotacoes = new ArrayList<>();

    public VendaFuncoes() {
        cotacoes = new ArrayList<>();
        cotacoes.add(new CotacaoMoedas(1, 0));
        cotacoes.add(new CotacaoMoedas(2, 0));
        cotacoes.add(new CotacaoMoedas(3, 0));
    }
    
    public void verSaldo(JPrincipal view, boolean saldoVisivel, Carteira carteira){
        JLabel saldo = view.getVendaSaldoValor();
                
        if(saldoVisivel){
            if(view.getVendaBtBitcoin().isSelected()){
                saldo.setText(formatoQtd.format(carteira.getBitcoin().getQuantia()));
            }else if(view.getVendaBtEthereum().isSelected()){
                saldo.setText(formatoQtd.format(carteira.getEthereum().getQuantia()));
            }else if(view.getVendaBtRipple().isSelected()){
                saldo.setText(formatoQtd.format(carteira.getRipple().getQuantia()));
            }else{
                saldo.setText("Nenhuma Cripto Selecionada");
            }
        }else{
            saldo.setText("Qtd. -,--");
        }
    }
    
    public void atualizarCotacoes(){
        for(CotacaoMoedas cotacao : cotacoes){
            cotacao.setCotacao(Consultas.getValor(cotacao.getId()));
        }
    }
    
    public void venda(JPrincipal view, Investidor inv, double qtd, int idMoeda){
        inv.setCarteira(Consultas.getCarteira(inv.getId()));
        // Adiciona antes de fazer a tentativa de atualização no banco de dados
        double taxa = 0;
        
        double cotacao = 0;
        atualizarCotacoes();
        for(CotacaoMoedas moeda : cotacoes){
            if(moeda.getId() == idMoeda)
                cotacao = moeda.getCotacao();
        }
        
        double valorVenda = qtd * cotacao;
        valorVenda = Math.round(valorVenda * 100.0) / 100.0;
        
        if(valorVenda == 0){
            JOptionPane.showMessageDialog(view, "Erro na atualização das cotas!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String moeda = null;
        switch(idMoeda){
            case 1:
                taxa = inv.getCarteira().getBitcoin().taxaDeVenda(valorVenda); 
                moeda = "Bitcoin";
                break;
            case 2:
                taxa = inv.getCarteira().getEthereum().taxaDeVenda(valorVenda);
                moeda = "Ethereum";
                break;
            case 3: 
                taxa = inv.getCarteira().getRipple().taxaDeVenda(valorVenda);
                moeda = "Ripple (XRP)";
                break;
        }
        
        // Após aplicação da venda verifica se valor fica negativo
        boolean verificNegativo = false;
        switch(idMoeda){
            case 1:
                inv.getCarteira().getBitcoin().remover(qtd);
                verificNegativo = inv.getCarteira().getBitcoin().getQuantia() < 0;
                break;
            case 2:
                inv.getCarteira().getEthereum().remover(qtd);
                verificNegativo = inv.getCarteira().getEthereum().getQuantia() < 0;
                break;
            case 3: 
                inv.getCarteira().getRipple().remover(qtd);
                verificNegativo = inv.getCarteira().getRipple().getQuantia() < 0;
                break;
        }
        
        if(verificNegativo){
            inv.setCarteira(Consultas.getCarteira(inv.getId()));
            JOptionPane.showMessageDialog(view, "Quantidade digitada para venda excede a quantidade atual " +
                    "da moeda",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        taxa = Math.round(taxa * 100.0) / 100.0;
        inv.getCarteira().getReal().adicionar(valorVenda - taxa);
        double valorRecebido = valorVenda - taxa;
        
        String confirmacao = "Deseja realizar a venda de " + qtd + " " + moeda + "?\n" +
                "Valor de venda: " + formatoValor.format(valorVenda) + ", Taxa cobrada " + 
                formatoValor.format(taxa) + ".\n"
                + "Valor recebido: " + formatoValor.format(valorRecebido) + ".";
        
        if(FuncoesGerais.confimFrame(view, confirmacao)){
            try{
                Conexao conexao = new Conexao();
                Connection conn = conexao.getConnection();

                InvestidoresDAO dao = new InvestidoresDAO(conn);

                dao.updateCarteira(inv);

                ExtratoFuncoes.newExtrato(inv, "-", qtd, moeda, cotacao, taxa);
                
                JOptionPane.showMessageDialog(view, "Venda realizada com sucesso!",
                        "Saque", JOptionPane.INFORMATION_MESSAGE);
                
                verSaldo(view, view.isVendaSaldoVisivel(), inv.getCarteira());
            }catch(SQLException e){
                // Retorna os valores ao incio se ocorrer algum erro
                inv.setCarteira(Consultas.getCarteira(inv.getId()));
                JOptionPane.showMessageDialog(view, "Erro de conexão!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
