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
            try{
                etat.drop();
                view.change();
                Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
