
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Daniel Montoya
 */
public class Server extends Thread {

    //Instancia de objetos
    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    PrintStream salida;
    BufferedReader entrada, teclado;

    /**
     * El método tiene la funcion de la creacion del servidor (IP = 127.0.0.1,
     * puerto 9000), este envía un mensaje que notifica que nadie se ha
     * conectado, en caso de que alguien se conectara, muestra un mensaje de
     * notificacion que alguien se ha conectado. También recibe mensajes de un
     * cliente que se conecte, y puede enviar mensajes al cliente por medio de
     * un PrintStream y un BufferedReader, para desconectarse del servidor,
     * tanto el cliente como el servidor pueden escribir el mensaje "/a".
     */
    @Override
    public void run() {

        try {
            String mensaje = "Esperando a que alguien se conecte...";
            System.out.println(mensaje);
            server = new ServerSocket(puerto); // Crea un servidor, pasando como parámetro un puerto el cual es donde el servidor va a escuchar
            socket = new Socket();
            socket = server.accept();//Espera que llegue una petición de entrada.
            mensaje = "¡Alguien se ha conectado!";
            String tec2 = " ";
            System.out.println(mensaje);

            while (!mensaje.equalsIgnoreCase("/a") || !tec2.equalsIgnoreCase("/a")) {//El ciclo mantiene la conversación hasta que se envíe un código de finalización llamado '/Adios'

                tec2 = " ";
                mensaje = " ";

                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Recibe el mensaje del cliente
                salida = new PrintStream(socket.getOutputStream());
                mensaje = entrada.readLine();//Coloca el mensaje recibido en una variable de tipo String
                System.out.println("\n\nEL CLIENTE HA DICHO:" + mensaje);//Muestra el mensaje recibida

                if (!mensaje.equalsIgnoreCase("/a")) { //La condición evalúa que el mensaje ingresado por el cliente es o no el de desconeccion.
                    System.out.print("\n\nSERVIDOR DICE:");
                    teclado = new BufferedReader(new InputStreamReader(System.in)); //Objeto que captura lo que se escribe en teclado
                    tec2 = teclado.readLine(); // Variable String que equivale a lo escrito por el teclado

                    salida = new PrintStream(socket.getOutputStream());
                    salida.println(tec2); //Envía el mensaje

                    if (tec2.equalsIgnoreCase("/a")) {//La condición evalúa que el mensaje ingresado por el servidor es o no el de desconeccion.
                        tec2 = "/a";
                        mensaje = "/a";
                    }//End if
                }//End if 
                else {
                    tec2 = "/a";
                    mensaje = "/a";
                }//End else

            }//End While
            System.out.println("El servidor se ha cerrado exitósamente");
            socket.close();//Cierra la conección, se usa para cerrar el puerto.
            entrada.close();//Cierra las entrada.
            salida.close();//Cierra las salidas.

        } catch (IOException e) {
        }
    }

}
