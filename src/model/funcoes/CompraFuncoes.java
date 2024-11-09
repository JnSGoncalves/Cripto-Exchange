package model.funcoes;

import DAO.Conexao;
import DAO.InvestidoresDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.moedas.Carteira;
import model.moedas.CotacaoMoedas;
import model.user.Investidor;
import view.JPrincipal;

public class CompraFuncoes {
    private static final DecimalFormat formatoValor = new DecimalFormat("R$ #,##0.00");
    private ArrayList<CotacaoMoedas> cotacoes = new ArrayList<>();

    public CompraFuncoes() {
        cotacoes = new ArrayList<>();
        cotacoes.add(new CotacaoMoedas(1, 0));
        cotacoes.add(new CotacaoMoedas(2, 0));
        cotacoes.add(new CotacaoMoedas(3, 0));
    }
    
    public void verSaldo(JPrincipal view, boolean saldoVisivel, Carteira carteira){
        JLabel saldo = view.getCompraSaldoValor();
                
        if(saldoVisivel){
            saldo.setText(formatoValor.format(carteira.getReal().getQuantia()));
        }else{
            saldo.setText("R$ -,--");
        }
    }
    
    public void atualizarCotacoes(){
        for(CotacaoMoedas cotacao : cotacoes){
            cotacao.setCotacao(Consultas.getValor(cotacao.getId()));
        }
    }
    
    public void compra(JPrincipal view, Investidor inv, double qtd, int idMoeda){
        inv.setCarteira(Consultas.getCarteira(inv.getId()));
        // Adiciona antes de fazer a tentativa de atualização no banco de dados
        double taxa = 0;
        
        double cotacao = 0;
        atualizarCotacoes();
        for(CotacaoMoedas moeda : cotacoes){
            if(moeda.getId() == idMoeda)
                cotacao = moeda.getCotacao();
        }
        
        double valorCompra = qtd * cotacao;
        valorCompra = Math.round(valorCompra * 100.0) / 100.0;
        
        if(valorCompra == 0){
            JOptionPane.showMessageDialog(view, "Erro na atualização das cotas!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String moeda = null;
        switch(idMoeda){
            case 1:
                taxa = inv.getCarteira().getBitcoin().taxaDeCompra(valorCompra); 
                moeda = "Bitcoin";
                break;
            case 2:
                taxa = inv.getCarteira().getEthereum().taxaDeCompra(valorCompra);
                moeda = "Ethereum";
                break;
            case 3: 
                taxa = inv.getCarteira().getRipple().taxaDeCompra(valorCompra);
                moeda = "Ripple (XRP)";
                break;
        }
        taxa = Math.round(taxa * 100.0) / 100.0;
        
        inv.getCarteira().getReal().remover(taxa + valorCompra);
        // Após aplicação da taxa verifica se valor fica negativo
        if(inv.getCarteira().getReal().getQuantia() < 0){
            inv.setCarteira(Consultas.getCarteira(inv.getId()));
            JOptionPane.showMessageDialog(view, "Valor da compra + taxa excede o saldo atual!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String confirmacao = "Deseja realizar a compra de " + qtd + " " + moeda + "?\n" +
                "Valor de compra: " + formatoValor.format(valorCompra) + ", Taxa: " + 
                formatoValor.format(taxa) + ".";
        if(FuncoesGerais.confimFrame(view, confirmacao)){
            switch(idMoeda){
            case 1:
                inv.getCarteira().getBitcoin().adicionar(qtd); 
                break;
            case 2:
                inv.getCarteira().getEthereum().adicionar(qtd); 
                break;
            case 3: 
                inv.getCarteira().getRipple().adicionar(qtd); 
                break;
            }
            
            try{
                Conexao conexao = new Conexao();
                Connection conn = conexao.getConnection();

                InvestidoresDAO dao = new InvestidoresDAO(conn);

                dao.updateCarteira(inv);

                JOptionPane.showMessageDialog(view, "Compra realizada com sucesso!",
                        "Saque", JOptionPane.INFORMATION_MESSAGE);
            
            }catch(SQLException e){
                // Retorna os valores ao incio se ocorrer algum erro
                inv.setCarteira(Consultas.getCarteira(inv.getId()));
                JOptionPane.showMessageDialog(view, "Erro de conexão!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
