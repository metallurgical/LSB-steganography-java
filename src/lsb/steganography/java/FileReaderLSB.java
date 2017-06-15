/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsb.steganography.java;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.imageio.ImageIO;

/**
 *
 * @author metallurgical
 */
class FileReaderLSB {
    
    private File file;
    char[] charData;
    
    /**
     * Accept only File object
     * @param file 
     */
    FileReaderLSB ( File file ) {
        this.file = file;
    }
    
    /**
     * Read file and return byte array
     * @throws Exception 
     */
    protected char[] readChar () throws Exception {
        
        charData = new char[ (int) file.length() ];
        
        try {
            
            Reader fs = new FileReader( file );
            fs.read( charData );
            
        }
        catch( SecurityException e ) {
            
            Alert alert = new Alert( AlertType.INFORMATION );
            alert.setTitle( Msg.ALERT_TITLE_INFO );
            alert.setHeaderText( null );
            alert.setContentText( Msg.FILE_NOT_PERMITTED );
            alert.showAndWait();
            System.out.println( "Error message" +  e.getMessage() );
            
        }
        
        return charData;
        
    }
    
    protected int[] readPixel () throws Exception {
        
        BufferedImage bi = ImageIO.read( file );
        int[] rgbArray = new int[ bi.getWidth() * bi.getHeight() * 4];
        bi.getRGB(0, 0, bi.getWidth(), bi.getHeight(), rgbArray,0,0);
        System.out.println(rgbArray[1]);
        return rgbArray;
    }
    
}
