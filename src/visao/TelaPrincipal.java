package visao;

import controle.Funcionario;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame{

    Funcionario dados = new Funcionario();// Instancia a classa Funcionario para usar a variavel que armazena o nome do Vendedor.
    
    //Instanciando as Salas do Cinema
    Sala1_ORegresso O_Regresso = new Sala1_ORegresso();
    Sala2_TirandoOAtraso tirando_o_atraso = new Sala2_TirandoOAtraso();
    Sala3_DeadPoolDub deadPoolDb = new Sala3_DeadPoolDub();
    Sala4_DeadPoolLeg deadPollLeg = new Sala4_DeadPoolLeg();
    Sala5_Snoopy snoopy = new Sala5_Snoopy();
    Sala6_ORegressoLeg oregressoleg = new Sala6_ORegressoLeg();
    
    public TelaPrincipal() { 
        initComponents();
        /* Chama o método para conectar ao banco de dados
        conecta.conect();
        */
        // chama o metodo para pegar dados do funcionário.
        dados.pedeDados();
        NomeFuncionario.setText(dados.getNome()); //Usado na interface gráfica
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuadradoInterno = new javax.swing.JInternalFrame();
        jPanelQuadradoInterno = new javax.swing.JPanel();
        Sala1_ORegresso = new javax.swing.JButton();
        Sala5_Snoopy = new javax.swing.JButton();
        Sala4_DeadPoolLeg = new javax.swing.JButton();
        Sala6_ORegressoLeg = new javax.swing.JButton();
        Sala2_TirandoOAtraso = new javax.swing.JButton();
        Sala3_DeadPoolDub = new javax.swing.JButton();
        ORegressoDub = new javax.swing.JLabel();
        TirandoOAtraso = new javax.swing.JLabel();
        DeadPoolDub = new javax.swing.JLabel();
        DeadPoolLeg = new javax.swing.JLabel();
        ORegressoLeg = new javax.swing.JLabel();
        Snoopy = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NomeFuncionario = new javax.swing.JTextField();
        NomeVendedor = new javax.swing.JLabel();
        FundoPrincipal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        QuadradoInterno.setTitle("Bem Vindo");
        QuadradoInterno.setVisible(true);
        QuadradoInterno.getContentPane().setLayout(null);

        jPanelQuadradoInterno.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelQuadradoInterno.setLayout(null);

        Sala1_ORegresso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/or.png"))); // NOI18N
        Sala1_ORegresso.setPreferredSize(new java.awt.Dimension(75, 25));
        Sala1_ORegresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sala1_ORegressoActionPerformed(evt);
            }
        });
        jPanelQuadradoInterno.add(Sala1_ORegresso);
        Sala1_ORegresso.setBounds(60, 0, 110, 150);

        Sala5_Snoopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/snoopy.png"))); // NOI18N
        Sala5_Snoopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sala5_SnoopyActionPerformed(evt);
            }
        });
        jPanelQuadradoInterno.add(Sala5_Snoopy);
        Sala5_Snoopy.setBounds(380, 230, 110, 150);

        Sala4_DeadPoolLeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dead.png"))); // NOI18N
        Sala4_DeadPoolLeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sala4_DeadPoolLegActionPerformed(evt);
            }
        });
        jPanelQuadradoInterno.add(Sala4_DeadPoolLeg);
        Sala4_DeadPoolLeg.setBounds(510, 0, 110, 150);

        Sala6_ORegressoLeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/or.png"))); // NOI18N
        Sala6_ORegressoLeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sala6_ORegressoLegActionPerformed(evt);
            }
        });
        jPanelQuadradoInterno.add(Sala6_ORegressoLeg);
        Sala6_ORegressoLeg.setBounds(230, 230, 110, 150);

        Sala2_TirandoOAtraso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tira.png"))); // NOI18N
        Sala2_TirandoOAtraso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sala2_TirandoOAtrasoActionPerformed(evt);
            }
        });
        jPanelQuadradoInterno.add(Sala2_TirandoOAtraso);
        Sala2_TirandoOAtraso.setBounds(220, 0, 110, 150);

        Sala3_DeadPoolDub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dead.png"))); // NOI18N
        Sala3_DeadPoolDub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sala3_DeadPoolDubActionPerformed(evt);
            }
        });
        jPanelQuadradoInterno.add(Sala3_DeadPoolDub);
        Sala3_DeadPoolDub.setBounds(370, 0, 110, 150);

        ORegressoDub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ORegressoDub.setText("O Regresso - Dub.");
        jPanelQuadradoInterno.add(ORegressoDub);
        ORegressoDub.setBounds(60, 140, 130, 50);

        TirandoOAtraso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TirandoOAtraso.setText("Tirando o Atraso-Dub.");
        jPanelQuadradoInterno.add(TirandoOAtraso);
        TirandoOAtraso.setBounds(209, 140, 154, 50);

        DeadPoolDub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeadPoolDub.setText("DeadPool - Dub. ");
        jPanelQuadradoInterno.add(DeadPoolDub);
        DeadPoolDub.setBounds(370, 150, 120, 30);

        DeadPoolLeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeadPoolLeg.setText("DeadPool - Leg.");
        jPanelQuadradoInterno.add(DeadPoolLeg);
        DeadPoolLeg.setBounds(514, 147, 130, 40);

        ORegressoLeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ORegressoLeg.setText("O Regresso - Leg.");
        jPanelQuadradoInterno.add(ORegressoLeg);
        ORegressoLeg.setBounds(220, 370, 130, 40);

        Snoopy.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Snoopy.setText("Snoopy & Charlie Brown-Dub.");
        jPanelQuadradoInterno.add(Snoopy);
        Snoopy.setBounds(350, 370, 200, 40);

        QuadradoInterno.getContentPane().add(jPanelQuadradoInterno);
        jPanelQuadradoInterno.setBounds(0, 30, 680, 450);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("Sistema de Emissão de Ingressos.");
        QuadradoInterno.getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 0, 290, 30);

        NomeFuncionario.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                NomeFuncionarioAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                NomeFuncionarioAncestorRemoved(evt);
            }
        });
        NomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeFuncionarioActionPerformed(evt);
            }
        });
        QuadradoInterno.getContentPane().add(NomeFuncionario);
        NomeFuncionario.setBounds(90, 0, 160, 30);

        NomeVendedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NomeVendedor.setText("Vendedor:");
        QuadradoInterno.getContentPane().add(NomeVendedor);
        NomeVendedor.setBounds(10, 0, 90, 30);

        getContentPane().add(QuadradoInterno);
        QuadradoInterno.setBounds(0, 0, 690, 510);

        FundoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo01.jpg"))); // NOI18N
        FundoPrincipal.setText("jLabel1");
        getContentPane().add(FundoPrincipal);
        FundoPrincipal.setBounds(686, 0, 0, 510);

        jMenu2.setText("Sair");

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSair);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(708, 570));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Sala1_ORegressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sala1_ORegressoActionPerformed
        
    // chama a tela do filme O Regresso
        O_Regresso.setVisible(true);  
    }//GEN-LAST:event_Sala1_ORegressoActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        // Fecha o SIstema.
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void Sala2_TirandoOAtrasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sala2_TirandoOAtrasoActionPerformed
        //torna a sua tela visivel ao usuario.
        tirando_o_atraso.setVisible(true);
        
        
    }//GEN-LAST:event_Sala2_TirandoOAtrasoActionPerformed

    private void Sala3_DeadPoolDubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sala3_DeadPoolDubActionPerformed
        //chama a tela da Sala3_DeadPoolDub.
            deadPoolDb.setVisible(true);
    }//GEN-LAST:event_Sala3_DeadPoolDubActionPerformed

    private void Sala4_DeadPoolLegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sala4_DeadPoolLegActionPerformed
        //chama a tela da Sala4_DeadPoolLeg.
        deadPollLeg.setVisible(true);
    }//GEN-LAST:event_Sala4_DeadPoolLegActionPerformed

    private void Sala5_SnoopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sala5_SnoopyActionPerformed
        //chama a tela da Sala5_Snoopy.
        snoopy.setVisible(true);
    }//GEN-LAST:event_Sala5_SnoopyActionPerformed

    private void Sala6_ORegressoLegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sala6_ORegressoLegActionPerformed
        //chama a tela da Sala6_ORegressoLeg.
        oregressoleg.setVisible(true);
    }//GEN-LAST:event_Sala6_ORegressoLegActionPerformed

    private void NomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeFuncionarioActionPerformed
        // Pega Nome do funcionario e exibe na Tela Principal.
        NomeFuncionario.setText(dados.getNome());
        
    }//GEN-LAST:event_NomeFuncionarioActionPerformed

    private void NomeFuncionarioAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_NomeFuncionarioAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeFuncionarioAncestorRemoved

    private void NomeFuncionarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_NomeFuncionarioAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeFuncionarioAncestorAdded
    
    
    //Inicia o Método main desta classe
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DeadPoolDub;
    private javax.swing.JLabel DeadPoolLeg;
    private javax.swing.JLabel FundoPrincipal;
    private javax.swing.JTextField NomeFuncionario;
    private javax.swing.JLabel NomeVendedor;
    private javax.swing.JLabel ORegressoDub;
    private javax.swing.JLabel ORegressoLeg;
    private javax.swing.JInternalFrame QuadradoInterno;
    private javax.swing.JButton Sala1_ORegresso;
    private javax.swing.JButton Sala2_TirandoOAtraso;
    private javax.swing.JButton Sala3_DeadPoolDub;
    private javax.swing.JButton Sala4_DeadPoolLeg;
    private javax.swing.JButton Sala5_Snoopy;
    private javax.swing.JButton Sala6_ORegressoLeg;
    private javax.swing.JLabel Snoopy;
    private javax.swing.JLabel TirandoOAtraso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JPanel jPanelQuadradoInterno;
    // End of variables declaration//GEN-END:variables
}
