package petrinet.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import petrinet.diagram.edit.parts.PetrinetEditPart;
import petrinet.diagram.edit.parts.PetrinetEditPartFactory;
import petrinet.diagram.part.PetrinetVisualIDRegistry;

/**
 * @generated
 */
public class PetrinetEditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public PetrinetEditPartProvider() {
		super(new PetrinetEditPartFactory(), PetrinetVisualIDRegistry.TYPED_INSTANCE, PetrinetEditPart.MODEL_ID);
	}

}
