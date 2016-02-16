package dk.dtu.compute.se.mdsu.tutorial1.simulator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import yeah.petrinet.PetrinetFactory;
import yeah.petrinet.PetrinetPackage;
import yeah.petrinet.Place;
import yeah.petrinet.Token;
import yeah.petrinet.Transition;

public class FireTransitionCommand extends CompoundCommand {
	
	FireTransitionCommand(EditingDomain domain, Transition transition){
		
	
		for(int i = 0; i<transition.getIn().size();i++){
			Place place = (Place)transition.getIn().get(i).getSource();
			Token token = place.getTokens().get(0);
			RemoveCommand A = new RemoveCommand(domain, place, PetrinetPackage.eINSTANCE.getPlace_Tokens(), token);
			this.append(A);	
		}
		
		for(int i = 0; i<transition.getOut().size();i++){
			Place place = (Place)transition.getOut().get(i).getTarget();
			CreateChildCommand C = new CreateChildCommand(domain, place, PetrinetPackage.eINSTANCE.getPlace_Tokens(), PetrinetFactory.eINSTANCE.createToken(), null);
		this.append(C);
		}
	}
}

	


