package org.example;

import javax.swing.*;
import java.awt.*;

public class Spielfeld extends JPanel {
    private static final int ROWS = 14;
    private static final int COLS = 20;
    private static final int CELL_SIZE = 70;
    private JPanel[][] cells;

    public Spielfeld() {
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
                cells[row][col] = cell;
                add(cell);
            }
        }
    }
}