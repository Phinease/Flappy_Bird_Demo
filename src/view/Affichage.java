package view;

import model.Etat;

import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel {
    private final Etat etat;
    public static final int LARG = 800;
    public static final int HAUT = 800;

    public Affichage(Etat e) {
        etat = e;
        this.setPreferredSize(new Dimension(LARG, HAUT));
    }

    @Override
    public void paint(Graphics g) {
        // nettoyer l'image
        super.paint(g);

        // dessiner l'oiseau
        g.setColor(Color.RED);
        g.drawOval(Etat.X_OVAL, etat.getHauteur(), Etat.LARG_OVAL, Etat.HAUT_OVAL);

        // dessiner la trace
        int size = etat.getSizeHistory();
        int LINEX = Etat.X_OVAL + Etat.LARG_OVAL / 2;

        g.setColor(Color.BLUE);
        for (int i = 1; i < size; i++) {
            g.drawLine(LINEX + (i - 1) * 10, etat.getHistory(size - i), LINEX + i * 10, etat.getHistory(size - 1 - i));
        }
    }

    // Utilisé par le controleur et le timer pour indique la vue que l'image a changé
    public void change() {
        etat.addHistory();
        repaint();
    }
}