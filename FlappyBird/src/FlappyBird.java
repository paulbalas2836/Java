import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird implements ActionListener, KeyListener {
    public static FlappyBird flappy;
    public JPanel gamePanel;
    public Rectangle bird;

    private final Random rand;
    private boolean lose = false;

    private int yMovement;
    private final int HEIGHT = 800, WIDTH = 500;
    private int countingPoints = 0;
    private final int birdHeight = 20, birdWidth = 20;
    private final ArrayList<Rectangle> columns;
    private final int width = 100;
    private final int space = 300;
    private final int birdXCoord = 20;
    private final int birdYCoord = HEIGHT / 2 - 60;

    FlappyBird() {
        JFrame frame = new JFrame();

        Timer timer = new Timer(20, this);
        gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addKeyListener(this);

        bird = new Rectangle(birdXCoord, birdYCoord, birdWidth, birdHeight);
        columns = new ArrayList<Rectangle>();
        rand = new Random();

            addColumns();
            addColumns();
        timer.start();
    }
    public void fly()
    {
        if(!lose)
        {
            yMovement -= 65;
        }
    }

    public void addColumns() {
        int height = 50 + rand.nextInt(350);
        int spaceBetween = 250;
        columns.add(new Rectangle(WIDTH + width + columns.size() * spaceBetween, 0, width, HEIGHT - height - space));
        columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * spaceBetween, HEIGHT - height - 175, width, height));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.repaint();

        int newHeight = 50 + rand.nextInt(300);
        int speed = 10;
        int check = 0;
        for (Rectangle column : columns) {
            gameLost(column);

            if(lose)
            {
                return;
            }

            if(column.y == 0 && bird.x + bird.width > column.x + column.width + 35)
            {
                countingPoints++;
            }
            //column movement
            column.x -= speed;

            //coloumn reset position
            if(column.x + column.width < 0)
            {
                column.x = WIDTH + width + (columns.size() - 1) * 100 ;
                check ++;
                if(check == 1 )
                {
                   column.height = HEIGHT - newHeight - space;
                }
                else
                {
                    column.y = HEIGHT - newHeight - 175;
                    column.height = newHeight;
                    check = 0;
                }
            }

        }
        birdFall();
    }

    public void repaint(Graphics g) {
        final String loseMessage = "You Lost!!";
        final int fontSize = 100;
        //Grass
        g.setColor(Color.GREEN);
        g.fillRect(0,625,WIDTH,25);

        //Ground
        g.setColor(Color.ORANGE);
        g.fillRect(0,650,WIDTH,150);

        //Sky
        g.setColor(Color.CYAN);
        g.fillRect(0,0,WIDTH,625);

        //bird
        g.setColor(Color.RED);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);

        //draw columns
        for(Rectangle column : columns)
        {
            paintColumn(g, column);
        }

        //lose
        if(lose)
        {
            g.setFont(new Font("TimesRoman",Font.BOLD , fontSize));
            g.drawString(loseMessage, WIDTH / 2 - 225, HEIGHT / 2);
        }

        //Points
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD , 90));
        g.drawString(String.valueOf(countingPoints), WIDTH / 2 - 25 , 90);
    }

    public void paintColumn(Graphics g, Rectangle column) {
        //columns
        g.setColor(Color.GREEN.darker());
        g.fillRect(column.x, column.y, column.width, column.height);

    }
    public void restart()
    {
        lose = false;
       bird.y = birdYCoord;
       bird.x = birdXCoord;
        countingPoints = 0;

        addColumns();
        addColumns();
    }

    public void gameLost(Rectangle column)
    {
        if(column.intersects(bird) || bird.y + bird.width >= 625)
        {
            bird.x -= 10;
            lose = true;
            columns.clear();
        }
    }

    public void birdFall()
    {
        if ( bird.y <= 625 - birdHeight) {
            bird.y += yMovement;
            yMovement = 6;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(lose) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                restart();
            }
        }else
        {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                fly();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public static void main(String[] args) {
        flappy = new FlappyBird();
    }


}
