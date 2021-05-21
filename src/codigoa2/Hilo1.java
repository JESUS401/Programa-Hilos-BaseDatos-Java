/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoa2;

import static codigoa2.AceptarPedidos.enviarOrden;
import static codigoa2.MostrarPedidosDiseñador.cajaNumero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus Hilo 1 cambia Estatus, Hilo 2 da alerta
 */
public class Hilo1  extends Thread{//Hilo uno cambia pedido a asignado y actualiza hora en que acepta diseñador
    
 
    @Override
    public void run(){// Aqui voy a poner la lógica AceptarPedidoDiseñador - hilo1 actualización base de datos
      System.out.println("Proceso1");
        
        /*recupero hora del computador*/
        LocalTime horaActual = LocalTime.now();
        Time time = Time.valueOf( horaActual );
       /*La voy a usar para asignar el tiempo de inicio de una asignación de un pedido*/
        /*RecuperarNombreDiseñador*/
        String nombreDiseñador;
        LoginDiseñador o1 = new LoginDiseñador();// creo un objeto para acceder al nombre usuario
        o1.setVisible(false);// pongo este valor en falso, de lo contrario se abriría una nueva ventana
        nombreDiseñador = o1.nombreUsuario;
        /*Termina recuperar nombre diseñador, lo voy a usar para query*/
        /*Inicia recuperar NumeroDiseñador (se usará para query)*/
        String numeroEmpleado;
        AceptarPedidos objeto = new AceptarPedidos();
        objeto.setVisible(false);
        numeroEmpleado = objeto.convertir;//variable numero de empleado recibe dato de objeto
        //Inicia recuperar numero Guía
        String numeroGuia;
        numeroGuia = objeto.enviarOrden;
        System.out.println("El numero de orden es"+numeroGuia ); //El numero se encuentra en numeroGuia
        //Declaro 2 variables que voy a usar
        String Estatus = "En elaboración";
        /*Comienzo a cambiar estatus de pedido conociendo usuario, numeroUsuario, numeroGuia*/
        //Realizo query
        
        
        try {
                    PreparedStatement ps2 = null;
                    PreparedStatement ps = null;
                    ResultSet resultado1 = null;
                    Conexion conn = new Conexion();
                    Connection con = conn.getConexion();
                    ps = con.prepareStatement("update pedidos_empleado set Estatus=? where NumeroEmpleado=? and id_pedido_empleado=?");
                    ps.setString(1,Estatus);
                    ps.setString(2, numeroEmpleado);
                    ps.setString(3, numeroGuia);
                    ps.executeUpdate();
                    ps2 = con.prepareStatement("update pedidos_empleado set hora_inicio=? where NumeroEmpleado=? and id_pedido_empleado=?");
                    ps2.setTime(1,time);
                    ps2.setString(2, numeroEmpleado);
                    ps2.setString(3, numeroGuia);
                    ps2.executeUpdate();
                    
                    
                    System.out.println("flujo 1 fue correcto");
                   

                } catch (SQLException error) {
                    System.out.println("ErrorQuery8801");
                    System.err.println(error.toString());
                    
                }
         
        
        
    }
    
    
}
