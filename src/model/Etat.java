package model;

import java.util.ArrayList;

public class Etat {
    public static final int JUMP_HEIGHT = 60;
    public static final int LARG_OVAL = 20;
    public static final int HAUT_OVAL = 100;
    public static final int X_OVAL = 50;

    public int Y_OVAL = 600;
    private ArrayList<Integer> history = new ArrayList<>();

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

    public void addHistory() {
        history.add(Y_OVAL + HAUT_OVAL / 2);
        if (history.size() > 100) history = new ArrayList<>(history.subList(history.size() - 100, history.size()));
    }

    public int getHistory(int i) {
        return history.get(i);
    }

    public int getSizeHistory() {
        return history.size();
    }
}
