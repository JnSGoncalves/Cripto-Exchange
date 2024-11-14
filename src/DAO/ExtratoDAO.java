package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import model.user.Investidor;

public class ExtratoDAO {
    Connection conn;

    public ExtratoDAO(Connection conn) {
        this.conn = conn;
    }
        
    public void inserir(String hora, String op, double valor, String moeda, double cotacao, double taxa, Investidor inv) 
            throws SQLException{
        String sql = "insert into extrato (id, hora, op, valor, moeda, cotacao, taxa, real, bitcoin, ethereum, ripple) values " 
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, inv.getId());
        statement.setString(2, hora);
        statement.setString(3, op);
        statement.setDouble(4, valor);
        statement.setString(5, moeda);
        statement.setDouble(6, cotacao);
        statement.setDouble(7, taxa);
        statement.setDouble(8, inv.getCarteira().getReal().getQuantia());
        statement.setDouble(9, inv.getCarteira().getBitcoin().getQuantia());
        statement.setDouble(10, inv.getCarteira().getEthereum().getQuantia());
        statement.setDouble(11, inv.getCarteira().getRipple().getQuantia());
        
        statement.execute();
        conn.close();
    }
    
    public ResultSet getExtrato(int id) throws SQLException{
        String sql = "select * from extrato where id = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, id);
        
        statement.execute();
        ResultSet res = statement.getResultSet();
        
        return res;
    }
}
