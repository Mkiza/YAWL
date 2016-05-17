package graphics.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Polygon;
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

		int cx = rectangle.x + rectangle.width / 4;
		int cy = rectangle.y + rectangle.height / 4;
		
		
		
		
		// eki: the token size and positions are tuned to the default size
		// of places; they could be derived from the actual size of
		// the place.
		if (m == type.NORMAL){
			graphics.popState();
			
			return;
			
		} else if (m == type.END) {
			graphics.setBackgroundColor(ColorConstants.red);
			graphics.fillRectangle(cx,cy,20,20);
			
		} else if (m == type.START) {
			graphics.setBackgroundColor(ColorConstants.green);
			int[] points = new int[6];
			points[0]=cx; points[1]=(int) (rectangle.y + rectangle.height * 0.25); points[2]=cx;
			points[3]=(int) (rectangle.y + rectangle.height * 0.75); points[4]=(int) (rectangle.x + rectangle.width*0.75); points[5]=(int) (rectangle.y + rectangle.height *0.5);
			
			graphics.fillPolygon(points);
			
			
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
