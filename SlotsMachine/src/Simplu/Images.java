package Simplu;

import javax.swing.*;
import java.awt.*;

public class Images {
    private final ImageIcon cardb = new ImageIcon("src\\Images\\Cardback.png");
    private final Image cardback = changeIcon(cardb.getImage(), 240, 240);
    private final ImageIcon heartCard = new ImageIcon("src\\Images\\HeartCard.png");
    private final ImageIcon diamondCard = new ImageIcon("src\\Images\\DiamondCard.png");
    private final ImageIcon spadesCard = new ImageIcon("src\\Images\\SpadesCard.png");
    private final ImageIcon clubsCard = new ImageIcon("src\\Images\\ClubsCard.png");

    private final Image heart = changeIcon(heartCard.getImage(), 240, 240);
    private final Image diamond = changeIcon(diamondCard.getImage(), 240, 240);
    private final Image spades = changeIcon(spadesCard.getImage(), 240, 240);
    private final Image clubs = changeIcon(clubsCard.getImage(), 240, 240);

    private final Image smallHeart = changeIcon(heartCard.getImage(), 100, 100);
    private final Image smallDiamond = changeIcon(diamondCard.getImage(), 100, 100);
    private final Image smallSpades = changeIcon(spadesCard.getImage(), 100, 100);
    private final Image smallClubs = changeIcon(clubsCard.getImage(), 100, 100);

    private final ImageIcon resizeCherry = new ImageIcon("src\\Images\\Cherry.png");
    private final ImageIcon resizeSeven = new ImageIcon("src\\Images\\Seven.png");
    private final ImageIcon resizeLemon = new ImageIcon("src\\Images\\Lemon.png");
    private final ImageIcon resizeMelon = new ImageIcon("src\\Images\\Melon.png");
    private final ImageIcon resizeOrange = new ImageIcon("src\\Images\\Orange.png");
    private final ImageIcon resizePlum = new ImageIcon("src\\Images\\Plum.png");
    private final ImageIcon resizeBar = new ImageIcon("src\\Images\\Bar.png");
    private final ImageIcon resizeGrape = new ImageIcon("src\\Images\\Grape.png");
    private final Image cherry = changeIcon(resizeCherry.getImage(),100,100);
    private final Image seven = changeIcon(resizeSeven.getImage(),100,100);
    private final Image lemon = changeIcon(resizeLemon.getImage(),100,100);
    private final Image melon = changeIcon(resizeMelon.getImage(),100,100);
    private final Image orange = changeIcon(resizeOrange.getImage(),100,100);
    private final Image plum = changeIcon(resizePlum.getImage(),100,100);
    private final Image bar = changeIcon(resizeBar.getImage(),100,100);
    private final Image grape = changeIcon(resizeGrape.getImage(),100,100);

    ImageIcon iconHeart = new ImageIcon("src\\Images\\Heart.png");
    ImageIcon iconSpades = new ImageIcon("src\\Images\\Spades.png");
    ImageIcon iconClubs = new ImageIcon("src\\Images\\Clubs.png");
    ImageIcon iconDiamod = new ImageIcon("src\\Images\\Diamond.png");

    public ImageIcon getIconHeart(){return iconHeart;}
    public ImageIcon getIconSpades(){return iconSpades;}
    public ImageIcon getIconClubs(){return iconClubs;}
    public ImageIcon getIconDiamod(){return iconDiamod;}

    public Image getCherry(){return cherry;}
    public Image getSeven(){return seven;}
    public Image getLemon(){return lemon;}
    public Image getMelon(){return melon;}
    public Image getOrange(){return orange;}
    public Image getPlum(){return plum;}
    public Image getBar(){return bar;}
    public Image getGrape(){return grape;}

   public Image getCardback(){
       return cardback;
   }

    public Image getSmallHeart(){
        return smallHeart;
    }
    public Image getSmallDiamond(){
        return smallDiamond;
    }
    public Image getSmallSpades(){
        return smallSpades;
    }
    public Image getSmallClubs(){
        return smallClubs;
    }

    public Image getHeart(){
        return heart;
    }
    public Image getDiamond(){
        return diamond;
    }
    public Image getSpades(){
        return spades;
    }
    public Image getClubs(){
        return clubs;
    }

    public Image changeIcon(Image imagine, int width, int height) {

        return imagine.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
