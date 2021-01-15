public class Etat {
    public static int hauteur = 600;

    public int getHauteur() {
        return hauteur;
    }

    public void jump() {
        hauteur -= 40;
        if (hauteur < 0) hauteur = 0;
    }
}
