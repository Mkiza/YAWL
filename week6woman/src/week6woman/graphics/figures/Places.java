package week6woman.graphics.figures;

import org.eclipse.draw2d.ColorConstants;
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
	
	@Override
	public void update() {
		this.repaint();
		
	}

	private enum Type {
		NORMAL, START, END
	}

	private Type type;
	
	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
		// First, get the location and dimension of the place as a rectangle
		Rectangle rectangle = this.getClientArea();
		

		Type m = null;
		graphics.pushState();
		graphics.setBackgroundColor(ColorConstants.black);
		graphics.setLineWidth(1);

		if (place instanceof Place) {
			m = getPlaceTypes((Place) place);
		}

		int cx = rectangle.x + rectangle.width / 2;
		int cy = rectangle.y + rectangle.height / 2;
		
		
		
		
		// eki: the token size and positions are tuned to the default size
		// of places; they could be derived from the actual size of
		// the place.
		if (m == type.NORMAL){
			graphics.popState();
			
			return;
			
		} else if (m == type.END) {
			graphics.drawRectangle(rectangle.x/2,rectangle.y/2,12,12);
			
		} else if (m == type.START) {
			graphics.drawRectangle(cx,cy,12,12);
			
		}
		
		graphics.popState();
	}

	private Type getPlaceTypes(Place place) {
		if (this.place instanceof Place) {
			PlaceType pt = ((Place) place).getType();
			if (pt != null) {
				switch (pt.getText().getValue()) {
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
