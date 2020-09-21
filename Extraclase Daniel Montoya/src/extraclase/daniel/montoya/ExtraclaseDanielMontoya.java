/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraclase.daniel.montoya;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Daniel Montoya
 */
public class ExtraclaseDanielMontoya extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        /**
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        */
        
        Chat c = new Chat();
        Scene scene = new Scene(c.grid(), 800, 600);
        
        primaryStage.setTitle("WhatsDan!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
