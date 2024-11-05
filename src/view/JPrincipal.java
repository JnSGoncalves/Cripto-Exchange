/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author jnsil
 */
public class JPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JPrincipal
     */
    public JPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFundo = new javax.swing.JPanel();
        jpAbas = new javax.swing.JTabbedPane();
        jpSaldo = new javax.swing.JPanel();
        lblTituloSaldo = new javax.swing.JLabel();
        lblBemVindo = new javax.swing.JLabel();
        jpValoresSaldo = new javax.swing.JPanel();
        jpSaldoReal = new javax.swing.JPanel();
        lblSaldoTotal = new javax.swing.JLabel();
        SaldoTotalValor = new javax.swing.JLabel();
        lblSaldoReal = new javax.swing.JLabel();
        SaldoRealValor = new javax.swing.JLabel();
        jpSaldoCriptos = new javax.swing.JPanel();
        lblSaldoBitcoin = new javax.swing.JLabel();
        SaldoBitcoinQtd = new javax.swing.JLabel();
        SaldoBitcoinValor = new javax.swing.JLabel();
        lblSaldoEtherium = new javax.swing.JLabel();
        SaldoEtheriumQtd = new javax.swing.JLabel();
        SaldoEtheriumValor = new javax.swing.JLabel();
        lblSaldoRipple = new javax.swing.JLabel();
        SaldoRippleQtd = new javax.swing.JLabel();
        SaldoRippleValor = new javax.swing.JLabel();
        SaldoBtAtualizar = new javax.swing.JButton();
        jpScrollExtrato = new javax.swing.JScrollPane();
        jpExtrato = new javax.swing.JPanel();
        lblTituloExtrato = new javax.swing.JLabel();
        jpDepSaque = new javax.swing.JPanel();
        jpCompra = new javax.swing.JPanel();
        jpVenda = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpFundo.setBackground(new java.awt.Color(255, 255, 255));

        jpSaldo.setBackground(new java.awt.Color(255, 255, 255));

        lblTituloSaldo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblTituloSaldo.setForeground(new java.awt.Color(0, 153, 204));
        lblTituloSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloSaldo.setText("Saldo");

        lblBemVindo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(0, 102, 102));
        lblBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBemVindo.setText("Bem Vindo(a) [Usuario]");

        jpValoresSaldo.setBackground(new java.awt.Color(255, 255, 255));

        jpSaldoReal.setBackground(java.awt.Color.white);
        jpSaldoReal.setLayout(new java.awt.GridLayout(2, 2, 50, 15));

        lblSaldoTotal.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblSaldoTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoTotal.setText("Saldo Total:");
        lblSaldoTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 1, 1, 1));
        jpSaldoReal.add(lblSaldoTotal);

        SaldoTotalValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        SaldoTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SaldoTotalValor.setText("R$ 0,00");
        SaldoTotalValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 1, 1, 1));
        jpSaldoReal.add(SaldoTotalValor);

        lblSaldoReal.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblSaldoReal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoReal.setText("Real:");
        jpSaldoReal.add(lblSaldoReal);

        SaldoRealValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        SaldoRealValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SaldoRealValor.setText("R$ 0,00");
        jpSaldoReal.add(SaldoRealValor);

        jpSaldoCriptos.setBackground(new java.awt.Color(255, 255, 255));
        jpSaldoCriptos.setLayout(new java.awt.GridLayout(3, 3));

        lblSaldoBitcoin.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblSaldoBitcoin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoBitcoin.setText("Bitcoin:");
        lblSaldoBitcoin.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 1, 30));
        jpSaldoCriptos.add(lblSaldoBitcoin);

        SaldoBitcoinQtd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        SaldoBitcoinQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SaldoBitcoinQtd.setText("QTD. 0,00");
        SaldoBitcoinQtd.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 1, 30));
        jpSaldoCriptos.add(SaldoBitcoinQtd);

        SaldoBitcoinValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        SaldoBitcoinValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SaldoBitcoinValor.setText("R$ 0,00");
        SaldoBitcoinValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 1, 30));
        jpSaldoCriptos.add(SaldoBitcoinValor);

        lblSaldoEtherium.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblSaldoEtherium.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoEtherium.setText("Etherium:");
        lblSaldoEtherium.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 30));
        jpSaldoCriptos.add(lblSaldoEtherium);

        SaldoEtheriumQtd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        SaldoEtheriumQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SaldoEtheriumQtd.setText("QTD. 0,00");
        SaldoEtheriumQtd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 30));
        jpSaldoCriptos.add(SaldoEtheriumQtd);

        SaldoEtheriumValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        SaldoEtheriumValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SaldoEtheriumValor.setText("R$ 0,00");
        SaldoEtheriumValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 30));
        jpSaldoCriptos.add(SaldoEtheriumValor);

        lblSaldoRipple.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblSaldoRipple.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoRipple.setText("Ripple:");
        lblSaldoRipple.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 40, 30));
        jpSaldoCriptos.add(lblSaldoRipple);

        SaldoRippleQtd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        SaldoRippleQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SaldoRippleQtd.setText("QTD. 0,00");
        SaldoRippleQtd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 40, 30));
        jpSaldoCriptos.add(SaldoRippleQtd);

        SaldoRippleValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        SaldoRippleValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SaldoRippleValor.setText("R$ 0,00");
        SaldoRippleValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 40, 30));
        jpSaldoCriptos.add(SaldoRippleValor);

        SaldoBtAtualizar.setBackground(new java.awt.Color(0, 153, 204));
        SaldoBtAtualizar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        SaldoBtAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        SaldoBtAtualizar.setText("Atualizar");

        javax.swing.GroupLayout jpValoresSaldoLayout = new javax.swing.GroupLayout(jpValoresSaldo);
        jpValoresSaldo.setLayout(jpValoresSaldoLayout);
        jpValoresSaldoLayout.setHorizontalGroup(
            jpValoresSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpSaldoReal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpSaldoCriptos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpValoresSaldoLayout.createSequentialGroup()
                .addContainerGap(373, Short.MAX_VALUE)
                .addComponent(SaldoBtAtualizar)
                .addGap(373, 373, 373))
        );
        jpValoresSaldoLayout.setVerticalGroup(
            jpValoresSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpValoresSaldoLayout.createSequentialGroup()
                .addComponent(SaldoBtAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpSaldoReal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSaldoCriptos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpSaldoLayout = new javax.swing.GroupLayout(jpSaldo);
        jpSaldo.setLayout(jpSaldoLayout);
        jpSaldoLayout.setHorizontalGroup(
            jpSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTituloSaldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpValoresSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBemVindo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpSaldoLayout.setVerticalGroup(
            jpSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpValoresSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpAbas.addTab("Saldo", jpSaldo);

        jpScrollExtrato.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jpExtrato.setBackground(new java.awt.Color(255, 255, 255));

        lblTituloExtrato.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblTituloExtrato.setForeground(new java.awt.Color(0, 153, 204));
        lblTituloExtrato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloExtrato.setText("Extrato");

        javax.swing.GroupLayout jpExtratoLayout = new javax.swing.GroupLayout(jpExtrato);
        jpExtrato.setLayout(jpExtratoLayout);
        jpExtratoLayout.setHorizontalGroup(
            jpExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpExtratoLayout.createSequentialGroup()
                .addComponent(lblTituloExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );
        jpExtratoLayout.setVerticalGroup(
            jpExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpExtratoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloExtrato)
                .addContainerGap(405, Short.MAX_VALUE))
        );

        jpScrollExtrato.setViewportView(jpExtrato);

        jpAbas.addTab("Extrato", jpScrollExtrato);

        javax.swing.GroupLayout jpDepSaqueLayout = new javax.swing.GroupLayout(jpDepSaque);
        jpDepSaque.setLayout(jpDepSaqueLayout);
        jpDepSaqueLayout.setHorizontalGroup(
            jpDepSaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        jpDepSaqueLayout.setVerticalGroup(
            jpDepSaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jpAbas.addTab("Depósito / Saque", jpDepSaque);

        javax.swing.GroupLayout jpCompraLayout = new javax.swing.GroupLayout(jpCompra);
        jpCompra.setLayout(jpCompraLayout);
        jpCompraLayout.setHorizontalGroup(
            jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        jpCompraLayout.setVerticalGroup(
            jpCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jpAbas.addTab("Compra", jpCompra);

        javax.swing.GroupLayout jpVendaLayout = new javax.swing.GroupLayout(jpVenda);
        jpVenda.setLayout(jpVendaLayout);
        jpVendaLayout.setHorizontalGroup(
            jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        jpVendaLayout.setVerticalGroup(
            jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jpAbas.addTab("Venda", jpVenda);

        javax.swing.GroupLayout jpFundoLayout = new javax.swing.GroupLayout(jpFundo);
        jpFundo.setLayout(jpFundoLayout);
        jpFundoLayout.setHorizontalGroup(
            jpFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        jpFundoLayout.setVerticalGroup(
            jpFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpAbas)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SaldoBitcoinQtd;
    private javax.swing.JLabel SaldoBitcoinValor;
    private javax.swing.JButton SaldoBtAtualizar;
    private javax.swing.JLabel SaldoEtheriumQtd;
    private javax.swing.JLabel SaldoEtheriumValor;
    private javax.swing.JLabel SaldoRealValor;
    private javax.swing.JLabel SaldoRippleQtd;
    private javax.swing.JLabel SaldoRippleValor;
    private javax.swing.JLabel SaldoTotalValor;
    private javax.swing.JTabbedPane jpAbas;
    private javax.swing.JPanel jpCompra;
    private javax.swing.JPanel jpDepSaque;
    private javax.swing.JPanel jpExtrato;
    private javax.swing.JPanel jpFundo;
    private javax.swing.JPanel jpSaldo;
    private javax.swing.JPanel jpSaldoCriptos;
    private javax.swing.JPanel jpSaldoReal;
    private javax.swing.JScrollPane jpScrollExtrato;
    private javax.swing.JPanel jpValoresSaldo;
    private javax.swing.JPanel jpVenda;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblSaldoBitcoin;
    private javax.swing.JLabel lblSaldoEtherium;
    private javax.swing.JLabel lblSaldoReal;
    private javax.swing.JLabel lblSaldoRipple;
    private javax.swing.JLabel lblSaldoTotal;
    private javax.swing.JLabel lblTituloExtrato;
    private javax.swing.JLabel lblTituloSaldo;
    // End of variables declaration//GEN-END:variables
}
