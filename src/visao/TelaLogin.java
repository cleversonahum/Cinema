package visao;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new javax.swing.JLabel();
        Login = new javax.swing.JTextField();
        Senha = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        Acessar = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        jLabelFundoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 500));
        getContentPane().setLayout(null);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo.png"))); // NOI18N
        getContentPane().add(Logo);
        Logo.setBounds(0, 30, 300, 190);

        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login);
        Login.setBounds(350, 80, 170, 30);
        getContentPane().add(Senha);
        Senha.setBounds(350, 120, 170, 30);

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSenha.setText("Senha: ");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(290, 120, 60, 20);

        Usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Usuario.setText("Usuário: ");
        getContentPane().add(Usuario);
        Usuario.setBounds(290, 80, 60, 20);

        Acessar.setText("Acessar");
        Acessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcessarActionPerformed(evt);
            }
        });
        getContentPane().add(Acessar);
        Acessar.setBounds(350, 160, 73, 23);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        getContentPane().add(Sair);
        Sair.setBounds(430, 160, 70, 23);

        jLabelFundoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundo.jpg"))); // NOI18N
        getContentPane().add(jLabelFundoLogin);
        jLabelFundoLogin.setBounds(0, 0, 560, 260);

        setSize(new java.awt.Dimension(573, 291));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcessarActionPerformed
       // Intanciar para chamar a tela principal
       //Login: admin , senha: admin - Já estabelecidos!
       if(Login.getText().equals("admin") && Senha.getText().equals("admin")){
       // Se login e senha corretos, instacia e chama a tela principal para a escolha dos filmes.
       TelaPrincipal tela = new TelaPrincipal();
       tela.setVisible(true);
       //comando para fechar a tela anterior(Tela de login)
       dispose();
       }else{
           JOptionPane.showMessageDialog(rootPane,"Senha ou Usuário Incorreto");
       }
    }//GEN-LAST:event_AcessarActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // Fecha a Aplicação
        
    }//GEN-LAST:event_SairActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginActionPerformed

   
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acessar;
    private javax.swing.JTextField Login;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton Sair;
    private javax.swing.JPasswordField Senha;
    private javax.swing.JLabel Usuario;
    private javax.swing.JLabel jLabelFundoLogin;
    private javax.swing.JLabel jLabelSenha;
    // End of variables declaration//GEN-END:variables
}
