package petrinet.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import yeah.*;
import yeah.petrinet.Arc;
import yeah.petrinet.Node;
import yeah.petrinet.petrinet;
import petrinet.diagram.edit.policies.PetrinetBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ArcReorientCommand extends EditElementCommand {

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
	public ArcReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof yeah.petrinet.Arc) {
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
	* @generated NOT
	*/
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof yeah.petrinet.Node && newEnd instanceof yeah.petrinet.Node)) {
			return false;
		}
		yeah.petrinet.Node target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof yeah.petrinet.petrinet)) {
			return false;
		}
		yeah.petrinet.petrinet container = (yeah.petrinet.petrinet) getLink().eContainer();
		return PetrinetBaseItemSemanticEditPolicy.getLinkConstraints().canExistArc_4010(container, getLink(),
				getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof yeah.petrinet.Node && newEnd instanceof yeah.petrinet.Node)) {
			return false;
		}
		yeah.petrinet.Node source = getLink().getSource();
		if (!(getLink().eContainer() instanceof yeah.petrinet.petrinet)) {
			return false;
		}
		yeah.petrinet.petrinet container = (yeah.petrinet.petrinet) getLink().eContainer();
		return PetrinetBaseItemSemanticEditPolicy.getLinkConstraints().canExistArc_4010(container, getLink(), source,
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
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated NOT
	*/
	protected yeah.petrinet.Arc getLink() {
		return (yeah.petrinet.Arc) getElementToEdit();
	}

	/**
	* @generated NOT
	*/
	protected yeah.petrinet.Node getOldSource() {
		return (yeah.petrinet.Node) oldEnd;
	}

	/**
	* @generated NOT
	*/
	protected yeah.petrinet.Node getNewSource() {
		return (yeah.petrinet.Node) newEnd;
	}

	/**
	* @generated
	*/
	protected yeah.petrinet.Node getOldTarget() {
		return (yeah.petrinet.Node) oldEnd;
	}

	/**
	* @generated
	*/
	protected yeah.petrinet.Node getNewTarget() {
		return (yeah.petrinet.Node) newEnd;
	}
}
