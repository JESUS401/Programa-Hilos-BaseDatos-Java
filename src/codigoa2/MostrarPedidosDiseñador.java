/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoa2;

import static codigoa2.LoginDiseñador.nombreUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class MostrarPedidosDiseñador extends javax.swing.JFrame {

    /**
     * Creates new form MostrarPedidosDiseñador
     */
    public MostrarPedidosDiseñador() {
        /*Arrancar ventana*/
        initComponents();
        this.setVisible(true);
        setTitle("Mostrar Pedidos diseñador"); //Nombre que se va a desplegar en la parte superior
        this.setVisible(true); //La visualización de la ventana es verdadero, caso contrario no se muestra
        this.setLocationRelativeTo(null); // Localización en pantalla en nulo para que me de el centro
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*RecuperarNombreDiseñador*/
        LoginDiseñador o1 = new LoginDiseñador();// creo un objeto para acceder al nombre usuario
        o1.setVisible(false);// pongo este valor en falso, de lo contrario se abriría una nueva ventana
        recibe13.setText(o1.nombreUsuario);//llamo nombreUsuario con el que inicio sesión
        /*RecuperarNumeroUsuario*/
        String Nombre = recibe13.getText();
        
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
                        //System.out.println("El numero de usuario es "+numeroDiseñador); //Usada para pruebas Numero de empleado se encuentra en numero diseñador
                        String convertir= String.valueOf(numeroDiseñador);//convierto de int a string
                        cajaNumero.setText(convertir);//almaceno el numero en la caja, para acceder a el posteriormente
                        
                      
                    }
                   

                } catch (SQLException error) {
                    System.out.println("ErrorQuery3135");
                    System.err.println(error.toString());
                    
                }
        
        //Termina Recuperar numero Usuario
        
        
        
        //Conociendo que usuario inició sesión procedo a realizar la conexión a la base de datos para mostrar la tabla

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tabla111.setModel(modelo);

            PreparedStatement ps = null;
            PreparedStatement ps2 = null;
            ResultSet resultado1 = null;
            ResultSet resultado2 = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
          
            

            //String buscar  con el valor de = caja1.getText();
            //
            String sql = "SELECT NumeroEmpleado,id_pedido_empleado,Id_arreglo,Estatus,Tiempo_estimado,hora_inicio,hora_termino FROM pedidos_empleado WHERE NumeroEmpleado = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cajaNumero.getText());
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
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        recibe13 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla111 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cajaNumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario: ");

        recibe13.setEditable(false);
        recibe13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibe13ActionPerformed(evt);
            }
        });

        jLabel2.setText("Estos son todos los pedidos que se encuentran a su nombre.");

        tabla111.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NumeroEmpleado", "id_pedido_empleado", "Id_arreglo", "Estatus", "Tiempo Estimado", "hora_inicio", "hora_termino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla111);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Mostrar Pedidos");

        jLabel4.setText("Número usuario:");

        cajaNumero.setEditable(false);

        jLabel5.setText("Únicamente se muestran los pedidos del usuario con el que inició sesión.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(recibe13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cajaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(0, 150, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(recibe13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cajaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recibe13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibe13ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_recibe13ActionPerformed

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
            java.util.logging.Logger.getLogger(MostrarPedidosDiseñador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarPedidosDiseñador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarPedidosDiseñador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarPedidosDiseñador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarPedidosDiseñador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField cajaNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField recibe13;
    private javax.swing.JTable tabla111;
    // End of variables declaration//GEN-END:variables
}
