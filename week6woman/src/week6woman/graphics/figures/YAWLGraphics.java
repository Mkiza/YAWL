package week6woman.graphics.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.pnml.tools.epnk.gmf.extensions.graphics.GraphicalExtension;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.ArcFigure;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.PlaceFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.Place;

import project.yawl.YawlPackage;

public class YAWLGraphics extends GraphicalExtension {

	@Override
	public List<EClass> getExtendedNetTypes() {
		ArrayList<EClass> list = new ArrayList<EClass>();
		list.add(YawlPackage.eINSTANCE.getYAWLNet());
		return list;
	}

	@Override
	public List<EClass> getExtendedNetObjects(EClass netType) {
		ArrayList<EClass> list = new ArrayList<EClass>();
		if (netType.equals(YawlPackage.eINSTANCE.getYAWLNet())) {
			list.add(YawlPackage.eINSTANCE.getArc());
			list.add(YawlPackage.eINSTANCE.getPlace());
		}
		return list;}

	@Override
	public ArcFigure createArcFigure(Arc arc) {
		if (arc instanceof project.yawl.Arc) {
			return new Arcs((project.yawl.Arc) arc);
		}
		return null;
	}
	@Override
	public PlaceFigure createPlaceFigure(Place place) {
		if (place instanceof project.yawl.Place) {
			return new Places((project.yawl.Place) place);
		}
		return null;
	}

	
}
