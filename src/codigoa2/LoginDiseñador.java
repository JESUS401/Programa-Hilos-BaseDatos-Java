/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoa2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jesus
 
 */






public class LoginDiseñador extends javax.swing.JFrame {

   
    
    
    
    
    
    /**
     * Creates new form LoginDiseñador
     */
    public LoginDiseñador() {
        initComponents();
        this.setVisible(true);
        setTitle("Iniciar Sesion Diseñador"); //Nombre que se va a desplegar en la parte superior
        this.setVisible(true); //La visualización de la ventana es verdadero, caso contrario no se muestra
        this.setLocationRelativeTo(null); // Localización en pantalla en nulo para que me de el centro
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
    }
    
    public static String nombreUsuario = "";// creo variable publica para referenciar usuario con quien inicia sesión
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuario = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        checkbox2 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 300, 60));

        contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 300, 60));

        checkbox2.setBackground(new java.awt.Color(0, 51, 153));
        checkbox2.setForeground(new java.awt.Color(255, 255, 255));
        checkbox2.setText("Mostrar Contraseña");
        checkbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox2ActionPerformed(evt);
            }
        });
        getContentPane().add(checkbox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 140, 20));

        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 300, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginDiseño2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox2ActionPerformed
        // Caja usuario
        
        
        
        
        if(checkbox2.isSelected()){
           
           contraseña.setEchoChar((char)0);
       }else{
           contraseña.setEchoChar('*');
       }
    
        
        
        

    }//GEN-LAST:event_checkbox2ActionPerformed



    

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Boton Iniciar Sesion Diseñador...
        
        nombreUsuario =usuario.getText();//nombre usuario vale el usuario que se usa para iniciar sesión
        
        
    try{
            //Conexion base de datos
            
            
            Conexion conn = new Conexion();
            Connection con =conn.getConexion();//Comectamos a la base de datos con la clase conexion
            
            
            String sql = "Select * from empleados where usuario =? and contraseña =? and administrador =0" ; //buscamos administradores con query

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getText());
            pst.setString(2, contraseña.getText());
            ResultSet rs = pst.executeQuery();
  
            
            //
          
            if(rs.next()){//si existe en la base 
               // Si usuario y contraseña son correctos
                System.out.println("Logeo Exitoso como Diseñador");
                VentanaDiseñador o1 = new VentanaDiseñador();
                this.setVisible(false);
                
               
                
            }else{
                //Si usuario y Contraseña son incorrectos
                System.out.println("ErrorDatosAdministrador");
                usuario.setText("");
                contraseña.setText("");
                JOptionPane.showMessageDialog(null, "Datos Incorrectos, no es diseñador. \nNo cuenta con los requisitos necesesarios.\nContacte al area de sistemas.");
                
            }
            
            
            
        }catch(Exception errorlogin){
            //Si no se puede conectar a la base de datos.
            System.out.println("ErrorLogin5240");
            JOptionPane.showMessageDialog(null, "Se produjo un error en la base de datos");
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
            java.util.logging.Logger.getLogger(LoginDiseñador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginDiseñador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginDiseñador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginDiseñador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginDiseñador().setVisible(true);
            }
        });
    }

    
    
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkbox2;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
