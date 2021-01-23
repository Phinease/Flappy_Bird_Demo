package model;

import control.Control;

import java.util.ArrayList;

public class Etat {
    public static final int JUMP_HEIGHT = 60;
    public static final int X_OVAL = 50;

    public int Y_OVAL = 0;
    private ArrayList<Integer> history = new ArrayList<>();

    // chaque délai, l'oiseau tombe un peu
    public void drop() {
        Y_OVAL -= 2;
        if (Y_OVAL < 0) Y_OVAL = 0;
    }

    public int getHauteur(int max) {
        if (Y_OVAL > max) Y_OVAL = max;
        return Y_OVAL;
    }

    // chaque click, l'oiseau saute mais jamais hors des limites
    public void jump() {
        Y_OVAL += JUMP_HEIGHT;
    }

    // Ajouter le point actuel dans le chemin
    public void addHistory() {
        history.add(Y_OVAL);
        if (history.size() > 100) history = new ArrayList<>(history.subList(history.size() - 100, history.size()));
    }

    public int getHistory(int i) {
        return history.get(i);
    }

    public int getSizeHistory() {
        return history.size();
    }
}
