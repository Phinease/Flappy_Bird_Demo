import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel {
    private final Etat etat;

    public static final int largeur = 800;
    public static final int hauteur = 800;
    public static final int OVALW = 20;
    public static final int OVALH = 100;
    public static int OVALX = 50;


    public Affichage(Etat e) {
        etat = e;
        this.setPreferredSize(new Dimension(largeur, hauteur));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(OVALX, etat.getHauteur(), OVALW, OVALH);
    }

    public void jump() {
        repaint(OVALX, etat.getHauteur(), OVALX + OVALW + 1, OVALH + 81);
    }
}