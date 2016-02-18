package yeah.petrinet.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import yeah.petrinet.diagram.providers.PetrinetElementTypes;

/**
 * @generated
 */
public class ArcSourceItemSemanticEditPolicy extends PetrinetBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ArcSourceItemSemanticEditPolicy() {
		super(PetrinetElementTypes.ArcSource_4006);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
