/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsb.steganography.java;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author metallurgical
 */
public class LSBSteganographyJava extends Application {
    
    private File selectedFile, coverFile;
    private GridPane grid;
    private Scene mainScene;
    
    @Override
    public void start( Stage stage ) {
        
        grid = new GridPane();
        grid.setPadding( new Insets( 15, 10, 15, 10) );
        //grid.setGridLinesVisible(true);
        //grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap( 10 );
        grid.setVgap( 10 );
        // create root node for title
        HBox hbox = new HBox();
        hbox.setPrefWidth( 600 );
        // padding the title
        hbox.setPadding( new Insets( 15, 10, 15, 10 ) );
        
        Label mainTitle = new Label( "LSB-STEGANOGRAPHY" );
        mainTitle.setFont( Font.font( "Verdana", FontWeight.BOLD, 30 ) );
        // adding child node into root node
        hbox.getChildren().add( mainTitle );
        grid.add( hbox, 1, 0 );
        
        // Step 1 Label
        Label step1 = new Label( "Step 1 : Choose Secret File" );
        grid.add( step1, 0, 1 );
        
        // Hbox Container 
        HBox step1Container  = (HBox) createHboxActionContainerNode();
        grid.add( step1Container, 0, 2, 2, 1 );
        
        /**
         * Displaying file(cover, secret) details
         */
        Label lblSecretFileName = new Label(), lblSize = new Label();
        Label lblCoverFileName = new Label(), lblSizeCover = new Label();
        
        Button btnChooseSecret = new Button( "Choose File" );
        btnChooseSecret.setOnAction( new EventHandler<ActionEvent> () {
            
            
            @Override
            public void handle( ActionEvent e ){
                
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle( "Open Secret File" );
                fileChooser.getExtensionFilters().addAll(
                        new ExtensionFilter( "Text Files", "*.txt" )
                );
                
                selectedFile = fileChooser.showOpenDialog( stage );
                
                if ( selectedFile != null ) {
                    
                    FileReaderLSB fr = new FileReaderLSB( selectedFile );
                    
                    try {
                        
                        lblSecretFileName.setText( selectedFile.getName() );
                        lblSize.setText( selectedFile.length() + " bytes" );
                        
                        char[] charData = fr.readChar();
                        System.out.println(charData);
                    }
                    catch( Exception exc ) {
                        System.out.println( Msg.ERROR_READING_FILE );
                    }
                    
                    
                }
            }
        });
        
        step1Container.getChildren().addAll( btnChooseSecret, lblSecretFileName, lblSize );
        
        // Step 1 Label
        Label step2 = new Label( "Step 2 : Choose Cover Image File" );
        grid.add( step2, 0, 3 );
        
        // Hbox Container 
        HBox step2Container  = (HBox) createHboxActionContainerNode();
        grid.add( step2Container, 0, 4, 2, 1 );
        
        Button btnChooseCover = new Button( "Choose File" );
        btnChooseCover.setOnAction( new EventHandler<ActionEvent> () {
            
            
            @Override
            public void handle( ActionEvent e ){
                
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle( "Open Cover Image File" );
                fileChooser.getExtensionFilters().addAll(
                        new ExtensionFilter( "Image Files", "*.png", "*.jpg" )
                );
                
                coverFile = fileChooser.showOpenDialog( stage );
                
                if ( coverFile != null ) {
                    
                    FileReaderLSB fr = new FileReaderLSB( coverFile );
                    
                    try {
                        
                        lblCoverFileName.setText( coverFile.getName() );
                        lblSizeCover.setText( coverFile.length() + " bytes" );
                        
                        fr.readPixel();
                        //System.out.println(charData);
                    }
                    catch( Exception exc ) {
                        System.out.println( Msg.ERROR_READING_FILE );
                    }
                    
                    
                }
            }
        });
        
        step2Container.getChildren().addAll( btnChooseCover, lblCoverFileName, lblSizeCover );
        
        // scene
        mainScene = new Scene( grid, 850, 400 );
        stage.setScene( mainScene );
        mainScene.getStylesheets().add( "MainStyle.css" );
        
        // make default width and height
        stage.setMinWidth( 400 );
        stage.setMinHeight( 300 );
        stage.show();
        
    }
    
    private Node createHboxActionContainerNode() {
        
        HBox container  = new HBox( 8 );
        container.getStyleClass().add( "hbox-container" );
        container.setPadding( new Insets( 15, 10, 15, 10 ) );
        return container;
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        launch( args );
    }
    
}
