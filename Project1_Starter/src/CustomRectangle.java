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
    
    public boolean isInWBoxRect() {
    	if(		this.getX() < 0.0 || this.getY() < 0.0 
				|| this.getX() + this.getWidth() > 1024.0 
				|| this.getY() + this.getHeight() > 1024.0) 
		{
			return false;
		}
    	return true;
    }
    
    public boolean isValidRect() {
    	if(this.getWidth() <= 0.0 || this.getHeight() <= 0.0)
    	{
    		return false;
    	}
		return true;
    }

}