package model;

public class Etat {
    public static final int JUMP_HEIGHT = 60;
    public int Y_OVAL = 600;

    // chaque délai, l'oiseau tombe un peu
    public void drop() {
        Y_OVAL += 2;
        if (Y_OVAL > 700) Y_OVAL = 700;
    }

    public int getHauteur() {
        return Y_OVAL;
    }

    // chaque click, l'oiseau saute mais jamais hors des limites
    public void jump() {
        Y_OVAL -= JUMP_HEIGHT;
        if (Y_OVAL < 0) Y_OVAL = 0;
    }
}
