package model.funcoes;

import java.text.DecimalFormat;
import javax.swing.JLabel;
import model.moedas.Carteira;
import view.JPrincipal;

public class SaqueDepFuncoes {
    private static final DecimalFormat formatoValor = new DecimalFormat("R$ #,##0.00");
    
    public static void verSaldo(JPrincipal view, boolean saldoVisivel, Carteira carteira){
        JLabel saldo = view.getSaqueDepSaldo();
                
        if(saldoVisivel){
            saldo.setText(formatoValor.format(carteira.getReal().getQuantia()));
        }else{
            saldo.setText("R$ -,--");
        }
    }
}
