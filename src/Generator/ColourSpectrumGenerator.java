
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
    public static RGBColour[] generateColoursArray(int numberOfColours){
        final ArrayList<RGBColour> generatedColours = generateColoursArrayList(numberOfColours);
        final int listSize = generatedColours.size();
        return generatedColours.toArray(new RGBColour[listSize]);
    }

    /**
     * Generates an ArrayList of colours across the spectrum
     * Resultant size will not be exactlty equal to the number of colours only
     * approximately
     */
    public static ArrayList<RGBColour> generateColoursArrayList(int numberOfColours){

        final ArrayList<RGBColour> colours = new ArrayList<>();
        
        final double incrementValue = (double)calculateStepCount() / (double)numberOfColours;
        System.out.println(incrementValue + " | " + calculateStepCount());
        
        
        double red = RED.getRed();
        double green = RED.getGreen();
        double blue = RED.getBlue();

        int index = 0;

        double leftOverIncrement = 0;

        while (green <= YELLOW.getGreen()){
            colours.add(index++, new RGBColour(red, green, blue));
            green += incrementValue;
        }
        
        leftOverIncrement = (green - YELLOW.getGreen());
        green = YELLOW.getGreen();

        while (red >= GREEN.getRed()){
            colours.add(index++, new RGBColour(red, green, blue));
            red -= incrementValue;
        }
        
        leftOverIncrement = (-red);
        red = GREEN.getRed();

        while (blue <= CYAN.getBlue()){
            colours.add(index++, new RGBColour(red, green, blue));
            blue += incrementValue;
            
        }
        
        leftOverIncrement = (blue - CYAN.getBlue());
        blue = CYAN.getBlue();

        while (green >= BLUE.getGreen()){
            colours.add(index++, new RGBColour(red, green, blue));
            green -= incrementValue;
        }

        leftOverIncrement = (-green);
        green = BLUE.getGreen();
        
        while (red <= MAGENTA.getRed()){
            colours.add(index++, new RGBColour(red, green, blue));
            red += incrementValue;
        }
        
        leftOverIncrement = red - MAGENTA.getRed();
        red = MAGENTA.getRed();
                
        while (blue >= RED.getBlue()){
            colours.add(index++, new RGBColour(red, green, blue));
            blue -= incrementValue;
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
