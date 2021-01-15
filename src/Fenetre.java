import javax.swing.*;

public class Fenetre extends JFrame {

    public Fenetre(String name){
        Affichage panel = new Affichage();

        this.setName(name);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.paint(getGraphics());
    }
}
