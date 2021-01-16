package control;

import model.Etat;
import view.Affichage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {
    private final Etat etat;
    private final Affichage vue;

    public Control(Etat e, Affichage a) {
        etat = e;
        vue = a;
    }

    // si la souris a cliqué, sauter et dire l'interface
    @Override
    public void mouseClicked(MouseEvent e) {
        etat.jump();
        vue.change();
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
