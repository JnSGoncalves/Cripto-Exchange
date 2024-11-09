package controller;

import DAO.Conexao;
import DAO.InvestidoresDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.funcoes.FuncoesGerais;
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
            String confirmSenha = view.getTxtConfirmSenha().getText();
            
            if(nome.isBlank()|| sobrenome.isBlank() || cpf.isBlank() || senha.isBlank() || confirmSenha.isBlank()){
                throw new IllegalArgumentException("Preencha todos os campos");
            }
            
            
            if(!FuncoesGerais.somenteDigitos(cpf) || cpf.length() != 11) {
                throw new IllegalArgumentException("Digite um CPF válido");
            }
            if(!FuncoesGerais.somenteDigitos(senha) || senha.length() != 6){
                throw new IllegalArgumentException("A senha deve conter 6 digitos numérios");
            }
            
            Conexao conexao = new Conexao();
            
            //   Verificação para saber se o CPF já foi cadastrado
            Connection conn = conexao.getConnection();
            InvestidoresDAO dao = new InvestidoresDAO(conn);
            ResultSet res = dao.consultCpf(cpf);
            
            if(res.next()){
                throw new IllegalArgumentException("CPF já cadastrado!");
            }
            
            if(!senha.equals(confirmSenha)){
                throw new IllegalArgumentException("As senhas devem ser iguais!");
            }
            
            dao.inserir(new Investidor(nome, sobrenome, cpf, senha));
            
            JOptionPane.showMessageDialog(view, "Investidor cadastrado!\nRealize o login para continuar.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            abrirLogin();
            
        }catch(IllegalArgumentException e){
            view.getLblReport().setText(e.getMessage());
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
