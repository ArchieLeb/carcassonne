package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;

    public BackgroundPanel(String resourcePath) {
        try {
            backgroundImage = ImageIO.read(getClass().getResource(resourcePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Hintergrundbild skalieren und zeichnen
            int width = getWidth();
            int height = getHeight();
            g.drawImage(backgroundImage, 0, 0, width, height, this);
        }
    }
}