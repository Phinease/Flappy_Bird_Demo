package view;

import model.Etat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Affichage extends JPanel {
    private final Etat etat;
    public static final int LARGEUR_FENETRE = 800;
    public static final int HAUTEUR_FENETRE = 800;
    public static final int LARG_OVAL = 20;
    public static final int HAUT_OVAL = 100;

    public Affichage(Etat e) {
        etat = e;
        etat.setMax(HAUTEUR_FENETRE - HAUT_OVAL);
        this.setPreferredSize(new Dimension(LARGEUR_FENETRE, HAUTEUR_FENETRE));
        etat.startParcours(LARGEUR_FENETRE, HAUTEUR_FENETRE);
    }

    @Override
    public void paint(Graphics g) {
        // nettoyer l'image
        super.paint(g);

        // dessiner l'oiseau
        int hauteur = etat.getHauteur();
        g.setColor(Color.RED);
        g.drawOval(Etat.X_OVAL, HAUTEUR_FENETRE - hauteur - HAUT_OVAL, LARG_OVAL, HAUT_OVAL);

        // dessiner la collision
        if (etat.getDead()) {
            g.setColor(Color.BLUE);
            g.drawString("Collision", 600, 600);
        }

        // dessiner la trace
        g.setColor(Color.BLACK);
        ArrayList<Point> points = etat.getParcours();
        Point last_point = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point point = points.get(i);
            g.drawLine(last_point.x, last_point.y, point.x, point.y);
            last_point = point;
        }

        // dessiner la documentation
        g.drawString("clic gauche: sauter", 600, 100);
        g.drawString("clic-droit: tomber", 600, 120);
    }

    // Utilisé par le controleur et le timer pour indique la vue que l'image a changé
    public void change() {
        revalidate();
        repaint();
    }
}