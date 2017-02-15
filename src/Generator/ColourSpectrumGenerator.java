
package Generator;

import java.util.ArrayList;


/**
 * Created by Alequin on 16/12/2016.
 * updated 14/02/17
 */

public class ColourSpectrumGenerator {

    private static RGBColour[] colours;
    private static int colourCount;
    
    private static RGBColour RED = new RGBColour(255,0,0);
    private static RGBColour YELLOW = new RGBColour(255,255,0);
    private static RGBColour GREEN = new RGBColour(0,255,0);
    private static RGBColour CYAN = new RGBColour(0,255,255);
    private static RGBColour BLUE = new RGBColour(0,0,255);
    private static RGBColour MAGENTA = new RGBColour(255,0,255);
    
    public static RGBColour[] generateColours(int numberOfColours){
        return generateColours(numberOfColours, new RGBColour(255,0,0));
    }
    
    /**
     * Generates an array of colours across the spectrum
     */
    public static RGBColour[] generateColours(int numberOfColours, RGBColour baseColour){

        if(numberOfColours <=0){
            throw new IllegalArgumentException("Number of colours must be greater than 0");
        }
        
        prepareGenerator(numberOfColours, baseColour);
        
        double totalSteps = calculateStepCount();
        final double incrementValue = totalSteps / (double)numberOfColours;
        
        double red = RED.getRed();
        double green = RED.getGreen();
        double blue = RED.getBlue();

        final int minMaxRange = RED.getMaxColourValue() - RED.getMinColourValue();
        
        double leftOverIncrement = 0;
        
        PRIMARY_LOOP:do{
            while (green < YELLOW.getGreen()){
                green += incrementValue;
                if(green <= YELLOW.getGreen()){
                    if(addColour(new RGBColour(red, green, blue))){
                        break PRIMARY_LOOP;
                    }
                }
            }

            leftOverIncrement = (green - YELLOW.getGreen());
            green = YELLOW.getGreen();
            if(leftOverIncrement > 0){
                red -= leftOverIncrement;
                if(leftOverIncrement <= minMaxRange){
                    if(addColour(new RGBColour(red, green, blue))){                       
                        break PRIMARY_LOOP;                    
                    }
                }
            }

            while (red > GREEN.getRed()){
                red -= incrementValue;
                if(red >= GREEN.getRed()){
                    if(addColour(new RGBColour(red, green, blue))){                        
                        break PRIMARY_LOOP;                    
                    }
                }
            }

            leftOverIncrement = GREEN.getRed() - red;
            red = GREEN.getRed();
            if(leftOverIncrement > 0){
                blue += leftOverIncrement;
                if(leftOverIncrement <= minMaxRange){
                    if(addColour(new RGBColour(red, green, blue))){                        
                        break PRIMARY_LOOP;                    
                    }
                }
            }

            while (blue < CYAN.getBlue()){
                blue += incrementValue;
                if(blue <= CYAN.getBlue()){
                   if(addColour(new RGBColour(red, green, blue))){                        
                       break PRIMARY_LOOP;                    
                   } 
                }
            }

            leftOverIncrement = (blue - CYAN.getBlue());
            blue = CYAN.getBlue();
            if(leftOverIncrement > 0){
                green -= leftOverIncrement;
                if(leftOverIncrement <= minMaxRange){
                    if(addColour(new RGBColour(red, green, blue))){                        
                        break PRIMARY_LOOP;                    
                    }
                }
            }

            while (green > BLUE.getGreen()){
                green -= incrementValue;
                if(green >= BLUE.getGreen()){
                    if(addColour(new RGBColour(red, green, blue))){                        
                        break PRIMARY_LOOP;                    
                    }
                }
            }

            leftOverIncrement = BLUE.getGreen() - green;
            green = BLUE.getGreen();
            if(leftOverIncrement > 0){
                red += leftOverIncrement;
                if(leftOverIncrement <= minMaxRange){
                    if(addColour(new RGBColour(red, green, blue))){                        
                        break PRIMARY_LOOP;                   
                    }
                }
            }

            while (red < MAGENTA.getRed()){
                red += incrementValue;
                if(red <= MAGENTA.getRed()){
                    if(addColour(new RGBColour(red, green, blue))){                        
                        break PRIMARY_LOOP;                    
                    }
                }
            }

            leftOverIncrement = red - MAGENTA.getRed();
            red = MAGENTA.getRed();
            if(leftOverIncrement > 0){
                blue -= leftOverIncrement;
                if(leftOverIncrement <= minMaxRange){
                    if(addColour(new RGBColour(red, green, blue))){                        
                        break PRIMARY_LOOP;                    
                    }
                }
            }        

            while (blue > RED.getBlue()){
                blue -= incrementValue;
                if(blue >= RED.getBlue()){
                    if(addColour(new RGBColour(red, green, blue))){                        
                        break PRIMARY_LOOP;                    
                    }
                }
            }

            leftOverIncrement = RED.getBlue() - blue;
            blue = MAGENTA.getRed();
            if(leftOverIncrement > 0){
                green -= leftOverIncrement;
                if(leftOverIncrement <= minMaxRange){
                    if(addColour(new RGBColour(red, green, blue))){                        
                        break PRIMARY_LOOP;                   
                    }
                }
            }  
        }while(colourCount < colours.length);
         
        return colours;
    };
    
    private static void prepareGenerator(int numberOfColours, RGBColour baseColour){
        
        setPrimaryColours(baseColour);
        colours = new RGBColour[numberOfColours];
        colourCount = 0;
    }
    
    private static void resetGenerator(){
        
        RED = null;
        YELLOW = null;
        GREEN = null;
        CYAN = null;
        BLUE = null;
        MAGENTA = null;
        
        colours = null;
        colourCount = 0;
    }
    
    /**
     * Adds the new colour to the colours array
     * returns true when the max number of colours have been made
     * @param colourToAdd
     * @return 
     */
    private static boolean addColour(RGBColour colourToAdd){
        
        colours[colourCount++] = colourToAdd;
        return colourCount >= colours.length;
        
    }
    
    private static void setPrimaryColours(RGBColour baseColour){
        
        final int min = baseColour.getMinColourValue();
        final int max = baseColour.getMaxColourValue();
        
        RED = new RGBColour(max, min, min);
        YELLOW = new RGBColour(max, max, min);
        GREEN = new RGBColour(min, max, min);
        CYAN = new RGBColour(min, max,max);
        BLUE = new RGBColour(min, min, max);
        MAGENTA = new RGBColour(max, min, max);
    }
    
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
