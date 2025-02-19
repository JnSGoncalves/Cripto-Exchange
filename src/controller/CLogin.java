package controller;

import DAO.Conexao;
import DAO.InvestidoresDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.funcoes.FuncoesGerais;
import model.moedas.Carteira;
import model.user.Investidor;
import view.JCadastro;
import view.JLogin;
import view.JPrincipal;

public class CLogin {
    private JLogin view;

    public CLogin(JLogin view) {
        this.view = view;
    }
    
    public void viewSenha(boolean visible){
        JPasswordField txtSenha = view.getTxtSenha();
        if(visible){
            txtSenha.setEchoChar('\0');
        }else{
            txtSenha.setEchoChar('•');
        }
    }
    
    public void abrirCadastro(){
        JCadastro j = JCadastro.getInstance();
        j.setVisible(true);
        view.dispose();
    }

    public void logar() {
        String cpf = view.getTxtCpf().getText();
        String senha = view.getTxtSenha().getText();
        
        if(cpf.isBlank() || senha.isBlank()){
            JOptionPane.showMessageDialog(view, "Preencha todos os campos.",
                 "Erro", JOptionPane.ERROR_MESSAGE);
             return;
        }
        
        if(!FuncoesGerais.somenteDigitos(cpf) || cpf.length() != 11) {
            JOptionPane.showMessageDialog(view, "Digite um CPF válido",
             "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!FuncoesGerais.somenteDigitos(senha) || senha.length() != 6){
            JOptionPane.showMessageDialog(view, "A senha deve conter 6 digitos numérios",
             "Erro", JOptionPane.ERROR_MESSAGE);
             return;
        }
        
        Investidor inv = new Investidor(cpf, senha);
        
        try{
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();
            InvestidoresDAO dao = new InvestidoresDAO(conn);
            
            ResultSet result = dao.consultLogin(inv);
            
            if(result.next()){
                // Senha nunca salva pela aplicação como medida de segurança
                inv.setSenha(null);
                
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                int id = result.getInt("id");
                double real = result.getDouble("real");
                double bitcoin = result.getDouble("bitcoin");
                double ethereum = result.getDouble("ethereum");
                double ripple = result.getDouble("ripple");
                
                inv.setNome(nome);
                inv.setSobrenome(sobrenome);
                inv.setId(id);
                inv.setCarteira(new Carteira(real, bitcoin, ethereum, ripple));
                
                view.dispose();
                JPrincipal jp = new JPrincipal(inv);
                jp.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(view, "CPF ou senha incorretos!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
