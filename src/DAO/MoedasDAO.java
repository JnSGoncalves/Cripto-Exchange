package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoedasDAO {
    private final Connection conn;

    public MoedasDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultMoeda(int moedaId) throws SQLException{
        String sql = "select * from moedas where id = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, moedaId);
        
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        
        return resultado;
    }
}
