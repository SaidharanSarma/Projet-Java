/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frstriLauncher;

import frstriGUI.Chat_acteur;
import static java.lang.System.exit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class Chat_launcher extends javax.swing.JFrame {

    /**
     * Creates new form Chat_launcher
     */
    public Chat_launcher() {
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

        jSpinner1 = new javax.swing.JSpinner();
        textIdentifiant = new javax.swing.JLabel();
        textPassword = new javax.swing.JLabel();
        textFieldId = new javax.swing.JTextField();
        textFieldPwd = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        textAdresse = new javax.swing.JLabel();
        textFieldAdr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textIdentifiant.setFont(new java.awt.Font("Linux Libertine G", 0, 14)); // NOI18N
        textIdentifiant.setText("Identifiant :");

        textPassword.setFont(new java.awt.Font("Linux Libertine G", 0, 14)); // NOI18N
        textPassword.setText("Mot de passe : ");

        textFieldPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPwdActionPerformed(evt);
            }
        });

        jButton1.setText("Se connecter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textAdresse.setFont(new java.awt.Font("Linux Libertine G", 0, 14)); // NOI18N
        textAdresse.setText("Adresse du serveur :");

        jLabel4.setFont(new java.awt.Font("Linux Libertine G", 0, 36)); // NOI18N
        jLabel4.setText("iHear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textIdentifiant)
                        .addComponent(textAdresse))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textPassword)
                        .addGap(30, 30, 30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textFieldId, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(textFieldPwd)
                    .addComponent(textFieldAdr))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textFieldAdr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textAdresse)
                        .addGap(18, 18, 18)
                        .addComponent(textIdentifiant)
                        .addGap(18, 18, 18)
                        .addComponent(textPassword)))
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPwdActionPerformed

    private boolean startConnection(String adresse){
        /* Code relatif à la connexion à la base de données */
        /* Chargement du driver JDBC pour MySQL */
        String urlBDD = "jdbc:mysql://" + adresse + ":3306/projet_java";
        String user = "root";
        String password = "";
        c = null;

        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
            //System.exit(0); /* Penser à l'affichage d'une erreur */
            System.out.println("ERREUR SGBD");
            return false; /*On divulge la non connexion*/
        }

        try{
            c = DriverManager.getConnection(urlBDD, user, password);
            /* requete ici*/

            System.out.println("Connection OK.");
        } catch ( SQLException e ) {
            /* Gérer les éventuelles erreurs ici */
            System.out.println(e);
            return false;
        } 
        
        return true; /* On confirme la connexion */
    }
    
    private void endConnection(){
        if ( c != null )
            try {
            /* Fermeture de la connexion */
                System.out.println("Connection KO.");
                c.close();
                c = null;
            } catch ( SQLException ignore ) {
            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */

            }
        
    }
    
    private boolean cmpString(String cmp, String cmp2){
        boolean retour = true;
        
        if(cmp.length() != cmp2.length())
            retour = false;

        if(retour)
            for(int i = 0; i < cmp.length(); i++){
                if(cmp.charAt(i) != cmp2.charAt(i)){
                    retour = false;
                }
            }
        
        return retour;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Si l'utilisateur appuie sur se connecter.
        boolean pass = false;
                
        /* Si il a renseigné tout les champs */
        if(!textFieldAdr.getText().isEmpty() && !textFieldId.getText().isEmpty() && !textFieldPwd.getText().isEmpty()){
            if(startConnection(textFieldAdr.getText())){
                /* La connexion est établie, test des identifiants données */
                Statement s = null;
                ResultSet r = null;
                String cmp, cmp2;
                int idUser = 0;
                
                try {
                    s = c.createStatement();
                    r = s.executeQuery("SELECT password, idUser FROM UTILISATEURS WHERE username like '" + textFieldId.getText() + "'"); /* On selectionne tout dans le salon */
                    System.out.println("Requete lancée !");
                    
                    while(r.next()){
                        cmp = String.valueOf(textFieldPwd.getPassword());
                        cmp2 = r.getString("password");
                        idUser = r.getInt("idUser");
                        System.out.println(cmp + " " + cmp2);
                        if(cmpString(cmp, cmp2)){
                            pass = true;
                        }
                    }
                    
                } catch ( SQLException e ) {
                    System.out.println("funtion rafraichir() " + e);
                } finally {
                    if ( r != null ) { /* fermeture resultset */
                        try {
                            r.close();
                        } catch ( SQLException ignore ) {
                        }
                    }
                    if ( s != null ) { /* fermeture statement */
                        try {
                            s.close();
                        } catch ( SQLException ignore ) {
                        }
                    }
                }
                
                new Chat_acteur(idUser, textFieldId.getText()).setVisible(true); /*On donne les identifiants à la prochaine fenetre */
                this.setVisible(false);
                
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Chat_launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat_launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat_launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat_launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat_launcher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel textAdresse;
    private javax.swing.JTextField textFieldAdr;
    private javax.swing.JTextField textFieldId;
    private javax.swing.JPasswordField textFieldPwd;
    private javax.swing.JLabel textIdentifiant;
    private javax.swing.JLabel textPassword;
    // End of variables declaration//GEN-END:variables

    private Connection c = null;
    
}
