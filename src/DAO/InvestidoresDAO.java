package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import model.moedas.Carteira;
import model.user.Investidor;

public class InvestidoresDAO {
    private final Connection conn;

    public InvestidoresDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultLogin(Investidor inv) throws SQLException{
        String sql = "select * from investidores where cpf = ? AND senha = ?";
        

        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, inv.getCpf());
        statement.setString(2, inv.getSenha());
        
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        
        return resultado;
    }
    
    public boolean consultSenha(int id, String senha) throws SQLException{
        String sql = "select * from investidores where id = ? AND senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, id);
        statement.setString(2, senha);
        
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        
        return resultado.next();
    }
    
    public ResultSet consultInv(int id) throws SQLException{
        String sql = "select * from investidores where id = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, id);
        
        statement.execute();
        ResultSet resultado = statement.getResultSet();

        return resultado;
    }
    
    public ResultSet consultCpf(String cpf) throws SQLException{        
        String sql = "select * from investidores where cpf = ?";
        

        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, cpf);
        
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        
        return resultado;
    }
    
    public void inserir(Investidor inv) throws SQLException{
        String sql = "insert into investidores (nome, sobrenome, cpf, senha) values ('" + inv.getNome() + "', '" +
                inv.getSobrenome() + "', '" + inv.getCpf() + "', '" + inv.getSenha() + "')";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void updateCarteira(Investidor inv) throws SQLException{
        Carteira carteira = inv.getCarteira();
        
        String sql = "update investidores set real = ?, bitcoin = ?, ethereum = ?, ripple = ? where id = ?";
        
        PreparedStatement statemant = conn.prepareStatement(sql);
        
        statemant.setDouble(1, carteira.getReal().getQuantia());
        statemant.setDouble(2, carteira.getBitcoin().getQuantia());
        statemant.setDouble(3, carteira.getEthereum().getQuantia());
        statemant.setDouble(4, carteira.getRipple().getQuantia());
        
        statemant.setInt(5, inv.getId());
        
        statemant.execute();
        conn.close();
    }
}
