package Simplu;

import java.text.NumberFormat;
import java.util.Locale;

public class UsdFormat {
    private final Locale usd = new Locale("en", "US");
    NumberFormat usdFormat = NumberFormat.getCurrencyInstance(usd);
    public Locale getUsd(){
        return usd;
    }
    public NumberFormat getUsdFormat(){
        return usdFormat;
    }
}
