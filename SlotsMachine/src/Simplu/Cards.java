package Simplu;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Cards extends JPanel implements Runnable {
    Thread thread;
    Images imagine = new Images();
    UsdFormat usFormat = new UsdFormat();
    InAndOut inAndOut = new InAndOut();
    private final HashMap<Integer, Integer> map = new HashMap<>();
    private final Image[] cards = {imagine.getHeart(), imagine.getDiamond(), imagine.getSpades(), imagine.getClubs()};
    private final Image[] smallCards = {imagine.getSmallHeart(), imagine.getSmallDiamond(), imagine.getSmallSpades(), imagine.getSmallClubs()};
    private final int rand1 = new Random().nextInt(smallCards.length);
    private final int rand2 = new Random().nextInt(smallCards.length);
    private final int rand3 = new Random().nextInt(smallCards.length);
    DoubleGui doubleGui;
    private int winning;

    public Cards(DoubleGui doubleGui) {
        this.doubleGui = doubleGui;

    }

    public void paint(Graphics g) {
        Number number;
        try {
            number = NumberFormat.getCurrencyInstance(usFormat.getUsd())
                    .parse(doubleGui.moneiei.getText());
            winning = number.intValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        super.paint(g);
        g.setColor(new Color(0xFFFFFF));
        g.fillRect(10, 10, 570, 100);
        g.setColor(new Color(0x000000));
        g.drawRect(10, 10, 570, 100);
        g.setColor(new Color(0xFFFFFF));
        g.fillRect(190, 120, 200, 250);
        g.setColor(new Color(0x000000));
        g.drawRect(190, 120, 200, 250);
        if (doubleGui.getCheck() || doubleGui.getCount() > 5) {
            g.drawImage(imagine.getCardback(), 170, 120, this);
        }
        g.drawImage(smallCards[rand1], 490, 10, this);
        g.drawImage(smallCards[rand2], 420, 10, this);
        g.drawImage(smallCards[rand3], 350, 10, this);
        if (doubleGui.getCount() <= 5) {
            if (!doubleGui.getCheck()) {
                g.drawImage(cards[doubleGui.getRand()], 170, 120, this);
            }
            CheckCards();

            if (doubleGui.getCount() == 1) {
                map.put(1, doubleGui.getRand());
                g.drawImage(smallCards[map.get(1)], 280, 10, this);
            } else if (doubleGui.getCount() == 2) {
                map.put(2, doubleGui.getRand());
                g.drawImage(smallCards[map.get(1)], 280, 10, this);
                g.drawImage(smallCards[map.get(2)], 210, 10, this);
            } else if (doubleGui.getCount() == 3) {
                map.put(3, doubleGui.getRand());
                g.drawImage(smallCards[map.get(1)], 280, 10, this);
                g.drawImage(smallCards[map.get(2)], 210, 10, this);
                g.drawImage(smallCards[map.get(3)], 140, 10, this);
            } else if (doubleGui.getCount() == 4) {
                map.put(4, doubleGui.getRand());
                g.drawImage(smallCards[map.get(1)], 280, 10, this);
                g.drawImage(smallCards[map.get(2)], 210, 10, this);
                g.drawImage(smallCards[map.get(3)], 140, 10, this);
                g.drawImage(smallCards[map.get(4)], 70, 10, this);
            } else if (doubleGui.getCount() == 5) {
                map.put(5, doubleGui.getRand());
                g.drawImage(smallCards[map.get(1)], 280, 10, this);
                g.drawImage(smallCards[map.get(2)], 210, 10, this);
                g.drawImage(smallCards[map.get(3)], 140, 10, this);
                g.drawImage(smallCards[map.get(4)], 70, 10, this);
                g.drawImage(smallCards[map.get(5)], 0, 10, this);
            }
        }

        YouLose();

        doubleGui.moneiei.setText(usFormat.getUsdFormat().format(winning));

    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public int[] smallCards() throws FileNotFoundException {
        int numbers[] = new int[3];
        int k = 0;
        for (int j = 0; j < 3; j++) {
            Scanner sc = new Scanner(Arrays.toString(inAndOut.in()));
            numbers[k] = sc.nextInt();
            k++;
        }
        return numbers;
    }

    @Override
    public void run() {
        Thread me = Thread.currentThread();
        while (thread == me) {
            repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public void CheckCards() {
        if (doubleGui.getButton() == Color.RED && (cards[doubleGui.getRand()] == imagine.getHeart() || cards[doubleGui.getRand()] == imagine.getDiamond())) {
            winning = winning * 2;
            doubleGui.setButton(Color.WHITE);
        } else if (doubleGui.getButton() == Color.BLACK && (cards[doubleGui.getRand()] == imagine.getHeart() || cards[doubleGui.getRand()] == imagine.getDiamond())) {
            winning = 0;
            doubleGui.setButton(Color.YELLOW);
        }
        if (doubleGui.getButton() == Color.BLACK && (cards[doubleGui.getRand()] == imagine.getSpades() || cards[doubleGui.getRand()] == imagine.getClubs())) {
            winning = winning * 2;
            doubleGui.setButton(Color.WHITE);
        } else if (doubleGui.getButton() == Color.RED && (cards[doubleGui.getRand()] == imagine.getSpades() || cards[doubleGui.getRand()] == imagine.getClubs())) {
            winning = 0;
            doubleGui.setButton(Color.YELLOW);
        }
        if (doubleGui.getButton() == Color.MAGENTA && cards[doubleGui.getRand()] == imagine.getHeart()) {
            winning = winning * 4;
            doubleGui.setButton(Color.WHITE);
        } else if (doubleGui.getButton() == Color.MAGENTA && cards[doubleGui.getRand()] != imagine.getHeart()) {
            winning = 0;
            doubleGui.setButton(Color.YELLOW);
        }
        if (doubleGui.getButton() == Color.PINK && cards[doubleGui.getRand()] == imagine.getDiamond()) {
            winning = winning * 4;
            doubleGui.setButton(Color.WHITE);
        } else if (doubleGui.getButton() == Color.PINK && cards[doubleGui.getRand()] != imagine.getDiamond()) {
            winning = 0;
            doubleGui.setButton(Color.YELLOW);
        }
        if (doubleGui.getButton() == Color.DARK_GRAY && cards[doubleGui.getRand()] == imagine.getSpades()) {
            winning = winning * 4;
            doubleGui.setButton(Color.WHITE);
        } else if (doubleGui.getButton() == Color.DARK_GRAY && cards[doubleGui.getRand()] != imagine.getSpades()) {
            winning = 0;
            doubleGui.setButton(Color.YELLOW);
        }
        if (doubleGui.getButton() == Color.GRAY && cards[doubleGui.getRand()] == imagine.getClubs()) {
            winning = winning * 4;
            doubleGui.setButton(Color.WHITE);
        } else if (doubleGui.getButton() == Color.GRAY && cards[doubleGui.getRand()] != imagine.getClubs()) {
            winning = 0;
            doubleGui.setButton(Color.YELLOW);
        }

    }

    public void YouLose() {
        if (doubleGui.getButton() == Color.YELLOW || doubleGui.getCount() == 5) {
            doubleGui.heart.setEnabled(false);
            doubleGui.spades.setEnabled(false);
            doubleGui.clubs.setEnabled(false);
            doubleGui.diamond.setEnabled(false);
            doubleGui.black.setEnabled(false);
            doubleGui.red.setEnabled(false);
        }
    }

}