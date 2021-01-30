package model;

import java.awt.*;
import java.util.ArrayList;

public class Etat {
    public static final int SAUT = 80;
    public static final int X_OVAL = 50;

    private int MAX_Y;
    private int Y_OVAL = 400;
    private boolean perdu = false;

    private final Parcours parcours;

    public Etat() {
        parcours = new Parcours();
        new Avancer(parcours);
        new Collosion(this);
    }

    // chaque délai, l'oiseau tombe un peu
    public void moveDown() {
        Y_OVAL -= SAUT;
        if (Y_OVAL < 0) Y_OVAL = 0;
    }

    public void drop() {
        Y_OVAL -= 2;
        if (Y_OVAL < 0) Y_OVAL = 0;
    }

    // chaque click, l'oiseau saute mais jamais hors des limites
    public void jump() {
        Y_OVAL += SAUT;
        if (Y_OVAL > MAX_Y) Y_OVAL = MAX_Y;
    }

    public ArrayList<Point> getParcours() {
        return parcours.getParcours();
    }

    public int getHauteur() {
        return Y_OVAL;
    }

    public boolean getPerdu() {
        return perdu;
    }

    public void setMax(int MAX_Y) {
        this.MAX_Y = MAX_Y;
    }

    public void testPerdu(boolean d) {
        perdu = d;
    }

    // Donner les données à Parcours pour produire des points
    public void startParcours(int largeur, int hauteur) {
        parcours.startParcours(largeur, hauteur);
    }
}
