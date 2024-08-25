package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FixedAspectRatioFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Fixed Aspect Ratio Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Set initial size and calculate the aspect ratio
            int initialWidth = 800;
            int initialHeight = 600;
            frame.setSize(initialWidth, initialHeight);
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

            // Add your content here
            JLabel label = new JLabel("Fixed Aspect Ratio Example", SwingConstants.CENTER);
            frame.add(label);

            frame.setVisible(true);
        });
    }
}
