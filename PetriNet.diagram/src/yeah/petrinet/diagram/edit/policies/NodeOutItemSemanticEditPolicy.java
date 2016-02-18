package yeah.petrinet.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import yeah.petrinet.diagram.providers.PetrinetElementTypes;

/**
 * @generated
 */
public class NodeOutItemSemanticEditPolicy extends PetrinetBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public NodeOutItemSemanticEditPolicy() {
		super(PetrinetElementTypes.NodeOut_4005);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
