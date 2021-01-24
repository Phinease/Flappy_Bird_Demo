package control;

import model.Etat;
import view.Affichage;

import javax.swing.*;
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
        if (SwingUtilities.isLeftMouseButton(e)) {
            etat.jump();
            vue.change();
        } else if (SwingUtilities.isRightMouseButton(e)) {
            etat.moveDown();
            vue.change();
        }
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
