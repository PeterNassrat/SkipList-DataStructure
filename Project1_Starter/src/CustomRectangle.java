import java.awt.Rectangle;
@SuppressWarnings("serial")
public class CustomRectangle extends Rectangle {

	public CustomRectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public String toString() {
    	return Integer.toString((int)this.getX()) + ", " + Integer.toString((int)this.getY())
    	+ ", " + Integer.toString((int)this.getWidth()) + ", " + Integer.toString((int)this.getHeight());
    }

}