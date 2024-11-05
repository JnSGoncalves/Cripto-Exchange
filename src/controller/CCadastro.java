package controller;

import DAO.Conexao;
import DAO.InvestidoresDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.user.Investidor;
import view.JCadastro;
import view.JLogin;

public class CCadastro {
    private JCadastro view;

    public CCadastro(JCadastro view) {
        this.view = view;
    }
    
    public void novoInvestidor(){
        try{
            String nome = view.getTxtNome().getText();
            String sobrenome = view.getTxtSobrenome().getText();
            String cpf = view.getTxtCpf().getText();
            String senha = view.getTxtSenha().getText();
            String confimSenha = view.getTxtConfirmSenha().getText();
            
            Conexao conexao = new Conexao();
            
            //   Verificação para saber se o CPF já foi cadastrado
            Connection conn = conexao.getConnection();
            InvestidoresDAO dao = new InvestidoresDAO(conn);
            ResultSet res = dao.consultCpf(cpf);
            
            if(res.next()){
                throw new IllegalArgumentException("CPF já cadastrado!");
            }
            
            if(!senha.equals(confimSenha)){
                throw new IllegalArgumentException("As senha devem ser iguais!");
            }
            
            dao.inserir(new Investidor(nome, sobrenome, cpf, senha));
            JOptionPane.showMessageDialog(view, "Investidor cadastrado!",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            JLogin jlogin = JLogin.getInstance();
            jlogin.setVisible(true);
            view.dispose();
            
        }catch(IllegalArgumentException e){
            view.getLblReport().setText(e.toString());
        }catch(SQLException e){
            e.toString();
            JOptionPane.showMessageDialog(view, "Investidor não cadastrado!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void viewSenha(boolean visible){
        JPasswordField txtSenha = view.getTxtSenha();
        if(visible){
            txtSenha.setEchoChar('\0');
        }else{
            txtSenha.setEchoChar('•');
        }
    }
    
    public void viewConfirmSenha(boolean visible){
        JPasswordField txtConfirmSenha = view.getTxtConfirmSenha();
        if(visible){
            txtConfirmSenha.setEchoChar('\0');
        }else{
            txtConfirmSenha.setEchoChar('•');
        }
    }
    
    public void abrirLogin(){
        JLogin j = JLogin.getInstance();
        j.setVisible(true);
        view.dispose();
    }
}
