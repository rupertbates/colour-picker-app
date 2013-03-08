package com.serendipity.colourPicker;

import android.graphics.Color;

import java.util.Random;

public class Colours {
    private Random rand = new Random();
    public final int text;
    public final int background;

    public Colours(){
        this.text = randomColour();
        this.background = complement(text);
    }

    private int randomColour() {
        return Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    private int complement(int colour){
        int textColor = Color.rgb(255 - Color.red(colour),
                255 - Color.green(colour),
                255 - Color.blue(colour));
        return textColor;
    }

    public String toString(){
        return "text: " + getHex(text) + "\nback:" + getHex(background);
    }

    protected String getHex(int colour){
        return "#" + Integer.toHexString(Color.red(colour)) + Integer.toHexString(Color.green(colour)) + Integer.toHexString(Color.blue(colour));
    }

}
