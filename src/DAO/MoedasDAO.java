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
    
    public void updateCotacao(double bitcoin, double ethereum, double ripple) throws SQLException{
        String sql = """
                    UPDATE moedas 
                    SET valor = CASE 
                        WHEN id = 1 THEN ?
                        WHEN id = 2 THEN ?
                        WHEN id = 3 THEN ?
                        ELSE valor
                    END
                    WHERE id IN (1, 2, 3);
                    """;
        
        PreparedStatement statemant = conn.prepareStatement(sql);
        
        statemant.setDouble(1, bitcoin);
        statemant.setDouble(2, ethereum);
        statemant.setDouble(3, ripple);
        
        statemant.execute();
        conn.close();
    }
}
