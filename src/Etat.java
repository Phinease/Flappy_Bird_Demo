public class Etat {
    public static int hauteur;

    public static int getHauteur() {
        return hauteur;
    }

    public void jump() {
        hauteur -= 40;
    }
}
