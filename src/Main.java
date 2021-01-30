import control.Control;
import model.Etat;
import model.Voler;
import view.Affichage;

import javax.swing.*;

public class Main extends JFrame {

    public Main(String name) {
        // Initialisation de MVC
        Etat etat = new Etat();
        Affichage panel = new Affichage(etat);
        Control control = new Control(etat, panel);
        new Voler(etat, panel);

        // Ajouter le controleur dans l'interface
        panel.addMouseListener(control);

        // Confuguration de la fenêtre
        this.setName(name);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main("Flappt Bird");
    }
}
