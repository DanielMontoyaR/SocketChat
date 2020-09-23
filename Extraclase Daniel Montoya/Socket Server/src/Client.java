
import java.io.*;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Montoya
 */
public class Client extends Thread{

    Socket cliente;
    String ip = "127.0.0.1";
    int puerto = 9000;
    PrintStream salida;
    BufferedReader entrada,teclado;//
    
    
    public void run(){
        
        
        
        try{
            Thread.sleep(1000);
            String tec = "";
            String msg = "";
            cliente = new Socket(ip,puerto); //Accede al servidor, por medio de la IP y el número de puerto
            
            while(!tec.equals("/Adios") || !msg.equals("/Adios")){
                
                
                
                entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); // Corresponde a la entrada que se recibe del servidor

                teclado = new BufferedReader(new InputStreamReader(System.in));//Objeto que captura lo que se escribe en teclado
                
                System.out.print( "\n\nCLIENTE DICE:");
                tec = teclado.readLine();// Variable String que equivale a lo escrito por el teclado

                salida = new PrintStream(cliente.getOutputStream());
                salida.println(tec);

                msg = entrada.readLine();
                System.out.println("\n\nEL HOST HA DICHO:" + msg);
            }
            
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
            
            
        }catch(Exception e){}
    
    }//End run
}//End Class
