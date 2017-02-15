
package Generator;

import java.util.ArrayList;


/**
 * Created by Alequin on 16/12/2016.
 * updated 14/02/17
 */

public class ColourSpectrumGenerator {

    private static final RGBColour RED = new RGBColour(255,0,0);
    private static final RGBColour YELLOW = new RGBColour(255,255,0);
    private static final RGBColour GREEN = new RGBColour(0,255,0);
    private static final RGBColour CYAN = new RGBColour(0,255,255);
    private static final RGBColour BLUE = new RGBColour(0,0,255);
    private static final RGBColour MAGENTA = new RGBColour(255,0,255);
    
    /**
     * Generates an ArrayList of colours across the spectrum
     * Resultant size will not be exactlty equal to the number of colours only
     * approximately
     */
    public static RGBColour[] generateColours(int numberOfColours){

        final RGBColour[] colours = new RGBColour[numberOfColours];
        double totalSteps = calculateStepCount();
        final double incrementValue = totalSteps / (double)numberOfColours;
        
        int index = 0;
        
        double red = RED.getRed();
        double green = RED.getGreen();
        double blue = RED.getBlue();

        final int minMaxRange = RED.getMaxColourValue() - RED.getMinColourValue();
        
        double leftOverIncrement = 0;

        while (green < YELLOW.getGreen()){
            green += incrementValue;
            if(green <= YELLOW.getGreen()){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }
        
        leftOverIncrement = (green - YELLOW.getGreen());
        green = YELLOW.getGreen();
        if(leftOverIncrement > 0){
            red -= leftOverIncrement;
            if(leftOverIncrement <= minMaxRange){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }

        while (red > GREEN.getRed()){
            red -= incrementValue;
            if(red >= GREEN.getRed()){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }
        
        leftOverIncrement = Math.abs(red);
        red = GREEN.getRed();
        if(leftOverIncrement > 0){
            blue += leftOverIncrement;
            if(leftOverIncrement <= minMaxRange){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }

        while (blue < CYAN.getBlue()){
            blue += incrementValue;
            if(blue <= CYAN.getBlue()){
               colours[index++] = new RGBColour(red, green, blue); 
            }
        }
        
        leftOverIncrement = (blue - CYAN.getBlue());
        blue = CYAN.getBlue();
        if(leftOverIncrement > 0){
            green -= leftOverIncrement;
            if(leftOverIncrement <= minMaxRange){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }

        while (green > BLUE.getGreen()){
            green -= incrementValue;
            if(green >= BLUE.getGreen()){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }

        leftOverIncrement = Math.abs(green);
        green = BLUE.getGreen();
        if(leftOverIncrement > 0){
            red += leftOverIncrement;
            if(leftOverIncrement <= minMaxRange){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }
        
        while (red < MAGENTA.getRed()){
            red += incrementValue;
            if(red <= MAGENTA.getRed()){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }
        
        leftOverIncrement = red - MAGENTA.getRed();
        red = MAGENTA.getRed();
        if(leftOverIncrement > 0){
            blue -= leftOverIncrement;
            if(leftOverIncrement <= minMaxRange){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }        
        
        while (blue > RED.getBlue()){
            blue -= incrementValue;
            if(blue >= RED.getBlue()){
                colours[index++] = new RGBColour(red, green, blue);
            }
        }
        
        if(colours.length < numberOfColours){
            leftOverIncrement = Math.abs(blue);
            blue = MAGENTA.getRed();
            if(leftOverIncrement > 0){
                green -= leftOverIncrement;
                if(leftOverIncrement <= minMaxRange){
                    colours[index++] = new RGBColour(red, green, blue);
                }
            }    
        }
         
        return colours;
    };
    
    private static int calculateStepCount(){

        return getDifferenceBetween(RED.getGreen(), YELLOW.getGreen()) +
                getDifferenceBetween(YELLOW.getRed(), GREEN.getRed()) +
                getDifferenceBetween(GREEN.getBlue(), CYAN.getBlue()) +
                getDifferenceBetween(CYAN.getGreen(), BLUE.getGreen()) +
                getDifferenceBetween(BLUE.getRed(), MAGENTA.getRed()) +
                getDifferenceBetween(MAGENTA.getBlue(), RED.getBlue());
    }
    
    private static int getDifferenceBetween(int value1, int value2){
        return Math.max(value1, value2) - Math.min(value1, value2);
    }
}
