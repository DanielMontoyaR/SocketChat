
/**
 *  Institito Tecnológico de Costa Rica
 *  Ingenirería en Computadores
 *  Algoritmos Y Estructuras de Datos I
 *  Elaborado por Daniel Montoya Rivera - 2020324854
 *  Profesor: Leonardo Araya Martínez
 *  Grupo: 3
 *  Semestre II
 *  2020
 */

/**
 * @author Daniel Montoya
 *
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Server serv = new Server();
        Client cliente = new Client();

        serv.start();
        cliente.start();
    }

}
