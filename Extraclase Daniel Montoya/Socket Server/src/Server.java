
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Montoya
 */
public class Server extends Thread{
    
    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    DataOutputStream salida;
    
    BufferedReader entrada, teclado;
    
    public void run(){
        
        try{
            server = new ServerSocket(puerto); // Crea un servidor, pasando como parámetro un puerto el cual es donde el servidor va a escuchar
            socket = new Socket();
            socket = server.accept();//Espera que llegue una petición de entrada.
            
            String mensaje = "Di algo";
            String tec = "";
            
            System.out.println(mensaje);
            
            
            
            
            while (!mensaje.equals("/Adios") || !tec.equals("/Adios")){//El ciclo mantiene la conversación hasta que se envíe un código de finalización llamado '/Adios'
                
                tec = "";
                mensaje = "";
                
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Recibe la información del cliente
                mensaje = entrada.readLine();//Coloca la información recibida en una variable de tipo String
                System.out.println("\n\nEL CLIENTE HA DICHO:" + mensaje);//Muestra la información recibida
                
                System.out.print( "\n\nSERVIDOR DICE:");
                teclado = new BufferedReader(new InputStreamReader(System.in)); //Objeto que captura lo que se escribe en teclado
                tec = teclado.readLine(); // Variable String que equivale a lo escrito por el teclado
                
                //salida = new DataOutputStream(socket.getOutputStream()); 
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(tec);
                oos.close();
                //salida.writeUTF(tec); // Envía lo que es escrito por teclado
                //System.out.print(tec);
                
            }
            System.out.println("El servidor se ha cerrado exitósamente");
            socket.close();//Cierra la conección, se usa para cerrar el puerto
            entrada.close();//Cierra las entrada
            salida.close();//Cierra las salidas
            
            
        }catch(Exception e){}
        
        
        
    }
    
}
