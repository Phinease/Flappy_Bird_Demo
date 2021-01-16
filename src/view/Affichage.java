package view;

import model.Etat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Affichage extends JPanel {
    private final Etat etat;

    public static final int LARG = 800;
    public static final int HAUT = 800;
    public static final int LARG_OVAL = 20;
    public static final int HAUT_OVAL = 100;
    public static final int X_OVAL = 50;

    public ArrayList<Integer> history = new ArrayList<>();


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
        g.drawOval(X_OVAL, etat.getHauteur(), LARG_OVAL, HAUT_OVAL);

        // dessiner la trace
        int size = history.size();
        int LINEX = X_OVAL + LARG_OVAL / 2;

        g.setColor(Color.BLUE);
        for (int i = 1; i < size; i++) {
            g.drawLine(LINEX + (i - 1) * 10, history.get(size - i), LINEX + i * 10, history.get(size - 1 - i));
        }
    }

    // Utilisé par le controleur et le timer pour indique la vue que l'image a changé
    public void change() {
        history.add(etat.getHauteur() + HAUT_OVAL / 2);
        if (history.size() > 100) {
            history = new ArrayList<>(history.subList(history.size() - 100, history.size()));
        }
        repaint();
    }
}