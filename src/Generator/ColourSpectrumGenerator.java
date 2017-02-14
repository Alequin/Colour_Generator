
package Generator;

import java.util.ArrayList;


/**
 * Created by Alequin on 16/12/2016.
 */

public class ColourSpectrumGenerator {

    private static RGBColour RED = new RGBColour(255,0,0);
    private static RGBColour ORANGE = new RGBColour(255,127,0);
    private static RGBColour YELLOW = new RGBColour(255,255,0);
    private static RGBColour CHARTREUSE = new RGBColour(127,255,0);
    private static RGBColour GREEN = new RGBColour(0,255,0);
    private static RGBColour SPRING_GREEN = new RGBColour(0,255,127);
    private static RGBColour CYAN = new RGBColour(0,255,255);
    private static RGBColour AZURE = new RGBColour(0,127,255);
    private static RGBColour BLUE = new RGBColour(0,0,255);
    private static RGBColour VIOLET = new RGBColour(127,0,255);
    private static RGBColour MAGENTA = new RGBColour(255,0,255);
    private static RGBColour ROSE = new RGBColour(255,0,127);

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
        while(currentPoint == 0){
            colours.add(index++, new RGBColour(red, green, blue));
            green += incrementValue;
            if(green >= ORANGE.getGreen()){
                currentPoint = 1;
            }
        }

        while (currentPoint == 1){
            colours.add(index++, new RGBColour(red, green, blue));
            green += incrementValue;
            if(green >= YELLOW.getGreen()){
                green = YELLOW.getGreen();
                leftOverIncrement = (green - YELLOW.getGreen());
                currentPoint = 2;
            }
        }

        while (currentPoint == 2){
            if(leftOverIncrement != 0){
                red -= leftOverIncrement;
                leftOverIncrement = 0;
            }
            colours.add(index++, new RGBColour(red, green, blue));
            red -= incrementValue;
            if(red <= CHARTREUSE.getRed()){
                currentPoint = 3;
            }
        }

        while (currentPoint == 3){
            colours.add(index++, new RGBColour(red, green, blue));
            red -= incrementValue;
            if(red <= GREEN.getRed()){
                red = GREEN.getRed();
                leftOverIncrement = (-red);
                currentPoint = 4;
            }
        }

        while (currentPoint == 4){
            if(leftOverIncrement != 0){
                blue += leftOverIncrement;
                leftOverIncrement = 0;
            }
            colours.add(index++, new RGBColour(red, green, blue));
            blue += incrementValue;
            if(blue >= SPRING_GREEN.getBlue()){
                currentPoint = 5;
            }
        }

        while (currentPoint == 5){
            colours.add(index++, new RGBColour(red, green, blue));
            blue += incrementValue;
            if(blue >= CYAN.getBlue()){
                blue = CYAN.getBlue();
                leftOverIncrement = (blue - CYAN.getBlue());
                currentPoint = 6;
            }
        }

        while (currentPoint == 6){
            if(leftOverIncrement != 0){
                green -= leftOverIncrement;
                leftOverIncrement = 0;
            }
            colours.add(index++, new RGBColour(red, green, blue));
            green -= incrementValue;
            if(green <= AZURE.getGreen()){
                currentPoint = 7;
            }
        }

        while (currentPoint == 7){
            colours.add(index++, new RGBColour(red, green, blue));
            green -= incrementValue;
            if(green <= BLUE.getGreen()){
                green = BLUE.getGreen();
                leftOverIncrement = (-green);
                currentPoint = 8;
            }
        }

        while (currentPoint == 8){
            if(leftOverIncrement != 0){
                red += leftOverIncrement;
                leftOverIncrement = 0;
            }
            colours.add(index++, new RGBColour(red, green, blue));
            red += incrementValue;
            if(red >= VIOLET.getRed()){
                currentPoint = 9;
            }
        }

        while (currentPoint == 9){
            colours.add(index++, new RGBColour(red, green, blue));
            red += incrementValue;
            if(red >= MAGENTA.getRed()){
                red = MAGENTA.getRed();
                leftOverIncrement = red - MAGENTA.getRed();
                currentPoint = 10;
            }
        }

        while (currentPoint == 10){
            if(leftOverIncrement != 0){
                blue -= leftOverIncrement;
                leftOverIncrement = 0;
            }
            colours.add(index++, new RGBColour(red, green, blue));
            blue -= incrementValue;
            if(blue <= ROSE.getBlue()){
                currentPoint = 11;
            }
        }

        while (currentPoint == 11){
            colours.add(index++, new RGBColour(red, green, blue));
            blue -= incrementValue;
            if(blue <= RED.getBlue()){
                currentPoint = 12;
            }
        }

        return colours;
    };
}
