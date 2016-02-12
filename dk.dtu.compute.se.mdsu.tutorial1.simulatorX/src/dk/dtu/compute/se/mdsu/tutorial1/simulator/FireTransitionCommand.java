package dk.dtu.compute.se.mdsu.tutorial1.simulator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import yeah.petrinet.PetrinetPackage;
import yeah.petrinet.Place;
import yeah.petrinet.Token;
import yeah.petrinet.Transition;

public class FireTransitionCommand extends CompoundCommand {
	
	FireTransitionCommand(EditingDomain domain, Transition transition){
		
	
		
		for(int i = 0; i<transition.getIn().size();i++){
			Place place = (Place)transition.getIn().get(i).getSource();
			Token token = place.getTokens().get(i);
			
			RemoveCommand A = new RemoveCommand(domain, place, PetrinetPackage.eINSTANCE.getPlace_Tokens(), token);
			CreateChildCommand C = new CreateChildCommand(domain, place, PetrinetPackage.eINSTANCE.getPlace_Tokens(), token, null);
			this.append(A);
			this.append(C);
		}
	}
	

}
