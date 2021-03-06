/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoa2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author jesus
 */
public class Cronometro extends javax.swing.JFrame {

   
    private Timer tiempo;
    private int centesimas_segundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    
    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            centesimas_segundos ++;
           if(centesimas_segundos == 100){
                segundos++;
                centesimas_segundos = 0;
            }
            if(segundos == 60){
                minutos ++;
                segundos = 0;
            } 
            if(minutos == 60){
                horas ++;
                minutos = 0;
            }
            if(horas == 24){
                horas = 0;
            }
            
            actualizarEtiquetaTiempo();
        }
    };
    
    private void actualizarEtiquetaTiempo(){
        String texto = (horas<=9?"0":"")+horas+":"+(minutos<=9?"0":"")+minutos+":"+(segundos <= 9?"0":"")+segundos+":"+(centesimas_segundos <=9?"0":"")+centesimas_segundos;
        etiqueta_tiempo.setText(texto);
    }


    
    public Cronometro() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        tiempo = new Timer(10, acciones);
        tiempo.start();
    }

    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etiqueta_tiempo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        enviarTiempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Ahora puede trabajar cuando termine de click en el boton: ");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reloj.jpg"))); // NOI18N

        etiqueta_tiempo.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        etiqueta_tiempo.setText("00:00:00:00");

        jButton1.setText("Terminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        enviarTiempo.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enviarTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(etiqueta_tiempo)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(etiqueta_tiempo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enviarTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Debe parar el cronometro y guardar tiempo que tomo hacer pedido
        tiempo.stop();
        String recuperarTiempo = etiqueta_tiempo.getText();
        enviarTiempo.setText(recuperarTiempo);
        
        /* el tiempo se pasa en formato 00:00:00:00 para ejecutar query debo borrar los ultimos 3 digitos*/
        /*char letra1 = recuperarTiempo.charAt(0);
        char letra2 = recuperarTiempo.charAt(1);
        char letra3 = recuperarTiempo.charAt(2);
        char letra4 = recuperarTiempo.charAt(3);
        char letra5 = recuperarTiempo.charAt(4);
        char letra6 = recuperarTiempo.charAt(5);
        char letra7 = recuperarTiempo.charAt(6);
        int datocompleto = letra1+letra2+letra3+letra4+letra5+letra6+letra7;
        System.out.println("Esta estupidez muestra" +datocompleto);*/
        
        //Conociendo el tiempo, actualizo la base de datos 
        
        /*Inicia recuperar NumeroDise??ador (se usar?? para query)*/
        String numeroEmpleado;
        AceptarPedidos objeto = new AceptarPedidos();
        objeto.setVisible(false);
        numeroEmpleado = objeto.convertir;//variable numero de empleado recibe dato de objeto
        //Inicia recuperar numero Gu??a
        String numeroGuia;
        numeroGuia = objeto.enviarOrden;
        //System.out.println("El numero de orden es"+numeroGuia ); //El numero se encuentra en numeroGuia
        
        
        
        
        
        try {
            String Estatus = "Terminado";
                    PreparedStatement ps2 = null;
                    PreparedStatement ps = null;
                    ResultSet resultado1 = null;
                    Conexion conn = new Conexion();
                    Connection con = conn.getConexion();
                    ps = con.prepareStatement("update pedidos_empleado set hora_termino=? where NumeroEmpleado=? and id_pedido_empleado=?");
                    ps.setString(1,recuperarTiempo);
                    ps.setString(2, numeroEmpleado);
                    ps.setString(3, numeroGuia);
                    ps.executeUpdate();
                   
                    ps2 = con.prepareStatement("update pedidos_empleado set Estatus=? where NumeroEmpleado=? and id_pedido_empleado=?");
                    ps2.setString(1,Estatus);
                    ps2.setString(2, numeroEmpleado);
                    ps2.setString(3, numeroGuia);
                    ps2.executeUpdate();
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "El pedido finaliz??, se informa al administrador el tiempo que tom?? ");

                } catch (SQLException error) {
                    System.out.println("ErrorQuery8801");
                    System.err.println(error.toString());
                    
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
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cronometro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField enviarTiempo;
    private javax.swing.JLabel etiqueta_tiempo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
