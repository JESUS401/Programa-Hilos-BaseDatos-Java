/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoa2;



/**
 *
 * @author jesus
 */
public class Hilo2 extends Thread { //Hilo 2 debe de mostrar mensaje en pantalla al agotar tiempo!
    @Override
    public void run(){
        System.out.println("Proceso 2");
        /*Recupero Tiempo del Pedido Aceptado*/
        String TiempoPedido;
        AceptarPedidos objeto1 = new AceptarPedidos();
        objeto1.setVisible(false);
        TiempoPedido = objeto1.enviarTiempo;// En este tiempo se va a mostrar el mensaje de termino
        /*Termina RecuperarTiempo*/
        
        
        //Lanzo ventana tiempo 
        Cronometro abrirVentana = new Cronometro();
        abrirVentana.setVisible(true);
        /*Actualizo la base de datos con clase cronometro*/
        
       
    }
    
}
