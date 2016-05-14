package project.yawl.constraints;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;

import project.yawl.Place;
import project.yawl.PlaceTypes;
import project.yawl.YAWLNet;

// imports missing

/**
 * This is a constraint saying that a YAWL net should have exactly one start place and one
 * end place.
 *
 * @author ekki@dtu.dk
 * @generated NOT
 */
public class StartEndConditions extends AbstractModelConstraint {

	public IStatus validate(IValidationContext ctx) {
		EObject object = ctx.getTarget();

                // TODO YAWLNet must refer to your java class for YAWL nets
		if (object instanceof YAWLNet) {
			EObject container = object.eContainer();
			if (container instanceof PetriNet) {
				int startCount = 0;
				int endCount = 0;
				Iterator<EObject> iterator = container.eAllContents();
				while (iterator.hasNext()) {
					EObject content = iterator.next();

					if(content instanceof Place){
						Place place = (Place) content;
						if(place.getType() != null && place.getType().getText().equals(PlaceTypes.START)){
							startCount++;
						}else if(place.getType() != null && place.getType().getText().equals(PlaceTypes.END)){
							endCount++;
						}
					}
					
					// TODO count number of places that are start places
					//      and number of places that are end places

				}
				if (startCount != 1 || endCount != 1) {
					// if there is not exactly one start place and exactly one
					// end place, return a failure status.
					return ctx.createFailureStatus(new Object[] {container});
					
				}
				
			}

		} 
		// otherwise return a success status
		return ctx.createSuccessStatus();
	}

}