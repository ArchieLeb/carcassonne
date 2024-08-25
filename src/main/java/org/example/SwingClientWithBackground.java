package org.example;
//
//import javax.swing.*;
//import java.io.IOException;
//
//public class Main {
//public static void main(String[] args) throws IOException {
//    SwingUtilities.invokeLater(() -> new CarcassonneGame());
//}
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SwingClientWithBackground {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Carcassonne Startscreen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            int initialWidth = 1192;
            int initialHeight = 685;
            frame.setSize(initialWidth, initialHeight);
            frame.setMinimumSize(new Dimension(initialWidth/2, initialHeight/2));
            //frame.setMaximumSize(new Dimension(Math.round(initialWidth*1.2f), Math.round(initialHeight*1.2f)));
            frame.setLocationRelativeTo(null);
            frame.setUndecorated(true);
            float aspectRatio = (float) initialWidth / initialHeight;

            // Add a ComponentListener to maintain the aspect ratio
            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    Dimension newSize = frame.getSize();
                    int newWidth = newSize.width;
                    int newHeight = newSize.height;

                    // Recalculate size based on the aspect ratio
                    if (newWidth / (float) newHeight < aspectRatio) {
                        newHeight = Math.round(newWidth / aspectRatio);
                    } else {
                        newWidth = Math.round(newHeight * aspectRatio);
                    }

                    // Set the new size with the fixed aspect ratio
                    frame.setSize(new Dimension(newWidth, newHeight));
                }
            });

            // Erstelle das benutzerdefinierte Panel mit dem Hintergrundbild
            BackgroundPanel backgroundPanel = new BackgroundPanel("/CarcassonneTitelbild.jpg");
            frame.setContentPane(backgroundPanel);
            backgroundPanel.setLayout(null);

            // Buttons
            JButton leftButton = new JButton("Neues Spiel starten");
            JButton rightButton = new JButton("Zurück zu Windows");

            // Initiale Positionierung der Buttons
            int buttonWidth = 150;
            int buttonHeight = 50;
            int gap = 100;
            leftButton.setBounds(gap, frame.getHeight() - buttonHeight - gap, buttonWidth, buttonHeight);
            rightButton.setBounds(frame.getWidth() - buttonWidth - gap, frame.getHeight() - buttonHeight - gap, buttonWidth, buttonHeight);
            JButton[] buttons = {leftButton, rightButton};
            for (JButton button : buttons) {
                button.setBackground(Color.ORANGE);
            }

            // ActionListener für die Buttons
            leftButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame gameframe = new JFrame("Carcassonne Spiel");
                    gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gameframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    gameframe.setUndecorated(true);
                    JPanel mainPanel = new BackgroundPanel("/CarcassonneTitelbild.jpg");
                    mainPanel.setLayout(new GridBagLayout());
                    Spielfeld SpielfeldPanel = new Spielfeld();
                    JPanel closepanel = new JPanel();
                    closepanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                    //closepanel.setPreferredSize(new Dimension(300, 200));
                    //closepanel.setBorder(BorderFactory.createLineBorder(Color.black));
                    JButton closeButton = new JButton("Zurück zu Windows");
                    closeButton.setPreferredSize(new Dimension(150, 50));
                    closepanel.add(closeButton);

                    //JLabel label = new JLabel("Funktion noch nicht implementiert", SwingConstants.CENTER);
                    //label.setFont(new Font("Arial", Font.PLAIN, 20));
                    closeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    //gameframe.add(label, BorderLayout.CENTER);
                    mainPanel.add(SpielfeldPanel);
                    gameframe.add(mainPanel);
                    gameframe.add(closepanel, BorderLayout.SOUTH);
                    gameframe.setLocationRelativeTo(null);
                    gameframe.setVisible(true);

                }
            });

            rightButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                }
            });


            // Buttons zum Panel hinzufügen
            backgroundPanel.add(leftButton);
            backgroundPanel.add(rightButton);

            // Hinzufügen eines ComponentListener, um die Positionen der Buttons bei Größenänderung des Fensters zu aktualisieren
            frame.addComponentListener(new java.awt.event.ComponentAdapter() {
                public void componentResized(java.awt.event.ComponentEvent evt) {
                    leftButton.setBounds(gap, frame.getHeight() - buttonHeight - gap, buttonWidth, buttonHeight);
                    rightButton.setBounds(frame.getWidth() - buttonWidth - gap, frame.getHeight() - buttonHeight - gap, buttonWidth, buttonHeight);
                }
            });

            //frame.setContentPane(backgroundPanel);
            frame.setVisible(true);
        });
    }
}


