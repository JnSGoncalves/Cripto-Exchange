package com.jngoncalves;

import view.JInicial;
import view.JPrincipal;

public class CriptoExchange {
    public static void main(String[] args) {
        JInicial ji = JInicial.getInstance();
        ji.setVisible(true);
    
        JPrincipal jp = new JPrincipal();
        jp.setVisible(true);
    }
}
