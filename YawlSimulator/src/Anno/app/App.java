package Anno.app;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetannotationsFactory;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.applications.ui.ApplicationUIManager;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import project.yawl.Transition;
import project.yawl.Arc;
import project.yawl.ArcType;
import org.pnml.tools.epnk.pntypes.ptnet.PTArcAnnotation;
import Anno.AnnoFactory;
import Anno.EnabledTransition;
import Anno.Marking;
import Anno.SelectArc;
import project.yawl.Place;
import project.yawl.PlaceTypes;
import project.yawl.TransitionTypes;
import Anno.Mode;

public class App extends ApplicationWithUIManager {

	private FlatAccess flataccess;
	
	public App(PetriNet petrinet) {
		super(petrinet);
		// TODO Auto-generated constructor stub
		
		getNetAnnotations().setName("name");
		ApplicationUIManager manager = this.getPresentationManager();
		manager.addPresentationHandler(new APPPresentationHandler());
		 manager.addActionHandler(new EnabledTransitionHandler(this));
		 manager.addActionHandler(new APPActionHandler(this));
		 
	}
	
	public FlatAccess getFlataccess() {
		if(flataccess==null){
			flataccess = new FlatAccess(this.getPetrinet());
		}
		return flataccess;
	}
	



	@Override
	protected void initializeContents() {
		// TODO Auto-generated method stub
		super.initializeContents();
		
		NetAnnotation netannotation = NetannotationsFactory.eINSTANCE.createNetAnnotation();
		 
		netannotation.setNet(getPetrinet()); 
		
		ObjectAnnotation objectannotation = NetannotationsFactory.eINSTANCE.createObjectAnnotation();
		
		netannotation.getObjectAnnotations().add(objectannotation);
		
		this.getNetAnnotations().getNetAnnotations().add(netannotation);
		this.getNetAnnotations().setCurrent(netannotation);
		
		FlatAccess flatNet = new FlatAccess(this.getPetrinet());
		Map<project.yawl.Place,Integer> initialMarking = computeInitialMarking(flatNet);
		NetAnnotation initialAnnotation = computeAnnotation(flatNet, initialMarking);
		initialAnnotation.setNet(this.getPetrinet());
		
		this.getNetAnnotations().getNetAnnotations().add(initialAnnotation);
		this.getNetAnnotations().setCurrent(initialAnnotation);
	}
	
	Map<project.yawl.Place, Integer> computeInitialMarking(FlatAccess flatNet) {
		Map<project.yawl.Place,Integer> marking = new HashMap<project.yawl.Place,Integer>();
		for (org.pnml.tools.epnk.pnmlcoremodel.Place place: flatNet.getPlaces()) {
			if (place instanceof Place) {
				Place ptPlace = (Place) place;
				if (ptPlace.getType() != null && ptPlace.getType().getText().equals(PlaceTypes.START)) {
					marking.put(ptPlace,1);
				} 
			}
		}
		return marking;
	}
	Map<project.yawl.Place, Integer> computeMarking() {
		Map<project.yawl.Place,Integer> marking = new HashMap<project.yawl.Place,Integer>();
		for (ObjectAnnotation annotation: this.getNetAnnotations().getCurrent().getObjectAnnotations()) {
			if (annotation instanceof Marking) {
				Marking markingAnnotation = (Marking) annotation;
				Object object = markingAnnotation.getObject();
				if (object instanceof Place && markingAnnotation.getValue() > 0) {
					Place ptPlace = (Place) object;
					marking.put(ptPlace, markingAnnotation.getValue());
				}
			}
		}
		return marking;
	}
	
	Map<Place, Integer> fireTransition(FlatAccess flatNet, Map<Place, Integer> marking1, Transition transition) {
		Map<Place,Integer> marking2 = new HashMap<Place, Integer>();
		for (Place place: marking1.keySet()) {
			marking2.put(place, marking1.put(place, marking1.get(place)));
		}
		
		for (Object arc: flatNet.getIn(transition)) {
			if (arc instanceof Arc) {
				Arc ptArc = (Arc) arc;
				ArcType ptArcAnnotation = ptArc.getType();
				Object source  = ptArc.getSource();
				if (source instanceof PlaceNode) {
					source = flatNet.resolve((PlaceNode) source);
					if (source instanceof Place) {
						Place place = (Place) source;
						int available = 0;
						if (marking1.containsKey(place)) {
							available = marking1.get(place);
						}
						int needed = 1; 
						if (ptArcAnnotation != null) {
							needed = ptArcAnnotation.getText().getValue();
						}
						marking2.put(place, available-needed);
					}
				}
			}
		}
		
		for (Object arc: flatNet.getOut(transition)) {
			if (arc instanceof Arc) {
				Arc ptArc = (Arc) arc;
				ArcType ptArcAnnotation = ptArc.getType();
				Object target  = ptArc.getTarget();
				if (target instanceof PlaceNode) {
					target = flatNet.resolve((PlaceNode) target);
					if (target instanceof Place) {
						Place place = (Place) target;
						int available = 0;
						if (marking1.containsKey(place)) {
							available = marking1.get(place);
						}
						int provided = 1; 
						if (ptArcAnnotation != null) {
							provided = ptArcAnnotation.getText().getValue();
						}
						marking2.put(place, available+provided);
					}
				}
			}
		}

		return marking2;
	}
	
	NetAnnotation computeAnnotation(FlatAccess flatNet, Map<Place, Integer> marking) {
		NetAnnotation annotation = NetannotationsFactory.eINSTANCE.createNetAnnotation();
		for (Place place: marking.keySet()) {
			Integer value = marking.get(place);
			if (value > 0) {
				Marking markingAnnotation = AnnoFactory.eINSTANCE.createMarking();
				markingAnnotation.setValue(value);
				markingAnnotation.setObject(place);
				annotation.getObjectAnnotations().add(markingAnnotation);
				// also annotate reference places with the current marking of the place
				for (PlaceNode ref: flatNet.getRefPlaces(place)) {
					Marking markingAnnotationRef = AnnoFactory.eINSTANCE.createMarking();
					markingAnnotationRef.setValue(value);
					markingAnnotationRef.setObject(ref);
					annotation.getObjectAnnotations().add(markingAnnotationRef);	
				}
			}
		}
		for (Node transition: flatNet.getTransitions()) {
			if (transition instanceof Transition) {
				if (enabled(flatNet, marking, (Transition) transition)) {
					EnabledTransition transitionAnnotation =
							AnnoFactory.eINSTANCE.createEnabledTransition();
					int i = 0;
					
					int splitType = ((Transition) transition).getSplitType().getText().getValue();
					int joinType = ((Transition) transition).getJoinType().getText().getValue();

					if (splitType == project.yawl.TransitionTypes.OR_VALUE || splitType == project.yawl.TransitionTypes.AND_VALUE) {
						for (Object arc : flatNet.getOut(transition)) {
							if (arc instanceof Arc) {
								Arc yawlArc = (Arc) arc;
								SelectArc arcAnnotation = AnnoFactory.eINSTANCE
										.createSelectArc();
								arcAnnotation.setSelected(true);
								arcAnnotation.setObject(yawlArc);
								arcAnnotation.setSourceTransition(transitionAnnotation);
								annotation.getObjectAnnotations().add(arcAnnotation);
							}
						}
					}else if (splitType == project.yawl.TransitionTypes.XOR_VALUE) {
						boolean selected = false;
						for (Object arc : flatNet.getOut(transition)) {
							if (arc instanceof Arc) {
								Arc yawlArc = (Arc) arc;

								if (!selected) {
									SelectArc arcAnnotation = AnnoFactory.eINSTANCE
											.createSelectArc();
									arcAnnotation.setSelected(true);
									arcAnnotation.setObject(yawlArc);
									arcAnnotation.setSourceTransition(transitionAnnotation);
									annotation.getObjectAnnotations().add(arcAnnotation);
									selected = true;
								} else {
									SelectArc arcAnnotation = AnnoFactory.eINSTANCE
											.createSelectArc();
									arcAnnotation.setSelected(false);
									arcAnnotation.setObject(yawlArc);
									arcAnnotation.setSourceTransition(transitionAnnotation);
									annotation.getObjectAnnotations().add(arcAnnotation);
								}
							}
						}
						
					} else {
						for (Object arc : flatNet.getOut(transition)) {
							if (arc instanceof Arc) {
								Arc yawlArc = (Arc) arc;
								SelectArc arcAnnotation = AnnoFactory.eINSTANCE
										.createSelectArc();
								arcAnnotation.setSelected(true);
								arcAnnotation.setObject(yawlArc);
								arcAnnotation.setSourceTransition(transitionAnnotation);
								annotation.getObjectAnnotations().add(arcAnnotation);
							}
						}
					}

					if (joinType == TransitionTypes.OR_VALUE) {
						for (Object arc : flatNet.getIn(transition)) {
							if (arc instanceof Arc) {
								Arc yawlArc = (Arc) arc;
								Object source = yawlArc.getSource();
								if (source instanceof PlaceNode) {
									source = flatNet.resolve((PlaceNode) source);
									if (source instanceof Place) {
										Place place = (Place) source;
										if (marking.containsKey(place) && marking.get(place) > 0) {
											SelectArc arcAnnotation = AnnoFactory.eINSTANCE
													.createSelectArc();
											arcAnnotation.setSelected(true);
											arcAnnotation.setObject(yawlArc);
											arcAnnotation.setTargetTransition(transitionAnnotation);
											annotation.getObjectAnnotations().add(arcAnnotation);
										}
									}
								}
							}
						}
					} else if (joinType == TransitionTypes.AND_VALUE) {
						for (Object arc : flatNet.getIn(transition)) {
							if (arc instanceof Arc) {
								Arc yawlArc = (Arc) arc;
								SelectArc arcAnnotation = AnnoFactory.eINSTANCE
										.createSelectArc();
								arcAnnotation.setSelected(true);
								arcAnnotation.setObject(yawlArc);
								arcAnnotation.setTargetTransition(transitionAnnotation);
								annotation.getObjectAnnotations().add(arcAnnotation);

							}
						}

					} else if (joinType == TransitionTypes.XOR_VALUE) {

						boolean selected = false;
						for (Object arc : flatNet.getIn(transition)) {
							if (arc instanceof Arc) {
								Arc yawlArc = (Arc) arc;
								Object source = yawlArc.getSource();
								if (source instanceof PlaceNode) {
									source = flatNet.resolve((PlaceNode) source);
									if (source instanceof Place) {
										Place place = (Place) source;
										if (marking.containsKey(place) && marking.get(place) > 0) {
											if (!selected) {
												SelectArc arcAnnotation = AnnoFactory.eINSTANCE
														.createSelectArc();
												arcAnnotation.setSelected(true);
												arcAnnotation.setObject(yawlArc);
												arcAnnotation.setTargetTransition(transitionAnnotation);
												annotation.getObjectAnnotations().add(arcAnnotation);
												selected = true;
											} else {
												SelectArc arcAnnotation = AnnoFactory.eINSTANCE
														.createSelectArc();
												arcAnnotation.setSelected(false);
												arcAnnotation.setObject(yawlArc);
												arcAnnotation.setTargetTransition(transitionAnnotation);
												annotation.getObjectAnnotations().add(arcAnnotation);
											}
										}
									}
								}
							}
						}
					} else {
						for (Object arc : flatNet.getIn(transition)) {
							if (arc instanceof Arc) {
								Arc yawlArc = (Arc) arc;
								SelectArc arcAnnotation = AnnoFactory.eINSTANCE
										.createSelectArc();
								arcAnnotation.setSelected(true);
								arcAnnotation.setObject(yawlArc);
								arcAnnotation.setTargetTransition(transitionAnnotation);
								annotation.getObjectAnnotations().add(arcAnnotation);
							}
						}

					}
					
					for(org.pnml.tools.epnk.pnmlcoremodel.Arc a: transition.getIn()){
						SelectArc SA = AnnoFactory.eINSTANCE.createSelectArc();
						SA.setObject(a); 
						transitionAnnotation.setMode(Mode.ENABLED);
						SA.setTargetTransition(transitionAnnotation);
						
						if(i==0)
							SA.setSelected(true);
						
						i++;
						
					}
					int t = 0;
					for(org.pnml.tools.epnk.pnmlcoremodel.Arc a: transition.getOut()){
						SelectArc SA = AnnoFactory.eINSTANCE.createSelectArc();
						SA.setObject(a); 
						SA.setSourceTransition(transitionAnnotation);
						
						if(t==0)
							SA.setSelected(true);
						
						t++;
						
					}
					
					
					transitionAnnotation.setObject(transition);
					
					
//			Lav korrekt		transitionAnnotation.setSelected(Selected.False);
					annotation.getObjectAnnotations().add(transitionAnnotation);
				}
			}
		}
		return annotation;
	}

	boolean enabled(FlatAccess flatNet, Map<Place, Integer> marking, Transition transition) {
		// TODO this does not work yet if there is more than one arc between the same
		//      place and the same transition!
		for (Object arc: flatNet.getIn(transition)) {
			if (arc instanceof Arc) {
				Arc ptArc = (Arc) arc;
				ArcType ptArcAnnotation = ptArc.getType();
				int available = 0;
				Object source = ptArc.getSource();
				if (source instanceof PlaceNode) {
					source = flatNet.resolve((PlaceNode) source);
					if (source instanceof Place) {
						if (marking.containsKey(source)) {
							available = marking.get(source);
						}
						int needed = 1; 
						if (ptArcAnnotation != null) {
							needed = ptArcAnnotation.getText().getValue();
						}
						if (available < needed) {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}


	
	
	

}
