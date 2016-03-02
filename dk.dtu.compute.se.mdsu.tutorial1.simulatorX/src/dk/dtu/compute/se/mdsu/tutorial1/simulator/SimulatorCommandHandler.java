package dk.dtu.compute.se.mdsu.tutorial1.simulator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

import yeah.petrinet.*;

// TODO replace these imports by your own classes (which
//      you generated from your model


public class SimulatorCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Transition transition = getTransition(event.getApplicationContext());
		if (isEnabled(transition)) {
			fire(transition);
			
		}
		return null;
	}

	@Override
	public void setEnabled(Object context) {
		Transition transition = getTransition(context);
		setBaseEnabled(isEnabled(transition));
	}
	
	static private Transition getTransition(Object context) {
		if (context instanceof IEvaluationContext) {
			IEvaluationContext evaluationContext = (IEvaluationContext) context;
			Object object = evaluationContext.getDefaultVariable();
			if (object instanceof List) {
				@SuppressWarnings("rawtypes")
				List list = (List) object;
				if (list.size() == 1) {
					object = list.get(0);
					if (object instanceof Transition) {
						return (Transition) object;
					} else if (object instanceof IGraphicalEditPart) {
						IGraphicalEditPart editPart = (IGraphicalEditPart) object;
						Object model = editPart.getModel();
						if (model instanceof View) {
							Object element = ((View) model).getElement();
							if (element instanceof Transition) {
								return (Transition) element;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	static private boolean isEnabled(Transition transition) {
		// TODO compute whether there are enough tokens on
		//      each input place of a transition; Note that
		//      there could be more than one arc between the
		//      same place and the same transition (

		int j = 0;
		
		for(int i = 0; i<transition.getIn().size();i++){
			Place b = (Place) transition.getIn().get(i).getSource();
			for(Token t: b.getTokens()){
				System.out.println(t.toString());
			}
			if(b.getTokens().size()>0){
				j++;
			}
		}
		
		if(j==transition.getIn().size()){
			//System.out.println("True");
			return true;
			
		}
		System.out.println("false");
		return false;
	}

	static private void fire(Transition transition) {
		
		// TODO create code which fires a transition, i.e.
		//      removes one token for each incoming arc from
		//      the target place and adds one token to the
		//      target place of each outgoing arc.
		
		// Note: don't use new Token() or new TokenIml() for
		//       creating a now token object use the factory
		//       that was generated from the model. This could
		//      look like:
        //
		// Token token = PetrinetFactory.eINSTANCE.createToken();
				
		// removing in tokens
//		System.out.println(transition.toString());
//		for(int i = 0; i<transition.getIn().size();i++){
//			Place b = (Place)transition.getIn().get(i).getSource();
//			
//			b.getTokens().remove(0);
////		    transition.getIn().get(i).setSource(b);
//		}
//		
//		// adding tokens
//		
//		for(int i = 0; i<transition.getOut().size();i++){
//			Place b = (Place)transition.getOut().get(i).getTarget();
//			b.getTokens().add(PetrinetFactory.eINSTANCE.createToken());
////			transition.getIn().get(i).setSource(b);
//			
//		
//		}
		
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(transition);
		  if (domain != null)
		    domain.getCommandStack().execute( new FireTransitionCommand(domain, transition));
		
		
			
	}
	



}
