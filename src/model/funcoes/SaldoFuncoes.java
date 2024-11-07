package model.funcoes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import model.moedas.Carteira;
import view.JPrincipal;

public class SaldoFuncoes {
    private static final DecimalFormat formatoValor = new DecimalFormat("R$ #,##0.00");
    // Como é trabalhado com muitas casas decimais a melhor opção é que as transações sejam realizadas com valores 
    // acima de 1 real
    private static final NumberFormat formatoQtd = new DecimalFormat("#0.######################", 
    DecimalFormatSymbols.getInstance(new Locale("pt", "BR")));
    
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
            double valorBitcoin = carteira.getBitcoin().getQuantia() * 
                    Consultas.getValor(carteira.getBitcoin().getIdMoeda());
            double valorEthereum = carteira.getEthereum().getQuantia() * 
                    Consultas.getValor(carteira.getEthereum().getIdMoeda());
            double valorRipple = carteira.getRipple().getQuantia() * 
                    Consultas.getValor(carteira.getRipple().getIdMoeda());
            double valorReal = carteira.getReal().getQuantia();
            
            double valorTotal = valorReal + valorBitcoin + valorEthereum + valorRipple;
            
            total.setText(formatoValor.format(valorTotal));
            real.setText(formatoValor.format(valorReal));
            bitcoinValor.setText(formatoValor.format(valorBitcoin));
            ethereumValor.setText(formatoValor.format(valorEthereum));
            rippleValor.setText(formatoValor.format(valorRipple));
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
