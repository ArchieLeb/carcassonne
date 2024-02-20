package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CarcassonneGame {
    private JFrame table;
    private JPanel panel;
    private JLabel label;

    public CarcassonneGame() {
        initializeTable();
        initializePanel();
        initializeLabel();
        initializeStartButton();
    }

    private void initializeTable() {
        //Anwendungsfläche erstellen
        table = new JFrame("Carcassonne - Play the Game");
        table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setSize(400, 200);
        table.setLocationRelativeTo(null);
        table.setVisible(true);
    }

    private void initializePanel() {
        //Panel für Komponenten erstellen
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        table.getContentPane().add(panel);
    }

    private void initializeLabel() {
        //Bild reinladen
        File file = new File("C:\\dev\\projects\\Carcassonne\\src\\main\\resources\\CarcassonneTitelbild.jpg");
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        label = new JLabel();
        label.setIcon(imageIcon);
    }

    private void initializeStartButton() {
        //Buttons erstellen
        JButton startButton = new JButton("Start Game Michi");
        startButton.setPreferredSize(new Dimension(150, 50));

        JButton playButton = new JButton("Neues Spiel starten");
        playButton.setPreferredSize(new Dimension(150,50));
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton exitButton = new JButton("Zurück zu Windows");
        exitButton.setPreferredSize(new Dimension(150,50));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
                //panel.setVisible(false);
                table.setSize(1208, 725);
                panel.setSize(1208,100);
                panel.setLocation(0,600);
                table.getContentPane().add(label);
                table.setLocationRelativeTo(null);
                panel.setVisible(true);
                panel.add(playButton);
                panel.add(exitButton);
                //playButton.setLocation(50,150);
                //exitButton.setLocation(1000,150);
                table.revalidate();
            }
        });
        panel.add(startButton);
        panel.revalidate();

    }
}