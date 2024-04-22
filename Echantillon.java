package ET;

public class Echantillon {
	    private final boolean x;
	    private final boolean y;
	    private final boolean output; // Expected output for the AND operation

	    public Echantillon(boolean x, boolean y, boolean output) {
	        this.x = x;
	        this.y = y;
	        this.output = output;
	    }

	    // Getters here...
	    public boolean getX() { return x; }
	    public boolean getY() { return y; }
	    public boolean getOutput() { return output; }
}