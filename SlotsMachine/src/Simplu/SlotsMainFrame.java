package Simplu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.text.ParseException;

public class SlotsMainFrame extends JFrame {

    UsdFormat usFormat= new UsdFormat();
    SpinningSlotsFrame spinningSlots = new SpinningSlotsFrame(this);

    private int betMoney = 1;
    private int currentMoney = 10;
    private int winning = 0;
    private int counter = 1;

    final JTextField sum;
    final JLabel myMoney;
    JButton moneyBet, cashIn, spin, doubleChance, reset, winningSum;

    SlotsMainFrame() {
        //Setting the GUI
        setContentPane(spinningSlots);
        this.setBounds(50, 50, 600, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        sum = new JTextField(usFormat.getUsdFormat().format(currentMoney));
        sum.setEditable(false);
        sum.setBounds(110, 30, 60, 30);

        myMoney = new JLabel("Current Money");
        myMoney.setBounds(0, 30, 100, 30);

        //Adding the and implementing the buttons
        winningSum = new JButton(usFormat.getUsdFormat().format(0));
        winningSum.setBounds(10, 450, 100, 30);
        winningSum.setEnabled(false);

        reset = new JButton("Reset");
        reset.setBounds(200, 500, 100, 30);
        reset.addActionListener(e -> {
            spinningSlots.reset();
            currentMoney = 20;
            sum.setText(usFormat.getUsdFormat().format(currentMoney));
            spin.setEnabled(true);
            betMoney = 1;
            moneyBet.setText(usFormat.getUsdFormat().format(betMoney));
            winningSum.setText(usFormat.getUsdFormat().format(0));

        });


        spin = new JButton("Spin");
        spin.setBounds(325, 500, 100, 30);
        spin.addActionListener(e -> {
            if (counter == 1) {
                spinningSlots.start();
            }

            counter = 0;
            spin.setEnabled(winning == 0);
            doubleChance.setEnabled(winning != 0);
            winningSum.setText(usFormat.getUsdFormat().format(winning));
            currentMoney = currentMoney - betMoney;
            if (currentMoney < betMoney) {
                spin.setEnabled(false);
            }
            sum.setText(usFormat.getUsdFormat().format(currentMoney));
            synchronized (spinningSlots) {
                spinningSlots.notify();
            }
        });

        moneyBet = new JButton(usFormat.getUsdFormat().format(betMoney));
        moneyBet.setBounds(10, 500, 100, 30);
        moneyBet.addActionListener(e -> {
            if (betMoney == 1) {
                betMoney = 5;
            } else if (betMoney == 5) {
                betMoney = 10;
            } else if (betMoney == 10) {
                betMoney = 25;
            } else if (betMoney == 25) {
                betMoney = 50;
            } else if (betMoney == 50) {
                betMoney = 100;


            } else if (betMoney == 100) {
                betMoney = 1;
            }
            moneyBet.setText(usFormat.getUsdFormat().format(betMoney));
            spin.setEnabled(!(currentMoney < betMoney));
        });


        doubleChance = new JButton("Double");
        doubleChance.setBounds(450, 500, 100, 30);
        doubleChance.setEnabled(false);
        doubleChance.addActionListener(e -> {
            new DoubleGui(this);
            winning = 0;
            winningSum.setText(usFormat.getUsdFormat().format(winning));
            if(currentMoney !=0){
            spin.setEnabled(true);}
            doubleChance.setEnabled(false);
        });

        cashIn = new JButton("CashIn");
        cashIn.setBounds(450, 470, 100, 30);
        cashIn.addActionListener(e -> {
            try {
                Number number = NumberFormat.getCurrencyInstance(usFormat.getUsd())
                        .parse(winningSum.getText());
                currentMoney = currentMoney + number.intValue();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            sum.setText(usFormat.getUsdFormat().format(currentMoney));
            winning = 0;
            if (currentMoney >= betMoney) {
                spin.setEnabled(true);
            }
            winningSum.setText(usFormat.getUsdFormat().format(winning));
            doubleChance.setEnabled(false);

        });


        //Adding all the elements to the GUI
        add(moneyBet);
        add(spin);
        add(reset);
        add(winningSum);
        add(doubleChance);
        add(myMoney);
        add(sum);
        add(cashIn);

        setVisible(true);
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public int getBetMoney() {
        return betMoney;
    }

    public void setWinning(int winning) {
        this.winning = winning;
    }
}
