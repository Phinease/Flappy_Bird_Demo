import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Affichage extends JPanel implements MouseListener {
    public static final int largeur = 800;
    public static final int hauteur = 800;
    public static final int OVALW = 20;
    public static final int OVALH = 100;
    public static int OVALX = 50;
    public static int OVALY = 600;


    public Affichage() {
        this.setPreferredSize(new Dimension(largeur, hauteur));
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(OVALX, OVALY, OVALW, OVALH);
    }

    public void jump() {
        OVALY -= 40;
        if (OVALY < 0) OVALY = 0;
        repaint(OVALX, OVALY - 40, OVALX + OVALW + 1, OVALH + 81);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jump();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}