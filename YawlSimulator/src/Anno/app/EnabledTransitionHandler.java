package Anno.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotations;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import project.yawl.Transition;
import project.yawl.Arc;

import Anno.AnnoFactory;
import Anno.EnabledTransition;
import Anno.SelectArc;
import Anno.Mode;


public class EnabledTransitionHandler implements IActionHandler {

	private App application;

	public EnabledTransitionHandler(App application) {
		super();
		this.application = application;
		
	}

	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		NetAnnotations netAnnotations = application.getNetAnnotations();
		NetAnnotation current = netAnnotations.getCurrent();
		
		FlatAccess flatNet = new FlatAccess(application.getPetrinet());
		if (current.getObjectAnnotations().contains(annotation)) {
			Object object = annotation.getObject();
			if (object instanceof Transition && annotation instanceof EnabledTransition) {
				Transition transition = (Transition) object;
				EnabledTransition transitionAnnotation = ((EnabledTransition) annotation);
				Map<project.yawl.Place,Integer> marking1 = application.computeMarking();
					Map<Arc, Boolean> selectedInArcs = new HashMap<Arc, Boolean>();
					Map<Arc, Boolean> selectedOutArcs = new HashMap<Arc, Boolean>();
					for (SelectArc arcAnnotation : transitionAnnotation.getInArcs()) {
						Arc yawlArc = (Arc) arcAnnotation.getObject();
						selectedInArcs.put(yawlArc, arcAnnotation.isSelected());	
					}
					for (SelectArc arcAnnotation : transitionAnnotation.getOutArcs()) {
						Arc yawlArc = (Arc) arcAnnotation.getObject();
						selectedOutArcs.put(yawlArc, arcAnnotation.isSelected());
					}
					
					
					Map<project.yawl.Place,Integer> marking2 = application.fireTransition(flatNet, marking1, transition, selectedOutArcs, selectedInArcs);
					NetAnnotation netAnnotation;
					if(marking2!=null){
						netAnnotation = application.computeAnnotation(flatNet, marking2);
					}else{
						netAnnotation = application.computeAnnotation(flatNet, marking1);
					}
					

					application.deleteNetAnnotationAfterCurrent();
					application.addNetAnnotationAsCurrent(netAnnotation);
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean mousePressed(MouseEvent arg0, ObjectAnnotation annotation) {
		return false; 
	}

	@Override
	public boolean mouseReleased(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}

}