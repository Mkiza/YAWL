
package yeah.petrinet.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import yeah.petrinet.diagram.providers.PetrinetElementTypes;

/**
 * @generated
 */
public class PetrinetPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createPetrinet1Group());
	}

	/**
	* Creates "petrinet" palette tool group
	* @generated
	*/
	private PaletteContainer createPetrinet1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Petrinet1Group_title);
		paletteContainer.setId("createPetrinet1Group"); //$NON-NLS-1$
		paletteContainer.add(createToken1CreationTool());
		paletteContainer.add(createArc2CreationTool());
		paletteContainer.add(createTransition3CreationTool());
		paletteContainer.add(createPlace4CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createToken1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Token1CreationTool_title,
				Messages.Token1CreationTool_desc, Collections.singletonList(PetrinetElementTypes.Token_3001));
		entry.setId("createToken1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetrinetElementTypes.getImageDescriptor(PetrinetElementTypes.Token_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createArc2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Arc2CreationTool_title,
				Messages.Arc2CreationTool_desc, Collections.singletonList(PetrinetElementTypes.Arc_4010));
		entry.setId("createArc2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetrinetElementTypes.getImageDescriptor(PetrinetElementTypes.Arc_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTransition3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Transition3CreationTool_title,
				Messages.Transition3CreationTool_desc, Collections.singletonList(PetrinetElementTypes.Transition_2002));
		entry.setId("createTransition3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetrinetElementTypes.getImageDescriptor(PetrinetElementTypes.Transition_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPlace4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Place4CreationTool_title,
				Messages.Place4CreationTool_desc, Collections.singletonList(PetrinetElementTypes.Place_2003));
		entry.setId("createPlace4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetrinetElementTypes.getImageDescriptor(PetrinetElementTypes.Place_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
