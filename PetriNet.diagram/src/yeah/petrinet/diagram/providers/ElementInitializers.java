package yeah.petrinet.diagram.providers;

import yeah.petrinet.diagram.part.PetrinetDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	* @generated
	*/
	public static ElementInitializers getInstance() {
		ElementInitializers cached = PetrinetDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			PetrinetDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
