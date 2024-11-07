package view;

import controller.CPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import model.user.Investidor;

public class JPrincipal extends javax.swing.JFrame {
    private CPrincipal c;
    private boolean saldoVisivel = false;
    
    public JPrincipal(Investidor inv) {
        initComponents();
        c = new CPrincipal(this, inv);
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
        saldoTotalValor = new javax.swing.JLabel();
        lblSaldoReal = new javax.swing.JLabel();
        saldoRealValor = new javax.swing.JLabel();
        jpSaldoCriptos = new javax.swing.JPanel();
        lblSaldoBitcoin = new javax.swing.JLabel();
        saldoBitcoinQtd = new javax.swing.JLabel();
        saldoBitcoinValor = new javax.swing.JLabel();
        lblSaldoEtherium = new javax.swing.JLabel();
        saldoEtheriumQtd = new javax.swing.JLabel();
        saldoEtheriumValor = new javax.swing.JLabel();
        lblSaldoRipple = new javax.swing.JLabel();
        saldoRippleQtd = new javax.swing.JLabel();
        saldoRippleValor = new javax.swing.JLabel();
        saldoBtAtualizar = new javax.swing.JButton();
        saldoBtVisualizar = new javax.swing.JToggleButton();
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

        lblSaldoTotal.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblSaldoTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoTotal.setText("Saldo Total:");
        lblSaldoTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 1, 1, 1));
        jpSaldoReal.add(lblSaldoTotal);

        saldoTotalValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        saldoTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saldoTotalValor.setText("R$ -,--");
        saldoTotalValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 1, 1, 1));
        jpSaldoReal.add(saldoTotalValor);

        lblSaldoReal.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblSaldoReal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoReal.setText("Real:");
        jpSaldoReal.add(lblSaldoReal);

        saldoRealValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        saldoRealValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saldoRealValor.setText("R$ -,--");
        jpSaldoReal.add(saldoRealValor);

        jpSaldoCriptos.setBackground(new java.awt.Color(255, 255, 255));
        jpSaldoCriptos.setLayout(new java.awt.GridLayout(3, 3));

        lblSaldoBitcoin.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblSaldoBitcoin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoBitcoin.setText("Bitcoin:");
        lblSaldoBitcoin.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 1, 30));
        jpSaldoCriptos.add(lblSaldoBitcoin);

        saldoBitcoinQtd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        saldoBitcoinQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoBitcoinQtd.setText("QTD. -,--");
        saldoBitcoinQtd.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 1, 30));
        jpSaldoCriptos.add(saldoBitcoinQtd);

        saldoBitcoinValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        saldoBitcoinValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saldoBitcoinValor.setText("R$ -,--");
        saldoBitcoinValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 1, 30));
        jpSaldoCriptos.add(saldoBitcoinValor);

        lblSaldoEtherium.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblSaldoEtherium.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoEtherium.setText("Etherium:");
        lblSaldoEtherium.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 30));
        jpSaldoCriptos.add(lblSaldoEtherium);

        saldoEtheriumQtd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        saldoEtheriumQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoEtheriumQtd.setText("QTD. -,--");
        saldoEtheriumQtd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 30));
        jpSaldoCriptos.add(saldoEtheriumQtd);

        saldoEtheriumValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        saldoEtheriumValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saldoEtheriumValor.setText("R$ -,--");
        saldoEtheriumValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 30));
        jpSaldoCriptos.add(saldoEtheriumValor);

        lblSaldoRipple.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblSaldoRipple.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldoRipple.setText("Ripple:");
        lblSaldoRipple.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 40, 30));
        jpSaldoCriptos.add(lblSaldoRipple);

        saldoRippleQtd.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        saldoRippleQtd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoRippleQtd.setText("QTD. -,--");
        saldoRippleQtd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 40, 30));
        jpSaldoCriptos.add(saldoRippleQtd);

        saldoRippleValor.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        saldoRippleValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saldoRippleValor.setText("R$ -,--");
        saldoRippleValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 40, 30));
        jpSaldoCriptos.add(saldoRippleValor);

        saldoBtAtualizar.setBackground(new java.awt.Color(0, 153, 204));
        saldoBtAtualizar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        saldoBtAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        saldoBtAtualizar.setText("Atualizar");
        saldoBtAtualizar.setFocusable(false);
        saldoBtAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoBtAtualizarActionPerformed(evt);
            }
        });

        saldoBtVisualizar.setBackground(new java.awt.Color(0, 153, 204));
        saldoBtVisualizar.setForeground(new java.awt.Color(255, 255, 255));
        saldoBtVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/olho-25x25.png"))); // NOI18N
        saldoBtVisualizar.setFocusable(false);
        saldoBtVisualizar.setMaximumSize(new java.awt.Dimension(94, 26));
        saldoBtVisualizar.setMinimumSize(new java.awt.Dimension(94, 26));
        saldoBtVisualizar.setPreferredSize(new java.awt.Dimension(94, 26));
        saldoBtVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoBtVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpValoresSaldoLayout = new javax.swing.GroupLayout(jpValoresSaldo);
        jpValoresSaldo.setLayout(jpValoresSaldoLayout);
        jpValoresSaldoLayout.setHorizontalGroup(
            jpValoresSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpSaldoReal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpSaldoCriptos, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
            .addGroup(jpValoresSaldoLayout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(saldoBtAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoBtVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpValoresSaldoLayout.setVerticalGroup(
            jpValoresSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpValoresSaldoLayout.createSequentialGroup()
                .addGroup(jpValoresSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saldoBtAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saldoBtVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saldoBtVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoBtVisualizarActionPerformed
        saldoVisivel = !saldoVisivel;
        saldoVisivel = c.saldoVisualizar(saldoVisivel);
    }//GEN-LAST:event_saldoBtVisualizarActionPerformed

    private void saldoBtAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoBtAtualizarActionPerformed
        c.saldoAtualizar(saldoVisivel);
    }//GEN-LAST:event_saldoBtAtualizarActionPerformed

    
    // Gets Aba Saldo
    public JLabel getSaldoBitcoinQtd() {
        return saldoBitcoinQtd;
    }
    public JLabel getSaldoBitcoinValor() {
        return saldoBitcoinValor;
    }
    public JButton getSaldoBtAtualizar() {
        return saldoBtAtualizar;
    }
    public JToggleButton getSaldoBtVisualizar() {
        return saldoBtVisualizar;
    }
    public JLabel getSaldoEtheriumQtd() {
        return saldoEtheriumQtd;
    }
    public JLabel getSaldoEtheriumValor() {
        return saldoEtheriumValor;
    }
    public JLabel getSaldoRealValor() {
        return saldoRealValor;
    }
    public JLabel getSaldoRippleQtd() {
        return saldoRippleQtd;
    }

    public JLabel getSaldoRippleValor() {
        return saldoRippleValor;
    }
    public JLabel getSaldoTotalValor() {
        return saldoTotalValor;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel saldoBitcoinQtd;
    private javax.swing.JLabel saldoBitcoinValor;
    private javax.swing.JButton saldoBtAtualizar;
    private javax.swing.JToggleButton saldoBtVisualizar;
    private javax.swing.JLabel saldoEtheriumQtd;
    private javax.swing.JLabel saldoEtheriumValor;
    private javax.swing.JLabel saldoRealValor;
    private javax.swing.JLabel saldoRippleQtd;
    private javax.swing.JLabel saldoRippleValor;
    private javax.swing.JLabel saldoTotalValor;
    // End of variables declaration//GEN-END:variables
}
