package tp_project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Класс вируализации/прорисовки главной картинки в JPanel1 и отслеживания
 * нажатия мыши
 */
public class MainPanel extends JPanel implements MouseListener {

    CoordinationCheck coordCheck = new CoordinationCheck();
    Interface parent;
    BufferedImage bim = null;
    int bw = 0, bh = 0;
    String pathPics = null;
    String flagMenu;

    /**
     * Метод считывания полученной картинки, которую получаем в классе
     * Interface. Выбор картинки происходит в зависимости от флага системы
     *
     * @param parent - объект класса Interface, из которого извлекаем флаг
     */
    public MainPanel(Interface parent) {
        this.parent = parent;

        flagMenu = parent.getFlagSystems();
        if (flagMenu == null) {
            pathPics = "/pics/main.png";
        }
        if (flagMenu == "MUSCLES") {
            pathPics = "/pics/muscles.png";
        }
        if (flagMenu == "BONES") {
            pathPics = "/pics/bones.png";
        }
        if (flagMenu == "ORGANS") {
            pathPics = "/pics/organs.png";
        }
        try {
            bim = ImageIO.read(this.getClass().getResource(pathPics));
            if (bim != null) {
                bw = bim.getWidth();
                bh = bim.getHeight();
            }
        } catch (IOException e) {
            System.out.println("cannot open file " + e);
        }
        addMouseListener(this);

    }

    /**
     * Переопределение метода для отрисовки изображений
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(bim, 0, 0, w, h, 0, 0, bw, bh, null);

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {

    }

    /**
     * Переопределение метода получения координат по нажатию мыши.
     *
     * Метод проверяет попадание в одну из заданных областей и получение
     * идентефикатора элемента из метода check(). Передача идентефикатора в метод
     * setBDObjectOrgans() для извлечения информации из БД в окно интерфейса
     *
     * @param arg0 - данные клика мыши
     */
    @Override
    public void mousePressed(MouseEvent arg0) {
        double x = arg0.getX();
        double y = arg0.getY();
        int ident = coordCheck.check(x, y, flagMenu);
        if (ident != 0) {
            parent.setBDObjectOrgans(ident);
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

}
