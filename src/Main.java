import javax.swing.*;

public class Main extends JFrame {

    public Main(String name){
        Etat etat = new Etat();
        Affichage panel = new Affichage(etat);
        Control control = new Control(etat, panel);
        panel.addMouseListener(control);

        this.setName(name);
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.paint(getGraphics());
    }

    public static void main(String[] args) {
        Main main = new Main("Flappt Bird");
    }
}
