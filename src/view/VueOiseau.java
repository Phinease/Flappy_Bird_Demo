package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class VueOiseau {
    private final CopyOnWriteArrayList<Oiseau> oiseaus = new CopyOnWriteArrayList<>();
    private final Random random = new Random();

    public VueOiseau() {
        oiseaus.add(new Oiseau());
    }

    public void dessiner(Graphics g) {
        oiseaus.removeIf(oiseau -> !oiseau.isAlive());

        for (Oiseau oiseau : oiseaus) {
            Point p = oiseau.getPos();
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File("frames/" + oiseau.getEtat() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(image, p.x, p.y, null);
        }
    }

    public void generer() {
        if (random.nextDouble() > 0.98) oiseaus.add(new Oiseau());
    }
}
