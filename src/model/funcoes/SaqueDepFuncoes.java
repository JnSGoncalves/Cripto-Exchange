package model.funcoes;

import DAO.Conexao;
import DAO.InvestidoresDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.moedas.Carteira;
import model.user.Investidor;
import view.JPrincipal;

public class SaqueDepFuncoes {
    private static final DecimalFormat formatoValor = new DecimalFormat("R$ #,##0.00");
    
    public static void verSaldo(JPrincipal view, boolean saldoVisivel, Carteira carteira){
        JLabel saldo = view.getSaqueDepSaldo();
                
        if(saldoVisivel){
            saldo.setText(formatoValor.format(carteira.getReal().getQuantia()));
        }else{
            saldo.setText("R$ -,--");
        }
    }
    
    public static void depositar(JPrincipal view, Investidor inv, double valor){
        // Atualiza pelo banco
        inv.setCarteira(Consultas.getCarteira(inv.getId()));
        // Adiciona antes de fazer a tentativa de atualização no banco de dados
        inv.getCarteira().getReal().adicionar(valor);
        
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();
            
            InvestidoresDAO dao = new InvestidoresDAO(conn);
            
            dao.updateCarteira(inv);
            
            JOptionPane.showMessageDialog(view, "Depósito realizado com sucesso!",
                    "Depósito", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException e){
            // Retorna os valores ao incio se ocorrer algum erro
            inv.setCarteira(Consultas.getCarteira(inv.getId()));
            JOptionPane.showMessageDialog(view, "Erro de conexão!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static void sacar(JPrincipal view, Investidor inv, double valor){
        // Atualiza pelo banco
        inv.setCarteira(Consultas.getCarteira(inv.getId()));
        // Remove antes de fazer a tentativa de atualização no banco de dados
        inv.getCarteira().getReal().remover(valor);
        
        if(inv.getCarteira().getReal().getQuantia() < 0){
            inv.setCarteira(Consultas.getCarteira(inv.getId()));
            JOptionPane.showMessageDialog(view, "Saldo não pode ser menor que 0!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!FuncoesGerais.confimFrame(view, "Deseja realizar o saque de R$ " + valor + "?")){
            inv.setCarteira(Consultas.getCarteira(inv.getId()));
            JOptionPane.showMessageDialog(view, "Operação cancelada!",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();
            
            InvestidoresDAO dao = new InvestidoresDAO(conn);
            
            dao.updateCarteira(inv);
            
            JOptionPane.showMessageDialog(view, "Saque realizado com sucesso!",
                    "Saque", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException e){
            // Retorna os valores ao incio se ocorrer algum erro
            inv.setCarteira(Consultas.getCarteira(inv.getId()));
            JOptionPane.showMessageDialog(view, "Erro de conexão!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
