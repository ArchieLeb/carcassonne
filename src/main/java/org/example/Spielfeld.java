package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Spielfeld extends JPanel {
    private static final int ROWS = 14;
    private static final int COLS = 20;
    private static final int CELL_SIZE = 300;

    private JPanel[][] cells;

    private List<BufferedImage> tileImages = new ArrayList<>();
    private BufferedImage selectedTile; // Um das ausgewählte Bild zu speichern
    private Random random = new Random();

    public Spielfeld() {
        loadTileImages();
        setLayout(new GridLayout(ROWS, COLS));
        cells = new JPanel[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JPanel cell = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(Color.GRAY);
                        g.drawRect(0, 0, getWidth(), getHeight());
                    }
                };
                cell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                cell.setBackground(Color.WHITE);

                final int finalRow = row;
                final int finalCol = col;

                // Maus-Listener zur Zelle hinzufügen
                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleCellClick(finalRow, finalCol);
                    }
                });
                cells[row][col] = cell;
                add(cell);
            }
        }
    }
    private void handleCellClick(int row, int col) {
        System.out.println("Zelle geklickt: (" + row + ", " + col + ")");
        Dimension cellSize = cells[row][col].getSize();
        System.out.println("Zellen-Dimensionen von Zelle "+row+"/"+col+": Breite = " + cellSize.width + ", Höhe = " + cellSize.height);

        applySelectedTileToCell(row,col,cells[row][col].getSize().width,cells[row][col].getSize().height);
        // Beispiel: Klick führt dazu, dass die Zelle die Farbe ändert
        //Color currentColor = cells[row][col].getBackground();
        //if (currentColor.equals(Color.LIGHT_GRAY)) {
        //    cells[row][col].setBackground(Color.WHITE);
        //} else {
        //    cells[row][col].setBackground(Color.LIGHT_GRAY);
        //}
    }

    private void loadTileImages() {
        try {
            Path tileFolder = Paths.get(getClass().getResource("/tiles").toURI());
            Files.list(tileFolder).forEach(path -> {
                try {
                    tileImages.add(ImageIO.read(path.toFile()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showRandomTilePopup() {
        // Wähle ein zufälliges Bild
        selectedTile = tileImages.get(random.nextInt(tileImages.size()));

        // Pop-up-Fenster mit dem Bild anzeigen
        JLabel imageLabel = new JLabel(new ImageIcon(selectedTile));
        JOptionPane.showMessageDialog(this, imageLabel, "Deine nächste Kachel", JOptionPane.PLAIN_MESSAGE);
    }

    public void applySelectedTileToCell(int row, int col, int width, int height) {
        if (selectedTile != null) {
            Image scaledImage = selectedTile.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(scaledImage));
            cells[row][col].removeAll();
            cells[row][col].add(label);
            cells[row][col].revalidate();
            cells[row][col].repaint();
        }
    }
}