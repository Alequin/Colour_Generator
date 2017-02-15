
package colourspectrumgeneratortester;

import Generator.ColourSpectrumGenerator;
import Generator.RGBColour;

public class ColourSpectrumGeneratorTester {

    public static void main(String[] args) {
        
        //testRGBValues();
        //testColourCount();
        testoffBy();
        //testoffByDirection();
    }
    
    public static void printColour(int index, RGBColour colour){
        System.out.println(index + ") " + colour.getRed() + ", " + colour.getBlue() + ", " + colour.getGreen());
    }
    
    public static void testRGBValues(){
        RGBColour[] colours = ColourSpectrumGenerator.generateColours(6);
        
        for(int a=1; a<colours.length+1; a++){
            printColour(a, colours[a-1]);
        }
    }
    
    public static void testColourCount(){
        int value = 1;
        for(int a=value; a<value+50; a++){
            RGBColour[] colours = ColourSpectrumGenerator.generateColours(a);
            System.out.println(a + ") " + colours.length);
        }
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
