package model.funcoes;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.user.Investidor;
import view.JPrincipal;

public class FuncoesGerais {
    public static String formatCPF(String cpf){
        return cpf.substring(0, 3) + "." + 
               cpf.substring(3, 6) + "." + 
               cpf.substring(6, 9) + "-" + 
               cpf.substring(9, 11);
    }
    
    public static boolean somenteDigitos(String str){
        return str != null && str.matches("\\d+");
    }
    
    public static boolean verificacaoSenha(JPrincipal view, Investidor inv){
        javax.swing.JPanel panel = new javax.swing.JPanel();
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(passwordField);

        int option = JOptionPane.showConfirmDialog(view, panel, "Digite sua senha", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            // Obtém a senha digitada (em formato de array de caracteres)
            char[] password = passwordField.getPassword();
            String senha = new String(password);
            java.util.Arrays.fill(password, '\u0000');

            if(Consultas.verSenha(inv.getId(), senha)){
                return true;
            }else{
                JOptionPane.showMessageDialog(view, "Senha incorreta!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }else{
            return false;
        }
    }
    
    public static boolean verificacaoSenha(JPasswordField jpSenha, JPrincipal view, Investidor inv){
        char[] password = jpSenha.getPassword();
        String senha = new String(password);
        java.util.Arrays.fill(password, '\u0000');

        if(Consultas.verSenha(inv.getId(), senha)){
            jpSenha.setText("");
            return true;
        }else{
            JOptionPane.showMessageDialog(view, "Senha incorreta!",
                "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean confimFrame(JPrincipal view, String mensagem){
        int resposta = JOptionPane.showConfirmDialog(view, mensagem, 
                "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            return true;
        } else{
            JOptionPane.showMessageDialog(view, "Operação Cancelada.",
                    "Cancelamento", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    public static boolean verfiValor(double valor){
        String valorString = Double.toString(valor);
        
        int indicePonto = valorString.indexOf(".");
        
        if(indicePonto == -1){
            // Sem casas decimais
            return true;
        }
        
        return (valorString.length() - indicePonto - 1) <= 2;
    }
}
