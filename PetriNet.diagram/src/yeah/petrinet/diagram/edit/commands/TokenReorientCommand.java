package yeah.petrinet.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import yeah.petrinet.Place;
import yeah.petrinet.Token;
import yeah.petrinet.diagram.edit.policies.PetrinetBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class TokenReorientCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final int reorientDirection;

	/**
	* @generated
	*/
	private final EObject oldEnd;

	/**
	* @generated
	*/
	private final EObject newEnd;

	/**
	* @generated
	*/
	public TokenReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Token) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Place && newEnd instanceof Place)) {
			return false;
		}
		Place target = getLink().getPlace();
		return PetrinetBaseItemSemanticEditPolicy.getLinkConstraints().canExistToken_4001(getLink(), getNewSource(),
				target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Place && newEnd instanceof Place)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof Place)) {
			return false;
		}
		Place source = (Place) getLink().eContainer();
		return PetrinetBaseItemSemanticEditPolicy.getLinkConstraints().canExistToken_4001(getLink(), source,
				getNewTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	* @generated
	*/
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().getTokens().remove(getLink());
		getNewSource().getTokens().add(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setPlace(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected Token getLink() {
		return (Token) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected Place getOldSource() {
		return (Place) oldEnd;
	}

	/**
	* @generated
	*/
	protected Place getNewSource() {
		return (Place) newEnd;
	}

	/**
	* @generated
	*/
	protected Place getOldTarget() {
		return (Place) oldEnd;
	}

	/**
	* @generated
	*/
	protected Place getNewTarget() {
		return (Place) newEnd;
	}
}
