package Anno.app;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IPresentationHandler;
import org.pnml.tools.epnk.applications.ui.figures.EllipseOverlay;
import org.pnml.tools.epnk.applications.ui.figures.PolylineOverlay;
import org.pnml.tools.epnk.applications.ui.figures.RectangleOverlay;

import project.yawl.Arc;
import project.yawl.Place;
import project.yawl.Transition;
import Anno.EnabledTransition;
import Anno.SelectArc;
import Anno.Mode;


public class APPPresentationHandler implements IPresentationHandler {

	@Override
	public IFigure handle(ObjectAnnotation annotation,
			AbstractGraphicalEditPart editPart) {
		if (annotation instanceof SelectArc) {
			SelectArc ArcAnnotation = (SelectArc) annotation;
			if (editPart instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart CNEP = (ConnectionNodeEditPart) editPart;
				// IFigure figure = graphicalEditPart.getFigure();
				java.lang.Object modelObject = CNEP.resolveSemanticElement();
				if (modelObject instanceof Arc) {
					PolylineOverlay overlay = new PolylineOverlay(CNEP);
					if (!ArcAnnotation.isSelected()) {
						System.out.println("last if");
						overlay.setForegroundColor(ColorConstants.black);
					} 
					return overlay;
				}
			}
			
		}
		if (annotation instanceof EnabledTransition) {
			EnabledTransition activationAnnotation =
					(EnabledTransition) annotation;
			if (editPart instanceof GraphicalEditPart) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
				// IFigure figure = graphicalEditPart.getFigure();
				java.lang.Object modelObject = graphicalEditPart.resolveSemanticElement();
				if (modelObject instanceof Transition) {
					RectangleOverlay overlay = new RectangleOverlay(graphicalEditPart);
					if (activationAnnotation.getMode().equals(Mode.ENABLED)) {
						overlay.setForegroundColor(ColorConstants.blue);
						overlay.setBackgroundColor(ColorConstants.blue);
					
					return overlay;
				}
			}
		} 
		
	}
		return null;

	}}
