import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            FlappyBird.flappy.repaint(g);
    }

}
