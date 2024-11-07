package model.funcoes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JLabel;
import model.moedas.Carteira;
import view.JPrincipal;

public class SaldoFuncoes {
    private static final DecimalFormat formatoValor = new DecimalFormat("R$ #,##0.00");
    private static final NumberFormat formatoQtd = NumberFormat.getInstance(new java.util.Locale("pt", "BR"));
    
    public static void verSaldo(JPrincipal view, boolean saldoVisivel, Carteira carteira){
        JLabel total = view.getSaldoTotalValor();
        JLabel real = view.getSaldoRealValor();
        JLabel bitcoinQtd = view.getSaldoBitcoinQtd();
        JLabel bitcoinValor = view.getSaldoBitcoinValor();
        JLabel ethereumQtd = view.getSaldoEtheriumQtd();
        JLabel ethereumValor = view.getSaldoEtheriumValor();
        JLabel rippleQtd = view.getSaldoRippleQtd();
        JLabel rippleValor = view.getSaldoRippleValor();
                
        if(saldoVisivel){
            // Cálculo dos valores das moedas faltando
            total.setText(formatoValor.format(0));
            real.setText(formatoValor.format(carteira.getReal().getQuantia()));
            bitcoinValor.setText(formatoValor.format(0));
            ethereumValor.setText(formatoValor.format(0));
            rippleValor.setText(formatoValor.format(0));
            bitcoinQtd.setText("Qtd. " + formatoQtd.format(carteira.getBitcoin().getQuantia()));
            ethereumQtd.setText("Qtd. " + formatoQtd.format(carteira.getEthereum().getQuantia()));
            rippleQtd.setText("Qtd. " + formatoQtd.format(carteira.getRipple().getQuantia()));
        }else{
            total.setText("R$ -,--");
            real.setText("R$ -,--");
            bitcoinValor.setText("R$ -,--");
            ethereumValor.setText("R$ -,--");
            rippleValor.setText("R$ -,--");
            bitcoinQtd.setText("Qtd. -,--");
            ethereumQtd.setText("Qtd. -,--");
            rippleQtd.setText("Qtd. -,--");
        }
    }
}
