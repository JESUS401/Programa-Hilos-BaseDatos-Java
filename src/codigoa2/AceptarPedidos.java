/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoa2;

import static codigoa2.MostrarPedidosDiseñador.recibe13;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class AceptarPedidos extends javax.swing.JFrame {
  
    /**
     * Creates new form AceptarPedidos
     */
    public AceptarPedidos() {
        initComponents();
        setTitle("Aceptar Pedidos Diseñador"); //Nombre que se va a desplegar en la parte superior
        this.setResizable(false);
        this.setVisible(true); //La visualización de la ventana es verdadero, caso contrario no se muestra
        this.setLocationRelativeTo(null); // Localización en pantalla en nulo para que me de el centro
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        /*RecuperarNombreDiseñador*/
        LoginDiseñador o1 = new LoginDiseñador();// creo un objeto para acceder al nombre usuario
        o1.setVisible(false);// pongo este valor en falso, de lo contrario se abriría una nueva ventana
        recibe14.setText(o1.nombreUsuario);//llamo nombreUsuario con el que inicio sesión
        /*RecuperarNumeroUsuario*/
        String Nombre = recibe14.getText();
        
            try {

                    PreparedStatement ps = null;
                    ResultSet resultado1 = null;
                    Conexion conn = new Conexion();
                    Connection con = conn.getConexion();
                    ps = con.prepareStatement("SELECT NumeroEmpleado FROM empleados WHERE Usuario = ?");
                    ps.setString(1, Nombre);
                    resultado1 = ps.executeQuery();
                    while(resultado1.next()){
                        
                        int numeroDiseñador = resultado1.getInt("NumeroEmpleado");
                        System.out.println("El numero de usuario es "+numeroDiseñador); //Numero de empleado se encuentra en numero diseñador
                        String convertir= String.valueOf(numeroDiseñador);//convierto de int a string
                        cajaNumero2.setText(convertir);//almaceno el numero en la caja, para acceder a el posteriormente
                      
                    }
                   

                } catch (SQLException error) {
                    System.out.println("ErrorQuery3135");
                    System.err.println(error.toString());
                    
                }
        
        //Termina Recuperar numero Usuario
       //Conociendo que usuario inició sesión procedo a realizar la conexión a la base de datos para mostrar la tabla

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tabla44.setModel(modelo);

            PreparedStatement ps = null;
            PreparedStatement ps2 = null;
            ResultSet resultado1 = null;
            ResultSet resultado2 = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
          
            

            //String buscar  con el valor de = caja1.getText();
            //
            String sql = "SELECT NumeroEmpleado,id_pedido_empleado,Id_arreglo,Estatus,Tiempo_estimado,hora_inicio,hora_termino FROM pedidos_empleado WHERE NumeroEmpleado = ? AND Estatus = 'Asignado'";
            ps = con.prepareStatement(sql);
            ps.setString(1, cajaNumero2.getText());
            resultado1 = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) resultado1.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("NumeroEmpleado");
            modelo.addColumn("id_pedido_empleado");
            modelo.addColumn("Id_arreglo");
            modelo.addColumn("Estatus");
            modelo.addColumn("Tiempo_estimado");
            modelo.addColumn("hora_inicio");
            modelo.addColumn("hora_termino");

            while (resultado1.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = resultado1.getObject(i + 1);
                }
                modelo.addRow(filas);

            }

        } catch (SQLException error) {
            System.out.println("Error de Conexion89");
            System.err.println(error.toString());
        }
        
        
    }
    
  
    public static String convertir = "";// creo variable publica para referenciar usuario con quien inicia sesió
    public static String enviarOrden = "";
    public static String enviarTiempo = "";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla44 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cajaNumero2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        recibe14 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        enviar = new javax.swing.JTextField();
        enviarTiempoCaja = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Estos son los pedidos que puede aceptar. ");

        tabla44.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NumeroEmpleado", "id_pedido_empleado", "Id_arreglo", "Estatus", "Tiempo_estimado", "hora_inicio", "hora_termino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla44MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla44);

        jLabel2.setText("¡Bienvenido Nuevamente!");

        jLabel3.setText("Usuario");

        cajaNumero2.setEditable(false);

        jLabel4.setText("Número Usuario");

        recibe14.setEditable(false);

        jButton1.setText("Aceptar Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        enviar.setEditable(false);
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        enviarTiempoCaja.setEditable(false);
        enviarTiempoCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarTiempoCajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enviarTiempoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(4, 4, 4)
                                    .addComponent(recibe14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4)
                                    .addGap(4, 4, 4)
                                    .addComponent(cajaNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cajaNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(recibe14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enviarTiempoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Botón aceptar pedido
        
        if(enviar.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Para usar esta opción debe seleccionar un pedido");
        }else{
            //Comienzo preguntando que si de verdad desea aceptar el pedido
        enviarTiempo = enviarTiempoCaja.getText();
        enviarOrden = enviar.getText();
        int respuesta = JOptionPane.showConfirmDialog(null,"Esta seguro que desea aceptar el pedido\nEsta acción no se puede deshacer");
        convertir = cajaNumero2.getText();
        if(respuesta == JOptionPane.YES_OPTION){
            //Esta parte de la actividad debe ejecutar hilos
                //Creo objeto para instanciar hilo
            Hilo1 primerhilo = new Hilo1();
            Hilo2 segundohilo = new Hilo2();
            primerhilo.start();
            segundohilo.start();
        } else if(respuesta == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "No se realizó ningún cambio");
        }
        
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabla44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla44MouseClicked
        // Click para seleccionar fila
        int seleccionarfila = tabla44.rowAtPoint(evt.getPoint());
        
        //recupero valor id pedido para referenciar update en los hilos
        enviar.setText(String.valueOf(tabla44.getValueAt(seleccionarfila, 1)));
        enviarTiempoCaja.setText(String.valueOf(tabla44.getValueAt(seleccionarfila, 4)));
        
        
    }//GEN-LAST:event_tabla44MouseClicked

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // caja que contiene Seleccion Numero guia pedido
        
    }//GEN-LAST:event_enviarActionPerformed

    private void enviarTiempoCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarTiempoCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enviarTiempoCajaActionPerformed

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
            java.util.logging.Logger.getLogger(AceptarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AceptarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AceptarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AceptarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AceptarPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField cajaNumero2;
    private javax.swing.JTextField enviar;
    private javax.swing.JTextField enviarTiempoCaja;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField recibe14;
    private javax.swing.JTable tabla44;
    // End of variables declaration//GEN-END:variables
}
