import control.Control;
import model.Etat;
import view.Affichage;

import javax.swing.*;

public class Main extends JFrame {

    public Main(String name){
        // Initialisation de MVC
        Etat etat = new Etat();
        Affichage panel = new Affichage(etat);
        Control control = new Control(etat, panel);

        // Ajouter le controleur dans l'interface
        panel.addMouseListener(control);

        // Confuguration de la fenêtre
        this.setName(name);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // l'oiseau doit tomber avec le temps, c'est sa minuterie
        // Pour mettre à jour l'interface en 60 PFS, on met le délais en 17 car 1000/60 ~= 17
        Timer timer = new Timer(17, arg0 -> {
            etat.drop();
            panel.change();
        });
        timer.start();
    }

    public static void main(String[] args) {
        Main main = new Main("Flappt Bird");
    }
}
