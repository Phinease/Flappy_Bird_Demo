package model;

import java.awt.*;
import java.util.ArrayList;

public class Avancer extends Thread {
    private final Parcours parcours;

    public Avancer(Parcours p) {
        parcours = p;
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(16);

                // Chaque 16 namoseconds(environ 60 PFS), les parcours déplacent à gauche un pixel.
                ArrayList<Point> points = parcours.getParcours();
                for (Point point : points) {
                    point.x--;
                }
            } catch (Exception ignored) {
            }
        }
    }
}
