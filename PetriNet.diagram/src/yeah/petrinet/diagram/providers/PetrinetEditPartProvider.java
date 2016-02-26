package yeah.petrinet.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import yeah.petrinet.diagram.edit.parts.PetrinetEditPart;
import yeah.petrinet.diagram.edit.parts.PetrinetEditPartFactory;
import yeah.petrinet.diagram.part.PetrinetVisualIDRegistry;

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
