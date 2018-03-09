import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Authentification extends javax.swing.JDialog {

    public Authentification(java.awt.Frame parent, boolean modal, JFrame userFrame) {
        super(parent, modal);
        initComponents();
        setSize(450,350);
        jPanel1.setSize(450,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Administrateur");
        Connecter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               if (Login.getText().equals("Abdeel") && (Mdp.getText().equals("123456")))
                {
                    dispose();
                    new Admin().setVisible(true);
                    userFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null,
                                    "INVALID LOGIN OU MOT DE PASSE",
                                    "ECHEC",
                                    JOptionPane.ERROR_MESSAGE);
                }
               
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Connecter = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();
        Mdp = new javax.swing.JPasswordField();
        Login = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        setIconImage(null);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin-Icon---01.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(140, 0, 190, 140);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Login");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 140, 100, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Mot de passe");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 200, 100, 20);

        Connecter.setBackground(new java.awt.Color(102, 153, 255));
        Connecter.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Connecter.setForeground(new java.awt.Color(2, 0, 0));
        Connecter.setText("Connecter");
        Connecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnecterActionPerformed(evt);
            }
        });
        jPanel1.add(Connecter);
        Connecter.setBounds(90, 250, 100, 30);

        Annuler.setBackground(new java.awt.Color(102, 153, 255));
        Annuler.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(Annuler);
        Annuler.setBounds(220, 250, 100, 30);

        Mdp.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jPanel1.add(Mdp);
        Mdp.setBounds(180, 190, 190, 30);

        Login.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel1.add(Login);
        Login.setBounds(180, 140, 190, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
    }//GEN-LAST:event_LoginActionPerformed

    private void ConnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnecterActionPerformed
        
        
        
    }//GEN-LAST:event_ConnecterActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the dialog */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Authentification dialog = new Authentification(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });*/
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Connecter;
    private javax.swing.JTextField Login;
    private javax.swing.JPasswordField Mdp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
