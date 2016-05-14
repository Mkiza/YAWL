package week6woman.graphics.figures;

import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.swt.SWT;

import org.pnml.tools.epnk.gmf.extensions.graphics.decorations.ReisigsArrowHeadDecoration;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.ArcFigure;

import project.yawl.Arc;
import project.yawl.ArcType;
import project.yawl.ArcTypes;

public class Arcs extends ArcFigure {

	public Arcs(Arc arc) {
		super(arc);
		type = getType();
		setGraphics();
	}
	
	private enum Type {
	    NORMAL, RESET
	}
	
	private Type type;
	
	@Override
	public void update() {
		
		Type oldType = type;
		type = getType();
		if (oldType != type) {
			setGraphics();
		}
		
	}
	
	private void setGraphics() {
		RotatableDecoration targetDecorator = null;

		if (type == Type.NORMAL) {
			this.setLineStyle(SWT.LINE_SOLID);	
			
			
		} else if (type == Type.RESET) {
			this.setLineStyle(SWT.LINE_DASH);
			
			
		} 
		targetDecorator = new ReisigsArrowHeadDecoration();
		this.setTargetDecoration(targetDecorator);
	}
	
	private Type getType() {
		if (this.arc instanceof Arc) {
			ArcType arctype = ((Arc)arc).getType();
			if (arctype != null) {
				switch (arctype.getText().getValue()) {
				case ArcTypes.NORMAL_VALUE:
					return Type.NORMAL;
				case ArcTypes.RESET_VALUE:
					return Type.RESET;
				}
			}return Type.NORMAL; 
		}
		return Type.NORMAL;
	}

}
