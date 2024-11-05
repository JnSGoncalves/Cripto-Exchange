package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import model.user.Investidor;
import model.user.Pessoa;

public class InvestidoresDAO {
    private Connection conn;

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
}
