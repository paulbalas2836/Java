package Simplu;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

public class DoubleGui extends JFrame {
    //Setting up the GUI
    JButton red, black, moneiei, getmoneiei, heart, spades, diamond, clubs;
    UsdFormat usFormat=new UsdFormat();
    Images images=new Images();

    SlotsMainFrame slots;
    Cards card = new Cards(this);

    private Number number;
    private int winning;
    private boolean check = true;
    private int rand;
    private int count = 0;
    //Colors for Cards choice , red-red, magenta-heart, diamond-pink, black-black, darkgray-spades,gray-clubs
    //Default Color is White, Wrong Color is Yellow
    private Color button=Color.WHITE ;

    DoubleGui(SlotsMainFrame slots) {
        setContentPane(card);
        card.start();
        try {
            number = NumberFormat.getCurrencyInstance(usFormat.getUsd())
                    .parse(slots.winningSum.getText());
            winning = number.intValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.slots = slots;
        this.setBounds(100, 100, 600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);


        moneiei = new JButton(usFormat.getUsdFormat().format(winning));
        moneiei.setBounds(365, 450, 200, 50);
        moneiei.setEnabled(false);

        getmoneiei = new JButton("Cash In");
        getmoneiei.setBounds(20, 450, 200, 50);

        red = new JButton("RED");
        red.setBounds(20, 300, 150, 50);
        red.setBackground(Color.RED);
        red.addActionListener(e -> {
            check = false;
            button = Color.RED;
            rand = new Random().nextInt(4);
            count++;
        });

        heart = new JButton(new ImageIcon(images.getIconHeart().getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        heart.setBorder(BorderFactory.createBevelBorder(1, Color.RED, Color.RED));
        heart.setBounds(20, 220, 75, 80);
        heart.addActionListener(e -> {
            check = false;
            button = Color.MAGENTA;
            rand = new Random().nextInt(4);
            count++;
        });

        diamond = new JButton(new ImageIcon(images.getIconDiamod().getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        diamond.setBorder(BorderFactory.createBevelBorder(1, Color.RED, Color.RED));
        diamond.setBounds(95, 220, 75, 80);
        diamond.addActionListener(e -> {
            check = false;
            button = Color.PINK;
            rand = new Random().nextInt(4);
            count++;
        });


        black = new JButton("BLACK");
        black.setBounds(415, 300, 150, 50);
        black.setBackground(Color.black);
        black.addActionListener(e -> {
            check = false;
            button = Color.BLACK;
            rand = new Random().nextInt(4);
            count++;
        });


        spades = new JButton(new ImageIcon(images.getIconSpades().getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        spades.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
        spades.setBounds(415, 220, 75, 80);
        spades.addActionListener(e -> {
            check = false;
            button = Color.DARK_GRAY;
            rand = new Random().nextInt(4);
            count++;
        });

        clubs = new JButton(new ImageIcon(images.getIconClubs().getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        clubs.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
        clubs.setBounds(490, 220, 75, 80);
        clubs.addActionListener(e -> {
            check = false;
            button = Color.GRAY;
            rand = new Random().nextInt(4);
            count++;
        });
        getmoneiei.addActionListener(e -> {
            Number number1;
            try {
                number1 = NumberFormat.getCurrencyInstance(usFormat.getUsd())
                        .parse(moneiei.getText());
                int money = number1.intValue();
                slots.winningSum.setText(usFormat.getUsdFormat().format(money));
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            dispose();
        });

        add(getmoneiei);
        add(moneiei);
        add(black);
        add(red);
        add(heart);
        add(spades);
        add(diamond);
        add(clubs);
        setVisible(true);
    }

    public boolean getCheck() {
        return check;
    }

    public Color getButton() {
        return button;
    }

    public int getRand() {
        return rand;
    }

    public int getCount() {
        return count;
    }

    public void setButton(Color button) {
        this.button = button;
    }
}
