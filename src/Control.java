import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {
    private final Etat etat;
    private final Affichage vue;

    public Control(Etat e, Affichage a) {
        etat = e;
        vue = a;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        etat.jump();
        vue.jump();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
