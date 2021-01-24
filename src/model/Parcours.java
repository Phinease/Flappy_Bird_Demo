package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours extends Thread {
    private static final int step = 50;
    private final Random random = new Random();

    private int LARGEUR_FENETRE;
    private ArrayList<Point> parcours = new ArrayList<>();

    public void startParcours(int largeur, int hauteur) {
        LARGEUR_FENETRE = largeur;

        Point p = new Point(60, hauteur / 2);

        parcours.add(p);
        for (int i = 1; i < 20; i++) {
            int length = 30 + random.nextInt(step);
            int new_y = p.y + (int) ((random.nextDouble() * 2 - 1) * length);
            parcours.add(new Point(p.x + length, Math.max(new_y, 0)));
            p = parcours.get(i);
        }

        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);

                // Chaque 500 nanosecounds, vérifier si la parcour est assez, si non ajouter
                Point last = parcours.get(parcours.size() - 1);
                if (last.x < LARGEUR_FENETRE) {
                    int length = 30 + random.nextInt(step);
                    int new_y = last.y + (int) ((random.nextDouble() * 2 - 1) * length);
                    parcours.add(new Point(last.x + length, Math.max(new_y, 0)));
                }

                // System.out.println("Size: " + parcours.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Point> getParcours() {
        // Éliminer les points innutiles avant de passer à etat
        Point first = parcours.get(0);
        for (Point point : parcours) {
            first = point;
            if (point.x >= 0) break;
        }
        int start = parcours.indexOf(first);
        parcours = new ArrayList<>(parcours.subList(Math.max(0, start - 1), parcours.size()));
        return parcours;
    }
}
