
package colourspectrumgeneratortester;

import Generator.ColourSpectrumGenerator;
import Generator.RGBColour;
import java.util.Random;

public class ColourSpectrumGeneratorTester {

    public static void main(String[] args) {
        
        //testRGBValues();
        testColourCount();
        //testoffBy();
        //testoffByDirection();
        //testAllColours();
    }
    
    public static void printColour(int index, RGBColour colour){
        System.out.println(index + ") " + colour.getRed() + ", " + colour.getBlue() + ", " + colour.getGreen());
    }
    
    public static void testRGBValues(){
        RGBColour[] colours = ColourSpectrumGenerator.generateColours(50, new RGBColour(150,150,100));
        
        for(int a=1; a<colours.length+1; a++){
            printColour(a, colours[a-1]);
        }
    }
    
    public static void testColourCount(){
        int value = 1;
        final Random r = new Random();
        for(int a=value; a<value+50000; a++){
            int red = r.nextInt(255);
            int green = r.nextInt(255);
            int blue = r.nextInt(255);
            RGBColour[] colours = ColourSpectrumGenerator.generateColours(a, new RGBColour(red,green,blue));
            if(colours.length != a){
                printColour(a, new RGBColour(red,green,blue));
            }
        }
    }
    
    public static void testoffBy(){
        int value = 1;
        int offByValue = 0;
        for(int a=value; a<value+2000; a++){
                RGBColour[] colours = ColourSpectrumGenerator.generateColours(a);
                offByValue = Math.max(offByValue, Math.abs(colours.length - a));
        }
        System.out.println(offByValue);
    }
    
    public static void testoffByDirection(){
        int value = 1;
        boolean negative = false;
        boolean positive = false;
        
        for(int a=value; a<value+1000; a++){
                RGBColour[] colours = ColourSpectrumGenerator.generateColours(a);
                if(a != colours.length){
                    int diff = a - colours.length;
                    if(!negative){
                        negative = diff > 0;
                    }
                    if(!positive){
                        positive = diff < 0;
                    }
                }
        }
        
        System.out.println("----------------------------------------------------------");
        System.out.println(negative + " | " + positive);
    }
    
    public static void testAllColours(){
        
        int red = 0;
        int green = 0;
        int blue = 0;
        
        while(red < 255){
            
            blue++;
            if(blue > 255){
                green++;
                blue = 0;
                if(green > 255){
                    red++;
                    green = 0;
                }
            }
            
            System.out.println(red + " | " + green + " | " + blue);
            RGBColour[] colours = ColourSpectrumGenerator.generateColours(1600, new RGBColour(red,green,blue));
            
        }
        
    }
    
    
    
}
