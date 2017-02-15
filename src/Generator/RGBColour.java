
package Generator;
/**
 * Created by Alequin on 20/12/2016.
 */

public class RGBColour {

    private int red;
    private int green;
    private int blue;
    
    private final int MAX_COLOUR_VALUE = 255;
    private final int MIN_COLOUR_VALUE = 0;

    public RGBColour(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    public RGBColour(double red, double green, double blue) {
        this((int)red, (int)green, (int)blue);
    }

    public void setRed(int red) {
        if(red < MIN_COLOUR_VALUE || red > MAX_COLOUR_VALUE){
            throw new IllegalArgumentException(
                    String.format("Value cannot be less than %s or greater than %s", 
                            Integer.toString(MIN_COLOUR_VALUE), Integer.toString(MAX_COLOUR_VALUE)
                    )
            );
        }
        this.red = red;
    }

    public void setGreen(int green) {
        if(green < MIN_COLOUR_VALUE || green > MAX_COLOUR_VALUE){
            throw new IllegalArgumentException(
                    String.format("Value cannot be less than %s or greater than %s", 
                            Integer.toString(MIN_COLOUR_VALUE), Integer.toString(MAX_COLOUR_VALUE)
                    )
            );
        }
        this.green = green;
    }

    public void setBlue(int blue) {
        if(blue < MIN_COLOUR_VALUE || blue > MAX_COLOUR_VALUE){
            throw new IllegalArgumentException(
                    String.format("Value cannot be less than %s or greater than %s", 
                            Integer.toString(MIN_COLOUR_VALUE), Integer.toString(MAX_COLOUR_VALUE)
                    )
            );
        }
        this.blue = blue;
    }
    
    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
    
    public int getMinColourValue(){
        return (int)Math.min(red, (Math.max(green, blue)) );
    }
    
    public int getMaxColourValue(){
        return (int)Math.max(red, (Math.max(green, blue)) );
    }
}
