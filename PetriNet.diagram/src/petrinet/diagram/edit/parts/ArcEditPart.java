package petrinet.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.swt.graphics.Color;
import petrinet.diagram.edit.policies.ArcItemSemanticEditPolicy;

/**
 * @generated
 */
public class ArcEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4010;

	/**
	* @generated
	*/
	public ArcEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ArcItemSemanticEditPolicy());
	}

	/**
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	* @generated
	*/
	protected Connection createConnectionFigure() {
		return new ArcFigure();
	}

	/**
	* @generated
	*/
	public ArcFigure getPrimaryShape() {
		return (ArcFigure) getFigure();
	}

	/**
	* @generated
	*/
	public class ArcFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public ArcFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			PolylineDecoration arcFigure0 = new PolylineDecoration();

			arcFigure0.setForegroundColor(ARCFIGURE0_FORE);

			this.add(arcFigure0);

		}

	}

	/**
	* @generated
	*/
	static final Color ARCFIGURE0_FORE = new Color(null, 0, 0, 0);

}
