package Anno.app;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;

import Anno.EnabledTransition;
import Anno.SelectArc;

import project.yawl.Transition;

import project.yawl.TransitionTypes;


public class APPActionHandler implements IActionHandler {

	private App application;

	public APPActionHandler(App application) {
		super();		
		this.application = application;
	}

	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		if (annotation instanceof SelectArc) {
			SelectArc arcAnnotation = (SelectArc) annotation;
			arcAnnotation.setSelected(!arcAnnotation.isSelected());


			if (arcAnnotation.getTargetTransition() != null
					&& arcAnnotation.getTargetTransition() instanceof EnabledTransition){
				EnabledTransition transitionAnnotation = (EnabledTransition) arcAnnotation.getTargetTransition();
				Transition transition = (Transition) transitionAnnotation.getObject();

				if (transition.getJoinType().getText().getValue()== TransitionTypes.XOR_VALUE){
					if (!arcAnnotation.isSelected()){
						for (SelectArc tempArcAnnotation : transitionAnnotation.getInArcs()) {
							tempArcAnnotation.setSelected(false);
						}
						arcAnnotation.setSelected(true);
					}
				} 
			} else if (arcAnnotation.getSourceTransition() != null && arcAnnotation.getSourceTransition() instanceof EnabledTransition) {
				EnabledTransition transitionAnnotation = (EnabledTransition) arcAnnotation.getSourceTransition(); 
				int availableCount = transitionAnnotation.getOutArcs().size();
				int selectedCount = 0;
				for (int i = 0; i < availableCount; i++) {
					if (transitionAnnotation.getOutArcs().get(i).isSelected()) {
						selectedCount++;
					}
				}

				Transition transition = (Transition) transitionAnnotation.getObject();

				if(transition.getSplitType().getText().getValue()== TransitionTypes.OR_VALUE){
					if (!arcAnnotation.isSelected()) {
						arcAnnotation.setSelected(true);
					} else {
						if (selectedCount > 1) {
							arcAnnotation.setSelected(false);
						}
					}
				} else if(transition.getSplitType().getText().getValue()== TransitionTypes.XOR_VALUE){
					if (!arcAnnotation.isSelected()){
						for (SelectArc tempArcAnnotation : transitionAnnotation.getOutArcs()) {
							tempArcAnnotation.setSelected(false);
						}
						arcAnnotation.setSelected(true);
					} 
				}

			}

			application.update();
			return true; 
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
