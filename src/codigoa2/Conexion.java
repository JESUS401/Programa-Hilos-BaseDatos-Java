/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoa2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class Conexion {

    private final String base = "programar";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://127.0.0.1/" + base;
    private Connection con = null;

    public Connection getConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Se conectó con éxito a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error1");
            JOptionPane.showMessageDialog(null, "Se produjo un error al conectar en la base de datos", "Error01", JOptionPane.WARNING_MESSAGE);
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error2");
        }
        return con;
    }
}
