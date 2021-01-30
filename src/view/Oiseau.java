package view;

import java.awt.*;
import java.util.Random;

public class Oiseau extends Thread {
    private final Random random = new Random();
    private final int delai;
    private final int vitesse;

    private int etat;
    private int position;
    private int hauteur;

    public Oiseau() {
        vitesse = random.nextInt(5) + 2;
        hauteur = random.nextInt(500);

        position = -200;
        delai = 50;
        etat = 0;
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(delai);
                position += vitesse;
                hauteur += (-1 * random.nextInt(2)) * random.nextInt(5);
                etat = (etat + 1) % 8;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (position > 800 || hauteur < -200 || hauteur > 800) {
                System.out.println("Removed: " + position + ", " + hauteur);
                return;
            }
        }
    }

    public Point getPos() {
        return new Point(position, hauteur);
    }

    public int getEtat() {
        return etat + 1;
    }
}
