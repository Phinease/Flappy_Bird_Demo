package model;

public class Etat {
    public int hauteur = 600;

    // chaque délai, l'oiseau tombe un peu
    public void drop() {
        hauteur += 2;
        if (hauteur > 700) hauteur = 700;
    }

    public int getHauteur() {
        return hauteur;
    }

    // chaque click, l'oiseau saute mais jamais hors des limites
    public void jump() {
        hauteur -= 60;
        if (hauteur < 0) hauteur = 0;
    }
}
