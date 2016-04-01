package week6woman.graphics.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.PlaceFigure;
import project.yawl.PlaceType;
import project.yawl.Place;
import project.yawl.PlaceTypes;



public class Places extends PlaceFigure {

	public Places(Place place) {
		super(place);
		// TODO Auto-generated constructor stub
	}
	
	private enum Type {
	    NORMAL, START, END
	}

	private Type type; 
	
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
		// First, get the location and dimension of the place as a rectangle
		Rectangle rectangle = this.getClientArea();

		
		if (place instanceof Place) {
			m = getPlaceTypes((Place) place);
		}
		switch (getPlaceTypes()){
		case PlaceTypes.END_VALUE:
		return type.END;
		case PlaceTypes.START_VALUE:
		return Type.START;
		
		}
		int cx = rectangle.x + rectangle.width/2;
		int cy = rectangle.y + rectangle.height/2;

		// eki: the token size and positions are tuned to the default size
		//      of places; they could be derived from the actual size of
		//      the place.
		if (m == 0) {
			return;
		} else if (m == 1) {
			graphics.setBackgroundColor(getForegroundColor());
			graphics.fillOval(cx-6, cy-6, 12, 12);
		} else if (m == 2) {
			graphics.setBackgroundColor(getForegroundColor());
			graphics.fillOval(cx-11, cy-11, 12, 12);
			graphics.fillOval(cx, cy, 12, 12);
		} else if (m == 3) {
			graphics.setBackgroundColor(getForegroundColor());
			graphics.fillOval(cx-6, cy-13, 12, 12);
			graphics.fillOval(cx-13, cy, 12, 12);
			graphics.fillOval(cx+1, cy, 12, 12);
		} else if (m == 4) {
			graphics.setBackgroundColor(getForegroundColor());
			graphics.fillOval(cx-13, cy-13, 12, 12);
			graphics.fillOval(cx+1, cy-13, 12, 12);
			graphics.fillOval(cx-13, cy+1, 12, 12);
			graphics.fillOval(cx+1, cy+1, 12, 12);
		} else {
			graphics.drawString(""+m, cx-5, cy-7);
		}
	}


	private Type getPlaceTypes(Place place) {
		if (this.place instanceof Place){
			PlaceType pt = ((Place)place).getType();
			if (pt !=null){
				switch (pt.getText().getValue()){
				case PlaceTypes.END_VALUE:
				return type.END;
				case PlaceTypes.START_VALUE:
				return Type.START;
				
				}
			}
		}
		
		
		return type.NORMAL;
	}

}
