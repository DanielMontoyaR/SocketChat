/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraclase.daniel.montoya;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Daniel Montoya
 */
public class Chat {
    
    public GridPane grid(){
        GridPane g = new GridPane();
        
        Button btn_Seleccionar = new Button();
        
        btn_Seleccionar.setText("Seleccionar Dirección");
        
        g.add(btn_Seleccionar,10,10);
        
        
        btn_Seleccionar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event){
                
                JTextField ipTF = new JTextField();
                JTextField puertoTF = new JTextField();
                Object[] message = {
                    "Ingrese la IP:", ipTF,
                    "Puerto:", puertoTF
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Ingreso a Chat", JOptionPane.OK_CANCEL_OPTION);
                
                if (option == JOptionPane.OK_OPTION) {
                    
                    String ip = ipTF.getText();
                    //int puerto = Integer.parseInt(puertoTF.getText());
                    
                    //ip.equals("h") && 
                    
                    if (puertoTF.getText().isEmpty() || ip.isEmpty()){
                        
                        System.out.println("Error, la ip no es válida");
                    }
                    else if (Integer.parseInt(puertoTF.getText()) <= 65535 && Integer.parseInt(puertoTF.getText()) >= 0){
                        
                        boolean funciona = true;
                        
                        for (int i = 0; i < ip.length(); i++) {
                            char k = ip.charAt(i);
                            if (k == '0' || k == '1' || k == '2' || k == '3' || k == '4' || k == '5' || k == '6' || k == '7' || k == '8' || k == '9' || k == '.'){
                                System.out.println("");
                            } else {
                                System.out.println("Error, la ip no es válida");
                                funciona = false;
                                i = ip.length();
                            }
                        }
                        if (funciona == true){
                            System.out.println("FUNCA");
                        }else
                            System.out.println("FUNCAN'T");
                    } else {
                        System.out.println("Error, puerto no válido");
                    }
                } else {
                    System.out.println("Login canceled");
                }
                

                
            }
        });
        
        
    
        //g.getChildren().add(btn_Seleccionar);
    
    
    
        return g;
    }
    
    
}
