package view;

import model.Etat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Affichage extends JPanel {
    private final Etat etat;

    public static final int largeur = 800;
    public static final int hauteur = 800;
    public static final int OVALW = 20;
    public static final int OVALH = 100;
    public static final int OVALX = 50;

    public ArrayList<Integer> history = new ArrayList<>();


    public Affichage(Etat e) {
        etat = e;
        this.setPreferredSize(new Dimension(largeur, hauteur));
    }

    @Override
    public void paint(Graphics g) {
        // nettoyer l'image
        super.paint(g);

        // dessiner l'oiseau
        g.setColor(Color.RED);
        g.drawOval(OVALX, etat.getHauteur(), OVALW, OVALH);

        // dessiner la trace
        int size = history.size();
        int LINEX = OVALX + OVALW / 2;

        g.setColor(Color.BLUE);
        for (int i = 1; i < size; i++) {
            g.drawLine(LINEX + (i - 1) * 10, history.get(size - i), LINEX + i * 10, history.get(size - 1 - i));
        }
    }

    // Utilisé par le controleur et le timer pour indique la vue que l'image a changé
    public void change() {
        history.add(etat.getHauteur() + OVALH / 2);
        if (history.size() > 100) {
            history = new ArrayList<>(history.subList(history.size() - 100, history.size()));
        }
        repaint();
    }
}