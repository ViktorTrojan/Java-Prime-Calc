package components.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private boolean border = false;
    private int rounded = 20;

    public Panel() {
        setOpaque(false);
    }

    private void paintBorder(Graphics2D g2, int width, int height) {
        if(!border) return;
        g2.setColor(getBackground().darker());
        g2.drawRoundRect(0, 0, width - 1, height - 1, rounded, rounded);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, rounded, rounded);

        paintBorder(g2, width, height);

        g2.dispose();
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }

    public int getRounded() {
        return rounded;
    }

    public void setRounded(int rounded) {
        this.rounded = rounded;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }
}
