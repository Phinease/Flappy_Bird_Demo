import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel {
    public static final int largeur = 800;
    public static final int hauteur = 800;

    public Affichage() {
        this.setPreferredSize(new Dimension(largeur, hauteur));
    }

    @Override
    public void paint(Graphics g){
        g.drawOval(50, 600, 20, 100);
    }
}