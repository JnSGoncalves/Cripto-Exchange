package com.jngoncalves;

/**
 *
 * @author jnsgoncalves
 */
import com.jngoncalves.view.*;

public class CriptoExchange {
    public static void main(String[] args) {
        JLogin janela = new JLogin();
        janela.setVisible(true);
        
        JInicial ji = new JInicial();
        ji.setVisible(true);
        
        JCadastro jc = new JCadastro();
        jc.setVisible(true);
    }
    
}
