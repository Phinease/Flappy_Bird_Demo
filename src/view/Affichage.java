package view;

import model.Etat;

import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel {
    private final Etat etat;
    public static final int LARGEUR_FENETRE = 800;
    public static final int HAUTEUR_FENETRE = 800;
    public static final int LARG_OVAL = 20;
    public static final int HAUT_OVAL = 100;

    public Affichage(Etat e) {
        etat = e;
        this.setPreferredSize(new Dimension(LARGEUR_FENETRE, HAUTEUR_FENETRE));
    }

    @Override
    public void paint(Graphics g) {
        // nettoyer l'image
        super.paint(g);

        // dessiner l'oiseau
        int hauteur = etat.getHauteur(HAUTEUR_FENETRE - HAUT_OVAL);
        g.setColor(Color.RED);
        g.drawOval(Etat.X_OVAL, HAUTEUR_FENETRE - hauteur - HAUT_OVAL, LARG_OVAL, HAUT_OVAL);

        // dessiner la trace
        int size = etat.getSizeHistory();
        int LINEX = Etat.X_OVAL + LARG_OVAL / 2;

        g.setColor(Color.BLUE);
        for (int i = 1; i < size; i++) {
            g.drawLine(LINEX + (i - 1) * 10, HAUTEUR_FENETRE - etat.getHistory(size - i) - HAUT_OVAL / 2,
                    LINEX + i * 10, HAUTEUR_FENETRE - etat.getHistory(size - 1 - i) - HAUT_OVAL / 2);
        }
    }

    // Utilisé par le controleur et le timer pour indique la vue que l'image a changé
    public void change() {
        etat.addHistory();
        repaint();
    }
}