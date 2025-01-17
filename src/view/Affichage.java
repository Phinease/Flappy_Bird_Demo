package view;

import model.Etat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

public class Affichage extends JPanel implements KeyListener {
    private final Etat etat;
    private final VueOiseau vueOiseau;

    public static final int LARGEUR_FENETRE = 800;
    public static final int HAUTEUR_FENETRE = 800;
    public static final int LARG_OVAL = 20;
    public static final int HAUT_OVAL = 100;

    public Affichage(Etat e) {
        this.setPreferredSize(new Dimension(LARGEUR_FENETRE, HAUTEUR_FENETRE));

        etat = e;
        etat.setMax(HAUTEUR_FENETRE - HAUT_OVAL);
        etat.startParcours(LARGEUR_FENETRE, HAUTEUR_FENETRE);

        vueOiseau = new VueOiseau();
        this.addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        // nettoyer l'image
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Arial", Font.PLAIN, 32));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // dessiner l'oiseau
        int hauteur = etat.getHauteur();
        g2.setStroke(new BasicStroke(3.0f));
        g2.setColor(Color.RED);
        g2.drawOval(Etat.X_OVAL, HAUTEUR_FENETRE - hauteur - HAUT_OVAL, LARG_OVAL, HAUT_OVAL);

        // dessiner la collision
        if (etat.getPerdu()) {
            g2.setColor(Color.BLUE);
            g2.drawString("Perdu", 0, 32);
        }

        // dessiner la trace
        g2.setColor(Color.BLACK);
        ArrayList<Point> points = etat.getParcours();
        Point last_point = points.get(0);
        for (int i = 1; i < points.size() - 1; i += 2) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);

            QuadCurve2D courbe = new QuadCurve2D.Double();
            Point2D debut = new Point2D.Double(last_point.x, last_point.y);
            Point2D ctrl = new Point2D.Double(p1.x, p1.y);
            Point2D fin = new Point2D.Double(p2.x, p2.y);

            courbe.setCurve(debut, ctrl, fin);
            g2.draw(courbe);

            last_point = p2;
        }

        // dessiner la documentation
        g2.drawString("clic gauche : sauter", 0, HAUTEUR_FENETRE - 50);
        g2.drawString("clic droit  : tomber", 0, HAUTEUR_FENETRE - 15);

        vueOiseau.dessiner(g);
    }

    // Utilisé par le controleur et le timer pour indique la vue que l'image a changé
    public void change() {
        revalidate();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("I'm Pressed2");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}