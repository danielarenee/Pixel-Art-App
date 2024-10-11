package frames;

import java.awt.Color;

public class ColorManager {
	 private Color currentColor;
	    
	    public ColorManager() {
	        currentColor = Color.BLACK; 
	    }
	 
	    public void setCurrentColor(Color color) {
	        currentColor = color;
	    }
	    
	    public Color getCurrentColor() {
	        return currentColor;
	    }

}
