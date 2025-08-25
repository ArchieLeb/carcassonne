package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Tile {
    String name;
    public Tile(String name) {
        this.name = name;
    }
    public String toString(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public BufferedImage loadImage(String filename) {
        try (InputStream input = getClass().getResourceAsStream("/tiles/" + filename)) {
            if (input == null) {
                System.err.println("Bilddatei " + filename + " kann nicht gefunden werden");
                return null;
            }
            System.out.println("Bilddatei " + filename + " erfolgreich gezogen!");
            return ImageIO.read(input);
        } catch (IOException e) {
            System.err.println(" Fehler beim Laden von: " + filename + e.getMessage());
            return null;
        }
    }
}

//    public String toString(){
//        return "leer";
//    };
//
//    public BufferedImage getImage(){
//        return null;
//    }
//    public void turn(){
//
//    };
