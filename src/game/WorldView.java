package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author darkk
 */
public abstract class WorldView extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        paintBackground(g2);
        paintForeground(g2);
    }

    protected void paintBackground(Graphics2D g) {

    }

    protected void paintForeground(Graphics2D g) {

    }
}
