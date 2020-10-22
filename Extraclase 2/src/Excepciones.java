
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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


public class Excepciones extends Main {
	 

    public String ExcepcionNumerica() {

        try {
            int x;
            x = Integer.parseInt(JOptionPane.showInputDialog("Excepcion Numerica: " + "\n \n Ingrese el número"));
            return  "NoError" + Integer.toString(x);

        } catch (NumberFormatException nfe) {
        	
        	log.error("ERROR NumberFormatException");

            JOptionPane.showMessageDialog(null, "Error, el parÃ¡metro de entrada debe ser un número entero    " + nfe);

            return "Error:" + nfe; 
            

        }//End catch
    }//End manejoExcepciones

    public String IndiceFueraDeLimite() {

        int listaEntera[] = {1, 2, 3, 4, 5};

        try {
            int x;
            x = Integer.parseInt(JOptionPane.showInputDialog("Excepcion del Ã�ndice: " + "\n \n Ingrese la posición de la lista (0-4)"));

            JOptionPane.showMessageDialog(null, "El contenido en la posicion numero: " + x + " de la lista es el número: " + listaEntera[x]);

            return "NoError" +Integer.toString(x);
        } catch (IndexOutOfBoundsException ioe) {
        	log.error("ERROR IndexOutOfBoundsException");

            JOptionPane.showMessageDialog(null, "Error, el indice no corresponde a la lista ofrecida    " + ioe);
            return "Error:" + ioe;

        }//End catch
    }//End IndiceFueraDeLimite

    public String DivisionEntreCero() {

        try {
            int a;
            int b;
            double c;
            a = Integer.parseInt(JOptionPane.showInputDialog("Division entre 0: " + "\n \n Ingrese el numerador:"));
            b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el denominador:"));

            c = a / b;

            JOptionPane.showMessageDialog(null, "El resultado de la division es:   " + c);

            return "NoError" +Double.toString(c);

        } catch (ArithmeticException ae) {
        	log.error("ERROR ArithmeticException");
            JOptionPane.showMessageDialog(null, "Error, division entre 0    " + ae);
            return "Error:" + ae;
        }//End catch
    }//End IndiceFueraDeLimite

    public String ArchivoNoEncontrado() {

        try {

            String fileName = "";
            String x = "";

            fileName = JOptionPane.showInputDialog("Archivo no encontrado: " + "\n \n Hay un artchivo de nombre 'patito' \n \n Ingrese el nombre del archivo:");

            BufferedReader texto = new BufferedReader(new FileReader(fileName + ".txt"));

            x = texto.readLine();

            JOptionPane.showMessageDialog(null, x);

            return "NoError" +x;

        } catch (FileNotFoundException fnfe) {
        	log.error("ERROR FileNotFoundException");
            JOptionPane.showMessageDialog(null, "Error, no existe ningun archivo con ese nombre    " + fnfe);
            return "Error:" + fnfe;
        } catch (IOException ioe) {
        	log.error("ERROR IOException");
            JOptionPane.showMessageDialog(null, "Error en alguna de las entradas o salidas     " + ioe);
            return "Error:" + ioe;
        }

    }//End ArchivoNoEncontrado

    public void PruebaExcepciones() {

        String x = ExcepcionNumerica();
        String y = IndiceFueraDeLimite();
        String z = DivisionEntreCero();
        String w = ArchivoNoEncontrado();
        if (x.substring(0, 6).equals("Error:")) {
            try {
                FileWriter escribeError = new FileWriter("Excepciones.txt");
                escribeError.write(x);
                escribeError.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (y.substring(0, 6).equals("Error:")) {
            try {
                FileWriter escribeError = new FileWriter("Excepciones.txt");
                escribeError.write(y);
                escribeError.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } else if (z.substring(0, 6).equals("Error:")) {
            try {
                FileWriter escribeError = new FileWriter("Excepciones.txt");
                escribeError.write(z);
                escribeError.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (w.substring(0, 6).equals("Error:")) {
            try {
                FileWriter escribeError = new FileWriter("Excepciones.txt");
                escribeError.write(w);
                escribeError.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

}//End Class
