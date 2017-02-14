
package Generator;
/**
 * Created by Alequin on 20/12/2016.
 */

public class RGBColour {

    private final double RED, GREEN, BLUE;

    public RGBColour(double RED, double GREEN, double BLUE) {
        this.RED = RED;
        this.GREEN = GREEN;
        this.BLUE = BLUE;
    }

    public int getRed() {
        return (int)RED;
    }

    public int getGreen() {
        return (int)GREEN;
    }

    public int getBlue() {
        return (int)BLUE;
    }
}
