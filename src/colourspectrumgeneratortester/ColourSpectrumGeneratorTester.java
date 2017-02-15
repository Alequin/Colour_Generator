
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
        for(int a=value; a<value+200_000; a++){
            int red = randomNum();
            int green = randomNum();
            int blue = randomNum();
            System.out.println(red + " | " + green + " | " + blue);
            RGBColour[] colours = ColourSpectrumGenerator.generateColours(a, new RGBColour(red,green,blue));
            System.out.println(a + ") " + colours.length);
        }
    }
    
    public static int randomNum(){
        return new Random().nextInt(255);
    }
    
    public static void testoffBy(){
        int value = 1;
        int offByValue = 0;
        for(int a=value; a<value+2000; a++){
                RGBColour[] colours = ColourSpectrumGenerator.generateColours(a);
                offByValue = Math.max(offByValue, Math.abs(colours.length - a));
                if(a % 10_000 == 0){
                    System.out.println(a);
                }
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
    
    
    
}
