/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsb.steganography.java;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author metallurgical
 */
public class LSBSteganographyJava extends Application {
    
    @Override
    public void start( Stage stage ) {
        
        // create root node for title
        HBox hbox = new HBox(8);
        hbox.setAlignment( Pos.TOP_CENTER );
        // padding the title
        hbox.setPadding( new Insets( 15, 10, 15, 10 ) );
        
        Label mainTitle = new Label( "LSB-STEGANOGRAPHY" );
        mainTitle.setFont( Font.font( "Verdana", FontWeight.BOLD, 30 ) );
        // adding child node into root node
        hbox.getChildren().add( mainTitle );
        
        Scene scene = new Scene( hbox, 300, 100 );
        stage.setScene( scene );
        // make default width and height
        stage.setMinWidth( 400 );
        stage.setMinHeight( 300 );
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        launch( args );
    }
    
}
