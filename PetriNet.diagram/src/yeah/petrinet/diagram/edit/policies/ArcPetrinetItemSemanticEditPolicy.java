package yeah.petrinet.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import yeah.petrinet.diagram.providers.PetrinetElementTypes;

/**
 * @generated
 */
public class ArcPetrinetItemSemanticEditPolicy extends PetrinetBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ArcPetrinetItemSemanticEditPolicy() {
		super(PetrinetElementTypes.ArcPetrinet_4007);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
