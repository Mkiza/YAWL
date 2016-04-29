package Anno.app;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IPresentationHandler;
import org.pnml.tools.epnk.applications.ui.figures.EllipseOverlay;
import org.pnml.tools.epnk.applications.ui.figures.RectangleOverlay;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;
import org.pnml.tools.epnk.pntypes.ptnet.Place;

import Anno.EnabledTransition;
import Anno.SelectArc;


public class APPPresentationHandler implements IPresentationHandler {

	@Override
	public IFigure handle(ObjectAnnotation annotation,
			AbstractGraphicalEditPart editPart) {
		if (annotation instanceof EnabledTransition) {
			EnabledTransition activationAnnotation =
					(EnabledTransition) annotation;
			if (editPart instanceof GraphicalEditPart) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
				// IFigure figure = graphicalEditPart.getFigure();
				java.lang.Object modelObject = graphicalEditPart.resolveSemanticElement();
				if (modelObject instanceof Transition) {
					RectangleOverlay overlay = new RectangleOverlay(graphicalEditPart);
				
						overlay.setForegroundColor(ColorConstants.blue);
						overlay.setBackgroundColor(ColorConstants.blue);
					
					return overlay;
				}
			}
		} else if (annotation instanceof SelectArc) {
			SelectArc ArcAnnotation = (SelectArc) annotation;
			if (editPart instanceof GraphicalEditPart) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
				// IFigure figure = graphicalEditPart.getFigure();
				java.lang.Object modelObject = graphicalEditPart.resolveSemanticElement();
				if (modelObject instanceof Place) {
					EllipseOverlay overlay = new EllipseOverlay(graphicalEditPart);
					if (!ArcAnnotation.isSelected()) {
						overlay.setForegroundColor(ColorConstants.lightGray);
						overlay.setBackgroundColor(ColorConstants.lightGray);
					}
					return overlay;
				}
			}
			
		}
		return null;
	}

}
