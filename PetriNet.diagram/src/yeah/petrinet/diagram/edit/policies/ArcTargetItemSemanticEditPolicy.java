package yeah.petrinet.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import yeah.petrinet.diagram.providers.PetrinetElementTypes;

/**
 * @generated
 */
public class ArcTargetItemSemanticEditPolicy extends PetrinetBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ArcTargetItemSemanticEditPolicy() {
		super(PetrinetElementTypes.ArcTarget_4003);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
