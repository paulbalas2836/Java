package Simplu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InAndOut {
    public String[] in() throws FileNotFoundException {
        Scanner inFile = new Scanner("D:\\Programe\\Pacane\\SmallCards").useDelimiter(",\\s*");
        int index=-1;
        String text[]=new String[3];
        while (inFile.hasNextLine()){
            index++;
        text[index]=inFile.nextLine();
        }
        inFile.close();

        return text ;
    }
}

