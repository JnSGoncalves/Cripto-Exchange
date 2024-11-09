package model.funcoes;

import DAO.Conexao;
import DAO.ExtratoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.user.Investidor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import view.JPrincipal;

public class ExtratoFuncoes {
    public static void newExtrato(Investidor inv, String op, double valor, String moeda, 
            double cotacao, double taxa){
        
        LocalDateTime dataEHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        String hora = formatador.format(dataEHoraAtual);
        
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();
            
            ExtratoDAO dao = new ExtratoDAO(conn);
            
            dao.inserir(hora, op, valor, moeda, cotacao, taxa, inv);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão!\nExtrato não salvo.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void viewExtrato(JPrincipal view, Investidor inv){
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();

            ExtratoDAO dao = new ExtratoDAO(conn);

            
            
            ResultSet res = dao.getExtrato(inv.getId());

            ArrayList<String> extratos = new ArrayList<>();
            while (res.next()) {
                String hora = res.getString("hora");
                String op = res.getString("op");
                double valor = res.getDouble("valor");
                String moeda = res.getString("moeda");
                double cotacao = res.getDouble("cotacao");
                double taxa = res.getDouble("taxa");
                double real = res.getDouble("real");
                double bitcoin = res.getDouble("bitcoin");
                double ethereum = res.getDouble("ethereum");
                double ripple = res.getDouble("ripple");

                String valorString = moeda.equals("Real")
                    ? String.format("%-15s", String.format("R$ %.2f", valor))
                    : String.format("%-15s", String.format("Qtd: %f", valor));

                moeda = switch (moeda.toLowerCase()) {
                    case "real" -> String.format("%-6s", "Real");
                    case "bitcoin" -> String.format("%-6s", "BTC");
                    case "ethereum" -> String.format("%-6s", "ETH");
                    case "ripple (xrp)" -> String.format("%-6s", "XRP");
                    default -> String.format("%-6s", moeda);
                };

                String cotacaoString = String.format("%-11s", String.format("R$ %.2f", cotacao));
                String taxaString = String.format("%-14s", String.format("R$ %.2f", taxa));
                String realString = String.format("%-16s", String.format("R$ %.2f", real));
                String bitcoinString = String.format("%-15s", String.format("%.6f", bitcoin));
                String ethereumString = String.format("%-15s", String.format("%.6f", ethereum));
                String rippleString = String.format("%-15s", String.format("%.6f", ripple));

                extratos.addFirst(String.format("%s %s %s %s CT: %s TX: %s Real: %s BTC: %s ETH: %s XRP: %s", 
                    hora, op, valorString, moeda, cotacaoString, taxaString, realString, bitcoinString, ethereumString, rippleString));
            }
            
            view.getExtratoTxtArea().setText(String.format("Nome: %s %s\nCPF: %s\n", 
                    inv.getNome(), inv.getSobrenome(), FuncoesGerais.formatCPF(inv.getCpf())));
            
            for(String extrato : extratos){
                String atual = view.getExtratoTxtArea().getText();
                view.getExtratoTxtArea().setText(atual + "\n" + extrato);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
    }
}
