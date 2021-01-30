package model;

import view.Affichage;

public class Voler extends Thread {
    private final Etat etat;
    private final Affichage view;

    public Voler(Etat e, Affichage a) {
        etat = e;
        view = a;
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(16);
                etat.drop();
                view.change();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
