package model.funcoes;

import DAO.Conexao;
import DAO.InvestidoresDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.moedas.Carteira;

public class Consultas {
    public static boolean verSenha(int id, String senha){
        try{
                Conexao conexao = new Conexao();
                Connection conn = conexao.getConnection();
                InvestidoresDAO dao = new InvestidoresDAO(conn);
                
                return dao.consultSenha(id, senha);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static Carteira getCarteira(int id){
        try{
                Conexao conexao = new Conexao();
                Connection conn = conexao.getConnection();
                InvestidoresDAO dao = new InvestidoresDAO(conn);
                ResultSet result = dao.consultInv(id);
                
                double real = result.getDouble("real");
                double bitcoin = result.getDouble("bitcoin");
                double ethereum = result.getDouble("ethereum");
                double ripple = result.getDouble("ripple");
                
                return new Carteira(real, bitcoin, ethereum, ripple);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
