package Simplu;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class SpinningSlotsFrame extends JPanel implements Runnable {
    UsdFormat usFormat = new UsdFormat();
    Images images = new Images();

    // DoubleMoney-TestArray
  /* private final Image[] fruits = {images.getCherry(), images.getCherry(), images.getCherry(), images.getCherry(),
            images.getCherry(), images.getCherry(),images.getCherry(), images.getCherry(), images.getCherry(),
            images.getCherry(), images.getCherry(), images.getCherry(), images.getCherry(), images.getCherry(),
            images.getCherry(), images.getCherry(), images.getCherry(), images.getCherry(), images.getCherry(),
            images.getCherry(), images.getCherry(),images.getCherry(), images.getCherry(), images.getCherry(),
            images.getCherry(), images.getCherry(), images.getCherry(), images.getCherry(), images.getCherry()};*/

    private final Image[] fruits = {images.getOrange(), images.getSeven(), images.getOrange(), images.getLemon(),
            images.getPlum(), images.getGrape(), images.getMelon(), images.getBar(), images.getSeven(),
            images.getCherry(), images.getLemon(), images.getBar(), images.getLemon(), images.getPlum(),
            images.getMelon(), images.getOrange(), images.getGrape(), images.getBar(), images.getCherry(),
            images.getOrange(), images.getPlum(), images.getLemon(), images.getMelon(), images.getGrape(),
            images.getBar(), images.getCherry(), images.getPlum(), images.getSeven(), images.getCherry()};

    private int yPoz1 = 300;
    private int yPoz2 = 100;
    private int yPoz3 = 200;
    Thread thread;
    private int counter = 1510;
    private int winning;

    /*Prima Linie*/
    private int i11 = new Random().nextInt(fruits.length);
    private int i12 = new Random().nextInt(fruits.length);
    private int i13 = new Random().nextInt(fruits.length);
    /*A Doua Linie*/
    private int i21 = new Random().nextInt(fruits.length);
    private int i22 = new Random().nextInt(fruits.length);
    private int i23 = new Random().nextInt(fruits.length);
    /*A Treia Linie*/
    private int i31 = new Random().nextInt(fruits.length);
    private int i32 = new Random().nextInt(fruits.length);
    private int i33 = new Random().nextInt(fruits.length);
    /*A Patra Linie*/
    private int i41 = new Random().nextInt(fruits.length);
    private int i42 = new Random().nextInt(fruits.length);
    private int i43 = new Random().nextInt(fruits.length);
    /*A Cincia Linie*/
    private int i51 = new Random().nextInt(fruits.length);
    private int i52 = new Random().nextInt(fruits.length);
    private int i53 = new Random().nextInt(fruits.length);
    private final SlotsMainFrame slots;

    public SpinningSlotsFrame(SlotsMainFrame slots) {
        this.slots = slots;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g);
        g.setColor(new Color(255, 253, 253));
        g.fillRect(20, 100, 550, 300);

        g.setColor(new Color(0, 0, 0));
        g.drawRect(20, 100, 550, 300);
        g.drawLine(130, 100, 130, 400);
        g.drawLine(240, 100, 240, 400);
        g.drawLine(350, 100, 350, 400);
        g.drawLine(460, 100, 460, 400);

        //First Line
        if (yPoz1 >= 80 && yPoz1 < 320) {
            g.drawImage(fruits[i11], 25, yPoz1, this);
        }
        if (yPoz2 >= 80 && yPoz2 < 320) {
            g.drawImage(fruits[i12], 25, yPoz2, this);
        }
        if (yPoz3 >= 80 && yPoz3 < 320) {
            g.drawImage(fruits[i13], 25, yPoz3, this);
        }
        //Second Line
        if (yPoz1 >= 80 && yPoz1 < 320) {
            g.drawImage(fruits[i21], 135, yPoz1, this);
        }
        if (yPoz2 >= 80 && yPoz2 < 320) {
            g.drawImage(fruits[i22], 135, yPoz2, this);
        }
        if (yPoz3 >= 80 && yPoz3 < 320) {
            g.drawImage(fruits[i23], 135, yPoz3, this);
        }
        //Third Line
        if (yPoz1 >= 80 && yPoz1 < 320) {
            g.drawImage(fruits[i31], 245, yPoz1, this);
        }
        if (yPoz2 >= 80 && yPoz2 < 320) {
            g.drawImage(fruits[i32], 245, yPoz2, this);

        }
        if (yPoz3 >= 80 && yPoz3 < 320) {
            g.drawImage(fruits[i33], 245, yPoz3, this);
        }
        //Fofth Line
        if (yPoz1 >= 80 && yPoz1 < 320) {
            g.drawImage(fruits[i41], 355, yPoz1, this);
        }
        if (yPoz2 >= 80 && yPoz2 < 320) {
            g.drawImage(fruits[i42], 355, yPoz2, this);
        }
        if (yPoz3 >= 80 && yPoz3 < 320) {
            g.drawImage(fruits[i43], 355, yPoz3, this);
        }
        //Fifth Line
        if (yPoz1 >= 80 && yPoz1 < 320) {
            g.drawImage(fruits[i51], 465, yPoz1, this);
        }
        if (yPoz2 >= 80 && yPoz2 < 320) {
            g.drawImage(fruits[i52], 465, yPoz2, this);
        }
        if (yPoz3 >= 80 && yPoz3 < 320) {
            g.drawImage(fruits[i53], 465, yPoz3, this);
        }

        int money = slots.getBetMoney();
        if ((counter == 1500 || counter == 0) && yPoz1 == 100) {
            //Drawing the lines
            //First Line
            if (fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41] && fruits[i11] == fruits[i51]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(243, 0, 0));
                g2.drawRect(30, 110, 90, 80);
                g2.drawRect(140, 110, 90, 80);
                g2.drawRect(250, 110, 90, 80);
                g2.drawRect(360, 110, 90, 80);
                g2.drawRect(470, 110, 90, 80);
                g2.drawLine(120, 150, 140, 150);
                g2.drawLine(230, 150, 250, 150);
                g2.drawLine(340, 150, 360, 150);
                g2.drawLine(450, 150, 470, 150);
            } else if (fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(243, 0, 0));
                g2.drawRect(30, 110, 90, 80);
                g2.drawRect(140, 110, 90, 80);
                g2.drawRect(250, 110, 90, 80);
                g2.drawRect(360, 110, 90, 80);
                g2.drawLine(120, 150, 140, 150);
                g2.drawLine(230, 150, 250, 150);
                g2.drawLine(340, 150, 360, 150);
            } else if (fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(243, 0, 0));
                g2.drawRect(30, 110, 90, 80);
                g2.drawRect(140, 110, 90, 80);
                g2.drawRect(250, 110, 90, 80);
                g2.drawLine(120, 150, 140, 150);
                g2.drawLine(230, 150, 250, 150);
            }
            else if (fruits[i11] == images.getCherry() && fruits[i11] == fruits[i21]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(243, 0, 0));
                g2.drawRect(30, 110, 90, 80);
                g2.drawRect(140, 110, 90, 80);
            }

            //Second Line
            if (fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42] && fruits[i12] == fruits[i52]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(63, 222, 1));
                g2.drawRect(30, 210, 90, 80);
                g2.drawRect(140, 210, 90, 80);
                g2.drawRect(250, 210, 90, 80);
                g2.drawRect(360, 210, 90, 80);
                g2.drawRect(470, 210, 90, 80);
                g2.drawLine(120, 250, 140, 250);
                g2.drawLine(230, 250, 250, 250);
                g2.drawLine(340, 250, 360, 250);
                g2.drawLine(450, 250, 470, 250);
            } else if (fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(63, 222, 1));
                g2.drawRect(30, 210, 90, 80);
                g2.drawRect(140, 210, 90, 80);
                g2.drawRect(250, 210, 90, 80);
                g2.drawRect(360, 210, 90, 80);
                g2.drawLine(120, 250, 140, 250);
                g2.drawLine(230, 250, 250, 250);
                g2.drawLine(340, 250, 360, 250);
            } else if (fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(63, 222, 1));
                g2.drawRect(30, 210, 90, 80);
                g2.drawRect(140, 210, 90, 80);
                g2.drawRect(250, 210, 90, 80);
                g2.drawLine(120, 250, 140, 250);
                g2.drawLine(230, 250, 250, 250);
            }
            else if (fruits[i12] == images.getCherry() && fruits[i12] == fruits[i22]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(63, 222, 1));
                g2.drawRect(30, 210, 90, 80);
                g2.drawRect(140, 210, 90, 80);
            }

            //Third Line
            if (fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43] && fruits[i13] == fruits[i53]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(239, 13, 180));
                g2.drawRect(30, 310, 90, 80);
                g2.drawRect(140, 310, 90, 80);
                g2.drawRect(250, 310, 90, 80);
                g2.drawRect(360, 310, 90, 80);
                g2.drawRect(470, 310, 90, 80);
                g2.drawLine(120, 350, 140, 350);
                g2.drawLine(230, 350, 250, 350);
                g2.drawLine(340, 350, 360, 350);
                g2.drawLine(450, 350, 470, 350);
            } else if (fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(239, 13, 180));
                g2.drawRect(30, 310, 90, 80);
                g2.drawRect(140, 310, 90, 80);
                g2.drawRect(250, 310, 90, 80);
                g2.drawRect(360, 310, 90, 80);
                g2.drawLine(120, 350, 140, 350);
                g2.drawLine(230, 350, 250, 350);
                g2.drawLine(340, 350, 360, 350);
            } else if (fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(239, 13, 180));
                g2.drawRect(30, 310, 90, 80);
                g2.drawRect(140, 310, 90, 80);
                g2.drawRect(250, 310, 90, 80);
                g2.drawLine(120, 350, 140, 350);
                g2.drawLine(230, 350, 250, 350);
            }
            else if (fruits[i13] == images.getCherry() && fruits[i13] == fruits[i23]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(239, 13, 180));
                g2.drawRect(30, 310, 90, 80);
                g2.drawRect(140, 310, 90, 80);
            }

            //Forth Line
            if (fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42] && fruits[i11] == fruits[i51]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(13, 17, 239));
                g2.drawRect(30, 110, 90, 80);
                g2.drawRect(140, 210, 90, 80);
                g2.drawRect(250, 310, 90, 80);
                g2.drawRect(360, 210, 90, 80);
                g2.drawRect(470, 110, 90, 80);
                g2.drawLine(120, 190, 140, 210);
                g2.drawLine(230, 290, 250, 310);
                g2.drawLine(340, 310, 360, 290);
                g2.drawLine(450, 210, 470, 190);
            } else if (fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(13, 17, 239));
                g2.drawRect(30, 110, 90, 80);
                g2.drawRect(140, 210, 90, 80);
                g2.drawRect(250, 310, 90, 80);
                g2.drawRect(360, 210, 90, 80);
                g2.drawLine(120, 190, 140, 210);
                g2.drawLine(230, 290, 250, 310);
                g2.drawLine(340, 310, 360, 290);
            } else if (fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(13, 17, 239));
                g2.drawRect(30, 110, 90, 80);
                g2.drawRect(140, 210, 90, 80);
                g2.drawRect(250, 310, 90, 80);
                g2.drawLine(120, 190, 140, 210);
                g2.drawLine(230, 290, 250, 310);

            }
            else if (fruits[i11] == images.getCherry() && fruits[i11] == fruits[i22]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(13, 17, 239));
                g2.drawRect(30, 110, 90, 80);
                g2.drawRect(140, 210, 90, 80);
            }

            //Fifth Line
            if (fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42] && fruits[i13] == fruits[i53]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(255, 221, 0));
                g2.drawRect(30, 310, 90, 80);
                g2.drawRect(140, 210, 90, 80);
                g2.drawRect(250, 110, 90, 80);
                g2.drawRect(360, 210, 90, 80);
                g2.drawRect(470, 310, 90, 80);
                g2.drawLine(120, 310, 140, 290);
                g2.drawLine(230, 210, 250, 190);
                g2.drawLine(340, 190, 360, 210);
                g2.drawLine(450, 290, 470, 310);
            } else if (fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(255, 221, 0));
                g2.drawRect(30, 310, 90, 80);
                g2.drawRect(140, 210, 90, 80);
                g2.drawRect(250, 110, 90, 80);
                g2.drawRect(360, 210, 90, 80);
                g2.drawLine(120, 310, 140, 290);
                g2.drawLine(230, 210, 250, 190);
                g2.drawLine(340, 190, 360, 210);
            } else if (fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(255, 221, 0));
                g2.drawRect(30, 310, 90, 80);
                g2.drawRect(140, 210, 90, 80);
                g2.drawRect(250, 110, 90, 80);
                g2.drawLine(120, 310, 140, 290);
                g2.drawLine(230, 210, 250, 190);
            }
            else if (fruits[i13] == images.getCherry() && fruits[i13] == fruits[i22]) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(new Color(255, 221, 0));
                g2.drawRect(30, 310, 90, 80);
                g2.drawRect(140, 210, 90, 80);
            }


            // Calculating winning prize
            winning += SmallestWinningFruits(0, money);
            winning +=BiggerWinningFruits(0, money);
            winning += BiggestWinnigFruits(0, money);

        }
        slots.spin.setEnabled(counter >= 1500 || counter <= 10);
        if (slots.getCurrentMoney() < slots.getBetMoney()) {
            slots.spin.setEnabled(false);
        }
        if (winning != 0) {
            slots.spin.setEnabled(false);
            slots.doubleChance.setEnabled(true);
        }
        slots.winningSum.setText(usFormat.getUsdFormat().format(winning));
        winning = 0;
        g.setColor(Color.RED);
    }


    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        Thread me = Thread.currentThread();
        while (thread == me) {
            int dy = 1;
            yPoz1 += dy;
            yPoz2 += dy;
            yPoz3 += dy;

            if (yPoz1 == 400) {
                i11 = new Random().nextInt(fruits.length);
                i21 = new Random().nextInt(fruits.length);
                i31 = new Random().nextInt(fruits.length);
                i41 = new Random().nextInt(fruits.length);
                i51 = new Random().nextInt(fruits.length);
                yPoz1 = 100;
            }
            if (yPoz2 == 400) {
                i12 = new Random().nextInt(fruits.length);
                i22 = new Random().nextInt(fruits.length);
                i32 = new Random().nextInt(fruits.length);
                i42 = new Random().nextInt(fruits.length);
                i52 = new Random().nextInt(fruits.length);
                yPoz2 = 100;
            }
            if (yPoz3 == 400) {
                i13 = new Random().nextInt(fruits.length);
                i23 = new Random().nextInt(fruits.length);
                i33 = new Random().nextInt(fruits.length);
                i43 = new Random().nextInt(fruits.length);
                i53 = new Random().nextInt(fruits.length);
                yPoz3 = 100;
            }
            repaint();

            try {
                Thread.sleep(1);
                if (counter < 1 && yPoz1 == 100) {
                    counter = 1500;
                    synchronized (this) {
                        wait();
                    }
                }
                counter--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void reset() {
        yPoz1 = 300;
        yPoz2 = 100;
        yPoz3 = 200;
        counter = 1510;
        winning = 0;
        //First Line
        i11 = new Random().nextInt(fruits.length);
        i12 = new Random().nextInt(fruits.length);
        i13 = new Random().nextInt(fruits.length);
        //Second Line
        i21 = new Random().nextInt(fruits.length);
        i22 = new Random().nextInt(fruits.length);
        i23 = new Random().nextInt(fruits.length);
        //Third Line
        i31 = new Random().nextInt(fruits.length);
        i32 = new Random().nextInt(fruits.length);
        i33 = new Random().nextInt(fruits.length);
        //Forth Line
        i41 = new Random().nextInt(fruits.length);
        i42 = new Random().nextInt(fruits.length);
        i43 = new Random().nextInt(fruits.length);
        //Fifth Line
        i51 = new Random().nextInt(fruits.length);
        i52 = new Random().nextInt(fruits.length);
        i53 = new Random().nextInt(fruits.length);
        repaint();
    }

    //Cherry, Lemon, Orange, Plum, Bar
    public int SmallestWinningFruits(int winning, int money) {
        //First Line
        if ((fruits[i11] == images.getCherry() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41] && fruits[i11] == fruits[i51]) ||
                (fruits[i11] == images.getLemon() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41] && fruits[i11] == fruits[i51]) ||
                (fruits[i11] == images.getOrange() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41] && fruits[i11] == fruits[i51]) ||
                (fruits[i11] == images.getPlum() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41] && fruits[i11] == fruits[i51]) ||
                 (fruits[i11] == images.getBar() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41] && fruits[i11] == fruits[i51]) )
        {
                 winning = winning + money * 80;
        }
        else if ((fruits[i11] == images.getCherry() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41]) ||
                (fruits[i11] == images.getLemon() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41]) ||
                (fruits[i11] == images.getOrange() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41]) ||
                (fruits[i11] == images.getPlum() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41]) ||
                (fruits[i11] == images.getBar() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41]))
    {
                 winning = winning + money * 20;
        } else if ((fruits[i11] == images.getCherry() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31]) ||
                (fruits[i11] == images.getLemon() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31]) ||
                (fruits[i11] == images.getOrange() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31]) ||
                (fruits[i11] == images.getPlum() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31])  ||
              (fruits[i11] == images.getBar() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31])) {

                 winning = winning + money * 8;

        } else if (fruits[i11] == images.getCherry() && fruits[i11] == fruits[i21]) {

                  winning = winning + money * 2;
        }
        //Second Line
        if ((fruits[i12] == images.getCherry() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42] && fruits[i12] == fruits[i52]) ||
                (fruits[i12] == images.getLemon() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42] && fruits[i12] == fruits[i52]) ||
                (fruits[i12] == images.getOrange() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42] && fruits[i12] == fruits[i52]) ||
                (fruits[i12] == images.getPlum() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42] && fruits[i12] == fruits[i52])  ||
                (fruits[i12] == images.getBar() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42] && fruits[i12] == fruits[i52])) {
            winning = winning + money * 80;
        } else if ((fruits[i12] == images.getCherry() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42]) ||
                (fruits[i12] == images.getLemon() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42]) ||
                (fruits[i12] == images.getOrange() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42]) ||
                (fruits[i12] == images.getPlum() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42]) ||
            (fruits[i12] == images.getBar() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42])) {
            winning = winning + money * 20;

        } else if ((fruits[i12] == images.getCherry() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32]) ||
                (fruits[i12] == images.getLemon() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32]) ||
                (fruits[i12] == images.getOrange() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32]) ||
                (fruits[i12] == images.getPlum() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32]) ||
                (fruits[i12] == images.getBar() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32])) {
            winning = winning + money * 8;

        } else if (fruits[i12] == images.getCherry() && fruits[i12] == fruits[i22]) {

            winning = winning + money * 2;
        }
        //Third Line
        if ((fruits[i13] == images.getCherry() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getLemon() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getOrange() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getPlum() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getBar() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43] && fruits[i13] == fruits[i53])) {
            winning = winning + money * 80;
        } else if ((fruits[i13] == images.getCherry() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43]) ||
                (fruits[i13] == images.getLemon() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43]) ||
                (fruits[i13] == images.getOrange() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43]) ||
                (fruits[i13] == images.getPlum() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43]) ||
                (fruits[i13] == images.getBar() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43])) {
            winning = winning + money * 20;

        } else if ((fruits[i13] == images.getCherry() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33]) ||
                (fruits[i13] == images.getLemon() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33]) ||
                (fruits[i13] == images.getOrange() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33]) ||
                (fruits[i13] == images.getPlum() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33]) ||
                (fruits[i13] == images.getBar() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33])) {
            winning = winning + money * 8;

        } else if (fruits[i13] == images.getCherry() && fruits[i13] == fruits[i23]) {

            winning = winning + money * 2;
        }
            //Forth Line
        if ((fruits[i11] == images.getCherry() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42] && fruits[i11] == fruits[i51]) ||
                (fruits[i11] == images.getLemon() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42] && fruits[i11] == fruits[i51]) ||
                (fruits[i11] == images.getOrange() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42] && fruits[i11] == fruits[i51]) ||
                (fruits[i11] == images.getPlum() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42] && fruits[i11] == fruits[i51]) ||
                (fruits[i11] == images.getBar() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42] && fruits[i11] == fruits[i51])) {

            winning = winning + money * 80;
        } else if ((fruits[i11] == images.getCherry() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42]) ||
                (fruits[i11] == images.getLemon() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42]) ||
                (fruits[i11] == images.getOrange() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42]) ||
                (fruits[i11] == images.getPlum() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42]) ||
                (fruits[i11] == images.getBar() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42])) {
            winning = winning + money * 20;

        } else if ((fruits[i11] == images.getCherry() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33]) ||
                (fruits[i11] == images.getLemon() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33]) ||
                (fruits[i11] == images.getOrange() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33]) ||
                (fruits[i11] == images.getPlum() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33]) ||
                (fruits[i11] == images.getBar() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33])) {

            winning = winning + money * 8;

        } else if (fruits[i11] == images.getCherry() && fruits[i11] == fruits[i22]) {
            winning = winning + money * 2;
        }
           //Fifth Line
        if ((fruits[i13] == images.getCherry() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getLemon() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getOrange() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getPlum() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getBar() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42] && fruits[i13] == fruits[i53])) {


            winning = winning + money * 80;
        } else if ((fruits[i13] == images.getCherry() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42]) ||
                (fruits[i13] == images.getLemon() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42]) ||
                (fruits[i13] == images.getOrange() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42]) ||
                (fruits[i13] == images.getPlum() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42]) ||
                (fruits[i13] == images.getBar() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42])) {

            winning = winning + money * 20;

        } else if ((fruits[i13] == images.getCherry() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31]) ||
                (fruits[i13] == images.getLemon() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31]) ||
                (fruits[i13] == images.getOrange() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31]) ||
                (fruits[i13] == images.getPlum() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31]) ||
                (fruits[i13] == images.getBar() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31])) {


            winning = winning + money * 8;

        } else if (fruits[i13] == images.getCherry() && fruits[i13] == fruits[i22]) {

            winning = winning + money * 2;
        }
        return winning;
    }

    //Melon, Grape
    public int BiggerWinningFruits(int winning, int money)
    {
         //First Line
        if ((fruits[i11] == images.getMelon() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41] && fruits[i11] == fruits[i51]) ||
                (fruits[i11] == images.getGrape() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41] && fruits[i11] == fruits[i51])) {
            winning = winning + money * 200;
        } else if ((fruits[i11] == images.getMelon() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41]) ||
                (fruits[i11] == images.getGrape() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41])) {
            winning = winning + money * 80;

        } else if ((fruits[i11] == images.getMelon() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31]) ||
                (fruits[i11] == images.getGrape() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31])) {
            winning = winning + money * 20;

        }
         //Second Line
        if ((fruits[i12] == images.getMelon() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42] && fruits[i12] == fruits[i52]) ||
                (fruits[i12] == images.getGrape() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42] && fruits[i12] == fruits[i52])) {
            winning = winning + money * 200;
        } else if ((fruits[i12] == images.getMelon() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42]) ||
                (fruits[i12] == images.getGrape() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42])) {
            winning = winning + money * 80;

        } else if ((fruits[i12] == images.getMelon() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32]) ||
                (fruits[i12] == images.getGrape() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32])) {
            winning = winning + money * 20;

        }
            //Third Line
        if ((fruits[i13] == images.getMelon() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getGrape() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43] && fruits[i13] == fruits[i53])) {

            winning = winning + money * 200;
        } else if ((fruits[i13] == images.getMelon() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43]) ||
                (fruits[i13] == images.getGrape() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43])) {

            winning = winning + money * 80;

        } else if ((fruits[i13] == images.getMelon() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33]) ||
                (fruits[i13] == images.getGrape() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33])) {

            winning = winning + money * 20;

        }
            //Forth Line
        if ((fruits[i11] == images.getMelon() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42] && fruits[i11] == fruits[i51]) ||
                (fruits[i11] == images.getGrape() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42] && fruits[i11] == fruits[i51])) {

            winning = winning + money * 200;
        } else if ((fruits[i11] == images.getMelon() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42]) ||
                (fruits[i11] == images.getGrape() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42])) {
            winning = winning + money * 80;

        } else if ((fruits[i11] == images.getMelon() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33]) ||
                (fruits[i11] == images.getGrape() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33])) {
            winning = winning + money * 20;

        }
         //Fifth Line
        if ((fruits[i13] == images.getMelon() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42] && fruits[i13] == fruits[i53]) ||
                (fruits[i13] == images.getGrape() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42] && fruits[i13] == fruits[i53])) {
            winning = winning + money * 200;
        } else if ((fruits[i13] == images.getMelon() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42]) ||
                (fruits[i13] == images.getGrape() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42])) {
            winning = winning + money * 80;

        } else if ((fruits[i13] == images.getMelon() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31]) ||
                (fruits[i13] == images.getGrape() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31])) {
            winning = winning + money * 20;

        }
        return winning;
    }

    // 7
    public int BiggestWinnigFruits(int winning, int money)
    {
        //First Line
        if (fruits[i11] == images.getSeven() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41] && fruits[i11] == fruits[i51]) {
            winning = winning + money * 2000;
        } else if (fruits[i11] == images.getSeven() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31] && fruits[i11] == fruits[i41]) {
            winning = winning + money * 400;
        } else if (fruits[i11] == images.getSeven() && fruits[i11] == fruits[i21] && fruits[i11] == fruits[i31]) {
            winning = winning + money * 40;
        }
           //Second Line
        if (fruits[i12] == images.getSeven() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42] && fruits[i12] == fruits[i52]) {
            winning = winning + money * 2000;
        } else if (fruits[i12] == images.getSeven() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32] && fruits[i12] == fruits[i42]) {
            winning = winning + money * 400;
        } else if (fruits[i12] == images.getSeven() && fruits[i12] == fruits[i22] && fruits[i12] == fruits[i32]) {
            winning = winning + money * 40;
        }
            //Third Line
        if (fruits[i13] == images.getSeven() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43] && fruits[i13] == fruits[i53]) {
            winning = winning + money * 2000;
        } else if (fruits[i13] == images.getSeven() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33] && fruits[i13] == fruits[i43]) {
            winning = winning + money * 400;
        } else if (fruits[i13] == images.getSeven() && fruits[i13] == fruits[i23] && fruits[i13] == fruits[i33]) {
            winning = winning + money * 40;
        }
            //Forth Line
        if (fruits[i11] == images.getSeven() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42] && fruits[i11] == fruits[i51]) {
            winning = winning + money * 2000;
        } else if (fruits[i11] == images.getSeven() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33] && fruits[i11] == fruits[i42]) {
            winning = winning + money * 400;
        } else if (fruits[i11] == images.getSeven() && fruits[i11] == fruits[i22] && fruits[i11] == fruits[i33]) {
            winning = winning + money * 40;
        }
            //Fifth Line
        if (fruits[i13] == images.getSeven() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42] && fruits[i13] == fruits[i53]) {
            winning = winning + money * 2000;
        } else if (fruits[i13] == images.getSeven() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31] && fruits[i13] == fruits[i42]) {
            winning = winning + money * 400;

        } else if (fruits[i13] == images.getSeven() && fruits[i13] == fruits[i22] && fruits[i13] == fruits[i31]) {
            winning = winning + money * 40;

        }
        return winning;
    }
}