
package Generator;

import java.util.ArrayList;


/**
 * Created by Alequin on 16/12/2016.
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

        final ArrayList<RGBColour> colours = new ArrayList<>();;
        final double incrementValue = (double)1592 / (double)numberOfColours;

        double red = RED.getRed();
        double green = RED.getGreen();
        double blue = RED.getBlue();

        int index = 0;
        int currentPoint = 0;

        double leftOverIncrement = 0;

        while (currentPoint == 0){
            colours.add(index++, new RGBColour(red, green, blue));
            green += incrementValue;
            if(green >= YELLOW.getGreen()){
                green = YELLOW.getGreen();
                leftOverIncrement = (green - YELLOW.getGreen());
                currentPoint = 1;
            }
        }

        while (currentPoint == 1){
            colours.add(index++, new RGBColour(red, green, blue));
            red -= incrementValue;
            if(red <= GREEN.getRed()){
                red = GREEN.getRed();
                leftOverIncrement = (-red);
                currentPoint = 2;
            }
        }

        while (currentPoint == 2){
            colours.add(index++, new RGBColour(red, green, blue));
            blue += incrementValue;
            if(blue >= CYAN.getBlue()){
                blue = CYAN.getBlue();
                leftOverIncrement = (blue - CYAN.getBlue());
                currentPoint = 3;
            }
        }

        while (currentPoint == 3){
            colours.add(index++, new RGBColour(red, green, blue));
            green -= incrementValue;
            if(green <= BLUE.getGreen()){
                green = BLUE.getGreen();
                leftOverIncrement = (-green);
                currentPoint = 4;
            }
        }

        while (currentPoint == 4){
            colours.add(index++, new RGBColour(red, green, blue));
            red += incrementValue;
            if(red >= MAGENTA.getRed()){
                red = MAGENTA.getRed();
                leftOverIncrement = red - MAGENTA.getRed();
                currentPoint = 5;
            }
        }

        while (currentPoint == 5){
            colours.add(index++, new RGBColour(red, green, blue));
            blue -= incrementValue;
            if(blue <= RED.getBlue()){
                currentPoint = 6;
            }
        }

        return colours;
    };
}
