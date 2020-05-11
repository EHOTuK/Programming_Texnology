package tp_project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * Класс вируализации/прорисовки дочерней картинки в JPanel2
 */
public class MiniPanel extends JPanel {

    Interface parent;
    BufferedImage bim = null;
    int bw = 0, bh = 0;

    public MiniPanel(Interface parent) {
        this.parent = parent;
        bim = parent.getBimage();
        if (bim != null) {
            bw = bim.getWidth();
            bh = bim.getHeight();
        }
    }

    /**
     * Переопределение метода отрисовки изображений, его "центрирование"
     *
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int y = (this.getWidth() - bim.getWidth()) / 2;
        int z = (this.getHeight() - bim.getHeight()) / 2;

        int w = bim.getWidth();
        int h = bim.getHeight();

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(bim, y, z, w, h, null);
    }

}
