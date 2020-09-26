
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
public class Client extends Thread {

    Socket cliente;
    String ip = "127.0.0.1";
    int puerto = 9000;
    PrintStream salida;
    BufferedReader entrada, teclado;//

    /**
     * El método tiene la funcion de crear el cliente que se conecta al servidor
     * (IP 127.0.0.1, puerto 9000), este puede enviar mensajes al servidor por
     * medio de un PrintStream y recibir mensajes del mismo, para salir del
     * cliente y desconectarse del servidor se escribe el mensaje "/a"
     */
    @Override
    public void run() {

        try {
            Thread.sleep(1000); //Este tiempo de espera se usa para evitar que tanto el servidor como el cliente se inicien al mismo tiempo, esto para evitar errores
            String tec = " ";
            String msg = " ";
            cliente = new Socket(ip, puerto); //Accede al servidor, por medio de la IP y el número de puerto

            while (!tec.equalsIgnoreCase("/a") || !msg.equalsIgnoreCase("/a")) {

                Thread.sleep(10);

                tec = " ";
                msg = " ";

                System.out.print("\n\nCLIENTE DICE:");
                entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); // Corresponde a la entrada que se recibe del servidor
                teclado = new BufferedReader(new InputStreamReader(System.in));//Objeto que captura lo que se escribe en teclado
                tec = teclado.readLine();// Variable String que equivale a lo escrito por el teclado
                salida = new PrintStream(cliente.getOutputStream());
                salida.println(tec); //Envía el mensaje

                if (!tec.equalsIgnoreCase("/a")) {//La condición evalúa que el mensaje enviado es o no el de desconeccion.

                    entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); // Corresponde a la entrada que se recibe del servidor
                    msg = entrada.readLine(); // Variable String que equivale a lo recibido por el servidor
                    System.out.println("\n\nEL HOST HA DICHO:" + msg);

                    if (msg.equalsIgnoreCase("/a")) {//La condición evalúa que el mensaje recibido por el servidor es o no el de desconeccion.
                        tec = "/a";
                        msg = "/a";
                    }//End if
                }//End if
                else {
                    tec = "/a";
                    msg = "/a";
                }//End Else
            }//End while

            entrada.close();//Cierra la entrada.
            salida.close();//Cierra la salida.
            teclado.close();//Cierra el teclado.
            cliente.close();//Cierra el cliente.

        } catch (IOException | InterruptedException e) {
        }

    }//End run
}//End Class
