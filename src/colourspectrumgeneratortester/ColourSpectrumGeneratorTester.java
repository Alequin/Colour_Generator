
package colourspectrumgeneratortester;

import Generator.ColourSpectrumGenerator;
import Generator.RGBColour;

public class ColourSpectrumGeneratorTester {

    public static void main(String[] args) {
        
        RGBColour[] colours = ColourSpectrumGenerator.generateColoursArray(1);
        
        for(int a=1; a<colours.length+1; a++){
            printColour(a, colours[a-1]);
        }
    }
    
    public static void printColour(int index, RGBColour colour){
        System.out.println(index + ") " + colour.getRed() + ", " + colour.getBlue() + ", " + colour.getGreen());
    }
    
}
