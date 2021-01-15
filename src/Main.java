import javax.swing.*;

public class Main extends JFrame {

    public Main(String name){
        Affichage panel = new Affichage();

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
