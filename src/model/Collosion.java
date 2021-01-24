package model;

import java.awt.*;
import java.util.ArrayList;

public class Collosion extends Thread {
    private final Etat etat;
    private final int x;

    public Collosion(Etat e) {
        etat = e;
        x = Etat.X_OVAL;
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Point PointBefore, PointAfter;
            ArrayList<Point> points = etat.getParcours();

            PointBefore = points.get(0);
            PointAfter = points.get(0);
            for (Point point : points) {
                if (point.x >= x) {
                    PointAfter = point;
                    break;
                }
                PointBefore = point;
            }

            double pente = ((double) PointAfter.y - PointBefore.y) / (PointAfter.x - PointBefore.x);
            int dist = x - PointBefore.x;
            int HeightCritical = PointBefore.y + (int) (pente * dist);
            etat.setDead(Math.abs(HeightCritical - (800 - etat.getHauteur() - 100 + 50)) > 50);
        }
    }
}
