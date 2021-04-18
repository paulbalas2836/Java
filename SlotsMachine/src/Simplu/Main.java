package Simplu;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InAndOut in=new InAndOut();
        System.out.println(in.in());
        new SlotsMainFrame();
    }
}
