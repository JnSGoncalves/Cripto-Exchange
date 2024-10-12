package com.jngoncalves;

import java.util.ArrayList;
import model.moedas.Moedas;
import view.JCadastro;
import view.JInicial;
import view.JLogin;

public class CriptoExchange {
    public static void main(String[] args) {
        ArrayList<Moedas> moedas = new ArrayList<Moedas>();

        JLogin janela = new JLogin();
        janela.setVisible(true);

        JInicial ji = new JInicial();
        ji.setVisible(true);

        JCadastro jc = new JCadastro();
        jc.setVisible(true);
    }
    
}
