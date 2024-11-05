package controller;

import view.JCadastro;
import view.JInicial;
import view.JLogin;

public class CInicial {
    JInicial view;

    public CInicial(JInicial view) {
        this.view = view;
    }

    public void abrirLogin(){
        view.dispose();
        JLogin j = JLogin.getInstance();
        j.setVisible(true);
    }
    
    public void abrirCadastro(){
        view.dispose();
        JCadastro j = JCadastro.getInstance();
        j.setVisible(true);
    }
}
